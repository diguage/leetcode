package com.diguage.algo.leetcode;

import java.util.ArrayList;
import java.util.List;

public class _0547_NumberOfProvinces {
  // tag::answer[]

/**
 * @author D瓜哥 · https://www.diguage.com
 * @since 2025-04-03 22:15:52
 */
public int findCircleNum(int[][] isConnected) {
  int len = isConnected.length;
  UnionFind un = new UnionFind(len);
  for (int i = 0; i < len; i++) {
    // 只处理矩阵右上半部分
    for (int j = len - 1; j > i; j--) {
      if (isConnected[i][j] == 1) {
        un.union(i, j);
      }
    }
  }
  return un.count();
}

private static class UnionFind {
  /**
   * 连通分量
   */
  int size;
  /**
   * 每个节点及对应的父节点
   */
  int[] parent;

  public UnionFind(int size) {
    this.size = size;
    parent = new int[size];
    for (int i = 0; i < size; i++) {
      parent[i] = i;
    }
  }

  /**
   * 连通分量
   */
  public int count() {
    return size;
  }

  /**
   * a 和 b 建立连接
   */
  public void union(int a, int b) {
    int ap = find(a);
    int bp = find(b);
    if (ap == bp) {
      return;
    }
    parent[ap] = bp;
    size--;
  }

  /**
   * 查找节点 a 的根节点
   */
  private int find(int a) {
    int ap = parent[a];
    if (ap != a) {
      List<Integer> path = new ArrayList<>();
      path.add(a);
      // 向上查找根节点
      while (ap != parent[ap]) {
        path.add(ap);
        ap = parent[ap];
      }
      // 路径压缩
      // 只有一步，无需缩短路径
      if (path.size() == 1) {
        return ap;
      }
      for (Integer idx : path) {
        parent[idx] = ap;
      }
    }
    return ap;
  }
}
  // end::answer[]
}
