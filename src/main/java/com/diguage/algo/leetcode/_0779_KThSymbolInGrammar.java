package com.diguage.algo.leetcode;

public class _0779_KThSymbolInGrammar {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-06-16 22:47:20
   */
  public int kthGrammar(int n, int k) {
    // 向上遍历到了第1行，则返回结果
    if (k == 1) {
      return 0;
    }
    // 如果在“蓝色区间”，则与上一行值相反
    if (k > (1 << (n - 2))) {
      return 1 ^ kthGrammar(n - 1, k - (1 << (n - 2)));
    }
    // 如果在“黄色区间”，则与上一行值相同
    return kthGrammar(n - 1, k);
  }
  // end::answer[]
}
