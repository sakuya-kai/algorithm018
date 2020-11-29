package com.sakuya.leetcode.week06;

import java.util.Arrays;

/**
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 *
 * 你可以认为每种硬币的数量是无限的。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：coins = [1, 2, 5], amount = 11
 * 输出：3
 * 解释：11 = 5 + 5 + 1
 * 示例 2：
 *
 * 输入：coins = [2], amount = 3
 * 输出：-1
 * 示例 3：
 *
 * 输入：coins = [1], amount = 0
 * 输出：0
 * 示例 4：
 *
 * 输入：coins = [1], amount = 1
 * 输出：1
 * 示例 5：
 *
 * 输入：coins = [1], amount = 2
 * 输出：2
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coin-change
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Normal322 {

    private int[] mem;

    /**
     * 自顶向下DP
     *
     * F(n) = min(F(n - coins[i])) + 1
     *
     * 时间复杂度O(M * N)
     * 空间复杂度O(N)
     *
     * M是coins长度
     * N是amount大小
     */
    public int coinChange(int[] coins, int amount) {
        if (amount < 1) return 0;
        mem = new int[amount];
        return recursion(coins, amount);
    }

    public int recursion(int[] coins, int amount) {
        if (amount < 0) return -1;
        if (amount == 0) return 0;
        if (mem[amount - 1] != 0) return mem[amount - 1];
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = recursion(coins, amount - coin);
            if (res >= 0 && res < min) {
                min = res + 1;
            }
        }
        mem[amount - 1] = min == Integer.MAX_VALUE ? -1 : min;
        return mem[amount - 1];
    }

    /**
     * 自底向上DP
     */
    public int _coinChange(int[] coins, int amount) {
        if (amount < 1) return 0;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i >= coin) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }

    int min = Integer.MAX_VALUE;

    /**
     * 贪心 + DFS
     *
     * 每次取最大面值的硬币，取的个数为 amount / coin 到 0
     * 加上各种剪枝判断，实际上的效率比DP高不少
     */
    public int __coinChange(int[] coins, int amount) {
        if (amount < 1) return 0;
        Arrays.sort(coins);
        recursion(coins, amount, coins.length - 1, 0);
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    public void recursion(int[] coins, int amount, int index, int count) {
        if (amount == 0) {
            min = Math.min(min, count);
            return;
        }
        if (index == -1) return;
        for (int k = amount / coins[index]; k >= 0 && k + count < min; k--) {
            recursion(coins, amount - k * coins[index], index - 1, count + k);
        }
    }

    public static void main(String[] args) {
        new Normal322().__coinChange(new int[]{1, 2, 5}, 11);
    }
}
