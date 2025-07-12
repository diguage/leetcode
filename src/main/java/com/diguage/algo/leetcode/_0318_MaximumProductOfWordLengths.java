package com.diguage.algo.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class _0318_MaximumProductOfWordLengths {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-03-24 20:39:51
   */
  public int maxProduct(String[] words) {
    Arrays.sort(words, Comparator.comparingInt(String::length));
    Map<String, boolean[]> wordToChars = new HashMap<>(words.length);
    int result = 0;
    for (int i = words.length - 1; i > 0; i--) {
      for (int j = i - 1; j >= 0; j--) {
        int multi = words[i].length() * words[j].length();
        // 优化
        if (multi < result) {
          continue;
        }
        boolean[] aChars = wordToChars.get(words[i]);
        if (aChars == null) {
          aChars = tagChars(words[i]);
          wordToChars.put(words[i], aChars);
        }
        boolean[] bChars = wordToChars.get(words[j]);
        if (bChars == null) {
          bChars = tagChars(words[j]);
          wordToChars.put(words[j], bChars);
        }
        boolean same = false;
        for (int k = 0; k < 26; k++) {
          if (aChars[k] && bChars[k]) {
            same = true;
            break;
          }
        }
        if (!same) {
          result = Math.max(result, multi);
        }
      }
    }
    return result;
  }

  private boolean[] tagChars(String words) {
    boolean[] aChars = new boolean[26];
    for (char c : words.toCharArray()) {
      aChars[c - 'a'] = true;
    }
    return aChars;
  }
  // end::answer[]
}
