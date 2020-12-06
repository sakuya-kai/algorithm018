package com.sakuya.leetcode.week07;

import java.util.HashSet;
import java.util.Set;

/**
 * 一条基因序列由一个带有8个字符的字符串表示，其中每个字符都属于 "A", "C", "G", "T"中的任意一个。
 *
 * 假设我们要调查一个基因序列的变化。一次基因变化意味着这个基因序列中的一个字符发生了变化。
 *
 * 例如，基因序列由"AACCGGTT" 变化至 "AACCGGTA" 即发生了一次基因变化。
 *
 * 与此同时，每一次基因变化的结果，都需要是一个合法的基因串，即该结果属于一个基因库。
 *
 * 现在给定3个参数 — start, end, bank，分别代表起始基因序列，目标基因序列及基因库，请找出能够使起始基因序列变化为目标基因序列所需的最少变化次数。如果无法实现目标变化，请返回 -1。
 *
 * 注意:
 *
 * 起始基因序列默认是合法的，但是它并不一定会出现在基因库中。
 * 所有的目标基因序列必须是合法的。
 * 假定起始基因序列与目标基因序列是不一样的。
 * 示例 1:
 *
 * start: "AACCGGTT"
 * end:   "AACCGGTA"
 * bank: ["AACCGGTA"]
 *
 * 返回值: 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-genetic-mutation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Normal433 {

    public int minMutation(String start, String end, String[] bank) {
        int ans = 0;
        Set<String> banks = new HashSet<>();
        for (String b : bank) {
            banks.add(b);
        }
        if (!banks.contains(end)) return -1;
        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        Set<String> visited = new HashSet<>();
        beginSet.add(start);
        endSet.add(end);
        char[] chenge = new char[]{'A', 'C', 'G', 'T'};
        while (!beginSet.isEmpty()) {
            ans++;
            Set<String> tmp = new HashSet<>();
            for (String b : beginSet) {
                char[] chars = b.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    char old = chars[i];
                    for (char ch : chenge) {
                        chars[i] = ch;
                        String newB = String.valueOf(chars);
                        if (endSet.contains(newB)) return ans;
                        if (banks.contains(newB) && !visited.contains(newB)) {
                            visited.add(newB);
                            tmp.add(newB);
                        }
                    }
                    chars[i] = old;
                }
            }
            beginSet = tmp;
            if (beginSet.size() > endSet.size()) {
                Set<String> set = beginSet;
                beginSet = endSet;
                endSet = set;
            }
        }
        return -1;
    }
}
