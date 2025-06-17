package com.diguage.algo.leetcode;

public class _0427_ConstructQuadTree {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-06-17 22:36:27
   */
  public Node construct(int[][] grid) {
    return dfs(grid, 0, 0, grid.length);
  }

  private Node dfs(int[][] grid, int row, int column, int length) {
    if (length == 1) {
      return new Node(grid[row][column] == 1, true);
    }
    boolean same = true;
    for (int r = 0; r < length; r++) {
      for (int c = 0; c < length; c++) {
        if (grid[row][column] != grid[row + r][column + c]) {
          same = false;
          break;
        }
      }
      if (!same) {
        break;
      }
    }
    if (same) {
      return new Node(grid[row][column] == 1, true);
    }

    int nextLength = length / 2;
    Node topLeft = dfs(grid, row, column, nextLength);
    Node topRight = dfs(grid, row, column + nextLength, nextLength);
    Node bottomLeft = dfs(grid, row + nextLength, column, nextLength);
    Node bottomRight = dfs(grid, row + nextLength, column + nextLength, nextLength);
    return new Node(true, false, topLeft, topRight, bottomLeft, bottomRight);
  }
  // end::answer[]

  public static void main(String[] args) {
    new _0427_ConstructQuadTree()
      .construct(new int[][]{
        {1, 1, 0, 0},
        {0, 0, 1, 1},
        {1, 1, 0, 0},
        {0, 0, 1, 1}});
  }


  static class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;


    public Node() {
      this.val = false;
      this.isLeaf = false;
      this.topLeft = null;
      this.topRight = null;
      this.bottomLeft = null;
      this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf) {
      this.val = val;
      this.isLeaf = isLeaf;
      this.topLeft = null;
      this.topRight = null;
      this.bottomLeft = null;
      this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
      this.val = val;
      this.isLeaf = isLeaf;
      this.topLeft = topLeft;
      this.topRight = topRight;
      this.bottomLeft = bottomLeft;
      this.bottomRight = bottomRight;
    }
  }
}
