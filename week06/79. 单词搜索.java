package com.sakuya.leetcode.week06;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * board =
 * [
 * ['A','B','C','E'],
 * ['S','F','C','S'],
 * ['A','D','E','E']
 * ]
 * <p>
 * 给定 word = "ABCCED", 返回 true
 * 给定 word = "SEE", 返回 true
 * 给定 word = "ABCB", 返回 false
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-search
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Normal79 {

    private boolean[][] visited;
    private int n;
    private int m;
    private int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    /**
     * 使用visited记录已访问节点，比较普通的DFS
     *
     * 时间复杂度 O(N * M * 3 ^ L) L是字符串的长度， 对于字符串的每个字符都会向另外三个方向进行递归
     * 空间复杂度 O(N * M)
     */
    public boolean exist(char[][] board, String word) {
        n = board.length;
        m = board[0].length;
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (recursion(board, i, j, word, 0))
                    return true;
            }
        }
        return false;
    }

    public boolean recursion(char[][] board, int i, int j, String word, int k) {
        if (board[i][j] != word.charAt(k)) return false;
        // 最后一个字符也相等直接返回true
        if (k == word.length() - 1) return true;
        visited[i][j] = true;
        boolean result = false;
        for (int[] dir : directions) {
            int newI = i + dir[0], newJ = j + dir[1];
            if (newI >= 0 && newI < n && newJ >= 0 && newJ < m) {
                if (!visited[newI][newJ]) {
                    boolean flag = recursion(board, newI, newJ, word, k + 1);
                    if (flag) {
                        result = true;
                        break;
                    }
                }
            }
        }
        // 复原
        visited[i][j] = false;
        return result;
    }

    /**
     * 精简之后的DFS
     */
    public boolean _exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                //从[i,j]这个坐标开始查找
                if (dfs(board, words, i, j, 0))
                    return true;
            }
        }
        return false;
    }

    boolean dfs(char[][] board, char[] word, int i, int j, int index) {
        //边界的判断，如果越界直接返回false。index表示的是查找到字符串word的第几个字符，
        //如果这个字符不等于board[i][j]，说明验证这个坐标路径是走不通的，直接返回false
        if (i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word[index])
            return false;
        //如果word的每个字符都查找完了，直接返回true
        if (index == word.length - 1)
            return true;
        //把当前坐标的值保存下来，为了在最后复原
        char tmp = board[i][j];
        //然后修改当前坐标的值
        board[i][j] = '.';
        //走递归，沿着当前坐标的上下左右4个方向查找
        boolean res = dfs(board, word, i + 1, j, index + 1) || dfs(board, word, i - 1, j, index + 1) ||
                dfs(board, word, i, j + 1, index + 1) || dfs(board, word, i, j - 1, index + 1);
        //递归之后再把当前的坐标复原
        board[i][j] = tmp;
        return res;
    }
}
