package com.sakuya.leetcode.week08;

/**
 * 给定一个数组 nums ，如果 i < j 且 nums[i] > 2*nums[j] 我们就将 (i, j) 称作一个重要翻转对。
 *
 * 你需要返回给定数组中的重要翻转对的数量。
 *
 * 示例 1:
 *
 * 输入: [1,3,2,3,1]
 * 输出: 2
 * 示例 2:
 *
 * 输入: [2,4,3,5,1]
 * 输出: 3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Normal493 {

    public int reversePairs(int[] nums) {
        if (nums == null || nums.length <= 0) return 0;
        return merger(nums, 0, nums.length - 1);
    }

    private int merger(int[] nums, int l, int r) {
        if (l >= r) return 0;
        int mid = (l + r) / 2;

        int count = merger(nums, l, mid) + merger(nums, mid + 1, r);

        int[] arr = new int[r - l + 1];
        int i = l, t = l, c = 0;
        for (int j = mid + 1; j <= r; j++) {
            while (i <= mid && nums[i] <= (long) 2 * nums[j]) i++;
            while (t <= mid && nums[t] < nums[j]) arr[c++] = nums[t++];
            arr[c++] = nums[j];
            count += mid - i + 1;
        }
        while (t <= mid) arr[c++] = nums[t++];
        System.arraycopy(arr, 0, nums, l, r - l + 1);
        return count;
    }
}
