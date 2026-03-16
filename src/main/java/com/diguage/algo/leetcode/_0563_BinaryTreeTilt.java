package com.diguage.algo.leetcode;

import com.diguage.algo.util.TreeNode;

import java.util.Objects;

public class _0563_BinaryTreeTilt {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-03-16 21:41:43
   */
  public int findTilt(TreeNode root) {
    return dfs(root).tiltSum;
  }

  private Tilt dfs(TreeNode root) {
    if (Objects.isNull(root)) {
      return new Tilt();
    }
    Tilt left = dfs(root.left);
    Tilt right = dfs(root.right);
    int tilt = Math.abs(left.valSum - right.valSum);
    int tiltSum = left.tiltSum + right.tiltSum + tilt;
    int valSum = left.valSum + right.valSum + root.val;
    return new Tilt(tiltSum, valSum, tilt);
  }

  private static class Tilt {
    int tiltSum;
    int valSum;
    int tilt;

    public Tilt() {
    }

    public Tilt(int tiltSum, int valSum, int tilt) {
      this.tiltSum = tiltSum;
      this.valSum = valSum;
      this.tilt = tilt;
    }
  }
  // end::answer[]
}
