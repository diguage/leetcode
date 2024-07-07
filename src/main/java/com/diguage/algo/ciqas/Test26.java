package com.diguage.algo.ciqas;

import com.diguage.algo.util.TreeNode;

import java.util.Arrays;
import java.util.Objects;

import static com.diguage.util.TreeNodes.buildTree;

/**
 * @author D瓜哥, https://www.diguage.com/
 * @since 2020-04-26 22:20
 */
public class Test26 {
    /**
     * https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof/solution/mian-shi-ti-26-shu-de-zi-jie-gou-xian-xu-bian-li-p/[面试题26. 树的子结构（先序遍历 + 包含判断，清晰图解） - 树的子结构 - 力扣（LeetCode）]
     */
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (Objects.isNull(B)) {
            return false;
        }
        if (Objects.isNull(A)) {
            return false;
        }
        return isMatch(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    private boolean isMatch(TreeNode A, TreeNode B) {
        if (Objects.isNull(B)) {
            return true;
        }
        if (Objects.isNull(A) || A.val != B.val) {
            return false;
        }
        return isMatch(A.left, B.left) && isMatch(A.right, B.right);
    }

    public static void main(String[] args) {
        Test26 test = new Test26();
        boolean r1 = test.isSubStructure(buildTree(Arrays.asList(-2, 1)),
                buildTree(Arrays.asList(-2, 1, -2)));
        System.out.println(r1);
    }
}
