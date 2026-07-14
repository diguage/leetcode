package com.diguage.algo.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class _0820_ShortEncodingOfWords {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-07-14 22:10:14
   */
  public int minimumLengthEncoding(String[] words) {
    // 按照长度从大到小排列，长度相同则按自然顺序排列
    // 更长的单词不可能为别的单词的后缀
    Arrays.sort(words, Comparator.comparing(String::length, Comparator.reverseOrder())
      .thenComparing(Comparator.naturalOrder()));
    StringBuilder sb = new StringBuilder();
    for (String word : words) {
      if (sb.indexOf(word + "#") >= 0) {
        continue;
      }
      sb.append(word).append('#');
    }
    return sb.length();
  }

  // end::answer[]
  static void main() {
    new _0820_ShortEncodingOfWords()
      .minimumLengthEncoding(new String[]{"feipyxx", "e"});
//      .minimumLengthEncoding(new String[]{"ctxdic","c"});
//      .minimumLengthEncoding(new String[]{"time", "me", "bell"});
  }
}
