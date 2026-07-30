package com.diguage.algo.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class _0840_MagicSquaresInGrid {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-07-29 22:40:19
   */
  public int numMagicSquaresInside(int[][] grid) {
    if (grid.length < 3 || grid[0].length < 3) {
      return 0;
    }
    List<int[]> fivePoint = new ArrayList<>();
    for (int r = 0; r < grid.length; r++) {
      for (int c = 0; c < grid[r].length; c++) {
        if (grid[r][c] == 5) {
          // 靠边的 5 不要
          if (r == 0 || r == grid.length - 1
            || c == 0 || c == grid[r].length - 1) {
            continue;
          }
          fivePoint.add(new int[]{r, c});
        }
      }
    }
    if (fivePoint.isEmpty()) {
      return 0;
    }
    int result = 0;
    for (int[] five : fivePoint) {
      if (isMagic(grid, five[0], five[1])) {
        result++;
      }
    }
    return result;

  }

  private boolean isMagic(int[][] grid, int r, int c) {
    int n11 = grid[r - 1][c - 1];
    int n12 = grid[r - 1][c];
    int n13 = grid[r - 1][c + 1];
    int n21 = grid[r][c - 1];
    int n22 = grid[r][c];
    int n23 = grid[r][c + 1];
    int n31 = grid[r + 1][c - 1];
    int n32 = grid[r + 1][c];
    int n33 = grid[r + 1][c + 1];
    List<Integer> nums = List.of(
      n11, n12, n13,
      n21, n22, n23,
      n31, n32, n33);
    int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
    for (Integer num : nums) {
      min = Math.min(min, num);
      if (min < 1) {
        return false;
      }
      max = Math.max(max, num);
      if (max > 9) {
        return false;
      }
    }
    if (min != 1 || max != 9) {
      return false;
    }
    Set<Integer> set = Set.copyOf(nums);
    if (set.size() != 9) {
      return false;
    }
    // 行
    if (n11 + n12 + n13 != 15
      || n21 + n22 + n23 != 15
      || n31 + n32 + n33 != 15) {
      return false;
    }
    // 列
    if (n11 + n21 + n31 != 15
      || n12 + n22 + n32 != 15
      || n13 + n23 + n33 != 15) {
      return false;
    }
    // 对角线
    if (n11 + n22 + n33 != 15
      || n13 + n22 + n31 != 15) {
      return false;
    }
    return true;
  }
  // end::answer[]
}
