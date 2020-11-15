package com.sakuya.leetcode.week04;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 *
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 *
 * 此外，你可以假设该网格的四条边均被水包围。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：grid = [
 *   ["1","1","1","1","0"],
 *   ["1","1","0","1","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","0","0","0"]
 * ]
 * 输出：1
 * 示例 2：
 *
 * 输入：grid = [
 *   ["1","1","0","0","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","1","0","0"],
 *   ["0","0","0","1","1"]
 * ]
 * 输出：3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-islands
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Normal200 {

    int yl;
    int xl;

    /**
     * DFS
     */
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int ans = 0;
        yl = grid.length;
        xl = grid[0].length;
        for (int y = 0; y < yl; y++) {
            for (int x = 0; x < xl; x++) {
                if (grid[y][x] == '1') {
                    ans++;
                    recursion(grid, y, x);
                }
            }
        }
        return ans;
    }

    public void recursion(char[][] grid, int y, int x) {
        if (y >= yl || x >= xl || grid[y][x] == '0') {
            return;
        }
        grid[y][x] = '0';
        recursion(grid, y + 1, x);
        recursion(grid, y, x + 1);
        recursion(grid, y - 1, x);
        recursion(grid, y, x - 1);
    }

    /**
     * BFS
     */
    public int _numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int ans = 0;
        int yl = grid.length;
        int xl = grid[0].length;
        for (int y = 0; y < yl; y++) {
            for (int x = 0; x < xl; x++) {
                if (grid[y][x] == '1') {
                    ans++;
                    grid[y][x] = '0';
                    Queue<Integer> queue = new LinkedList<>();
                    queue.add(y * xl + x);
                    while (!queue.isEmpty()) {
                        int xy = queue.remove();
                        int x0 = xy % xl;
                        int y0 = xy / xl;

                        if (y0 + 1 < yl && grid[y0 + 1][x0] == '1') {
                            queue.add((y0 + 1) * xl + x0);
                            grid[y0 + 1][x0] = '0';
                        }
                        if (y0 - 1 >= 0 && grid[y0 - 1][x0] == '1') {
                            queue.add((y0 - 1) * xl + x0);
                            grid[y0 - 1][x0] = '0';
                        }
                        if (x0 + 1 < xl && grid[y0][x0 + 1] == '1') {
                            queue.add(y0 * xl + x0 + 1);
                            grid[y0][x0 + 1] = '0';
                        }
                        if (x0 - 1 >= 0 && grid[y0][x0 - 1] == '1') {
                            queue.add(y0 * xl + x0 - 1);
                            grid[y0][x0 - 1] = '0';
                        }
                    }
                }
            }
        }
        return ans;
    }
}
