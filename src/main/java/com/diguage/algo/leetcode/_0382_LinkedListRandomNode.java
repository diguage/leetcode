package com.diguage.algo.leetcode;

import com.diguage.algo.util.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class _0382_LinkedListRandomNode {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-07-27 21:16:24
   */
  class Solution {
    // 方案一：将节点存入 ArrayList 中。
    //    private Random random;
    //    private List<ListNode> nodes;
    //    public Solution(ListNode head) {
    //      nodes = new ArrayList<>();
    //      while (head != null) {
    //        nodes.add(head);
    //        head = head.next;
    //      }
    //      random = new Random();
    //    }
    //
    //    public int getRandom() {
    //      if (nodes == null || nodes.size() == 0) {
    //        return 0;
    //      }
    //      return nodes.get(random.nextInt(nodes.size())).val;
    //    }

    // 方案三：将 Link List 转换成 ArrayList
    private Random random;
    private List<Integer> nodes;

    public Solution(ListNode head) {
      nodes = new ArrayList<>();
      while (head != null) {
        nodes.add(head.val);
        head = head.next;
      }
      random = new Random();
    }

    public int getRandom() {
      if (nodes == null || nodes.size() == 0) {
        return 0;
      }
      return nodes.get(random.nextInt(nodes.size()));
    }

    // 方案二：计算长度，每次都从头向后遍历来取选中的值
    //    private Random random;
    //    private int size;
    //    private ListNode head;
    //
    //    public Solution(ListNode head) {
    //      random = new Random();
    //      this.size = 0;
    //      this.head = head;
    //      while (head != null) {
    //        this.size++;
    //        head = head.next;
    //      }
    //    }
    //
    //    public int getRandom() {
    //      if (size == 0) {
    //        return 0;
    //      }
    //      int num = random.nextInt(size);
    //      ListNode curr = head;
    //      for (int i = 0; i < num; i++) {
    //        curr = curr.next;
    //      }
    //      return curr.val;
    //    }
  }
  // end::answer[]
}
