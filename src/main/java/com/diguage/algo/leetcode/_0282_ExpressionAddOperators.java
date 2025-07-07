package com.diguage.algo.leetcode;

import java.util.ArrayList;
import java.util.List;

public class _0282_ExpressionAddOperators {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-07-07 20:46:03
   */
  public List<String> addOperators(String num, int target) {
    List<String> result = new ArrayList<>();
    backtrack(num, target, result, new StringBuilder(), 0, 0, 0);
    return result;
  }

  private void backtrack(String num, int target, List<String> result,
                         StringBuilder path, int start, long eval, long pre) {
    if (start == num.length()) {
      if (target == eval) {
        result.add(path.toString());
      }
      return;
    }
    for (int i = start; i < num.length(); i++) {
      // 数字不能以 0 开头
      if (num.charAt(start) == '0' && i > start) {
        break;
      }
      long cur = Long.parseLong(num.substring(start, i + 1));
      int len = path.length();
      if (start == 0) {
        backtrack(num, target, result, path.append(cur), i + 1, cur, cur);
        // 通过设置长度来实现回溯
        path.setLength(len);
      } else {
        backtrack(num, target, result, path.append("+").append(cur), i + 1, eval + cur, cur);
        path.setLength(len);

        backtrack(num, target, result, path.append("-").append(cur), i + 1, eval - cur, -cur);
        path.setLength(len);

        backtrack(num, target, result, path.append("*").append(cur), i + 1,
          eval - pre + pre * cur, pre * cur);
        path.setLength(len);
      }
    }
  }

  // end::answer[]
  public static void main(String[] args) {
    new _0282_ExpressionAddOperators().addOperators("123456789", 45);
  }
}
