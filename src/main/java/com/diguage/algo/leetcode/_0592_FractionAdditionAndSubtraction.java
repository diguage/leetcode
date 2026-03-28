package com.diguage.algo.leetcode;

public class _0592_FractionAdditionAndSubtraction {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-03-28 19:36:17
   */
  public String fractionAddition(String expression) {
    // 起始数字
    int num = 0, den = 1;
    char symbol = '+';
    int index = 0;
    while (index < expression.length()) {
      // 获取下一个分子分母
      int div = expression.indexOf("/", index);
      int nextNum = Integer.parseInt(expression.substring(index, div));
      int nextDen = 0;
      int end = div + 1;
      while (end < expression.length()
        && Character.isDigit(expression.charAt(end))) {
        nextDen = 10 * nextDen + (expression.charAt(end) - '0');
        end++;
      }
      // 计算两个分子分母
      int[] sum = add(num, den, symbol, nextNum, nextDen);
      num = sum[0];
      den = sum[1];
      if (end < expression.length()) {
        symbol = expression.charAt(end);
        index = end + 1;
      } else {
        break;
      }
    }
    return num + "/" + den;
  }

  private int[] add(int preNum, int preDen, char symbol, int nextNum, int nextDen) {
    if (symbol == '-') {
      nextNum = -nextNum;
    }
    int num = preDen == nextDen ? preNum + nextNum : preNum * nextDen + nextNum * preDen;
    if (num == 0) {
      return new int[]{0, 1};
    }
    int den = preDen == nextDen ? preDen : preDen * nextDen;
    // 处理约数：最简单的解法，GCD 最大公约数
    int max = Math.max(Math.abs(num), Math.abs(den));
    int min = Math.min(Math.abs(num), Math.abs(den));
    // 处理约数
    int gcd = gcd(max, min);
    return new int[]{num / gcd, den / gcd};
    // 处理约数：更高效的解法
    //    int div = Math.min(Math.abs(num), Math.abs(den));
    //    if (num % div == 0 && den % div == 0) {
    //      return new int[]{num / div, den / div};
    //    }
    //    for (int i = (int) Math.sqrt(div); i > 1; i--) {
    //      if (num % i == 0 && den % i == 0) {
    //        num = num / i;
    //        den = den / i;
    //      }
    //    }
    //    return new int[]{num, den};
  }

  private int gcd(int a, int b) {
    return b == 0 ? a : gcd(b, a % b);
  }
  // end::answer[]

  static void main() {
    new _0592_FractionAdditionAndSubtraction()
      .fractionAddition("5/2+2/9-5/6");
//      .fractionAddition("-1/2+1/2+1/3");
//      .fractionAddition("-1/2+1/2");
  }
}
