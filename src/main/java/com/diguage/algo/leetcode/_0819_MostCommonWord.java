package com.diguage.algo.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _0819_MostCommonWord {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-07-12 20:55:35
   */
  public String mostCommonWord(String paragraph, String[] banned) {
    Set<String> ban = new HashSet<>(banned.length);
    for (String b : banned) {
      StringBuilder sb = new StringBuilder();
      for (char c : b.toCharArray()) {
        sb.append((char) (c | 0b10_0000));
      }
      ban.add(sb.toString());
    }
    paragraph = paragraph.replaceAll("[!?',;.]", " ");
    Map<String, Integer> map = new HashMap<>();
    for (String word : paragraph.split(" ")) {
      if (word.isEmpty()) {
        continue;
      }
      StringBuilder sb = new StringBuilder();
      for (char c : word.toCharArray()) {
        sb.append((char) (c | 0b10_0000));
      }
      word = sb.toString();
      if (ban.contains(word)) {
        continue;
      }
      map.put(word, map.getOrDefault(word, 0) + 1);
    }

    return map.entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey();
  }

  // end::answer[]
  static void main() {
    new _0819_MostCommonWord().mostCommonWord("Bob. hIt, baLl", new String[]{"bob", "hit"});
  }
}
