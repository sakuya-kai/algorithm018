package com.sakuya.leetcode.week08;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 给出一个区间的集合，请合并所有重叠的区间。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-intervals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Normal56 {

    /**
     * 时间复杂度O(N * logN)
     * 空间复杂度O(1)
     */
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 1) return intervals;
        // 按照左区间大小排序
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        int index = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i - 1][1] >= intervals[i][0]) {
                // 前后两个区间能合并时把合并结果放到后一个上
                intervals[i][0] = Math.min(intervals[i - 1][0], intervals[i][0]);
                intervals[i][1] = Math.max(intervals[i - 1][1], intervals[i][1]);
            } else {
                // 不能合并时把上一个合并结果放入index的下标中
                intervals[index++] = intervals[i - 1];
            }
            // 最后一个区间结果
            if (i == intervals.length - 1) {
                intervals[index++] = intervals[i];
            }
        }
        // 结果放在intervals的前index个
        return Arrays.copyOf(intervals, index);
    }
}
