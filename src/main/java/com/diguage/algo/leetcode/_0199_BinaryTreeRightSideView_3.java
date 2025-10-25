package com.diguage.algo.leetcode;

import com.diguage.algo.util.TreeNode;
import com.diguage.util.TreeNodes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _0199_BinaryTreeRightSideView_3 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-10-25 10:51:00
   */
  public List<Integer> rightSideView(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    dfs(root, result, 0);
    return result;
  }

  private void dfs(TreeNode root, List<Integer> result, int level) {
    if (null == root) {
      return;
    }
    // 如果是先根遍历，每层都会根节点先到，
    // 直接在 List 里面追加（add）即可
    if (level == result.size()) {
      result.add(root.val);
    } else {
      // 如果是左中右遍历，左中节点先到，那么就需要更新
      // 如果是右中左遍历，右节点先到，直接添加就无需更新
      result.set(level, root.val);
    }
    dfs(root.left, result, level + 1);
    // 如果是中根遍历，会先遍历到最深的叶子节点，
    // 所以需要用 null 占位符把 List 给撑起来
    // while (result.size() <= level) {
    //   result.add(null);
    // }
    // result.set(level, root.val);
    dfs(root.right, result, level + 1);
  }
  // end::answer[]

  static void main() {
    new _0199_BinaryTreeRightSideView_3()
      .rightSideView(TreeNodes.buildTree(Arrays.asList(1, 2, 3, 4, null, null, null, 5)));
  }

}
