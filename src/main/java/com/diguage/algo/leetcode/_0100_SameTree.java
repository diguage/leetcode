package com.diguage.algo.leetcode;

import com.diguage.algo.util.TreeNode;

import java.util.Objects;

import static com.diguage.util.TreeNodes.buildTree;
import static java.util.Arrays.asList;

/**
 * = 100. Same Tree
 *
 * https://leetcode.com/problems/same-tree/[Same Tree - LeetCode]
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2020-02-05 09:53
 */
public class _0100_SameTree {
  // tag::answer[]
    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Same Tree.
     * Memory Usage: 36.4 MB, less than 5.75% of Java online submissions for Same Tree.
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (Objects.isNull(p) && Objects.isNull(q)) {
            return true;
        }
        if (Objects.isNull(p) || Objects.isNull(q)) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        boolean left = isSameTree(p.left, q.left);
        if (!left) {
            return false;
        }
        return isSameTree(p.right, q.right);
    }

  // end::answer[]


    public static void main(String[] args) {
        _0100_SameTree solution = new _0100_SameTree();
        boolean r1 = solution.isSameTree(buildTree(asList(1, 2)), buildTree(asList(1, null, 2)));
        System.out.println(!r1);
    }
}
