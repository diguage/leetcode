package com.diguage.algorithm.leetcode;

import java.util.Arrays;

import static com.diguage.algorithm.leetcode._0116_PopulatingNextRightPointersInEachNode.Node;
import static com.diguage.algorithm.leetcode._0116_PopulatingNextRightPointersInEachNode.build;

/**
 * = 116. Populating Next Right Pointers in Each Node
 * 
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node/[Populating Next Right Pointers in Each Node - LeetCode]
 * 
 * You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. The binary tree has the following definition:
 * 
 * [source,cpp]
 * ----
 * struct Node {
 * int val;
 * Node *left;
 * Node *right;
 * Node *next;
 * }
 * ----
 * 
 * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to `NULL`.
 * 
 * Initially, all next pointers are set to `NULL`.
 * 
 * *Follow up:*
 * 
 * * You may only use constant extra space.
 * * Recursive approach is fine, you may assume implicit stack space does not count as extra space for this problem.
 * 
 * .Example:
 * [source]
 * ----
 * Input: root = [1,2,3,4,5,6,7]
 * Output: [1,#,2,3,#,4,5,6,7,#]
 * Explanation: Given the above perfect binary tree (Figure A), your function should populate each next pointer to point to its next right node, just like in Figure B. The serialized output is in level order as connected by the next pointers, with '#' signifying the end of each level.
 * ----
 * 
 * *Constraints:*
 * 
 * * The number of nodes in the given tree is less than `4096`.
 * * `-1000 <= node.val <= 1000`
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2024-06-25 16:22:49
 */
public class _0116_PopulatingNextRightPointersInEachNode_21 {
  /**
   * 根据提示写出来的：在上一层建立下一层的链接。
   * 
   * 根据思考的过程，最重要的就是保存每一层的最左节点。这是每一层的起始位置。
   * 另外，每层循环的结束是当前节点为 `null` 了。（每层最后的一个节点没有 `next` 节点）。
   */
  public Node connect(Node root) {
// 原始手写代码
//    if (root == null) {
//      return root;
//    }
//    Node mostLeft = root;
//    while (mostLeft != null) {
//      Node cur = mostLeft;
//      mostLeft = mostLeft.left;
//      // 这个变量不需要，因为可以通过 cur.next.left 获得
//      Node right = null;
//      while (cur != null) {
//        if (right != null) {
//          right.next = cur.left;
//        }
//        if (cur.left != null) {
//          cur.left.next = cur.right;
//        }
//        right = cur.right;
//        cur = cur.next;
//      }
//    }
//    return root;
    // 参考官方题解后的精简代码
    if (root == null) {
      return null;
    }
    // 重点有三个
    // 1. 寻找最左节点
    Node mostLeft = root;
    while (mostLeft != null) {
      // 遍历这一层节点组织成的链表，为下一层的节点更新 next 指针
      Node cur = mostLeft;
      // 3. 确定每层的结束条件
      while (cur != null) {
        // 第一种情况：当前节点的左右子节点简历联系
        if (cur.left != null) {
          cur.left.next = cur.right;
        }
        // 2. 建立左树右节点到右树左节点的链接
        // 第二种情况：建立左树右节点到右树左节点的链接
        if (cur.right != null && cur.next != null) {
          cur.right.next = cur.next.left;
        }
        // 向后移动指针
        cur = cur.next;
      }
      mostLeft = mostLeft.left;
    }
    return root;
  }

  public static void main(String[] args) {
    _0116_PopulatingNextRightPointersInEachNode_21 solution = new _0116_PopulatingNextRightPointersInEachNode_21();
    Node node = solution.connect(build(Arrays.asList(0, 1, 2, 3, 4, 5)));
    System.out.println(node);
  }
}
