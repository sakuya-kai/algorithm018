package com.sakuya.leetcode.week04;

import java.util.*;

/**
 * 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
 *
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典中的单词。
 * 说明:
 *
 * 如果不存在这样的转换序列，返回 0。
 * 所有单词具有相同的长度。
 * 所有单词只由小写字母组成。
 * 字典中不存在重复的单词。
 * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 * 示例 1:
 *
 * 输入:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 *
 * 输出: 5
 *
 * 解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 *      返回它的长度 5。
 * 示例 2:
 *
 * 输入:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 *
 * 输出: 0
 *
 * 解释: endWord "cog" 不在字典中，所以无法进行转换。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-ladder
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Normal127 {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int ans = 1;
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.add(-1);
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean flag = false;
            for (int i = 0; i < size; i++) {
                int index = queue.remove();
                String word = index == -1 ? beginWord : wordList.get(index);
                for (int j = 0; j < wordList.size(); j++) {
                    if (visited.contains(j))continue;
                    String w = wordList.get(j);
                    if (diff(word, w) == 1) {
                        if (w.equals(endWord)) {
                            ans++;
                            return ans;
                        }
                        flag = true;
                        visited.add(j);
                        queue.add(j);
                    }
                }
            }
            if (flag) ans++;
        }
        return 0;
    }

    public int diff(String a, String b) {
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) diff++;
        }
        return diff;
    }

    public int _ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return 0;
        int ans = 1;
        Set<String> dict = new HashSet<>(wordList);
        Set<String> begin = new HashSet<>();
        Set<String> end = new HashSet<>();
        begin.add(beginWord);
        end.add(endWord);
        dict.remove(beginWord);
        dict.remove(endWord);
        while (!begin.isEmpty() && !end.isEmpty()) {
            ans++;
            Set<String> temp = new HashSet<>();
            for (String word : begin) {
                char[] chs = word.toCharArray();
                for (int i = 0; i < chs.length; i++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        char old = chs[i];
                        chs[i] = c;
                        String target = String.valueOf(chs);
                        if (end.contains(target)) {
                            return ans;
                        }
                        if (dict.contains(target)) {
                            temp.add(target);
                            dict.remove(target);
                        }
                        chs[i] = old;
                    }
                }
            }
            begin = temp.size() < end.size() ? temp: end;
            end = begin.size() < end.size() ? end : temp;
        }
        return 0;
    }
}
