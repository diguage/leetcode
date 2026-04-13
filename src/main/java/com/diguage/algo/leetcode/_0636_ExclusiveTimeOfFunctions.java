package com.diguage.algo.leetcode;

import java.util.*;

public class _0636_ExclusiveTimeOfFunctions {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-04-13 19:48:20
   */
  public int[] exclusiveTime(int n, List<String> logs) {
    Deque<Item> stack = new ArrayDeque<>();
    int[] result = new int[n];
    Item pre = null;
    for (String log : logs) {
      Item item = parse(log);
      if ("start".equals(item.status)) {
        if (!stack.isEmpty()) {
          Item head = stack.peek();
          result[head.id] += item.time - pre.time;
        }
        stack.push(item);
      } else {
        Item head = stack.pop();
        result[head.id] += item.time - pre.time;
      }
      pre = item;
    }
    return result;
  }

  private Item parse(String log) {
    Item item = new Item();
    int ai = log.indexOf(":");
    item.id = Integer.parseInt(log.substring(0, ai));
    int bi = log.lastIndexOf(":");
    item.status = log.substring(ai + 1, bi);
    item.time = Integer.parseInt(log.substring(bi + 1));
    // end 向后延迟一个单位，简化处理
    if ("end".equals(item.status)) {
      item.time++;
    }
    return item;
  }

  private static class Item {
    int id;
    String status;
    int time;
  }

  // end::answer[]

  static void main() {
    new _0636_ExclusiveTimeOfFunctions().exclusiveTime(2, List.of("0:start:0", "1:start:2", "1:end:5", "0:end:6"));
  }
}
