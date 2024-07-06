package com.diguage.algorithm.leetcode;

import com.diguage.algorithm.util.TreeNode;

import java.util.Arrays;
import java.util.Objects;

import static com.diguage.util.TreeNodes.buildTree;

/**
 * = 437. Path Sum III
 *
 * https://leetcode.com/problems/path-sum-iii/[Path Sum III - LeetCode]
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2020-01-28 23:06
 */
public class _0437_PathSumIII {
  // tag::answer[]
    /**
     * Runtime: 23 ms, faster than 10.40% of Java online submissions for Path Sum III.
     * Memory Usage: 39.1 MB, less than 90.91% of Java online submissions for Path Sum III.
     *
     * Copy from: https://leetcode-cn.com/problems/path-sum-iii/solution/leetcode-437-path-sum-iii-by-li-xin-lei/[LeetCode 437 Path Sum III - 路径总和 III - 力扣（LeetCode）]
     */
    public int pathSum(TreeNode root, int sum) {
        if (Objects.isNull(root)) {
            return 0;
        }
        return pathSum(root.left, sum) + pathSum(root.right, sum) + childPathSum(root, sum);
    }

    private int childPathSum(TreeNode root, int sum) {
        if (Objects.isNull(root)) {
            return 0;
        }
        int result = 0;
        if (root.val == sum) {
            result++;
        }
        result += childPathSum(root.left, sum - root.val);
        result += childPathSum(root.right, sum - root.val);
        return result;
    }

  // end::answer[]


    public static void main(String[] args) {
        _0437_PathSumIII solution = new _0437_PathSumIII();
        int r1 = solution.pathSum(buildTree(Arrays.asList(10, 5, -3, 3, 2, null, 11, 3, -2, null, 1)), 8);
        System.out.println((r1 == 3) + " : " + r1);
    }
}
