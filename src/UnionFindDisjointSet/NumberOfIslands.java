package UnionFindDisjointSet;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;
import java.util.*;

/**
 * Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water),
 * return the number of islands.
 *
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 *Example 1:
 *
 * Input: grid = [
 *   ['1','1','1','1','0'],
 *   ['1','1','0','1','0'],
 *   ['1','1','0','0','0'],
 *   ['0','0','0','0','0']
 * ]
 * Output: 1
 * Example 2:
 *
 * Input: grid = [
 *   ['1','1','0','0','0'],
 *   ['1','1','0','0','0'],
 *   ['0','0','1','0','0'],
 *   ['0','0','0','1','1']
 * ]
 * Output: 3
 *
 */

public class NumberOfIslands {
    int row, col;
    char[][] islands;
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int count = 0;
        islands = grid;
        row = grid.length;
        col = grid[0].length;
        for (int i = 0; i < grid.length; i += 1) {
            for (int j = 0; j < grid[0].length; j += 1) {
                if (grid[i][j] == '1') {
                    dfs(i, j);
                    count += 1;
                }
            }
        }
        return count;
    }
    private void dfs(int x, int y) {
        // Mark the visited node
        islands[x][y] = 'M';
        if (x > 0 && islands[x - 1][y] == '1') {
            dfs(x - 1, y);
        }
        if (x < row - 1 && islands[x + 1][y] == '1') {
            dfs(x + 1, y);
        }
        if (y > 0 && islands[x][y - 1] == '1') {
            dfs(x, y - 1);
        }
        if (y < col - 1 && islands[x][y + 1] == '1') {
            dfs(x, y + 1);
        }
    }
    @Test
    public void testNumOfIslands() {
        char[][] grid = new char[][] {
                new char[]{'1','1','1','1','0'},
                new char[]{'1','1','0','1','0'},
                new char[]{'1','1','0','0','0'},
                new char[]{'0','0','0','0','0'},
        };
        assertEquals(1, numIslands(grid));
    }
    @Test
    public void testNumOfIslands1() {
        char[][] grid = new char[][] {
                new char[]{'1','1','0','0','0'},
                new char[]{'1','1','0','0','0'},
                new char[]{'0','0','1','0','0'},
                new char[]{'0','0','0','1','1'},
        };
        assertEquals(3, numIslands(grid));
    }
}
