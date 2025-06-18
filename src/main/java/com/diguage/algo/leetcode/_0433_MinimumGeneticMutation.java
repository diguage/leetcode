package com.diguage.algo.leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class _0433_MinimumGeneticMutation {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-06-18 21:17:14
   */
  public int minMutation(String startGene, String endGene, String[] bank) {
    Set<String> banks = Arrays.stream(bank).collect(Collectors.toSet());
    Set<String> used = new HashSet<>();
    Queue<String> queue = new LinkedList<>();
    queue.offer(startGene);
    used.add(startGene);
    int step = 0;
    char[] chars = new char[]{'A', 'C', 'G', 'T'};
    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        String curr = queue.poll();
        if (curr.equals(endGene)) {
          return step;
        }
        for (char c : chars) {
          for (int j = 0; j < curr.length(); j++) {
            if (c == curr.charAt(j)) {
              continue;
            }
            StringBuilder sb = new StringBuilder(curr);
            sb.setCharAt(j, c);
            String ns = sb.toString();
            if (banks.contains(ns) && !used.contains(ns)) {
              queue.offer(ns);
              used.add(ns);
            }
          }
        }
      }
      step++;
    }
    return -1;
  }
  // end::answer[]

  public static void main(String[] args) {
    new _0433_MinimumGeneticMutation()
      .minMutation("AACCGGTT", "AAACGGTA", new String[]{"AACCGGTA", "AACCGCTA", "AAACGGTA"});
  }
}
