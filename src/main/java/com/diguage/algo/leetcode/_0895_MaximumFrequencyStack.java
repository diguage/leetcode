package com.diguage.algo.leetcode;

import java.util.*;

public class _0895_MaximumFrequencyStack {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-09-02 22:28:10
   */
  class FreqStack {
    private List<Deque<Integer>> stacks;
    private Map<Integer, Integer> cnt;

    public FreqStack() {
      stacks = new ArrayList<>();
      cnt = new HashMap<>();
    }

    public void push(int val) {
      int c = cnt.getOrDefault(val, 0);
      if (c == stacks.size()) {
        stacks.add(new ArrayDeque<>());
      }
      stacks.get(c).push(val);
      cnt.put(val, c + 1);
    }

    public int pop() {
      int top = stacks.size() - 1;
      Integer var = stacks.get(top).pop();
      if (stacks.get(top).isEmpty()) {
        stacks.remove(top);
      }
      cnt.merge(var, -1, Integer::sum);
      return var;
    }
  }
  // end::answer[]
}
