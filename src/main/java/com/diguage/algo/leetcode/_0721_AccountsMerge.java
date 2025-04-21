package com.diguage.algo.leetcode;

import java.util.*;

public class _0721_AccountsMerge {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-04-21 21:49:58
   */
  public List<List<String>> accountsMerge(List<List<String>> accounts) {
    Map<String, Integer> emailToNoMap = new HashMap<>();
    Map<String, String> emailToNameMap = new HashMap<>();
    int emailCount = 0;
    for (List<String> account : accounts) {
      String name = account.getFirst();
      for (int i = 1; i < account.size(); i++) {
        String email = account.get(i);
        if (!emailToNoMap.containsKey(email)) {
          emailToNoMap.put(email, emailCount++);
          emailToNameMap.put(email, name);
        }
      }
    }
    UnionFind uf = new UnionFind(emailCount);
    for (List<String> account : accounts) {
      String firstEmail = account.get(1);
      Integer ai = emailToNoMap.get(firstEmail);
      for (int j = 2; j < account.size(); j++) {
        Integer bi = emailToNoMap.get(account.get(j));
        uf.union(ai, bi);
      }
    }
    Map<Integer, List<String>> noToEmailMap = new HashMap<>();
    emailToNoMap.forEach((email, no) -> {
      int id = uf.find(no);
      List<String> emails = noToEmailMap.computeIfAbsent(id, v -> new ArrayList<>());
      emails.add(email);
    });
    List<List<String>> result = new ArrayList<>();
    for (List<String> emails : noToEmailMap.values()) {
      List<String> account = new ArrayList<>(emails.size() + 1);
      account.add(emailToNameMap.get(emails.getFirst()));
      Collections.sort(emails);
      account.addAll(emails);
      result.add(account);
    }
    return result;
  }

  private static class UnionFind {
    int[] parent;

    public UnionFind(int size) {
      this.parent = new int[size];
      for (int i = 0; i < size; i++) {
        parent[i] = i;
      }
    }

    public void union(int a, int b) {
      int ap = find(a);
      int bp = find(b);
      if (ap == bp) {
        return;
      }
      if (ap < bp) {
        parent[bp] = ap;
      } else {
        parent[ap] = bp;
      }
    }

    public int find(int a) {
      int ap = parent[a];
      List<Integer> path = new ArrayList<>();
      path.add(a);
      while (ap != parent[ap]) {
        path.add(ap);
        ap = parent[ap];
      }
      for (Integer i : path) {
        parent[i] = ap;
      }
      return ap;
    }
  }
  // end::answer[]
  public static void main(String[] args) {
    new _0721_AccountsMerge().accountsMerge(new ArrayList<>(List.of(
      new ArrayList<>(List.of("David", "David0@m.co", "David4@m.co", "David3@m.co")),
      new ArrayList<>(List.of("David", "David5@m.co", "David5@m.co", "David0@m.co")),
      new ArrayList<>(List.of("David", "David1@m.co", "David4@m.co", "David0@m.co")),
      new ArrayList<>(List.of("David", "David0@m.co", "David1@m.co", "David3@m.co")),
      new ArrayList<>(List.of("David", "David4@m.co", "David1@m.co", "David3@m.co")))));
//    new _0721_AccountsMerge().accountsMerge(new ArrayList<>(List.of(
//      new ArrayList<>(List.of("David", "David0@m.co", "David1@m.co")),
//      new ArrayList<>(List.of("David", "David3@m.co", "David4@m.co")),
//      new ArrayList<>(List.of("David", "David4@m.co", "David5@m.co")),
//      new ArrayList<>(List.of("David", "David2@m.co", "David3@m.co")),
//      new ArrayList<>(List.of("David", "David1@m.co", "David2@m.co")))));
  }
}
