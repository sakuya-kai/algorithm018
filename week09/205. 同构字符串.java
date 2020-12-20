package com.sakuya.leetcode.week09;

/**
 * 给定两个字符串 s 和 t，判断它们是否是同构的。
 *
 * 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
 *
 * 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。
 *
 * 示例 1:
 *
 * 输入: s = "egg", t = "add"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "foo", t = "bar"
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/isomorphic-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Normal205 {

    /**
     * 双 hash表验证
     */
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        char[] mapS = new char[128];
        char[] mapT = new char[128];
        for (int i = 0; i < s.length(); i++) {
            char chs = s.charAt(i);
            char cht = t.charAt(i);
            if (mapS[chs] == 0) {
                mapS[chs] = cht;
            } else if (mapS[chs] != cht) {
                return false;
            }
            if (mapT[cht] == 0) {
                mapT[cht] = chs;
            } else if (mapT[cht] != chs) {
                return false;
            }
        }
        return true;
    }

    /**
     * 记录上次字符出现的位置，全一样就是同构
     */
    public boolean _isIsomorphic(String s, String t) {
        int n = s.length();
        int[] mapS = new int[128];
        int[] mapT = new int[128];
        for (int i = 0; i < n; i++) {
            char chs = s.charAt(i);
            char cht = t.charAt(i);
            //当前的映射值是否相同
            if (mapS[chs] != mapT[cht]) {
                return false;
            } else {
                //是否已经修改过，修改过就不需要再处理
                if (mapS[chs] == 0) {
                    mapS[chs] = i + 1;
                    mapT[cht] = i + 1;
                }
            }
        }
        return true;
    }
}
