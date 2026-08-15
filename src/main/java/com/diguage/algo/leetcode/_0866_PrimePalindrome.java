package com.diguage.algo.leetcode;

public class _0866_PrimePalindrome {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-08-15 20:21:10
   */
  public int primePalindrome(int n) {
    if (isPrime(n) && isPalindrome(n)) {
      return n;
    }
    int num = findNextPalindrome(n);
    while (!isPrime(num)) {
      num = findNextPalindrome(num);
    }
    return num;
  }

  private int findNextPalindrome(int num) {
    if (num < 9) {
      return num + 1;
    } else if (num == 9) {
      num = 10;
    }
    char[] chars = String.valueOf(num).toCharArray();
    int first = chars[0] - '0';
    int n = chars.length;
    // 首位是偶数，不能是回文质数
    if ((first & 1) == 0) {
      int next = first + 1;
      return next * (int) Math.pow(10, n - 1) + next;
    } else {
      int left = 0, right = n - 1;
      while (left < right) {
        chars[right--] = chars[left++];
      }
      int next = Integer.parseInt(new String(chars));
      if (next > num) {
        return next;
      } else {
        int mid = n / 2;
        if ((n & 1) == 0) {
          left = mid - 1;
          right = mid;
        } else {
          left = mid;
          right = mid;
        }
        while (true) {
          while (0 <= left) {
            if (chars[left] < '9') {
              char nc = (char) (chars[left] + 1);
              chars[left] = nc;
              chars[right] = nc;
              break;
            } else {
              chars[left--] = '0';
              chars[right++] = '0';
            }
          }
          if (chars[0] == '0') {
            return (int) Math.pow(10, n) + 1;
          } else {
            next = Integer.parseInt(String.valueOf(chars));
            if (next > num) {
              return next;
            }
          }
        }
      }
    }
  }

  private boolean isPalindrome(int num) {
    char[] chars = String.valueOf(num).toCharArray();
    int left = 0, right = chars.length - 1;
    while (left < right) {
      if (chars[left++] != chars[right--]) {
        return false;
      }
    }
    return true;
  }

  private boolean isPrime(int num) {
    if (num < 2 || (2 < num && (num & 1) == 0)) {
      return false;
    }
    for (int i = 3; i <= Math.sqrt(num); i++) {
      if (num % i == 0) {
        return false;
      }
    }
    return true;
  }

  // end::answer[]
  static void main() {
    new _0866_PrimePalindrome()
      .primePalindrome(102);
//      .primePalindrome(11);
//      .primePalindrome(1);
//      .primePalindrome(8);
//      .primePalindrome(13);
  }
}
