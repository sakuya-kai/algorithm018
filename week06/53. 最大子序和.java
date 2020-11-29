package com.sakuya.leetcode.week06;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 *
 * 输入: [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Normal53 {

    /**
     * 优化空间后的DP
     *
     * F(i) = max(F(i - 1) + num, num)
     *
     * 时间复杂度O(n)
     * 空间复杂度O(1)
     */
    public int maxSubArray(int[] nums) {
        int max = nums[0], ans = max;
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max + nums[i], nums[i]);
            ans = Math.max(max, ans);
        }
        return ans;
    }
}
