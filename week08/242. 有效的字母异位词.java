package com.sakuya.leetcode.week08;

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 示例 1:
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-anagram
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Normal242 {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;
        char[] cs = s.toCharArray();
        char[] ct = t.toCharArray();
        int[] map = new int[26];
        int count = 0;
        for (int i = 0; i < cs.length; i++) {
            if (++map[cs[i] - 'a'] == 1) {
                count++;
            }
            if (--map[ct[i] - 'a'] == 0) {
                count--;
            }
        }
        return count == 0;
    }
}
