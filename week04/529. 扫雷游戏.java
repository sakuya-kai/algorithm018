package com.sakuya.leetcode.week04;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 让我们一起来玩扫雷游戏！
 * <p>
 * 给定一个代表游戏板的二维字符矩阵。 'M' 代表一个未挖出的地雷，'E' 代表一个未挖出的空方块，'B' 代表没有相邻（上，下，左，右，和所有4个对角线）地雷的已挖出的空白方块，数字（'1' 到 '8'）表示有多少地雷与这块已挖出的方块相邻，'X' 则表示一个已挖出的地雷。
 * <p>
 * 现在给出在所有未挖出的方块中（'M'或者'E'）的下一个点击位置（行和列索引），根据以下规则，返回相应位置被点击后对应的面板：
 * <p>
 * 如果一个地雷（'M'）被挖出，游戏就结束了- 把它改为 'X'。
 * 如果一个没有相邻地雷的空方块（'E'）被挖出，修改它为（'B'），并且所有和其相邻的未挖出方块都应该被递归地揭露。
 * 如果一个至少与一个地雷相邻的空方块（'E'）被挖出，修改它为数字（'1'到'8'），表示相邻地雷的数量。
 * 如果在此次点击中，若无更多方块可被揭露，则返回面板。
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入:
 * <p>
 * [['E', 'E', 'E', 'E', 'E'],
 * ['E', 'E', 'M', 'E', 'E'],
 * ['E', 'E', 'E', 'E', 'E'],
 * ['E', 'E', 'E', 'E', 'E']]
 * <p>
 * Click : [3,0]
 * <p>
 * 输出:
 * <p>
 * [['B', '1', 'E', '1', 'B'],
 * ['B', '1', 'M', '1', 'B'],
 * ['B', '1', '1', '1', 'B'],
 * ['B', 'B', 'B', 'B', 'B']]
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minesweeper
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Normal529 {

    int yl;
    int xl;

    int[] dirX = {0, 1, 0, -1, 1, 1, -1, -1};
    int[] dirY = {1, 0, -1, 0, 1, -1, 1, -1};

    /**
     * DFS
     */
    public char[][] updateBoard(char[][] board, int[] click) {
        if (board == null || board.length == 0) return board;
        yl = board.length;
        xl = board[0].length;
        int clickY = click[0];
        int clickX = click[1];
        if (board[clickY][clickX] == 'M') {
            board[clickY][clickX] = 'X';
        } else {
            dfs(board, clickY, clickX);
        }
        return board;
    }


    public int mNum(char[][] board, int y, int x) {
        int m = 0;
        for (int i = 0; i < 8; i++) {
            int dy = y + dirY[i];
            int dx = x + dirX[i];
            if (dy < 0 || dy >= yl || dx < 0 || dx >= xl) {
                continue;
            }
            if (board[dy][dx] == 'M') m++;
        }
        return m;
    }

    public void dfs(char[][] board, int y, int x) {
        int m = mNum(board, y, x);
        if (m == 0) {
            board[y][x] = 'B';
            for (int i = 0; i < 8; i++) {
                int dy = y + dirY[i];
                int dx = x + dirX[i];
                if (dy < 0 || dy >= yl || dx < 0 || dx >= xl || board[dy][dx] != 'E') {
                    continue;
                }
                dfs(board, dy, dx);
            }
        } else {
            board[y][x] = (char) (m + '0');
        }
    }

    /**
     * BFS
     */
    public char[][] _updateBoard(char[][] board, int[] click) {
        if (board == null || board.length == 0) return board;
        yl = board.length;
        xl = board[0].length;
        int clickY = click[0];
        int clickX = click[1];
        if (board[clickY][clickX] == 'M') {
            board[clickY][clickX] = 'X';
        } else {
            boolean[][] visited = new boolean[yl][xl];
            Queue<Integer> queue = new LinkedList<>();
            queue.add(clickY * xl + clickX);
            while (!queue.isEmpty()) {
                int xy = queue.remove();
                int y0 = xy / xl;
                int x0 = xy % xl;
                int m = mNum(board, y0, x0);
                if (m == 0) {
                    board[y0][x0] = 'B';
                    for (int i = 0; i < 8; i++) {
                        int dy = y0 + dirY[i];
                        int dx = x0 + dirX[i];
                        if (dy < 0 || dy >= yl || dx < 0 || dx >= xl || board[dy][dx] != 'E' || visited[dy][dx]) {
                            continue;
                        }
                        visited[dy][dx] = true;
                        queue.add(dy * xl + dx);
                    }
                } else {
                    board[y0][x0] = (char) (m + '0');
                }
            }
        }
        return board;
    }
}
