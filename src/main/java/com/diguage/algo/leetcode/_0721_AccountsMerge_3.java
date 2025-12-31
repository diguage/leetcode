package com.diguage.algo.leetcode;

import java.util.*;

public class _0721_AccountsMerge_3 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-12-31 16:42:26
   */
  public List<List<String>> accountsMerge(List<List<String>> accounts) {
    Map<String, Integer> emailToNoMap = new HashMap<>();
    Map<String, String> emailToNameMap = new HashMap<>();
    for (List<String> account : accounts) {
      for (int i = 1; i < account.size(); i++) {
        String email = account.get(i);
        if (!emailToNoMap.containsKey(email)) {
          emailToNoMap.put(email, emailToNoMap.size());
          emailToNameMap.put(email, account.getFirst());
        }
      }
    }
    UnionFind un = new UnionFind(emailToNoMap.size());
    for (List<String> account : accounts) {
      String firstEmail = account.get(1);
      Integer ai = emailToNoMap.get(firstEmail);
      for (int i = 2; i < account.size(); i++) {
        String email = account.get(i);
        Integer bi = emailToNoMap.get(email);
        un.union(ai, bi);
      }
    }
    Map<Integer, List<String>> numToEmails = new HashMap<>();
    emailToNoMap.forEach((email, idx) -> {
      int parent = un.find(idx);
      numToEmails.computeIfAbsent(parent, k -> new ArrayList<>()).add(email);
    });

    List<List<String>> result = new ArrayList<>(numToEmails.size());
    for (List<String> emails : numToEmails.values()) {
      List<String> ra = new ArrayList<>(emails.size() + 1);
      ra.add(emailToNameMap.get(emails.getFirst()));
      Collections.sort(emails);
      ra.addAll(emails);
      result.add(ra);
    }
    return result;
  }

  private static class UnionFind {
    private int[] parents;

    public UnionFind(int capacity) {
      parents = new int[capacity];
      for (int i = 0; i < capacity; i++) {
        parents[i] = i;
      }
    }

    public int find(int n) {
      int np = parents[n];
      List<Integer> path = new ArrayList<>();
      path.add(n);
      while (np != parents[np]) {
        path.add(np);
        np = parents[np];
      }
      for (Integer in : path) {
        parents[in] = np;
      }
      return np;
    }

    public void union(int a, int b) {
      int ap = find(a);
      int bp = find(b);
      if (ap == bp) {
        return;
      }
      // 注意：这里是要修复 ap 和 bp 的父节点！
      if (ap < bp) {
        parents[bp] = ap;
      } else {
        parents[ap] = bp;
      }
    }
  }
  // end::answer[]

  static void main() {
    new _0721_AccountsMerge_3().accountsMerge(List.of(
      List.of("David", "David0@m.co", "David1@m.co"),
      List.of("David", "David3@m.co", "David4@m.co"),
      List.of("David", "David4@m.co", "David5@m.co"),
      List.of("David", "David2@m.co", "David3@m.co"),
      List.of("David", "David1@m.co", "David2@m.co")));
//    new _0721_AccountsMerge_3().accountsMerge(new ArrayList<>(List.of(
//      new ArrayList<>(List.of("David", "David0@m.co", "David4@m.co", "David3@m.co")),
//      new ArrayList<>(List.of("David", "David5@m.co", "David5@m.co", "David0@m.co")),
//      new ArrayList<>(List.of("David", "David1@m.co", "David4@m.co", "David0@m.co")),
//      new ArrayList<>(List.of("David", "David0@m.co", "David1@m.co", "David3@m.co")),
//      new ArrayList<>(List.of("David", "David4@m.co", "David1@m.co", "David3@m.co")))));
  }
}
