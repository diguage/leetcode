package com.diguage.algo.leetcode;

public class _0134_GasStation_2 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-06-05 21:32:18
   */
  public int canCompleteCircuit(int[] gas, int[] cost) {
    int start = 0;
    int oil = 0;
    boolean running = false;
    for (int i = 0; i < gas.length * 2; i++) {
      int index = i % gas.length;
      if (!running && gas[index] < cost[index]) {
        continue;
      }
      if (!running) {
        running = true;
        start = index;
      }
      oil += gas[index] - cost[index];
      if (oil < 0) {
        running = false;
        oil = 0;
        continue;
      }
      if (index == start - 1 || (start == 0 && index == gas.length - 1)) {
        return start;
      }
    }
    return -1;
  }

  // end::answer[]
  public static void main(String[] args) {
    new _0134_GasStation_2()
      .canCompleteCircuit(new int[]{5, 1, 2, 3, 4}, new int[]{4, 4, 1, 5, 1});
  }
}
