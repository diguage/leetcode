package com.diguage.algo.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _0676_ImplementMagicDictionary {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-05-06 21:07:37
   */
  class MagicDictionary {
    private Map<Integer, List<String>> lenToWord;

    public MagicDictionary() {
      lenToWord = new HashMap<>();
    }

    public void buildDict(String[] dictionary) {
      for (String word : dictionary) {
        lenToWord.computeIfAbsent(word.length(), _ -> new ArrayList<>())
          .add(word);
      }
    }

    public boolean search(String searchWord) {
      if (lenToWord.containsKey(searchWord.length())) {
        List<String> words = lenToWord.get(searchWord.length());
        for (String word : words) {
          int cnt = 0;
          for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) != searchWord.charAt(i)) {
              cnt++;
            }
            if (cnt > 1) {
              break;
            }
          }
          if (cnt == 1) {
            return true;
          }
        }
      }
      return false;
    }
  }
  // end::answer[]
}
