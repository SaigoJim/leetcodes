package DynamicProgramming;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

/**
 * Given an integer n, return the least number of perfect square numbers that sum to n.
 *
 * A perfect square is an integer that is the square of an integer;
 * in other words, it is the product of some integer with itself.
 * For example, 1, 4, 9, and 16 are perfect squares while 3 and 11 are not.
 *
 *
 * Example 1:
 *
 * Input: n = 12
 * Output: 3
 * Explanation: 12 = 4 + 4 + 4.
 * Example 2:
 *
 * Input: n = 13
 * Output: 2
 * Explanation: 13 = 4 + 9.
 *
 * Constraints:
 *
 * 1 <= n <= 104
 */
public class PerfectSquares {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i < dp.length; i += 1) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j += 1) {
                min = Math.min(min, dp[i - j * j]);
            }
            dp[i] = min + 1;
        }
        return dp[n];
    }
    public int numSquaresUsingReduction(int n) {
        List<Integer> perfects = new ArrayList<>();
        for (int i = 1; i * i <= n; i += 1) {
            perfects.add(i * i);
        }
        int[] array = new int[perfects.size()];
        for (int i = 0; i < array.length; i += 1) {
            array[i] = perfects.get(i);
        }
        return coinChange(array, n);
    }

    public int coinChange(int[] coins, int amount) {
        int[][] A = new int[coins.length + 1][amount + 1];
        for (int i = 0; i < A[0].length; i += 1) {
            A[0][i] = Integer.MAX_VALUE;
        }
        for (int i = 1; i < A.length; i += 1) {
            int coin = coins[i - 1];
            for (int j = 1; j < A[0].length; j += 1) {
                if (coin <= j && A[i][j - coin] != Integer.MAX_VALUE){
                    A[i][j] = Math.min(A[i - 1][j], A[i][j - coin] + 1);
                } else {
                    A[i][j] = A[i - 1][j];
                }
            }
        }
        return A[coins.length][amount] == Integer.MAX_VALUE ? -1 : A[coins.length][amount];
    }
    @Test
    public void testPerfect0() {
        int n = 12;
        int expected = 3;
        int actual = numSquares(n);
        assertEquals(expected, actual);
    }

    @Test
    public void testPerfect1() {
        int n = 13;
        int expected = 2;
        int actual = numSquares(n);
        assertEquals(expected, actual);
    }
}
