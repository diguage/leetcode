package com.diguage.algo.leetcode;

import java.util.Arrays;

public class _0881_BoatsToSavePeople {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-09-15 23:20:35
   */
  public int numRescueBoats(int[] people, int limit) {
    Arrays.sort(people);
    int result = 0;
    int light = 0, heavy = people.length - 1;
    while (light <= heavy) {
      if (people[light] + people[heavy] < limit) {
        light++;
      }
      heavy--;
      result++;
    }
    return result;
  }
  // end::answer[]
}
