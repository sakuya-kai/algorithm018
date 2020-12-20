package com.sakuya.leetcode.week09;

/**
 * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "aba"
 * 输出: True
 * 示例 2:
 * <p>
 * 输入: "abca"
 * 输出: True
 * 解释: 你可以删除c字符。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-palindrome-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Normal680 {

    /**
     * 左右指针，先去掉相等的字符，遇到不等的要么去掉左边要么去掉右边，有一个满足就行
     */
    public boolean validPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        char[] chars = s.toCharArray();
        for (; chars[i] == chars[j] && i < j; i++, j--);
        return palindrome(chars, i + 1, j) || palindrome(chars, i, j - 1);
    }

    private boolean palindrome(char[] chars, int i, int j) {
        while (i < j) {
            if (chars[i++] != chars[j--]) return false;
        }
        return true;
    }
}
