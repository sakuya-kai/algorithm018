package com.sakuya.leetcode.week09;

/**
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 *
 *  
 *
 * 示例：
 *
 * 输入："Let's take LeetCode contest"
 * 输出："s'teL ekat edoCteeL tsetnoc"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-words-in-a-string-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Normal557 {

    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        int start = 0, end = 0;
        while (end < chars.length) {
            while (end < chars.length && chars[end] != ' ') end++;
            reverse(chars, start, end - 1);
            end++;
            start = end;
        }
        return String.valueOf(chars);
    }

    public void reverse(char[] chars, int i, int j) {
        while (i < j) {
            char temp = chars[i];
            chars[i++] = chars[j];
            chars[j--] = temp;
        }
    }
}
