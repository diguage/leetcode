package com.diguage.algo.leetcode;

import com.diguage.algo.util.TreeNode;
import com.diguage.util.TreeNodes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class _0655_PrintBinaryTree {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-04-22 21:49:32
   */
  public List<List<String>> printTree(TreeNode root) {
    int height = getHeight(root);
    int m = height + 1;
    List<String[]> data = new ArrayList<>(m);
    int n = (1 << (height + 1)) - 1;
    dfs(data, height, root, 0, 0, n - 1);
    List<List<String>> result = new ArrayList<>();
    for (String[] datum : data) {
      List<String> row = new ArrayList<>(n);
      for (String s : datum) {
        row.add(Objects.isNull(s) ? "" : s);
      }
      result.add(row);
    }
    return result;
  }

  private void dfs(List<String[]> data, int height, TreeNode root,
                   int index, int left, int right) {
    if (Objects.isNull(root)) {
      return;
    }
    String[] r;
    if (data.size() == index) {
      r = new String[(1 << (height + 1)) - 1];
      data.add(r);
    } else {
      r = data.get(index);
    }
    // 每次都在中间位置添加元素
    int mid = left + (right - left + 1) / 2;
    r[mid] = String.valueOf(root.val);
    dfs(data, height, root.left, index + 1, left, mid - 1);
    dfs(data, height, root.right, index + 1, mid + 1, right);
  }

  private int getHeight(TreeNode root) {
    if (Objects.isNull(root)) {
      return -1;
    }
    return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
  }
  // end::answer[]

  static void main() {
    new _0655_PrintBinaryTree()
      .printTree(TreeNodes.buildTree(Arrays.asList(1, 2, 3, null, 4)));
  }
}
