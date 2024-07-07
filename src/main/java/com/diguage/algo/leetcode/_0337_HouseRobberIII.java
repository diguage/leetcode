package com.diguage.algo.leetcode;

import com.diguage.algo.util.TreeNode;

import java.util.Objects;

import static com.diguage.util.TreeNodes.buildTree;
import static java.util.Arrays.asList;

/**
 * = 337. House Robber III
 *
 * https://leetcode.com/problems/house-robber-iii/[House Robber III - LeetCode]
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2020-01-29 16:34
 */
public class _0337_HouseRobberIII {
  // tag::answer[]
    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for House Robber III.
     * Memory Usage: 41.3 MB, less than 13.89% of Java online submissions for House Robber III.
     *
     * Copy from: https://leetcode-cn.com/problems/house-robber-iii/solution/java-2ms-by-horanol/[java 2ms - 打家劫舍 III - 力扣（LeetCode）]
     */
    public int rob(TreeNode root) {
        int[] robs = doRob(root);
        return Math.max(robs[0], robs[1]);
    }

    public int[] doRob(TreeNode root) {
        int[] result = new int[2];
        if (Objects.isNull(root)) {
            return result;
        }
        int[] left = doRob(root.left);
        int[] right = doRob(root.right);
        result[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        result[1] = left[0] + right[0] + root.val;
        return result;
    }

  // end::answer[]


    public static void main(String[] args) {
        _0337_HouseRobberIII solution = new _0337_HouseRobberIII();
        int r1 = solution.rob(buildTree(asList(3, 2, 3, null, 3, null, 1)));
        System.out.println((r1 == 7) + " : " + r1);

        int r2 = solution.rob(buildTree(asList(3, 4, 5, 1, 3, null, 1)));
        System.out.println((r2 == 9) + " : " + r2);
    }
}
