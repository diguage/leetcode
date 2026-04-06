package com.diguage.algo.leetcode;

public class _0622_DesignCircularQueue {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-04-06 18:28:56
   */
  class MyCircularQueue {
    private Integer[] data;
    private int capacity;
    private int head;
    private int tail;
    private int size;

    public MyCircularQueue(int k) {
      this.data = new Integer[k];
      this.capacity = k;
      this.head = 0;
      this.tail = 0;
      this.size = 0;
    }

    public boolean enQueue(int value) {
      if (isFull()) {
        return false;
      }
      data[head++ % this.capacity] = value;
      this.size++;
      return true;
    }

    public boolean deQueue() {
      if (isEmpty()) {
        return false;
      }
      data[this.tail++ % this.capacity] = null;
      this.size--;
      return true;
    }

    public int Front() {
      if (isEmpty()) {
        return -1;
      }
      return this.data[tail % this.capacity];
    }

    public int Rear() {
      if (isEmpty()) {
        return -1;
      }
      return this.data[(head - 1) % this.capacity];
    }

    public boolean isEmpty() {
      return this.size == 0;
    }

    public boolean isFull() {
      return this.size == this.capacity;
    }
  }

  // end::answer[]
  static void main() {
//    MyCircularQueue queue = new MyCircularQueue(6);
//    queue.enQueue(6);
//    System.out.println(queue.Rear());
//    System.out.println(queue.Rear());
//    System.out.println(queue.deQueue());
//    System.out.println(queue.enQueue(5));
//    System.out.println(queue.Rear());
//    System.out.println(queue.deQueue());
//    System.out.println(queue.Front());
//    System.out.println(queue.deQueue());
//    System.out.println(queue.deQueue());
//    System.out.println(queue.deQueue());

//    MyCircularQueue queue = new MyCircularQueue(3);
//    queue.enQueue(1);
//    queue.enQueue(2);
//    queue.enQueue(3);
//    queue.enQueue(4);
//    System.out.println(queue.Rear());
//    System.out.println(queue.isFull());
//    System.out.println(queue.deQueue());
//    queue.enQueue(4);
//    System.out.println(queue.Rear());

//    MyCircularQueue queue = new MyCircularQueue(2);
//    queue.enQueue(1);
//    queue.enQueue(2);
//    System.out.println(queue.deQueue());
//    queue.enQueue(3);
//    System.out.println(queue.deQueue());
//    queue.enQueue(3);
//    System.out.println(queue.deQueue());
//    queue.enQueue(3);
//    System.out.println(queue.deQueue());
//    System.out.println(queue.Front());
//
//    queue.enQueue(4);
//    System.out.println(queue.Rear());
  }
}
