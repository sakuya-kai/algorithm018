package com.sakuya.leetcode.week07;

/**
 * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
 *
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 *
 *
 * 数独部分空格内已填入了数字，空白格用 '.' 表示。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-sudoku
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Normal36 {

    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') continue;
                // 判断横竖
                for (int k = 0; k < 9; k++) {
                    if (board[i][j] == board[i][k] && k != j || board[i][j] == board[k][j] && k != i) {
                        return false;
                    }
                }
                // 判断3 * 3格子
                int i0 = (i / 3) * 3, j0 = (j / 3) * 3;
                for (int n = i0; n < i0 + 3; n++) {
                    for (int m = j0; m < j0 + 3; m++) {
                        if (board[i][j] == board[n][m] && i != n && j != m) {
                            System.out.println(i + ":" + j);
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public boolean _isValidSudoku(char[][] board) {
        int[][] rows = new int[9][9];
        int[][] col = new int[9][9];
        int[][] box = new int[9][9];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j]!='.'){
                    int num = board[i][j] - '1';
                    int index_box = (i/3)*3+j/3;
                    if (rows[i][num]==1) { return false;}
                    else { rows[i][num]=1; }
                    if (col[j][num]==1) { return false;}
                    else { col[j][num]=1; }
                    if (box[index_box][num]==1)  { return false;}
                    else { box[index_box][num]=1; }
                }
            }
        }
        return true;
    }
}
