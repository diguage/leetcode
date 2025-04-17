package com.diguage.algo.leetcode;

import com.diguage.algo.util.TreeNode;
import com.diguage.util.TreeNodes;

import java.util.Arrays;

public class _0337_HouseRobberIii_2 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-04-17 15:26:16
   */
  public int rob(TreeNode root) {
    if (root == null) return 0;
    int[] dp = dfs(root);
    return Math.max(dp[0], dp[1]);
  }

  private int[] dfs(TreeNode root) {
    if (root == null) {
      return new int[]{0, 0};
    }
    // result[0] 表示包含当前根节点时，可取的最大值
    // result[1] 表示不包含当前根节点，也就是下级节点可取的最大值
    // dp[0] = max(root.val + left[1] + right[1], left[0] + right[0])
    //         在取当前节点和不取当前节点两者中选最大的一个
    // 向上推进一层，则下一级的 result[0] 之和，就是上一层的 result[1]
    int[] left = dfs(root.left);
    int[] right = dfs(root.right);
    int currMax = Math.max(root.val + left[1] + right[1], left[0] + right[0]);
    int childMax = left[0] + right[0];
    return new int[]{currMax, childMax};
  }

  // end::answer[]
  public static void main(String[] args) {
    new _0337_HouseRobberIii_2()
      .rob(TreeNodes.buildTree(
        Arrays.asList(4, 1, null, 2, null, null, null, 3)));
  }
}
