package com.diguage.algorithm.leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @author D瓜哥 · https://www.diguage.com
 * @since 2024-06-29 20:59:24
 */
public class _0752_OpenTheLock {
  /**
   * 在看到 BFS 的提示下，自己思考出来
   */
  public int openLock(String[] deadends, String target) {
    String origin = "0000";
    Set<String> deads = new HashSet<>();
    for (String deadend : deadends) {
      // 如果起始点就在黑名单里，直接返回
      if (deadend.equals(origin)) {
        return -1;
      }
      deads.add(deadend);
    }
    // 保存访问过的节点，防止出现循环节点
    Set<String> visited = new HashSet<>();
    // 使用 BFS 来处理
    Queue<String> queue = new LinkedList<>();
    queue.offer(origin);
    int step = 0;
    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        String cur = queue.poll();
        if (cur.equals(target)) {
          return step;
        }
        // 处理过就不再处理
        if (visited.contains(cur)) {
          continue;
        } else {
          visited.add(cur);
        }
        // 对字符串按字符位进行加减操作
        for (int j = 0; j < cur.length(); j++) {
          String plus = plus(cur, j);
          if (!deads.contains(plus)) {
            queue.offer(plus);
          }
          String minus = minus(cur, j);
          if (!deads.contains(minus)) {
            queue.offer(minus);
          }
        }
      }
      step++;
    }
    return -1;
  }

  private String plus(String str, int index) {
    StringBuilder sb = new StringBuilder(str);
    char c = sb.charAt(index);
    if (c == '9') {
      c = '0';
    } else {
      c += 1;
    }
    sb.replace(index, index + 1, String.valueOf(c));
    return sb.toString();
  }

  private String minus(String str, int index) {
    StringBuilder sb = new StringBuilder(str);
    char c = sb.charAt(index);
    if (c == '0') {
      c = '9';
    } else {
      c -= 1;
    }
    sb.replace(index, index + 1, String.valueOf(c));
    return sb.toString();
  }

  public static void main(String[] args) {
    int result = new _0752_OpenTheLock()
      .openLock(new String[]{"8888"}, "0009");
    System.out.println("result: " + result + " : " + (result == 1));
  }
}
