package com.diguage.algorithm.leetcode;

import com.diguage.algorithm.util.TreeNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static com.diguage.util.TreeNodes.buildTree;

/**
 * = 437. Path Sum III
 *
 * https://leetcode.com/problems/path-sum-iii/[Path Sum III - LeetCode]
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2020-01-28 23:06
 */
public class _0437_PathSumIII_22 {
  /**
   * = 参考
   *
   * . https://leetcode.cn/problems/path-sum-iii/solutions/596361/dui-qian-zhui-he-jie-fa-de-yi-dian-jie-s-dey6/[437. 路径总和 III / 对前缀和解法的一点解释^]
   * . https://leetcode.cn/problems/path-sum-iii/solutions/100992/qian-zhui-he-di-gui-hui-su-by-shi-huo-de-xia-tian/[437. 路径总和 III / 前缀和，递归，回溯^]
   */
  public int pathSum(TreeNode root, long target) {
    // key 是前缀和， value 是该前缀和的节点数量
    Map<Long, Integer> prefix = new HashMap<>();
    //前缀树为0的个数至少是一个
    prefix.put(0L, 1);
    // 前缀和的递归回溯思路
    return dfs(root, target, prefix, 0);
  }

  private int dfs(TreeNode root, long target, Map<Long, Integer> prefix, long sum) {
    // 1.递归终止条件
    if (root == null) {
      return 0;
    }

    // 2.本层要做的事情
    int result = 0;
    // 当前路径上的和
    sum += root.val;
    // TODO 这里不明白：
    //  从上往下，路径不应该只有一条吗？
    //  为什么是直接加 prefix.getOrDefault(sum - target, 0)？
    // 两节点间的路径和 = 两节点的前缀和之差
    // 得到我们想要前缀树的个数，想要前缀树值就是当前前缀树值减去目标值
    // target = prefixSum₂ - prefixSum₁
    result += prefix.getOrDefault(sum - target, 0);
    //将当前前缀树的值保存
    prefix.put(sum, prefix.getOrDefault(sum, 0) + 1);

    // 3.进入下一层
    //遍历左边
    result += dfs(root.left, target, prefix, sum);
    //遍历右边
    result += dfs(root.right, target, prefix, sum);

    // 4.回到本层，恢复状态，去除当前节点的前缀和数量
    // 一个节点必须是另一个节点的祖先节点。
    // 换句话说，当我们把一个节点的前缀和信息更新到map里时，它应当只对其子节点们有效。
    // 所以，退出该分支时，要把该分支的信息清理掉。
    // 这不是回溯吗？
    prefix.put(sum, prefix.get(sum) - 1);

    //结果是当前节点前缀树的个数加上左边满足的个数加右边满足的个数
    return result;
  }

  public static void main(String[] args) {
    _0437_PathSumIII_22 solution = new _0437_PathSumIII_22();
    long r1 = solution.pathSum(buildTree(Arrays.asList(10, 5, -3, 3, 2, null, 11, 3, -2, null, 1)), 8);
    System.out.println((r1 == 3) + " : " + r1);
  }
}
