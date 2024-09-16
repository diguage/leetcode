package com.diguage.algo.leetcode;

import com.diguage.algo.util.ListNode;

public class _0237_DeleteNodeInALinkedList_2 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-09-16 20:54:33
   */
  public void deleteNode(ListNode node) {
    // 把后面一个元素拷贝过来
    node.val = node.next.val;
    // 把当前元素的下节点指针指向下下节点
    node.next = node.next.next;
  }
  // end::answer[]
}
