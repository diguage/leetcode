package com.diguage.algo.leetcode;

import com.diguage.algo.util.TreeNode;
import com.diguage.util.TreeNodes;

import java.util.*;

/**
 * = 101. Symmetric Tree
 *
 * https://leetcode.com/problems/symmetric-tree/[Symmetric Tree - LeetCode]
 *
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 *
 * For example, this binary tree `[1,2,2,3,4,4,3]` is symmetric:
 *
 * ----
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * ----
 *
 * But the following `[1,2,2,null,3,null,3]` is not:
 *
 * ----
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 * ----
 *
 * **Note:**
 *
 * Bonus points if you could solve it both recursively and iteratively.
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2020-01-02 00:20
 */
public class _0101_SymmetricTree {
  // tag::answer[]
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    private boolean isMirror(TreeNode t1, TreeNode t2) {
        if (Objects.isNull(t1) && Objects.isNull(t2)) {
            return true;
        }
        if (Objects.isNull(t1)||Objects.isNull(t2)) {
            return false;
        }
        return (Objects.equals(t1.val, t2.val))
                && isMirror(t1.left, t2.right)
                && isMirror(t1.right, t2.left);
    }

    /**
     * Runtime: 1 ms, faster than 36.88% of Java online submissions for Symmetric Tree.
     *
     * Memory Usage: 38.9 MB, less than 43.54% of Java online submissions for Symmetric Tree.
     */
    public boolean isSymmetricIterative(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode t1 = queue.poll();
            TreeNode t2 = queue.poll();
            if (Objects.isNull(t1) && Objects.isNull(t2)) {
                continue;
            }
            if (Objects.isNull(t1) || Objects.isNull(t2)) {
                return false;
            }
            if (!Objects.equals(t1.val, t2.val)) {
                return false;
            }
            queue.add(t1.left);
            queue.add(t2.right);
            queue.add(t1.right);
            queue.add(t2.left);
        }
        return true;
    }

    /**
     * Runtime: 228 ms, faster than 36.88% of Java online submissions for Symmetric Tree.
     *
     * Memory Usage: 92.6 MB, less than 5.44% of Java online submissions for Symmetric Tree.
     */
    public boolean isSymmetricBfs(TreeNode root) {
        if (Objects.isNull(root)) {
            return true;
        }
        ArrayList<TreeNode> parent = new ArrayList<>();
        parent.add(root);
        while (!parent.isEmpty()) {
            HashSet<TreeNode> nodes = new HashSet<>(parent);
            if (nodes.size() == 1 && nodes.contains(null)) {
                return true;
            }
            ArrayList<TreeNode> children = new ArrayList<>(parent.size() * 2);
            for (TreeNode node : parent) {
                if (Objects.isNull(node)) {
                    children.add(null);
                    children.add(null);
                } else {
                    children.add(node.left);
                    children.add(node.right);
                }
            }
            for (int i = 0; i < children.size() / 2; i++) {
                TreeNode left = children.get(i);
                TreeNode right = children.get(children.size() - 1 - i);
                if (Objects.isNull(left) && Objects.isNull(right)) {
                    continue;
                }
                if (Objects.isNull(left) || Objects.isNull(right)) {
                    return false;
                }
                if (!Objects.equals(left.val, right.val)) {
                    return false;
                }
            }
            parent = children;
        }

        return true;
    }

  // end::answer[]


    public static void main(String[] args) {
        _0101_SymmetricTree solution = new _0101_SymmetricTree();

        List<Integer> a1 = Arrays.asList(1, 2, 2, 3, 4, 4, 3);
        TreeNode t1 = TreeNodes.buildTree(a1);
        boolean r1 = solution.isSymmetric(t1);
        System.out.println((r1 == true) + " : " + r1);

        List<Integer> a2 = Arrays.asList(1, 2, 2, null, 3, null, 3);
        TreeNode t2 = TreeNodes.buildTree(a2);
        boolean r2 = solution.isSymmetric(t2);
        System.out.println((r2 == false) + " : " + r2);

        List<Integer> a3 = Arrays.asList(1, 2, 2, null, 3, 3);
        TreeNode t3 = TreeNodes.buildTree(a3);
        boolean r3 = solution.isSymmetric(t3);
        System.out.println((r3 == true) + " : " + r3);
    }
}
