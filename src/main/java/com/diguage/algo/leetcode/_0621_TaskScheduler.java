package com.diguage.algo.leetcode;

import java.util.*;

/**
 * = 621. Task Scheduler
 *
 * https://leetcode.com/problems/task-scheduler/[Task Scheduler - LeetCode]
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2020-01-31 21:26
 */
public class _0621_TaskScheduler {
  // tag::answer[]
    /**
     * Runtime: 2 ms, faster than 99.97% of Java online submissions for Task Scheduler.
     * Memory Usage: 42.7 MB, less than 5.88% of Java online submissions for Task Scheduler.
     *
     * Copy from: https://leetcode-cn.com/problems/task-scheduler/solution/621-ren-wu-diao-du-qi-java-jie-ti-zhu-shi-ying-gai/[621. 任务调度器--Java--解题注释应该能看懂 - 任务调度器 - 力扣（LeetCode）]
     *
     * @author D瓜哥 · https://www.diguage.com
     * @since 2020-01-31 21:26
     */
    public int leastInterval(char[] tasks, int n) {
        if (Objects.isNull(tasks) || tasks.length == 0) {
            return 0;
        }
        int[] counts = new int[26];
        for (char task : tasks) {
            counts[task - 'A']++;
        }
        Arrays.sort(counts);
        int maxCount = counts[25];
        // 前面 maxCount - 1 个任务需要有 n 个间隔，所以就是 (maxCount - 1) * (n + 1)
        // 而最后一个任务不需要间隔，就只能算 1
        int restCount = (maxCount - 1) * (n + 1) + 1;
        for (int i = 24; i >= 0 && counts[i] == maxCount; i--) {
            restCount++;
        }
        return Math.max(restCount, tasks.length);
    }

    /**
     * Runtime: 2 ms, faster than 99.97% of Java online submissions for Task Scheduler.
     * Memory Usage: 42.6 MB, less than 5.88% of Java online submissions for Task Scheduler.
     * <p>
     * Copy from: https://leetcode-cn.com/problems/task-scheduler/solution/ren-wu-diao-du-qi-by-leetcode/[任务调度器 - 任务调度器 - 力扣（LeetCode）]
     */
    public int leastInterval1(char[] tasks, int n) {
        if (Objects.isNull(tasks) || tasks.length == 0) {
            return 0;
        }
        int[] counts = new int[26];
        for (char task : tasks) {
            counts[task - 'A']++;
        }
        Arrays.sort(counts);
        int maxValue = counts[25] - 1;
        int idleSlots = maxValue * n;
        for (int i = 24; i >= 0 && counts[i] > 0; i--) {
            idleSlots -= Math.min(maxValue, counts[i]);
        }
        return idleSlots > 0 ? idleSlots + tasks.length : tasks.length;
    }

    /**
     * Runtime: 29 ms, faster than 42.49% of Java online submissions for Task Scheduler.
     * Memory Usage: 41.9 MB, less than 5.88% of Java online submissions for Task Scheduler.
     * <p>
     * Copy from: https://leetcode-cn.com/problems/task-scheduler/solution/ren-wu-diao-du-qi-by-leetcode/[任务调度器 - 任务调度器 - 力扣（LeetCode）]
     */
    public int leastIntervalQueue(char[] tasks, int n) {
        if (Objects.isNull(tasks) || tasks.length == 0) {
            return 0;
        }
        int[] counts = new int[26];
        for (char c : tasks) {
            counts[c - 'A']++;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for (int count : counts) {
            if (count > 0) {
                queue.add(count);
            }
        }
        int time = 0;
        while (!queue.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            int i = 0;
            while (i <= n) {
                if (!queue.isEmpty()) {
                    if (queue.peek() > 1) {
                        temp.add(queue.poll() - 1);
                    } else {
                        queue.poll();
                    }
                }
                time++;
                i++;
                if (queue.isEmpty() && temp.isEmpty()) {
                    break;
                }
            }
            for (Integer count : temp) {
                queue.add(count);
            }
        }
        return time;
    }

  // end::answer[]


    public static void main(String[] args) {
        _0621_TaskScheduler solution = new _0621_TaskScheduler();
        int r1 = solution.leastInterval("AAABBB".toCharArray(), 2);
        System.out.println((r1 == 8) + " : " + r1);
    }
}
