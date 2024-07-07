package com.diguage.algo.ciqas;

/**
 * @author D瓜哥, https://www.diguage.com/
 * @since 2020-04-26 10:07
 */
public class Test13 {

    public int movingCount(int m, int n, int k) {
        int[][] matrix = new int[m][n];
        return movingCount(m, n, k, matrix, 0, 0);
    }

    private int movingCount(int m, int n, int k, int[][] matrix, int y, int x) {
        if (y < 0 || y == m // 越界
                || x < 0 || x == n // 越界
                || matrix[y][x] == 1 // 访问过
                || digSum(y) + digSum(x) > k) { // 不符合条件
            return 0;
        }
        matrix[y][x] = 1;
        int count = movingCount(m, n, k, matrix, y - 1, x)
                + movingCount(m, n, k, matrix, y, x + 1)
                + movingCount(m, n, k, matrix, y + 1, x)
                + movingCount(m, n, k, matrix, y, x - 1);
        return count + 1;
    }


    private int digSum(int num) {
        int result = 0;
        while (num > 0) {
            result += (num % 10);
            num /= 10;
        }
        return result;
    }

    public static void main(String[] args) {
        Test13 test = new Test13();
        System.out.println(test.movingCount(14, 14, 5));
        System.out.println(test.digSum(12345));
    }
}
