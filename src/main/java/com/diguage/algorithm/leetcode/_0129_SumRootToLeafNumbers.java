package com.diguage.algorithm.leetcode;

import com.diguage.algorithm.util.TreeNode;

import java.util.Objects;

import static com.diguage.util.TreeNodes.buildTree;
import static java.util.Arrays.asList;

/**
 * = 129. Sum Root to Leaf Numbers
 *
 * https://leetcode.com/problems/sum-root-to-leaf-numbers/[Sum Root to Leaf Numbers - LeetCode]
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2020-02-07 23:56
 */
public class _0129_SumRootToLeafNumbers {
  // tag::answer[]

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Sum Root to Leaf Numbers.
     * Memory Usage: 37.7 MB, less than 5.13% of Java online submissions for Sum Root to Leaf Numbers.
     */
    private int sum = 0;
    public int sumNumbers(TreeNode root) {
        dfs(root, 0);
        return sum;
    }

    private void dfs(TreeNode root, int parent) {
        if (Objects.isNull(root)) {
            return;
        }
        int temp = parent * 10 + root.val;
        if (Objects.isNull(root.left) && Objects.isNull(root.right)) {
            sum += temp;
            return;
        }
        dfs(root.left, temp);
        dfs(root.right, temp);
    }


  // end::answer[]


    public static void main(String[] args) {
        _0129_SumRootToLeafNumbers solution = new _0129_SumRootToLeafNumbers();

        solution.sum = 0;
        int r1 = solution.sumNumbers(buildTree(asList(1, 2, 3)));
        System.out.println((r1 == 25) + " : " + r1);

        solution.sum = 0;
        int r2 = solution.sumNumbers(buildTree(asList(4, 9, 0, 5, 1)));
        System.out.println((r2 == 1026) + " : " + r2);
    }
}
