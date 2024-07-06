package com.diguage.algorithm.leetcode;

import com.diguage.algorithm.util.TreeNode;

import java.util.HashMap;
import java.util.Map;

import static com.diguage.util.Jsons.toJson;

/**
 * = 106. Construct Binary Tree from Inorder and Postorder Traversal
 * <p>
 * https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/[Construct Binary Tree from Inorder and Postorder Traversal - LeetCode]
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2024-06-14 17:07:33
 */
public class _0106_ConstructBinaryTreeFromInorderAndPostorderTraversal_2 {
  // tag::answer[]

  /**
   *在自己实现的基础上，参考： https://leetcode.cn/problems/construct-binary-tree-from-inorder-and-postorder-traversal/solutions/426738/cong-zhong-xu-yu-hou-xu-bian-li-xu-lie-gou-zao-14/comments/2236345 解决了下标错误的问题。
   */
  public TreeNode buildTree(int[] inorder, int[] postorder) {
    if (inorder == null || postorder == null || inorder.length != postorder.length) {
      return null;
    }
    Map<Integer, Integer> numToIndex = new HashMap<>();
    for (int i = 0; i < inorder.length; i++) {
      numToIndex.put(inorder[i], i);
    }
    return buildTree(inorder, postorder, numToIndex, 0, inorder.length - 1, 0, postorder.length - 1);
  }

  private TreeNode buildTree(int[] inorder, int[] postorder, Map<Integer, Integer> numToIndex, int inStart, int inEnd, int postStart, int postEnd) {
    if (inStart > inEnd || postStart > postEnd) {
      return null;
    }
    int value = postorder[postEnd];
    TreeNode root = new TreeNode(value);
    int index = numToIndex.get(value);
    int size = index - inStart;
    root.left = buildTree(inorder, postorder, numToIndex, inStart, index - 1, postStart, postStart + size - 1);
    root.right = buildTree(inorder, postorder, numToIndex, index + 1, inEnd, postStart + size, postEnd - 1);
    return root;
  }

  // end::answer[]


  public static void main(String[] args) {
    _0106_ConstructBinaryTreeFromInorderAndPostorderTraversal_2
      solution = new _0106_ConstructBinaryTreeFromInorderAndPostorderTraversal_2();
//        TreeNode r1 = solution.buildTree(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3});
    TreeNode r1 = solution.buildTree(new int[]{1, 2}, new int[]{2, 1});
    System.out.println(toJson(r1));
  }
}
