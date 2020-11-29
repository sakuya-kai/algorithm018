package com.sakuya.leetcode.week06;

/**
 * 给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​
 *
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 *
 * 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * 示例:
 *
 * 输入: [1,2,3,0,2]
 * 输出: 3
 * 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Normal309 {

    /**
     * 相比普通交易多了一个冷冻期的状态
     */
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0) return 0;
        int dp0 = -prices[0];
        int dp1 = 0;
        int dp2 = 0;
        for (int i = 1; i < n; i++) {
            int newDp0 = Math.max(dp0, dp2 - prices[i]);
            int newDp1 = dp0 + prices[i];
            int newDp2 = Math.max(dp1, dp2);
            dp0 = newDp0;
            dp1 = newDp1;
            dp2 = newDp2;
        }
        return Math.max(dp1, dp2);
    }
}
