package com.diguage.algo.leetcode;

public class _0825_FriendsOfAppropriateAges {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-07-18 22:50:16
   */
  public int numFriendRequests(int[] ages) {
    int[] cnt = new int[121];
    for (int age : ages) {
      cnt[age]++;
    }
    int result = 0;
    int ageY = 0;
    int cntWindows = 0;
    for (int ageX = 0; ageX < cnt.length; ageX++) {
      cntWindows += cnt[ageX];
      if (ageY * 2 <= ageX + 14) {
        cntWindows -= cnt[ageY];
        ageY++;
      }
      if (cntWindows > 0) {
        result += cnt[ageX] * cntWindows - cnt[ageX];
      }
    }
    return result;
  }
  // end::answer[]

// 超时，不知道答案是否正确
//  public int numFriendRequests(int[] ages) {
//    Set<String> set = new HashSet<>();
//    for (int i = 0; i < ages.length; i++) {
//      for (int j = i + 1; j < ages.length; j++) {
//        if (!(isFriend(ages, i, j))) {
//          set.add(i + "/" + j);
//        }
//        if (!isFriend(ages, j, i)) {
//          set.add(j + "/" + i);
//        }
//      }
//    }
//    return set.size();
//  }
//
//  private boolean isFriend(int[] ages, int x, int y) {
//    int a = ages[x];
//    int b = ages[y];
//    return b <= 0.5F * a + 7
//      || b > a
//      || (b > 100 && a < 100);
//  }


  static void main() {
    new _0825_FriendsOfAppropriateAges().numFriendRequests(new int[]{16, 16});
  }
}
