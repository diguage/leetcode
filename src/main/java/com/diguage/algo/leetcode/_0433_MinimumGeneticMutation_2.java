package com.diguage.algo.leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class _0433_MinimumGeneticMutation_2 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-02-03 22:51:25
   */
  public int minMutation(String startGene, String endGene, String[] bank) {
    Set<String> banks = Arrays.stream(bank).collect(Collectors.toSet());
    int step = 0;
    Queue<String> queue = new LinkedList<>();
    queue.offer(startGene);
    char[] chars = new char[]{'A', 'C', 'G', 'T'};
    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        String curr = queue.poll();
        if (endGene.equals(curr)) {
          return step;
        }

        for (int j = 0; j < curr.length(); j++) {
          char c = curr.charAt(j);
          StringBuilder sb = new StringBuilder(curr);
          for (char nc : chars) {
            if (nc == c) {
              continue;
            }
            sb.setCharAt(j, nc);
            String gene = sb.toString();
            if (banks.contains(gene)) {
              queue.offer(gene);
              banks.remove(gene);
            }
          }
        }
      }
      step++;
    }
    return -1;
  }

  // end::answer[]
  static void main() {
    new _0433_MinimumGeneticMutation_2()
      .minMutation("AACCGGTT", "AAACGGTA",
        new String[]{"AACCGATT", "AACCGATA", "AAACGATA", "AAACGGTA"});
  }
//  AACCGGTT
//  AAACGGTT
//  AAACGGTA
//  AAACGGTA
}
