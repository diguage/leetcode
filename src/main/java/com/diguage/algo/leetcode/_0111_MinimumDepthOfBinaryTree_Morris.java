package com.diguage.algo.leetcode;

import com.diguage.algo.util.TreeNode;

import static com.diguage.util.TreeNodes.buildTree;
import static java.util.Arrays.asList;

/**
 * = 111. Minimum Depth of Binary Tree
 *
 * https://leetcode.com/problems/minimum-depth-of-binary-tree/[Minimum Depth of Binary Tree - LeetCode]
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2020-02-07 21:26
 */
public class _0111_MinimumDepthOfBinaryTree_Morris {
  // tag::answer[]

  /**
   * 参考左程云《程序员代码面试指南》的解法
   */
  public int minDepth(TreeNode head) {
    if (head == null) {
      return 0;
    }
    TreeNode cur = head;
    TreeNode mostRight = null;
    int curLevel = 0;
    int minHeight = Integer.MAX_VALUE;
    while (cur != null) {
      mostRight = cur.left;
      if (mostRight != null) { // 当前 cur 有左子树，能到达两次
        // cur 左子树上，右边界的节点个数
        int leftTreeRightSize = 1;
        // 找到 cur 左子树上最右边的节点
        while (mostRight.right != null && mostRight.right != cur) {
          leftTreeRightSize++;
          mostRight = mostRight.right;
        }
        if (mostRight.right == null) {
          // 第一次到达 cur，那么下一个节点的 level 必然+1
          curLevel++;
          mostRight.right = cur;
          cur = cur.left;
          continue;
        } else {
          // 第二次到达cur，那么下一个节点的 level = curLevel - leftTreeRightSize
          // 此时检查 mostRight 是不是叶节点，记录答案
          if (mostRight.left == null) {
            minHeight = Math.min(minHeight, curLevel);
          }
          curLevel -= leftTreeRightSize;
          mostRight.right = null;
        }
      } else {
        // 当前 cur 没有左子树，只能到达有ICI，那么下一个节点的 level 必然+1
        curLevel++;
      }
      cur = cur.right;
    }
    int finalRight = 1;
    cur = head;
    while (cur.right != null) {
      finalRight++;
      cur = cur.right;
    }
    // 最后不要忘了单独看一看整棵树的最右节点是不是叶节点
    if (cur.left == null && cur.right == null) {
      minHeight = Math.min(minHeight, finalRight);
    }
    return minHeight;
  }

  // end::answer[]


  public static void main(String[] args) {
    _0111_MinimumDepthOfBinaryTree_Morris solution = new _0111_MinimumDepthOfBinaryTree_Morris();
    int r1 = solution.minDepth(buildTree(asList(3, 9, 20, null, null, 15, 7)));
    System.out.println((r1 == 2) + " : " + r1);
  }
}
