package com.diguage.algo.leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Objects;

/**
 * = 71. Simplify Path
 *
 * https://leetcode.com/problems/simplify-path/[Simplify Path - LeetCode]
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2020-02-04 16:15
 */
public class _0071_SimplifyPath {
  // tag::answer[]
    /**
     * Runtime: 5 ms, faster than 71.14% of Java online submissions for Simplify Path.
     * Memory Usage: 39.9 MB, less than 6.67% of Java online submissions for Simplify Path.
     */
    public String simplifyPath(String path) {
        String[] paths = path.split("/");
        Deque<String> stack = new LinkedList<>();
        for (String subpath : paths) {
            if ("..".equals(subpath) && !stack.isEmpty()) {
                stack.removeLast();
                continue;
            }
            if (subpath.length() > 0 && !".".equals(subpath) && !"..".equals(subpath)) {
                stack.addLast(subpath);
            }
        }
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            String name = stack.removeFirst();
            result.append("/").append(name);
        }
        return result.length() > 0 ? result.toString() : "/";
    }

    /**
     * Runtime: 3 ms, faster than 97.40% of Java online submissions for Simplify Path.
     * Memory Usage: 39.4 MB, less than 20.00% of Java online submissions for Simplify Path.
     */
    public String simplifyPathLoop(String path) {
        if (Objects.isNull(path)) {
            return "/";
        }
        Deque<String> stack = new LinkedList<>();
        int i = 0;
        while (i < path.length()) {
            if (path.charAt(i) == '/') {
                i++;
                continue;
            }
            StringBuilder sb = new StringBuilder();
            while (i < path.length() && (path.charAt(i) != '.' && path.charAt(i) != '/')) {
                sb.append(path.charAt(i));
                i++;
            }

            if (sb.length() > 0) {
                stack.addLast(sb.toString());
                continue;
            }
            while (i < path.length() && path.charAt(i) != '/') {
                sb.append(path.charAt(i));
                i++;
            }
            String strings = sb.toString();
            if (sb.length() == 2 && !stack.isEmpty() && "..".equals(strings)) {
                stack.removeLast();
            }
            if (sb.length() > 2 || (sb.length() == 2 && !"..".equals(strings))) {
                stack.addLast(strings);
            }
        }
        if (stack.isEmpty()) {
            return "/";
        }
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            String name = stack.removeFirst();
            result.append("/").append(name);
        }
        return result.length() > 0 ? result.toString() : "/";
    }

  // end::answer[]


    public static void main(String[] args) {
        _0071_SimplifyPath solution = new _0071_SimplifyPath();

        String r9 = solution.simplifyPath("/home/foo/.ssh/../.ssh2/authorized_keys/");
        System.out.println("/home/foo/.ssh2/authorized_keys".equals(r9) + " : " + r9);

        String r8 = solution.simplifyPath("/home/foo/.ssh/authorized_keys/");
        System.out.println("/home/foo/.ssh/authorized_keys".equals(r8) + " : " + r8);

        String r7 = solution.simplifyPath("/..hidden");
        System.out.println("/..hidden".equals(r7) + " : " + r7);

        String r1 = solution.simplifyPath("/home/");
        System.out.println("/home".equals(r1) + " : " + r1);

        String r2 = solution.simplifyPath("/../");
        System.out.println("/".equals(r2) + " : " + r2);

        String r3 = solution.simplifyPath("/home//foo/");
        System.out.println("/home/foo".equals(r3) + " : " + r3);

        String r4 = solution.simplifyPath("/a/./b/../../c/");
        System.out.println("/c".equals(r4) + " : " + r4);

        String r5 = solution.simplifyPath("/a/../../b/../c//.//");
        System.out.println("/c".equals(r5) + " : " + r5);

        String r6 = solution.simplifyPath("/a//b////c/d//././/..");
        System.out.println("/a/b/c".equals(r6) + " : " + r6);
    }
}
