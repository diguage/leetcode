package com.diguage.algorithm.leetcode;

import com.diguage.algorithm.util.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author D瓜哥 · https://www.diguage.com
 * @since 2024-06-20 11:03:26
 */
public class _0095_UniqueBinarySearchTreesII {
  /**
   * 参考 https://leetcode.cn/problems/unique-binary-search-trees-ii/solutions/339143/bu-tong-de-er-cha-sou-suo-shu-ii-by-leetcode-solut/[95. 不同的二叉搜索树 II - 官方题解^]
   */
  public List<TreeNode> generateTrees(int n) {
    if (n == 0) {
      return Collections.emptyList();
    }
    return generateTrees(1, n);
  }

  private List<TreeNode> generateTrees(int start, int end) {
    List<TreeNode> result = new ArrayList<>();
    if (start > end) {
      result.add(null);
      return result;
    }

    // 枚举可行根节点
    for (int i = start; i <= end; i++) {
      // 获得所有可行的左子树集合
      List<TreeNode> leftTrees = generateTrees(start, i - 1);
      // 获得所有可行的右子树集合
      List<TreeNode> rightTrees = generateTrees(i + 1, end);
      for (TreeNode left : leftTrees) {
        for (TreeNode right : rightTrees) {
          // 从左子树集合中选出一棵左子树，
          // 从右子树集合中选出一棵右子树，拼接到根节点上
          TreeNode curr = new TreeNode(i);
          curr.left = left;
          curr.right = right;
          result.add(curr);
        }
      }
    }
    return result;
  }
}
