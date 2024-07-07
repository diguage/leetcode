package com.diguage.algo.leetcode;

import com.diguage.util.Jsons;
import com.diguage.algo.util.TreeNode;

/**
 * = 105. Construct Binary Tree from Preorder and Inorder Traversal
 *
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/[Construct Binary Tree from Preorder and Inorder Traversal - LeetCode]
 *
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 *
 * *Note:*
 *
 * You may assume that duplicates do not exist in the tree.
 *
 * For example, given
 *
 * ----
 * preorder = [3,9,20,15,7]
 * inorder = [9,3,15,20,7]
 * ----
 *
 * Return the following binary tree:
 *
 * ----
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * ----
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2020-01-04 20:25
 */
public class _0105_ConstructBinaryTreeFromPreorderAndInorderTraversal {
  // tag::answer[]
  /**
   * 自我实现，感觉比 https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/discuss/34538/My-Accepted-Java-Solution[My Accepted Java Solution - LeetCode Discuss] 简单。
   */
  public TreeNode buildTree(int[] preorder, int[] inorder) {
    if (preorder == null || inorder == null || preorder.length != inorder.length) {
      return null;
    }
    return buildTree(preorder, inorder, 0, 0, preorder.length);
  }

  private TreeNode buildTree(int[] preorder, int[] inorder, int pre, int in, int size) {
    int val = preorder[pre];
    TreeNode root = new TreeNode(val);
    int leftSize = 0;
    int i = in;
    for (; i < size + in; i++) {
      if (inorder[i] == val) {
        break;
      }
      leftSize++;
    }
    if (leftSize > 0) {
      root.left = buildTree(preorder, inorder, pre + 1, in, leftSize);
    }
    int rightSize = size - leftSize - 1;
    if (rightSize > 0) {
      root.right = buildTree(preorder, inorder, pre + leftSize + 1, i + 1, rightSize);
    }
    return root;
  }

  // end::answer[]


  public static void main(String[] args) {
    _0105_ConstructBinaryTreeFromPreorderAndInorderTraversal solution = new _0105_ConstructBinaryTreeFromPreorderAndInorderTraversal();
    int[] preorder = {3, 9, 20, 15, 7};
    int[] inorder = {9, 3, 15, 20, 7};
    TreeNode tree = solution.buildTree(preorder, inorder);
    System.out.println(Jsons.toJson(tree));
  }
}
