package com.diguage.algo.leetcode;

import com.diguage.algo.util.TreeNode;
import com.diguage.util.TreeNodes;

import java.util.Arrays;

/**
 */
public class _0538_ConvertBSTToGreaterTree_1 {
  // tag::answer[]

  /**
   * 基于 Morris 的倒序中根遍历
   *
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-06-26 20:50:34
   */
  public TreeNode convertBST(TreeNode root) {
    int sum = 0;
    // 反向 Morris
    TreeNode cur = root;
    TreeNode mostLeft = null;
    while (cur != null) {
      // 向右转
      mostLeft = cur.right;
      if (mostLeft != null) {
        // 寻找最左边的节点
        while (mostLeft.left != null && mostLeft.left != cur) {
          mostLeft = mostLeft.left;
        }
        if (mostLeft.left == null) {
          // 第一次访问，将最左节点的左子树指向当前节点
          mostLeft.left = cur;
          cur = cur.right;
          continue;
        } else {
          // 第二次访问，掐断中间建立的连接
          mostLeft.left = null;
        }
      }
      // 计算累加和
      sum += cur.val;
      cur.val = sum;
      cur = cur.left;
    }
    return root;
  }

  // end::answer[]


  public static void main(String[] args) {
    TreeNode tree = TreeNodes.buildTree(Arrays.asList(4, 2, 6, 1, 3, 5, 7));
    _0538_ConvertBSTToGreaterTree_1 solution = new _0538_ConvertBSTToGreaterTree_1();
    solution.convertBST(tree);
  }
}
