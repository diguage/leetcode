package com.diguage.algo.leetcode;

import java.util.*;

public class _0841_KeysAndRooms {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-05-24 18:48:35
   */
  public boolean canVisitAllRooms(List<List<Integer>> rooms) {
    Queue<Integer> queue = new LinkedList<>();
    queue.addAll(rooms.get(0));
    rooms.set(0, null);
    while (!queue.isEmpty()) {
      Integer key = queue.poll();
      List<Integer> keys = rooms.get(key);
      if (keys != null) {
        queue.addAll(keys);
        rooms.set(key, null);
      }
    }
    return rooms.stream().allMatch(Objects::isNull);
  }
  // end::answer[]

  public static void main(String[] args) {
    ;
    new _0841_KeysAndRooms().canVisitAllRooms(
      new ArrayList<List<Integer>>(List.of(List.of(1, 3), List.of(3, 0, 1), List.of(2), List.of(0)))
    );
  }
}
