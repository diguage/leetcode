package com.diguage.algo.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class _1700_NumberOfStudentsUnableToEatLunch {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-05-22 18:05:05
   */
  public int countStudents(int[] students, int[] sandwiches) {
    Queue<Integer> queue = new LinkedList<>();
    for (int student : students) {
      queue.offer(student);
    }
    for (int i = 0; i < sandwiches.length; i++) {
      int sandwich = sandwiches[i];
      int size = queue.size();
      while (queue.peek() != sandwich && size > 0) {
        queue.offer(queue.poll());
        size--;
      }
      if (size == 0) {
        break;
      }
      queue.poll();
    }
    return queue.size();
  }

  // end::answer[]
  public static void main(String[] args) {
    new _1700_NumberOfStudentsUnableToEatLunch()
      .countStudents(new int[]{1, 1, 0, 0}, new int[]{0, 1, 0, 1});
  }
}
