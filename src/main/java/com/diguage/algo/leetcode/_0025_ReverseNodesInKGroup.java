package com.diguage.algo.leetcode;

import com.diguage.algo.util.ListNode;

public class _0025_ReverseNodesInKGroup {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-04-02 16:12:21
   */
  public ListNode reverseKGroup(ListNode head, int k) {
    int size = 0;
    ListNode cur = head;
    while (cur != null) {
      size++;
      cur = cur.next;
    }
    int sect = size / k;
    // 如果长度不够一段，则直接返回
    if (sect == 0) {
      return head;
    }
    // 将链表分段做反转，再拼接
    ListNode dummy = new ListNode(0);
    ListNode tail = dummy;
    cur = head;
    for (int i = 0; i < sect; i++) {
      ListNode[] result = reverse(cur, cur, null, k);
      tail.next = result[0];
      tail = result[1];
      cur = result[2];
    }
    tail.next = cur; // 把最后的尾部给接上
    return dummy.next;
  }

  // 参数：1、head，2、curr，3、prev，4、k
  // 结果：1、head，2、tail（反转过来，参数的 head 就是 tail），3、next
  private ListNode[] reverse(ListNode head,
                             ListNode cur, ListNode prev, int k) {
    if (k == 0) {
      return new ListNode[]{null, head, cur};
    }
    ListNode[] result = reverse(head, cur.next, cur, k - 1);
    if (k == 1) {
      result[0] = cur;
    }
    cur.next = prev;
    return result;
  }
  // end::answer[]
}
