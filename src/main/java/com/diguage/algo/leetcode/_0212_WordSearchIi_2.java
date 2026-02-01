package com.diguage.algo.leetcode;

import java.util.*;

public class _0212_WordSearchIi_2 {
  // tag::answer[]

  /**
   * 回溯（63/65）
   *
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-02-01 22:18:24
   */
  public List<String> findWords(char[][] board, String[] words) {
    List<String> result = new ArrayList<>();
    Map<Character, List<int[]>> map = new HashMap<>();
    for (int r = 0; r < board.length; r++) {
      for (int c = 0; c < board[r].length; c++) {
        map.computeIfAbsent(board[r][c], _ -> new ArrayList<>())
          .add(new int[]{r, c});
      }
    }
    for (String word : words) {
      List<int[]> loc = map.getOrDefault(word.charAt(0), Collections.emptyList());
      for (int[] l : loc) {
        if (backtrack(board, l[0], l[1], word, 0, result)) {
          break;
        }
      }
    }
    return result;
  }

  private boolean backtrack(char[][] board, int row, int column,
                            String word, int index,
                            List<String> result) {
    if (index >= word.length()) {
      result.add(word);
      return true;
    }
    if (row < 0 || row >= board.length
      || column < 0 || column >= board[row].length
      || board[row][column] != word.charAt(index)) {
      return false;
    }

    char c = board[row][column];
    board[row][column] = '.';
    boolean r = // 上
      backtrack(board, row - 1, column, word, index + 1, result)
        // 下
        || backtrack(board, row + 1, column, word, index + 1, result)
        // 左
        || backtrack(board, row, column - 1, word, index + 1, result)
        // 右
        || backtrack(board, row, column + 1, word, index + 1, result);
    board[row][column] = c;
    return r;
  }
  // end::answer[]
}
