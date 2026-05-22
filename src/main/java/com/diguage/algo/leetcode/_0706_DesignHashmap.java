package com.diguage.algo.leetcode;

import java.util.Arrays;

public class _0706_DesignHashmap {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-05-22 23:10:56
   */
  class MyHashMap {
    private int[] data;

    public MyHashMap() {
      data = new int[1_000_001];
      Arrays.fill(data, -1);
    }

    public void put(int key, int value) {
      data[key] = value;
    }

    public int get(int key) {
      return data[key];
    }

    public void remove(int key) {
      data[key] = -1;
    }
  }
  // end::answer[]
}
