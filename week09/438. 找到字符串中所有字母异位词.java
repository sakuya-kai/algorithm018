package com.sakuya.leetcode.week09;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
 *
 * 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
 *
 * 说明：
 *
 * 字母异位词指字母相同，但排列不同的字符串。
 * 不考虑答案输出的顺序。
 * 示例 1:
 *
 * 输入:
 * s: "cbaebabacd" p: "abc"
 *
 * 输出:
 * [0, 6]
 *
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-all-anagrams-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Normal438 {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int index = 0;
        char[] cs = s.toCharArray();
        char[] cp = s.toCharArray();
        while (index < cs.length - cp.length) {
            if (isAnagram(cs, index, cp)) {
                ans.add(index);
            }
            index++;
        }
        return ans;
    }

    private boolean isAnagram(char[] cs, int index, char[] cp) {
        int[] map = new int[26];
        int count = 0;
        for (int i = 0; i < cp.length; i++) {
            System.out.println(index);
            if (++map[cs[index + i] - 'a'] == 1) {
                count++;
            }
            if (--map[cp[i] - 'a'] == 0) {
                count--;
            }
        }
        return count == 0;
    }
}
