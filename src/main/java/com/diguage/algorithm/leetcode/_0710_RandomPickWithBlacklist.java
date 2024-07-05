package com.diguage.algorithm.leetcode;

import java.util.*;

public class _0710_RandomPickWithBlacklist {
  class Solution {
    Map<Integer, Integer> b2w;
    Random random;
    int size;

    /**
     * 把黑名单都放在最后
     */
    public Solution(int n, int[] blacklist) {
      size = n - blacklist.length;
      random = new Random();
      b2w = new HashMap<>();
      List<Integer> sb = new ArrayList<>();
      List<Integer> bw = new ArrayList<>();
      Set<Integer> bb = new HashSet<>();
      for (int i = 0; i < blacklist.length; i++) {
        int b = blacklist[i];
        // 按照界限，把黑名单数字按照大小分开
        if (b >= size) {
          bb.add(b);
        } else {
          sb.add(b);
        }
      }
      for (int i = n - 1; i >= size; i--) {
        // 从最后的数字里找出不是黑名单的数字
        if (!bb.contains(i)) {
          bw.add(i);
        }
      }
      // 建立起黑→白的对应关系
      while (!sb.isEmpty() && !bw.isEmpty()) {
        Integer b = sb.remove(sb.size() - 1);
        Integer w = bw.remove(bw.size() - 1);
        b2w.put(b, w);
      }
    }

    public int pick() {
      int val = random.nextInt(size);
      return b2w.getOrDefault(val, val);
    }
  }
}
