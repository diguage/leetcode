package com.diguage.algo.leetcode;

import java.util.*;

/**
 * = 150. Evaluate Reverse Polish Notation
 *
 * https://leetcode.com/problems/evaluate-reverse-polish-notation/[Evaluate Reverse Polish Notation - LeetCode]
 *
 * Evaluate the value of an arithmetic expression in https://en.wikipedia.org/wiki/Reverse_Polish_notation[Reverse Polish notation].
 *
 * Valid operators are `+`, `-`, `*`, `/`. Each operand may be an integer or another expression.
 *
 * *Note:*
 *
 * * Division between two integers should truncate toward zero.
 * * The given RPN expression is always valid. That means the expression would always evaluate to a result and there won't be any divide by zero operation.
 *
 * .Example 1:
 * [source]
 * ----
 * Input: ["2", "1", "+", "3", "*"]
 * Output: 9
 * Explanation: ((2 + 1) * 3) = 9
 * ----
 *
 * .Example 2:
 * [source]
 * ----
 * Input: ["4", "13", "5", "/", "+"]
 * Output: 6
 * Explanation: (4 + (13 / 5)) = 6
 * ----
 *
 * .Example 3:
 * [source]
 * ----
 * Input: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
 * Output: 22
 * Explanation:
 *   ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
 * = ((10 * (6 / (12 * -11))) + 17) + 5
 * = ((10 * (6 / -132)) + 17) + 5
 * = ((10 * 0) + 17) + 5
 * = (0 + 17) + 5
 * = 17 + 5
 * = 22
 * ----
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2020-01-26 16:01
 */
public class _0150_EvaluateReversePolishNotation {
  // tag::answer[]
    /**
     * Runtime: 4 ms, faster than 97.32% of Java online submissions for Evaluate Reverse Polish Notation.
     *
     * Memory Usage: 41.1 MB, less than 6.00% of Java online submissions for Evaluate Reverse Polish Notation.
     */
    public int evalRPN(String[] tokens) {
        if (Objects.isNull(tokens) || tokens.length == 0) {
            return 0;
        }
        Deque<Integer> stack = new LinkedList<>();
        Set<String> operators = new HashSet<>(Arrays.asList("+", "-", "*", "/"));

        for (String token : tokens) {
            if (operators.contains(token)) {
                Integer v1 = stack.pop();
                Integer v2 = stack.pop();
                if ("+".equals(token)) {
                    stack.push(v1 + v2);
                    continue;
                }
                if ("-".equals(token)) {
                    stack.push(v2 - v1);
                    continue;
                }
                if ("*".equals(token)) {
                    stack.push(v1 * v2);
                    continue;
                }
                if ("/".equals(token)) {
                    stack.push(v2 / v1);
                    continue;
                }
            } else {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }

  // end::answer[]


    public static void main(String[] args) {
        _0150_EvaluateReversePolishNotation solution = new _0150_EvaluateReversePolishNotation();
        String[] t1 = {"2", "1", "+", "3", "*"};
        int r1 = solution.evalRPN(t1);
        System.out.println((r1 == 9) + " : " + r1);

        String[] t2 = {"4", "13", "5", "/", "+"};
        int r2 = solution.evalRPN(t2);
        System.out.println((r2 == 6) + " : " + r2);

        String[] t3 = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        int r3 = solution.evalRPN(t3);
        System.out.println((r3 == 22) + " : " + r3);
    }
}
