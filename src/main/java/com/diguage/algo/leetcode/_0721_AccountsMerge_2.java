package com.diguage.algo.leetcode;

import java.util.*;

public class _0721_AccountsMerge_2 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-09-23 20:42:51
   */
  public List<List<String>> accountsMerge(List<List<String>> accounts) {
    List<List<String>> next = accounts;
    do {
      accounts = next;
      next = merge(accounts);
    } while (next.size() != accounts.size());
    for (List<String> as : next) {
      String name = as.removeFirst();
      Collections.sort(as);
      as.addFirst(name);
    }
    return next;
  }

  private List<List<String>> merge(List<List<String>> accounts) {
    Map<String, Integer> emailToIndex = new HashMap<>();
    List<List<String>> result = new ArrayList<>();
    for (int i = 0; i < accounts.size(); i++) {
      List<String> as = accounts.get(i);
      int index = -1;
      for (int j = 1; j < as.size(); j++) {
        String email = as.get(j);
        if (emailToIndex.containsKey(email)) {
          int temp = emailToIndex.get(email);
          if (temp < result.size()) {
            index = temp;
            break;
          }
        } else {
          emailToIndex.put(email, result.size());
        }
      }
      if (index >= 0) {
        HashSet<String> set = new HashSet<>(result.get(index));
        for (int j = 1; j < as.size(); j++) {
          String email = as.get(j);
          emailToIndex.remove(email);
          if (!set.contains(email)) {
            result.get(index).add(email);
            set.add(email);
          }
        }
      } else {
        ArrayList<String> list = new ArrayList<>(as.size());
        list.add(as.getFirst());
        as.removeFirst();
        list.addAll(new HashSet<>(as));
        result.add(list);
      }
    }
    return result;
  }
  // end::answer[]

  public static void main(String[] args) {
    new _0721_AccountsMerge_2().accountsMerge(List.of(
        new ArrayList<>(List.of("Alex", "Alex5@m.co", "Alex4@m.co", "Alex0@m.co")),
        new ArrayList<>(List.of("Ethan", "Ethan3@m.co", "Ethan3@m.co", "Ethan0@m.co")),
        new ArrayList<>(List.of("Kevin", "Kevin4@m.co", "Kevin2@m.co", "Kevin2@m.co")),
        new ArrayList<>(List.of("Gabe", "Gabe0@m.co", "Gabe3@m.co", "Gabe2@m.co")),
        new ArrayList<>(List.of("Gabe", "Gabe3@m.co", "Gabe4@m.co", "Gabe2@m.co"))

//        new ArrayList<>(List.of("John", "johnsmith@mail.com", "john_newyork@mail.com")),
//        new ArrayList<>(List.of("John", "johnsmith@mail.com", "john00@mail.com")),
//        new ArrayList<>(List.of("Mary", "mary@mail.com")),
//        new ArrayList<>(List.of("John", "johnnybravo@mail.com"))

//      new ArrayList<>(List.of("Gabe", "Gabe0@m.co", "Gabe3@m.co", "Gabe1@m.co")),
//      new ArrayList<>(List.of("Kevin", "Kevin3@m.co", "Kevin5@m.co", "Kevin0@m.co")),
//      new ArrayList<>(List.of("Ethan", "Ethan5@m.co", "Ethan4@m.co", "Ethan0@m.co")),
//      new ArrayList<>(List.of("Hanzo", "Hanzo3@m.co", "Hanzo1@m.co", "Hanzo0@m.co")),
//      new ArrayList<>(List.of("Fern", "Fern5@m.co", "Fern1@m.co", "Fern0@m.co"))
      )
    );
  }
}
