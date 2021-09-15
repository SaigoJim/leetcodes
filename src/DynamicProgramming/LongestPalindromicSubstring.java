package DynamicProgramming;
import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

import static org.junit.Assert.*;

/**
 * Given a string s, return the longest palindromic substring in s.
 *
 * Example 1:
 *
 * Input: s = "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * Example 2:
 *
 * Input: s = "cbbd"
 * Output: "bb"
 * Example 3:
 *
 * Input: s = "a"
 * Output: "a"
 * Example 4:
 *
 * Input: s = "ac"
 * Output: "a"
 *
 * Constraints:
 *
 * 1 <= s.length <= 1000
 * s consist of only digits and English letters.
 */

public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        String[] dp = new String[s.length() + 1];
        dp[0] = "";
        String longest = "";
        for (int i = 1; i < dp.length; i += 1) {
            int indexOfChar = i - 1;
            char c = s.charAt(indexOfChar);
            String preLP = dp[i - 1];
            int correspondIndex = indexOfChar - preLP.length() - 1;
            if (correspondIndex < 0) {
            }
            if (dp[i].length() > longest.length()) {
                longest = dp[i];
            }
        }
        return longest;
    }

    @Test
    public void testLongestPalindrome0() {
        String s = "babad";
        String expected = "bab";
        String actual = longestPalindrome(s);
        assertEquals(expected, actual);
    }

    @Test
    public void testLongestPalindrome1() {
        String s = "cbbd";
        String expected = "bb";
        String actual = longestPalindrome(s);
        assertEquals(expected, actual);
    }

    @Test
    public void testLongestPalindrome2() {
        String s = "ac";
        String expected = "a";
        String actual = longestPalindrome(s);
        assertEquals(expected, actual);
    }

    @Test
    public void testLongestPalindrome3() {
        String s = "a";
        String expected = "a";
        String actual = longestPalindrome(s);
        assertEquals(expected, actual);
    }

    @Test
    public void testLongestPalindrome4() {
        String s = "aa";
        String expected = "aa";
        String actual = longestPalindrome(s);
        assertEquals(expected, actual);
    }
}
