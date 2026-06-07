package com.diguage.algo.leetcode;

public class _0748_ShortestCompletingWord {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-06-07 21:12:37
   */
  public String shortestCompletingWord(String licensePlate, String[] words) {
    int[] letters = countChars(licensePlate);
    String result = null;
    for (String word : words) {
      int[] can = countChars(word);
      boolean flag = true;
      for (int i = 0; i < letters.length; i++) {
        if (can[i] < letters[i]) {
          flag = false;
          break;
        }
      }
      if (flag && (result == null || word.length() < result.length())) {
        result = word;
      }
    }
    return result;
  }

  private int[] countChars(String word) {
    int[] letters = new int[26];
    for (char c : word.toCharArray()) {
      if (!Character.isAlphabetic(c)) {
        continue;
      }
      c |= 0b10_0000;
      letters[c - 'a']++;
    }
    return letters;
  }

  // end::answer[]
  static void main() {
    new _0748_ShortestCompletingWord()
      .shortestCompletingWord("1s3 PSt", new String[]{"step", "steps", "stripe", "stepple"});
  }
}
