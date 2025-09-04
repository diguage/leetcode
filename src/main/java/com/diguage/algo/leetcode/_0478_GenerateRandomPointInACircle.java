package com.diguage.algo.leetcode;

import java.util.Random;

public class _0478_GenerateRandomPointInACircle {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-09-04 21:48:11
   */
  class Solution {
    private double x;
    private double y;
    private double r;
    private Random random;

    public Solution(double radius, double x_center, double y_center) {
      this.x = x_center;
      this.y = y_center;
      this.r = radius;
      random = new Random();
    }

    public double[] randPoint() {
      // 循环法
      while (true) {
        double rx = random.nextDouble(2 * r);
        double ry = random.nextDouble(2 * r);
        if (Math.pow(r - rx, 2) + Math.pow(r - ry, 2) <= Math.pow(r, 2)) {
          return new double[]{rx + (x - r), ry + (y - r)};
        }
      }
      // 递归法
      //  double rx = random.nextDouble(2 * r);
      //  double ry = random.nextDouble(2 * r);
      //  if (Math.pow(r - rx, 2) + Math.pow(r - ry, 2) > Math.pow(r, 2)) {
      //    return randPoint();
      //  } else {
      //    return new double[]{rx + (x - r), ry + (y - r)};
      //  }
    }
  }
  // end::answer[]
}
