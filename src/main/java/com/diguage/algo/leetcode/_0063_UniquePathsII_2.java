package com.diguage.algo.leetcode;

import static com.diguage.util.Printers.printMatrix;

public class _0063_UniquePathsII_2 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2019-10-26 23:50
   */
  public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    int row = obstacleGrid.length;
    int column = obstacleGrid[0].length;
    // 1. obstacleGrid 表示走到某个节点一共有多少路径
    //    将障碍设置为-1，便于和 0 区分
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < column; j++) {
        if (obstacleGrid[i][j] == 1) {
          obstacleGrid[i][j] = -1;
        }
      }
    }
    // 3. 第一行也只有一种走法，如果有障碍，则后面的路径为0
    for (int i = 0; i < column; i++) {
      if (obstacleGrid[0][i] == -1) {
        break;
      }
      obstacleGrid[0][i] = 1;
    }
    // 3. 第一列只有一种走法，如果有障碍，则后面的路径为0
    for (int i = 0; i < row; i++) {
      if (obstacleGrid[i][0] == -1) {
        break;
      }
      obstacleGrid[i][0] = 1;
    }
    printMatrix(obstacleGrid);
    // 4. 确定遍历顺序：从左上向右下遍历
    for (int i = 1; i < row; i++) {
      for (int j = 1; j < column; j++) {
        if (obstacleGrid[i][j] == -1) {
          continue;
        }
        // 2. 确定递推公式
        int mi = 0;
        if (obstacleGrid[i - 1][j] != -1) {
          mi = obstacleGrid[i - 1][j];
        }
        int ni = 0;
        if (obstacleGrid[i][j - 1] != -1) {
          ni = obstacleGrid[i][j - 1];
        }
        obstacleGrid[i][j] = mi + ni;
        printMatrix(obstacleGrid);
      }
    }
    return obstacleGrid[row - 1][column - 1] == -1 ? 0 : obstacleGrid[row - 1][column - 1];
  }

  // end::answer[]
  public static void main(String[] args) {
    int[][] obstacleGrid = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
    new _0063_UniquePathsII_2().uniquePathsWithObstacles(obstacleGrid);
  }
}
