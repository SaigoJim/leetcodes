package DynamicProgramming;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

/**
 * EASY
 *
 * Given an integer n,
 * return an array ans of length n + 1 such that for each i (0 <= i <= n),
 * ans[i] is the number of 1's in the binary representation of i.
 *
 * Example 1:
 *
 * Input: n = 2
 * Output: [0,1,1]
 * Explanation:
 * 0 --> 0
 * 1 --> 1
 * 2 --> 10
 * Example 2:
 *
 * Input: n = 5
 * Output: [0,1,1,2,1,2]
 * Explanation:
 * 0 --> 0
 * 1 --> 1
 * 2 --> 10
 * 3 --> 11
 * 4 --> 100
 * 5 --> 101
 *
 * Constraints:
 *
 * 0 <= n <= 105
 */
public class CountingBits {
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        ans[0] = 0;
        for (int i = 1; i < ans.length; i += 1) {
            if (i % 2 == 1) {
                ans[i] = ans[i - 1] + 1;
            } else {
                ans[i] = ans[i / 2];
            }
        }
        return ans;
    }

    @Test
    public void testCountBits0() {
        int n = 2;
        int[] expected = new int[]{0, 1, 1};
        int[] actual = countBits(n);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testCountBits2() {
        int n = 5;
        int[] expected = new int[]{0, 1, 1, 2, 1, 2};
        int[] actual = countBits(n);
        assertArrayEquals(expected, actual);
    }
}
