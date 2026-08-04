package com.diguage.algo.leetcode;


public class _0848_ShiftingLetters {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-08-04 22:47:14
   */
  public String shiftingLetters(String s, int[] shifts) {
    char[] chars = s.toCharArray();
    for (int i = shifts.length - 1; i >= 0; i--) {
      shifts[i] = (i == shifts.length - 1
        ? shifts[i] : shifts[i] + shifts[i + 1]) % 26;
      chars[i] = (char) (((chars[i] - 'a') + shifts[i]) % 26 + 'a');
    }
    return new String(chars);
  }
  // end::answer[]
}
