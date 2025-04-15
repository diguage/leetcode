package com.diguage.algo.leetcode;

import java.util.ArrayList;
import java.util.List;

public class _0093_RestoreIpAddresses_2 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2020-02-06 10:00
   */
  public List<String> restoreIpAddresses(String s) {
    List<String> result = new ArrayList<>();
    backtrack(s, result, new ArrayList<>(4), 0);
    return result;
  }

  private void backtrack(String s, List<String> result, List<String> path, int index) {
    if (path.size() == 4) {
      if (index == s.length()) {
        result.add(String.join(".", path));
      }
      return;
    }
    for (int i = 1; i <= 3; i++) {
      int end = index + i;
      if (end > s.length()) {
        break;
      }
      String nums = s.substring(index, end);
      if (Integer.parseInt(nums) > 255) {
        break;
      }
      path.add(nums);
      backtrack(s, result, path, end);
      path.removeLast();
      // 如果起始字符是 0，则只处理 0 这一种情况，不允许出现 01 等情况
      if (s.charAt(index) == '0') {
        break;
      }
    }
  }

  // end::answer[]
  public static void main(String[] args) {
    new _0093_RestoreIpAddresses_2().restoreIpAddresses("101023");
  }
}
