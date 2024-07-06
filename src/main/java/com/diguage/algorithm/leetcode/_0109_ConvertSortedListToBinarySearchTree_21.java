package com.diguage.algorithm.leetcode;

import com.diguage.util.Jsons;
import com.diguage.algorithm.util.ListNode;
import com.diguage.algorithm.util.TreeNode;

import static com.diguage.util.ListNodes.build;
import static java.util.Arrays.asList;

/**
 * = 109. Convert Sorted List to Binary Search Tree
 *
 * https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/[LeetCode - Convert Sorted List to Binary Search Tree]
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2024-06-24 15:03:55
 */
public class _0109_ConvertSortedListToBinarySearchTree_21 {
  // tag::answer[]

  ListNode globalHead = null;

  /**
   * 分支+中序遍历
   *
   * 注：没想到这个的效率更高。有点不可思议。
   *
   * 参考： https://leetcode.cn/problems/convert-sorted-list-to-binary-search-tree/solutions/378582/you-xu-lian-biao-zhuan-huan-er-cha-sou-suo-shu-1-3/[109. 有序链表转换二叉搜索树 - 官方题解^]
   */
  public TreeNode sortedListToBST(ListNode head) {
    if (head == null) {
      return null;
    }
    int length = getLength(head);
    globalHead = head;
    return buildTree(0, length - 1);
  }

  private TreeNode buildTree(int left, int right) {
    if (left > right) {
      return null;
    }
    int mid = left + (right - left) / 2;
    TreeNode root = new TreeNode();
    root.left = buildTree(left, mid - 1);
    root.val = globalHead.val;
    globalHead = globalHead.next;
    root.right = buildTree(mid + 1, right);
    return root;
  }

  private int getLength(ListNode head) {
    int result = 0;
    while (head != null) {
      result++;
      head = head.next;
    }
    return result;
  }


  // end::answer[]


    public static void main(String[] args) {
        _0109_ConvertSortedListToBinarySearchTree_21 solution = new _0109_ConvertSortedListToBinarySearchTree_21();
        TreeNode r1 = solution.sortedListToBST(build(asList(-10, -3, 0, 5, 9)));
        System.out.println(Jsons.toJson(r1));
    }
}
