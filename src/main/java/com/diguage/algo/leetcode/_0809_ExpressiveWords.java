package com.diguage.algo.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class _0809_ExpressiveWords {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-07-04 22:31:50
   */
  public int expressiveWords(String s, String[] words) {
    Object[] data = get(s);
    int result = 0;
    List<Integer> cnt = (List<Integer>) data[1];
    for (String word : words) {
      Object[] wd = get(word);
      if (!Objects.equals(data[0], wd[0])) {
        continue;
      }
      List<Integer> wcnt = (List<Integer>) wd[1];
      boolean flag = true;
      for (int i = 0; i < cnt.size(); i++) {
        Integer a = cnt.get(i);
        Integer b = wcnt.get(i);
        if (Objects.equals(a, b)) {
          continue;
        }
        if (b > a || a < 3) {
          flag = false;
          break;
        }
      }
      if (flag) {
        result += 1;
      }
    }
    return result;
  }

  private Object[] get(String s) {
    List<Character> chars = new ArrayList<>();
    List<Integer> count = new ArrayList<>();
    chars.add(s.charAt(0));
    count.add(1);
    char[] array = s.toCharArray();
    for (int i = 1; i < array.length; i++) {
      if (array[i] == chars.getLast()) {
        Integer cnt = count.removeLast();
        count.add(cnt + 1);
      } else {
        chars.add(array[i]);
        count.add(1);
      }
    }
    return new Object[]{chars, count};
  }
  // end::answer[]

  static void main() {
    new _0809_ExpressiveWords().expressiveWords("heeellooo", new String[]{"hello", "hi", "helo"});
  }
}
