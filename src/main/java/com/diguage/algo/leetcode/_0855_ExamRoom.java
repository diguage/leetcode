package com.diguage.algo.leetcode;

import java.util.PriorityQueue;
import java.util.TreeSet;

public class _0855_ExamRoom {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-08-09 22:10:35
   */
  class ExamRoom {
    int n;
    TreeSet<Integer> seats;
    PriorityQueue<int[]> queue;

    public ExamRoom(int n) {
      this.n = n;
      this.seats = new TreeSet<>();
      this.queue = new PriorityQueue<>((a, b) -> {
        int d1 = a[1] - a[0], d2 = b[1] - b[0];
        return d1 / 2 < d2 / 2 || (d1 / 2 == d2 / 2 && a[0] > b[0]) ? 1 : -1;
      });
    }

    public int seat() {
      if (seats.isEmpty()) {
        seats.add(0);
        return 0;
      }
      int left = seats.first(), right = n - 1 - seats.last();
      while (seats.size() >= 2) {
        int[] p = queue.peek();
        // 不属于延迟删除的区间
        if (seats.contains(p[0]) && seats.contains(p[1]) && seats.higher(p[0]) == p[1]) {
          int d = p[1] - p[0];
          if (d / 2 < right || d / 2 <= left) { // 最左或最右的座位更优
            break;
          }
          queue.poll();
          queue.offer(new int[]{p[0], p[0] + d / 2});
          queue.offer(new int[]{p[0] + d / 2, p[1]});
          seats.add(p[0] + d / 2);
          return p[0] + d / 2;
        }
        queue.poll(); // leave 函数中延迟删除的区间在此时删除
      }
      if (right > left) { // 最右的位置更优
        queue.offer(new int[]{seats.getLast(), n - 1});
        seats.add(n - 1);
        return n - 1;
      } else {
        queue.offer(new int[]{0, seats.getFirst()});
        seats.add(0);
        return 0;
      }

    }

    public void leave(int p) {
      if (p != seats.first() && p != seats.last()) {
        int prev = seats.lower(p), next = seats.higher(p);
        queue.offer(new int[]{prev, next});
      }
      seats.remove(p);
    }
  }
  // end::answer[]

//  /**
//   * @author D瓜哥 · https://www.diguage.com
//   * @since 2026-08-09 22:10:35
//   */
//  static class ExamRoom {
//    private int max;
//    private List<Integer> seats;
//    PriorityQueue<int[]> queue;
//
//    public ExamRoom(int n) {
//      max = n - 1;
//      seats = new ArrayList<>();
//      queue = new PriorityQueue<>(
//        Comparator.comparingInt((int[] a) -> (a[1] - a[0]) / 2).reversed()
//          .thenComparingInt(a -> a[0]));
//    }
//
//    public int seat() {
//      if (seats.isEmpty()) {
//        seats.add(0);
//        return 0;
//      } else if (seats.size() == 1) {
//        if (seats.getLast() / 2 >= (max - seats.getLast()) / 2 && seats.getLast() != 0) {
//          seats.add(0, 0);
//          queue.offer(new int[]{seats.getFirst(), seats.getLast()});
//          return 0;
//        } else {
//          seats.add(max);
//          queue.offer(new int[]{seats.getFirst(), seats.getLast()});
//          return max;
//        }
//      } else {
//        if (queue.isEmpty()) {
//          if (seats.getFirst() != 0) {
//            queue.offer(new int[]{-1, seats.getFirst()});
//          }
//          for (int i = 1; i < seats.size(); i++) {
//            if (seats.get(i - 1) + 1 < seats.get(i)) {
//              queue.offer(new int[]{seats.get(i - 1), seats.get(i)});
//            }
//          }
//          if (seats.getLast() != max) {
//            queue.offer(new int[]{seats.getLast(), max + 1});
//          }
//        }
//        int[] range = queue.poll();
//        int result = range[0] + (range[1] - range[0]) / 2;
//        if (range[0] + 1 < result) {
//          queue.offer(new int[]{range[0], result});
//        }
//        if (result + 1 < range[1]) {
//          queue.offer(new int[]{result, range[1]});
//        }
//        seats.add(search(range[0]) + 1, result);
//        return result;
//      }
//    }
//
//    public void leave(int p) {
//      queue.clear();
//      seats.remove(search(p));
//    }
//
//    private int search(int p) {
//      if (p < 0) {
//        return -1;
//      }
//      int left = 0, right = seats.size() - 1;
//      while (left < right) {
//        int mid = left + (right - left) / 2;
//        if (seats.get(mid) < p) {
//          left = mid + 1;
//        } else {
//          right = mid;
//        }
//      }
//      return right;
//    }
//  }
//  static void main() {
//    ExamRoom room = new ExamRoom(2);

//    ExamRoom room = new ExamRoom(2);
//    room.seat();
//    room.seat();
//    room.leave(0);
//    ExamRoom room = new ExamRoom(10);
//    System.out.println(room.seat());
//    System.out.println(room.seat());
//    System.out.println(room.seat());
//    room.leave(0);
//    room.leave(4);
//    System.out.println(room.seat());
//    System.out.println(room.seat());
//    System.out.println(room.seat());
//    System.out.println(room.seat());
//    System.out.println(room.seat());
//    System.out.println(room.seat());
//    System.out.println(room.seat());
//    System.out.println(room.seat());
//    System.out.println(room.seat());
//    room.leave(0);
//    room.leave(4);
//    System.out.println(room.seat());
//    System.out.println(room.seat());
//    room.leave(7);
//    System.out.println(room.seat());
//    room.leave(3);
//    System.out.println(room.seat());
//    room.leave(3);
//    System.out.println(room.seat());
//    room.leave(9);
//    System.out.println(room.seat());
//    room.leave(0);
//    room.leave(8);
//    System.out.println(room.seat());
//    System.out.println(room.seat());
//    room.leave(2);
//  }
}
