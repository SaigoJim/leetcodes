package DynamicProgramming;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * You are given an integer array coins representing coins of different denominations and
 * an integer amount representing a total amount of money.
 *
 * Return the fewest number of coins that you need to make up that amount.
 * If that amount of money cannot be made up by any combination of the coins, return -1.
 *
 * You may assume that you have an infinite number of each kind of coin.
 *
 * Example 1:
 *
 * Input: coins = [1,2,5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 * Example 2:
 *
 * Input: coins = [2], amount = 3
 * Output: -1
 * Example 3:
 *
 * Input: coins = [1], amount = 0
 * Output: 0
 * Example 4:
 *
 * Input: coins = [1], amount = 1
 * Output: 1
 * Example 5:
 *
 * Input: coins = [1], amount = 2
 * Output: 2
 */

public class CoinChange {
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
//    public int coinChange(int[] coins, int amount) {
//        int[] endAt = new int[amount + 1];
//        for (int i = 1; i < endAt.length; i += 1) {
//            int endAtI = Integer.MAX_VALUE;
//            for (int coin : coins) {
//                int index = i - coin;
//                if (index >= 0 && index <= i && endAt[index] != -1) {
//                    endAtI = Math.min(endAtI, endAt[index] + 1);
//                }
//            }
//            if (endAtI == Integer.MAX_VALUE) {
//                endAtI = -1;
//            }
//            endAt[i] = endAtI;
//        }
//        return endAt[amount];
//    }

    @Test
    public void testCoinChange0() {
        int[] coins = new int[]{1,2,5};
        int amount = 11;
        int expected = 3;
        int actual = coinChange(coins, amount);
        assertEquals(expected, actual);
    }
    @Test
    public void testCoinChange1() {
        int[] coins = new int[]{2};
        int amount = 3;
        int expected = -1;
        int actual = coinChange(coins, amount);
        assertEquals(expected, actual);
    }
    @Test
    public void testCoinChange2() {
        int[] coins = new int[]{1};
        int amount = 0;
        int expected = 0;
        int actual = coinChange(coins, amount);
        assertEquals(expected, actual);
    }
    @Test
    public void testCoinChange3() {
        int[] coins = new int[]{1};
        int amount = 1;
        int expected = 1;
        int actual = coinChange(coins, amount);
        assertEquals(expected, actual);
    }
    @Test
    public void testCoinChange4() {
        int[] coins = new int[]{1};
        int amount = 2;
        int expected = 2;
        int actual = coinChange(coins, amount);
        assertEquals(expected, actual);
    }
    @Test
    public void testCoinChange5() {
        int[] coins = new int[]{186,419,83,408};
        int amount = 6249;
        int expected = 20;
        int actual = coinChange(coins, amount);
        assertEquals(expected, actual);
    }

    @Test
    public void testCoinChange6() {
        int[] coins = new int[]{1};
        int amount = 1;
        int expected = 1;
        int actual = coinChange(coins, amount);
        assertEquals(expected, actual);
    }
}
