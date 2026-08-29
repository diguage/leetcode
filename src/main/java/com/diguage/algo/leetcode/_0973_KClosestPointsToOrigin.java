package com.diguage.algo.leetcode;

import java.util.Arrays;

public class _0973_KClosestPointsToOrigin {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-08-29 21:55:28
   */
  public int[][] kClosest(int[][] points, int k) {
    quickSelect(points, k - 1, 0, points.length - 1);
    return Arrays.copyOfRange(points, 0, k);
  }

  private void quickSelect(int[][] points, int idx, int left, int right) {
    if (left >= right) {
      return;
    }
    int p = partittion(points, left, right);
    if (p == idx) {
      return;
    }
    if (p < idx) {
      quickSelect(points, idx, p + 1, right);
    } else {
      quickSelect(points, idx, left, p - 1);
    }
  }

  private int partittion(int[][] points, int left, int right) {
    int[] v = points[left];
    int dist = v[0] * v[0] + v[1] * v[1];
    int l = left, r = right + 1;
    while (l <= r) {
      while (++l <= right && points[l][0] * points[l][0] + points[l][1] * points[l][1] < dist) {
      }
      while (left <= --r && points[r][0] * points[r][0] + points[r][1] * points[r][1] > dist) {
      }
      if (l >= r) {
        break;
      }
      swap(points, l, r);
    }
    points[left] = points[r];
    points[r] = v;
    return r;
  }

  private void swap(int[][] points, int a, int b) {
    int[] tmp = points[a];
    points[a] = points[b];
    points[b] = tmp;
  }
  // end::answer[]
//  public int[][] kClosest(int[][] points, int k) {
//    quickSort(points, k, 0, points.length - 1);
//    int[][] result = new int[k][2];
//    System.arraycopy(points, 0, result, 0, k);
//    return result;
//  }
//
//  private void quickSort(int[][] nums, int k, int left, int right) {
//    if (left >= right) {
//      return;
//    }
//    int l = left, r = right;
//    int pivot = left + ((right - left) / 2);
//    int pn = nums[pivot][0] * nums[pivot][0] + nums[pivot][1] * nums[pivot][1];
//    while (l <= r) {
//      while (l < r
//        && nums[l][0] * nums[l][0] + nums[l][1] * nums[l][1] < pn) {
//        l++;
//      }
//      while (l < r
//        && pn < nums[r][0] * nums[r][0] + nums[r][1] * nums[r][1]) {
//        r--;
//      }
//      if (l <= r) {
//        int[] temp = nums[l];
//        nums[l] = nums[r];
//        nums[r] = temp;
//        l++;
//        r--;
//      }
//
//    }
//    if (k <= r) {
//      quickSort(nums, k, left, r);
//    } else if (k >= l) {
//      quickSort(nums, k, l, right);
//    }
//  }
  // end::answer[]

  static void main() {
    new _0973_KClosestPointsToOrigin()
      .kClosest(new int[][]{{3, 3}, {5, -1}, {-2, 4}}, 1);
//      .kClosest(new int[][]{{1, 3}, {-2, 2}}, 1);
  }
}
