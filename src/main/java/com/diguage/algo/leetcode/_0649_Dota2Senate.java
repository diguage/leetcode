package com.diguage.algo.leetcode;

import java.util.HashMap;
import java.util.Map;

public class _0649_Dota2Senate {
  // tag::answer[]

  /**
   * 通过了所有的测试用例。和官方答案相比，感觉又不对。
   *
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-04-28 09:02:03
   */
  public String predictPartyVictory(String senate) {
    Map<Character, Integer> counter = new HashMap<>();
    counter.put('R', 0);
    counter.put('D', 0);
    char[] chars = senate.toCharArray();
    for (char c : chars) {
      counter.put(c, counter.get(c) + 1);
    }
    int length = senate.length();
    for (int i = 0; counter.get('R') > 0 && counter.get('D') > 0; i++) {
      int baseIndex = i % length;
      if (chars[baseIndex] == '.') {
        continue;
      }
      for (int j = baseIndex + 1; j < 2 * length; j++) {
        int rivalIndex = j % length;
        if (chars[rivalIndex] == '.' || chars[baseIndex] == chars[rivalIndex]) {
          continue;
        }
        char rivalChar = chars[rivalIndex];
        chars[rivalIndex] = '.';
        counter.put(rivalChar, counter.get(rivalChar) - 1);
        break;
      }
      if (counter.get('R') <= 0 || counter.get('D') <= 0) {
        break;
      }
    }
    if (counter.get('R') <= 0) {
      return "Dire";
    } else {
      return "Radiant";
    }
  }

  // end::answer[]
  public static void main(String[] args) {
    new _0649_Dota2Senate().predictPartyVictory("DRRDRDRDRDDRDRDRD");
  }
}
