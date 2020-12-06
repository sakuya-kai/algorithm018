package com.sakuya.leetcode.week07;

import java.util.ArrayList;
import java.util.List;

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 *  
 *
 * 示例：
 *
 * 输入：n = 3
 * 输出：[
 *        "((()))",
 *        "(()())",
 *        "(())()",
 *        "()(())",
 *        "()()()"
 *      ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Normal22 {

    List<String> ans = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        generateParenthesis(new StringBuilder(), n, 0, 0);
        return ans;
    }

    public void generateParenthesis(StringBuilder sb, int n, int left, int right) {
        if (left == n && right == n) {
            ans.add(sb.toString());
            return;
        }
        if (left < n) {
            sb.append("(");
            generateParenthesis(sb, n, left + 1, right);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (right < left) {
            sb.append(")");
            generateParenthesis(sb, n, left, right + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
