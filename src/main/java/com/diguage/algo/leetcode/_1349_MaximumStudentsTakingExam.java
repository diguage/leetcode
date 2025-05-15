package com.diguage.algo.leetcode;

public class _1349_MaximumStudentsTakingExam {
  // tag::answer[]

  /**
   * 通过 50 / 57 个测试用例，后超时。
   *
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-05-15 20:31:46
   */
  int result = Integer.MIN_VALUE;

  public int maxStudents(char[][] seats) {
    int seatNo = seats.length * seats[0].length - 1;
    backtrack(seats, seatNo, 0);
    return result;
  }

  private void backtrack(char[][] seats, int seatNo, int num) {
    if (seatNo < 0) {
      result = Math.max(result, num);
      return;
    }
    int row = seatNo / seats[0].length;
    int column = seatNo % seats[0].length;
    if (seats[row][column] == '.') {
      for (int i = 1; i >= 0; i--) {
        if (i == 0) {
          seats[row][column] = '0';
          backtrack(seats, seatNo - 1, num);
          seats[row][column] = '.';
        } else {
          seats[row][column] = '1';
          // 左
          boolean left = false;
          if (column > 0 && seats[row][column - 1] == '.') {
            left = true;
            seats[row][column - 1] = '0';
          }
          // 左上
          boolean leftUp = false;
          if (row > 0 && column > 0
            && seats[row - 1][column - 1] == '.') {
            leftUp = true;
            seats[row - 1][column - 1] = '0';
          }
          // 右
          boolean right = false;
          if (column < seats[0].length - 1 && seats[row][column + 1] == '.') {
            right = true;
            seats[row][column + 1] = '0';
          }
          // 右上
          boolean rightUp = false;
          if (row > 0 && column < seats[row].length - 1
            && seats[row - 1][column + 1] == '.') {
            rightUp = true;
            seats[row - 1][column + 1] = '0';
          }

          backtrack(seats, seatNo - 1, num + 1);

          // 右上
          if (rightUp) {
            seats[row - 1][column + 1] = '.';
          }
          // 右
          if (right) {
            seats[row][column + 1] = '.';
          }
          // 左上
          if (leftUp) {
            seats[row - 1][column - 1] = '.';
          }
          // 左
          if (left) {
            seats[row][column - 1] = '.';
          }
          seats[row][column] = '.';
        }
      }
    } else {
      backtrack(seats, seatNo - 1, num);
    }
  }
  // end::answer[]

  public static void main(String[] args) {
    new _1349_MaximumStudentsTakingExam().maxStudents(new char[][]{
      {'.', '.', '.', '.', '#', '.', '.', '.'},
      {'.', '.', '.', '.', '.', '.', '.', '.'},
      {'.', '.', '.', '.', '.', '.', '.', '.'},
      {'.', '.', '.', '.', '.', '.', '#', '.'},
      {'.', '.', '.', '.', '.', '.', '.', '.'},
      {'.', '.', '#', '.', '.', '.', '.', '.'},
      {'.', '.', '.', '.', '.', '.', '.', '.'},
      {'.', '.', '.', '#', '.', '.', '#', '.'}
//      {'.', '#', '.', '#'},
//      {'.', '.', '.', '#'},
//      {'#', '#', '.', '.'},
//      {'.', '#', '#', '#'}
//      {'.', '#', '.', '#'},
//      {'.', '.', '.', '#'},
//      {'#', '#', '.', '.'},
//      {'.', '#', '#', '#'}
//      {'#', '.', '#', '#', '.', '#'},
//      {'.', '#', '#', '#', '#', '.'},
//      {'#', '.', '#', '#', '.', '#'}
    });
  }
}
