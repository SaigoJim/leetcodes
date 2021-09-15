import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;
import static org.junit.Assert.*;

/** Given an m x n board of characters and a list of strings words,
 * return all words on the board.Each word must be constructed from letters of sequentially adjacent cells,
 * where adjacent cells are horizontally or vertically neighboring.
 * The same letter cell may not be used more than once in a word.
 * Example 1:
 * Input: board = [
 * ['o','a','a','n'],
 * ['e','t','a','e'],
 * ['i','h','k','r'],
 * ['i','f','l','v']],
 * words = ["oath","pea","eat","rain"]
 * Output: ["eat","oath"]
 * Example 2:
 * Input: board = [
 * ['a','b'],
 * ['c','d']],
 * words = ["abcb"]
 * Output: []
*/
public class WordSearchII {
    private char[][] grid;
    private boolean[][] marked;
    private int row, col;
    public List<String> findWords(char[][] board, String[] words) {
        grid = board;
        row = grid.length;
        col = grid[0].length;
        List<String> matchedWords = new ArrayList<>();
        if (grid == null || grid.length == 0) {
            return matchedWords;
        }
        marked = new boolean[row][col];
        for (String word : words) {
            if (isInBoard(word)) {
                matchedWords.add(word);
            }
        }
        return matchedWords;
    }

    private boolean isInBoard(String word) {
        for (int i = 0; i < grid.length; i += 1) {
            for (int j = 0; j < grid[0].length; j += 1) {
                char c = grid[i][j];
                if (c == word.charAt(0)) {
                    if (dfs(i, j, 1, word)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(int x, int y, int pos, String word) {
        if (pos == word.length()) {
            return true;
        }
        // Mark the visited node
        marked[x][y] = true;
        char letter = word.charAt(pos);
        if (x > 0 && grid[x - 1][y] == letter && marked[x - 1][y] == false) {
            if (dfs(x - 1, y, pos + 1, word)) {
                marked[x][y] = false;
                return true;
            }
        }
        if (x < row - 1 && grid[x + 1][y] == letter && marked[x + 1][y] == false) {
            if (dfs(x + 1, y, pos + 1, word)) {
                marked[x][y] = false;
                return true;
            }
        }
        if (y > 0 && grid[x][y - 1] == letter && marked[x][y - 1] == false) {
            if (dfs(x, y - 1, pos + 1, word)) {
                marked[x][y] = false;
                return true;
            }
        }
        if (y < col - 1 && grid[x][y + 1] == letter && marked[x][y + 1] == false) {
            if (dfs(x, y + 1, pos + 1, word)) {
                marked[x][y] = false;
                return true;
            }
        }
        marked[x][y] = false;
        return false;
    }


    @Test
    public void testFindWords() {
        char[][] board = new char[][]{
                new char[]{'o','a','a','n'},
                new char[]{'e','t','a','e'},
                new char[]{'i','h','k','r'},
                new char[]{'i','f','l','v'}
        };
        String[] words = new String[]{"oath","pea","eat","rain"};
        Set<String> expected = new HashSet<>();
        expected.add("eat");
        expected.add("oath");
        Set<String> actual = new HashSet<>();
        for (String word : findWords(board, words)) {
            actual.add(word);
        }
        assertEquals(expected, actual);
    }
    @Test
    public void testFindWords1() {
        char[][] board = new char[][]{
                new char[]{'a','b'},
                new char[]{'c','d'}
        };
        String[] words = new String[]{"abcb"};
        assertEquals(0, findWords(board, words).size());
    }
    @Test
    public void testFindWords2() {
        char[][] board = new char[][]{
                new char[]{'a','b'},
                new char[]{'c','d'}
        };
        String[] words = new String[]{"ab","cb","ad","bd","ac","ca","da","bc","db","adcb","dabc","abb","acb"};
        Set<String> expected = new HashSet<>();
        expected.add("ab");
        expected.add("ac");
        expected.add("bd");
        expected.add("ca");
        expected.add("db");
        Set<String> actual = new HashSet<>();
        for (String word : findWords(board, words)) {
            actual.add(word);
        }
        assertEquals(expected, actual);
    }
    @Test
    public void testFindWords3() {
        char[][] board = new char[][]{
                new char[]{'a','b'},
                new char[]{'a','a'}
        };

        String[] words = new String[]{"aba","baa","bab","aaab","aaa","aaaa","aaba"};
        List<String> l = findWords(board, words);
//        Set<String> expected = new HashSet<>();
//        expected.add("ab");
//        expected.add("ac");
//        expected.add("bd");
//        expected.add("ca");
//        expected.add("db");
//        Set<String> actual = new HashSet<>();
//        for (String word : findWords(board, words)) {
//            actual.add(word);
//        }
//        assertEquals(expected, actual);
    }
}
