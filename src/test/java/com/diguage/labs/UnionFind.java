package com.diguage.labs;

import java.util.ArrayList;
import java.util.List;

/**
 * 并查集
 *
 * PS：没想到代码竟然一次通过。
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2025-04-03 15:22:41
 */
public class UnionFind {
  /**
   * 连通分量
   */
  private int size;
  /**
   * 每个节点及对应的父节点
   */
  private int[] parent;

  public UnionFind(int size) {
    this.size = size;
    parent = new int[size];
    // 自己指向自己
    for (int i = 0; i < size; i++) {
      parent[i] = i;
    }
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
   * a 和 b 是否连通
   */
  public boolean connected(int a, int b) {
    int ap = find(a);
    int bp = find(b);
    return ap == bp;
  }

  /**
   * 连通分量
   */
  public int count() {
    return size;
  }

  /**
   * 查找节点 a 的根节点
   */
  private int find(int a) {
    int ap = parent[a];
    if (a != ap) {
      List<Integer> path = new ArrayList<>();
      path.add(a);
      // 向上查找根节点
      while (parent[ap] != ap) {
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

  public static void main(String[] args) {
    UnionFind uf = new UnionFind(10);
    uf.union(0, 1);
    uf.union(1, 2);
    uf.union(2, 3);
    uf.union(3, 4);
    uf.union(5, 6);
    uf.union(6, 7);
    uf.union(7, 8);
    uf.union(8, 9);
    uf.union(0, 5);
    System.out.println(uf.count() + ", " + uf.connected(0, 9));
    System.out.println(uf.count() + ", " + uf.connected(2, 9));
    System.out.println(uf.count() + ", " + uf.connected(3, 9));
    System.out.println(uf.count() + ", " + uf.connected(5, 9));
  }
}
