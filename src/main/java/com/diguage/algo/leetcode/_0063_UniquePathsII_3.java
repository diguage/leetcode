package com.diguage.algo.leetcode;

public class _0063_UniquePathsII_3 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-04-18 17:32:04
   */
  public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    boolean obstacled = false;
    boolean firstObstacle = obstacleGrid[0][0] == 1;
    for (int i = 0; i < obstacleGrid[0].length; i++) {
      if (obstacleGrid[0][i] == 1) {
        obstacleGrid[0][i] = 0;
        obstacled = true;
      } else {
        if (obstacled) {
          obstacleGrid[0][i] = 0;
        } else {
          obstacleGrid[0][i] = 1;
        }
      }
    }
    obstacled = false;
    int rows = obstacleGrid.length;
    for (int i = 1; i < rows; i++) {
      if (obstacleGrid[i][0] == 1) {
        obstacleGrid[i][0] = 0;
        obstacled = true;
      } else {
        if (obstacled || firstObstacle) {
          obstacleGrid[i][0] = 0;
        } else {
          obstacleGrid[i][0] = 1;
        }
      }
    }
    for (int i = 1; i < rows; i++) {
      for (int j = 1; j < obstacleGrid[i].length; j++) {
        if (obstacleGrid[i][j] == 1) {
          obstacleGrid[i][j] = 0;
        } else {
          obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
        }
      }
    }
    return obstacleGrid[rows - 1][obstacleGrid[rows - 1].length - 1];
  }
  // end::answer[]
}
