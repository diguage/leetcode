package com.diguage.algorithm.ciqas;

import java.util.Objects;

/**
 * @author D瓜哥, https://www.diguage.com/
 * @since 2020-04-25 20:20
 */
public class Test05 {
    public String replaceSpace(String s) {
        if (Objects.isNull(s) || s.length() == 0) {
            return "";
        }
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                num++;
            }
        }
        if (num == 0) {
            return s;
        }
        char[] result = new char[s.length() + num * 2];
        int r = result.length - 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == ' ') {
                result[r--] = '0';
                result[r--] = '2';
                result[r--] = '%';
            } else {
                result[r--] = c;
            }
        }
        return new String(result);
    }

    public static void main(String[] args) {
        Test05 solution = new Test05();
        String s1 = "We are happy.";
        System.out.println(solution.replaceSpace(s1));
    }
}
