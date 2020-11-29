package com.sakuya.leetcode.week06;

/**
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 *
 * 题目数据保证答案肯定是一个 32 位的整数。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "12"
 * 输出：2
 * 解释：它可以解码为 "AB"（1 2）或者 "L"（12）。
 * 示例 2：
 *
 * 输入：s = "226"
 * 输出：3
 * 解释：它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 * 示例 3：
 *
 * 输入：s = "0"
 * 输出：0
 * 示例 4：
 *
 * 输入：s = "1"
 * 输出：1
 * 示例 5：
 *
 * 输入：s = "2"
 * 输出：1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/decode-ways
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Normal91 {

    /**
     * 普通DP
     *
     * 时间复杂度O(n)
     * 空间复杂度O(n)
     */
    public int numDecodings(String s) {
        int n = s.length();
        if (n == 0 || s.charAt(0) == '0') return 0;

        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            char c0 = s.charAt(i - 2);
            char c1 = s.charAt(i - 1);
            if (c1 == '0') {
                // 当前字符是0，只能解析成10或20，否则返回0
                if (c0 == '1' || c0 == '2') dp[i] = dp[i - 2];
                else return 0;
            } else if (c0 == '1' || ((c0 == '2') && c1 <= '6')) {
                // 前两个字符组合成 11 => 26 的形式，有两种组合方式，所以dp[i] = dp[i - 1] + dp[i - 2]
                dp[i] = dp[i - 1] + dp[i - 2];
            } else {
                // 其他情况组合不变dp[i] = dp[i - 1]
                dp[i] = dp[i - 1];
            }
        }
        return dp[n];
    }

    /**
     * 空间优化后
     *
     * 空间复杂度O(1)
     */
    public int _numDecodings(String s) {
        int n = s.length();
        if (n == 0 || s.charAt(0) == '0') return 0;

        int pre = 1, cur = 1, tmp;
        for (int i = 1; i < n; i++) {
            tmp = cur;
            char c0 = s.charAt(i - 1);
            char c1 = s.charAt(i);
            if (c1 == '0') {
                if (c0 == '1' || c0 == '2') cur = pre;
                else return 0;
            } else if (c0 == '1' || ((c0 == '2') && c1 <= '6')) {
                cur = cur + pre;
            }
            pre = tmp;
        }
        return cur;
    }


}
