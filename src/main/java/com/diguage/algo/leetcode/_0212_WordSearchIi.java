package com.diguage.algo.leetcode;

import java.util.*;

public class _0212_WordSearchIi {
  // tag::answer[]
  /**
   * 通过 43 / 65 个测试用例。超时！
   *
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-06-12 22:53:03
   */
  public List<String> findWords(char[][] board, String[] words) {
    Arrays.sort(words, String::compareTo);
    Map<Character, List<String>> charToWordMap = new HashMap<>();
    for (int i = 0; i < words.length; i++) {
      String word = words[i];
      char c = word.charAt(0);
      charToWordMap.computeIfAbsent(c, k -> new ArrayList<>()).add(word);
    }
    Map<Character, List<int[]>> charToIndexMap = new HashMap<>();
    for (int r = 0; r < board.length; r++) {
      for (int c = 0; c < board[r].length; c++) {
        char ac = board[r][c];
        if (charToWordMap.containsKey(ac)) {
          charToIndexMap.computeIfAbsent(ac, k -> new ArrayList<>())
            .add(new int[]{r, c});
        }
      }
    }
    Set<String> result = new HashSet<>();
    charToIndexMap.forEach((k, v) -> {
      for (int[] idx : v) {
        List<String> aWords = charToWordMap.get(k);
        for (String aw : aWords) {
          dfs(board, idx[0], idx[1], aw, 0, new HashSet<>(), result);
        }
      }
    });
    return new ArrayList<>(result);
  }

  private void dfs(char[][] board, int row, int col,
                   String word, int idx, Set<List<Integer>> path,
                   Set<String> result) {
    List<Integer> index = Arrays.asList(row, col);
    if (path.contains(index)) {
      return;
    }
    if (result.contains(word)) {
      return;
    }
    if (idx == word.length()) {
      result.add(word);
      return;
    }
    if (row < 0 || row >= board.length
      || col < 0 || col >= board[0].length) {
      return;
    }
    if (board[row][col] != word.charAt(idx)) {
      return;
    }
    path.add(index);
    int[][] options = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    for (int[] option : options) {
      int r = row + option[0];
      int c = col + option[1];
      dfs(board, r, c, word, idx + 1, path, result);
    }
    path.remove(index);
  }
  // end::answer[]
}
