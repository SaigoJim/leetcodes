package DynamicProgramming;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

/**
 * Given a string s and a dictionary of strings wordDict,
 * return true if s can be segmented into a space-separated sequence of one or more dictionary words.
 *
 * Note that the same word in the dictionary may be reused multiple times in the segmentation.
 *
 *
 * Example 1:
 *
 * Input: s = "leetcode", wordDict = ["leet","code"]
 * Output: true
 * Explanation: Return true because "leetcode" can be segmented as "leet code".
 * Example 2:
 *
 * Input: s = "applepenapple", wordDict = ["apple","pen"]
 * Output: true
 * Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
 * Note that you are allowed to reuse a dictionary word.
 * Example 3:
 *
 * Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
 * Output: false
 *
 * Constraints:
 *
 * 1 <= s.length <= 300
 * 1 <= wordDict.length <= 1000
 * 1 <= wordDict[i].length <= 20
 * s and wordDict[i] consist of only lowercase English letters.
 * All the strings of wordDict are unique.
 * */

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i < dp.length; i += 1) {
            char c = s.charAt(i - 1);
            for (String word : wordDict) {
                if (word.charAt(word.length() - 1) == c) {
                    int j = i - word.length();
                    if (j >= 0) {
                        dp[i] = dp[j] && s.substring(j, i).equals(word);
                    }
                    if(dp[i]) {
                        break;
                    }
                }
            }
        }
        return dp[dp.length - 1];
    }

    public boolean wordBreakWithoutDP(String s, List<String> wordDict) {
        Set<String> wordSet = new TreeSet<>();
        for (String word : wordDict) {
            wordSet.add(word);
        }
        HashMap<String, Boolean> memory = new HashMap<>();
//        return wordBreakHelper(s, wordSet);
        return wordBreakHelperWithMemoization(s, wordSet, memory);
    }

    private boolean wordBreakHelper(String s, Set<String> wordSet) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i += 1) {
            sb.append(s.charAt(i));
            if (wordSet.contains(sb.toString())) {
                if (i == s.length() - 1) {
                    return true;
                } else if(wordBreakHelper(s.substring(i + 1), wordSet)) {
                    return true;
                }
            }
        }
        return false;
    }
    private boolean wordBreakHelperWithMemoization(
            String s, Set<String> wordSet, HashMap<String, Boolean> memory) {
        if (memory.containsKey(s)) {
            return memory.get(s);
        }
        StringBuilder sb = new StringBuilder();
        boolean result = false;
        for (int i = 0; i < s.length(); i += 1) {
            sb.append(s.charAt(i));
            if (wordSet.contains(sb.toString())) {
                if (i == s.length() - 1) {
                    result = true;
                    break;
                } else if(wordBreakHelper(s.substring(i + 1), wordSet)) {
                    result = true;
                    break;
                }
            }
        }
        memory.put(s, result);
        return result;
    }

    @Test
    public void testWordBreak0() {
        List<String> wordDict = new ArrayList<>();
        wordDict.add("apple");
        wordDict.add("pen");
        String s = "applepenapple";
        assertTrue(wordBreak(s, wordDict));
    }

    @Test
    public void testWordBreak1() {
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
        String s = "leetcode";
        assertTrue(wordBreak(s, wordDict));
    }

    @Test
    public void testWordBreak2() {
        List<String> wordDict = new ArrayList<>();
        wordDict.add("cats");
        wordDict.add("dog");
        wordDict.add("sand");
        wordDict.add("and");
        wordDict.add("cat");
        String s = "catsandog";
        assertFalse(wordBreak(s, wordDict));
    }

    @Test
    public void testWordBreak3() {
        List<String> wordDict = new ArrayList<>();
        wordDict.add("bc");
        wordDict.add("cb");
        String s = "ccbb";
        assertFalse(wordBreak(s, wordDict));
    }
}
