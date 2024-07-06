package com.diguage.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * = 89. Gray Code
 *
 * https://leetcode.com/problems/gray-code/[Gray Code - LeetCode]
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2020-02-05 19:36
 */
public class _0089_GrayCode {
  // tag::answer[]
    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Gray Code.
     * Memory Usage: 37 MB, less than 8.00% of Java online submissions for Gray Code.
     *
     * Copy from: https://leetcode-cn.com/problems/gray-code/solution/gray-code-jing-xiang-fan-she-fa-by-jyd/[Gray Code （镜像反射法，图解） - 格雷编码 - 力扣（LeetCode）]
     */
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>((int) Math.pow(2, n));
        result.add(0);
        int head = 1;
        for (int i = 0; i < n; i++) {
            for (int j = result.size() - 1; j >= 0; j--) {
                result.add(head + result.get(j));
            }
            head <<= 1;
        }
        return result;
    }

  // end::answer[]


    public static void main(String[] args) {
        _0089_GrayCode solution = new _0089_GrayCode();
        System.out.println(Arrays.toString(solution.grayCode(4).toArray()));
    }
}
