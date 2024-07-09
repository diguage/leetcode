package com.diguage.algo.leetcode;

import java.util.ArrayList;
import java.util.List;
import static com.diguage.util.Printers.*;

/**
 * = 46. Permutations
 *
 * https://leetcode.com/problems/permutations/[Permutations - LeetCode]
 *
 * Given a collection of *distinct* integers, return all possible permutations.
 *
 * .Example:
 * [source]
 * ----
 * Input: [1,2,3]
 * Output:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 * ----
 */
public class _0046_Permutations_2 {
  // tag::answer[]
  /**
   * 参考《算法小抄》的参数，自己实现的
   *
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-06-28 22:30
   */
  public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    boolean[] used = new boolean[nums.length];
    backtrack(nums, result, path, used);
    return result;
  }

  private void backtrack(int[] nums, List<List<Integer>> result,
                         List<Integer> path, boolean[] used) {
    if (nums == null || nums.length == 0) {
      return;
    }
    if (path.size() == nums.length) {
      result.add(new ArrayList<>(path));
      return;
    }
    for (int i = 0; i < nums.length; i++) {
      if (used[i]) {
        continue;
      }
      used[i] = true;
      path.add(nums[i]);
      backtrack(nums, result, path, used);
      path.remove(path.size() - 1);
      used[i] = false;
    }
  }
  // end::answer[]
}
