package com.diguage.algo.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class _0225_ImplementStackUsingQueues {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-07-02 16:59:24
   */
  class MyStack {

    // 一个队列解法
    private Queue<Integer> queue;

    public MyStack() {
      queue = new LinkedList<>();
    }

    public void push(int x) {
      int size = queue.size();
      queue.offer(x);
      for (int i = 0; i < size; i++) {
        queue.offer(queue.poll());
      }
    }

    public int pop() {
      return queue.poll();
    }

    public int top() {
      return queue.peek();
    }

    public boolean empty() {
      return queue.isEmpty();
    }

    //    // 两个队列的解法
    //    private Queue<Integer> q1;
    //    private Queue<Integer> q2;
    //
    //    public MyStack() {
    //      q1 = new LinkedList<>();
    //      q2 = new LinkedList<>();
    //    }
    //
    //    public void push(int x) {
    //      if (q1.isEmpty()) {
    //        q1.offer(x);
    //        while (!q2.isEmpty()) {
    //          q1.offer(q2.poll());
    //        }
    //      } else {
    //        q2.offer(x);
    //        while (!q1.isEmpty()) {
    //          q2.offer(q1.poll());
    //        }
    //      }
    //    }
    //
    //    public int pop() {
    //      if (q1.isEmpty()) {
    //        return q2.poll();
    //      } else {
    //        return q1.poll();
    //      }
    //    }
    //
    //    public int top() {
    //      if (q1.isEmpty()) {
    //        return q2.peek();
    //      } else {
    //        return q1.peek();
    //      }
    //    }
    //
    //    public boolean empty() {
    //      if (q1.isEmpty()) {
    //        return q2.isEmpty();
    //      } else {
    //        return q1.isEmpty();
    //      }
    //    }
  }
  // end::answer[]
}
