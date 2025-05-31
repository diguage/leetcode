package com.diguage.algo.leetcode;

import com.diguage.algo.util.TreeNode;
import com.diguage.util.TreeNodes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _1382_BalanceABinarySearchTree {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-05-31 22:12:20
   */
  public TreeNode balanceBST(TreeNode root) {
    List<TreeNode> data = new ArrayList<>();
    TreeNode cur = root;
    while (cur != null) {
      TreeNode mostRight = cur.left;
      if (mostRight != null) {
        while (mostRight.right != null && mostRight.right != cur) {
          mostRight = mostRight.right;
        }
        if (mostRight.right == null) {
          mostRight.right = cur;
          cur = cur.left;
          continue;
        } else {
          mostRight.right = null;
        }
      }
      data.add(cur);
      cur = cur.right;
    }
    TreeNode result = dfs(data, 0, data.size() - 1);
    return result;
  }

  private TreeNode dfs(List<TreeNode> data, int start, int end) {
    if (start > end) {
      return null;
    }
    int mid = start + (end - start) / 2;
    TreeNode node = data.get(mid);
    node.left = dfs(data, start, mid - 1);
    node.right = dfs(data, mid + 1, end);
    return node;
  }
  // end::answer[]
  public static void main(String[] args) {
    new _1382_BalanceABinarySearchTree()
      .balanceBST(TreeNodes.buildTree(Arrays.asList(4, 2, 6, 1, 3, 5, 7)));
  }
}
