package com.diguage.algo.leetcode;

import com.diguage.algo.util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class _0199_BinaryTreeRightSideView_4 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-10-04 21:04:38
   */
  public List<Integer> rightSideView(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    dfs(root, 1, result);
    return result;
  }

  private void dfs(TreeNode root, int heigh, List<Integer> result) {
    if (Objects.isNull(root)) {
      return;
    }
    // 更快的做法是：递归先有后左，这样只需要在第一个遇到是加入即可，后面无需更新
    if (result.size() < heigh) {
      result.add(root.val);
    } else {
      result.set(heigh - 1, root.val);
    }
    dfs(root.left, heigh + 1, result);
    dfs(root.right, heigh + 1, result);
  }
  // end::answer[]
}
