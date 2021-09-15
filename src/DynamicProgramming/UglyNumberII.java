package DynamicProgramming;

import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

import static org.junit.Assert.*;
/**
 * Medium
 *
 * An ugly number is a positive integer whose prime factors are limited to 2, 3, and 5.
 *
 * Given an integer n, return the nth ugly number.
 *
 *
 * Example 1:
 *
 * Input: n = 10
 * Output: 12
 * Explanation: [1, 2, 3, 4, 5, 6, 8, 9, 10, 12] is the sequence of the first 10 ugly numbers.
 * Example 2:
 *
 * Input: n = 1
 * Output: 1
 * Explanation: 1 has no prime factors, therefore all of its prime factors are limited to 2, 3, and 5.
 *
 * Constraints:
 *
 * 1 <= n <= 1690
 */

public class UglyNumberII {
    public int nthUglyNumber(int n) {
        int[] primeFactors = new int[]{2, 3, 5};
        int[] dp = new int[n];
        Queue<Integer> minHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        minHeap.add(1);
        for (int i = 0; i < dp.length; i += 1) {
            dp[i] = minHeap.remove();
            for (int prime : primeFactors) {
                minHeap.add(dp[i] * prime);
            }
        }
        int x = 1;
        return dp[dp.length - 1];
    }

    @Test
    public void testNthUN0() {
        int n = 10;
        int expected = 12;
        int actual = nthUglyNumber(n);
        assertEquals(expected, actual);
    }

    @Test
    public void testNthUN1() {
        int n = 1;
        int expected = 1;
        int actual = nthUglyNumber(n);
        assertEquals(expected, actual);
    }
}
