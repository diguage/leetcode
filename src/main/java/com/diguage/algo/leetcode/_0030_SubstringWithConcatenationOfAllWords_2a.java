package com.diguage.algo.leetcode;

import java.util.*;

public class _0030_SubstringWithConcatenationOfAllWords_2a {
  // tag::answer[]
  /**
   * 超时（152/182）
   *
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-01-06 20:13:53
   */
  public List<Integer> findSubstring(String s, String[] words) {
    if (s.length() < words.length * words[0].length()) {
      return Collections.emptyList();
    }
    int[] sc = new int[26];
    for (char c : s.toCharArray()) {
      sc[c - 'a']++;
    }
    for (String word : words) {
      for (char c : word.toCharArray()) {
        sc[c - 'a']--;
        if (sc[c - 'a'] < 0) {
          return Collections.emptyList();
        }
      }
    }
    for (String word : words) {
      if (!s.contains(word)) {
        return Collections.emptyList();
      }
    }
    Set<String> permutations = new HashSet<>();
    StringBuilder path = new StringBuilder();
    boolean[] used = new boolean[words.length];
    buildPermutations(words, permutations, path, used);
    List<Integer> result = new ArrayList<>(permutations.size());
    for (String p : permutations) {
      result.addAll(findAll(s, p, 0));
    }
    return result;
  }

  private List<Integer> findAll(String s, String p, int index) {
    List<Integer> result = new ArrayList<>();
    while (index + p.length() <= s.length()) {
      int i = s.indexOf(p, index);
      if (i < 0) {
        return result;
      }
      result.add(i);
      index = i + 1;
    }
    return result;
  }

  private void buildPermutations(String[] words, Set<String> permutations,
                                 StringBuilder path, boolean[] used) {
    if (path.length() == words.length * words[0].length()) {
      permutations.add(path.toString());
      return;
    }
    for (int i = 0; i < words.length; i++) {
      if (used[i]) {
        continue;
      }
      String word = words[i];
      path.append(word);
      used[i] = true;
      buildPermutations(words, permutations, path, used);
      used[i] = false;
      path.delete(path.length() - word.length(), path.length());
    }
  }

  // end::answer[]
  static void main() {
    new _0030_SubstringWithConcatenationOfAllWords_2a()
      .findSubstring("a", new String[]{"a"});
  }
}
