package com.diguage.algo.leetcode;

import java.util.*;

public class _0609_FindDuplicateFileInSystem {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-04-04 19:10:59
   */
  public List<List<String>> findDuplicate(String[] paths) {
    Map<String, List<String>> result = new HashMap<>();
    for (String path : paths) {
      parse(path, result);
    }
    return result.values().stream()
      .filter(c -> c.size() > 1)
      .toList();
  }

  private void parse(String path, Map<String, List<String>> result) {
    path = path.substring(4);
    int index = 0;
    String root = null;
    // 使用 split 方法做字符串截断更简单
    while (index < path.length()) {
      int i = path.indexOf(" ", index);
      if (Objects.isNull(root)) {
        root = path.substring(index, i);
        index = i + 1;
        if (root.isEmpty()) {
          root = "/";
        }
        continue;
      }
      if (i < 0) {
        i = path.length();
      }
      int left = path.indexOf('(', index, i);
      int right = path.indexOf(')', left, i);
      String p = path.substring(index, left);
      String c = path.substring(left + 1, right);
      result.computeIfAbsent(c, _ -> new ArrayList<>())
        .add("root" + root + ("/".equals(root) ? "" : "/") + p);
      index = i + 1;
    }
  }
  // end::answer[]
}
