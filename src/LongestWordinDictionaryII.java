import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;
public class LongestWordinDictionaryII {
    public String longestWord(String[] words) {
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length()) {
                    return o2.compareTo(o1);
                }
                return o1.length() - o2.length();
            }
        });
        Set<String> wordsSet = new HashSet<>();
        for (String word : words) {
            wordsSet.add(word);
        }
        String longestWord = "";
        for (int i = words.length - 1; i > -1; i -= 1) {
            if (isInDictionary(words[i], wordsSet)) {
                String curLongest = words[i];
                return curLongest;
            }
        }
        return longestWord;
    }
    private boolean isInDictionary(String word, Set<String> stringSet) {
        for (int i = word.length(); i > 0; i -= 1) {
            String subWord = word.substring(0, i);
            if (!stringSet.contains(subWord)) {
                return false;
            }
        }
        return true;
    }
    @Test
    public void testLongest0() {
        String[] words = new String[]{"w","wo","wor","worl","world"};
        assertEquals("world", longestWord(words));
    }
    @Test
    public void testLongest1() {
        String[] words = new String[]{"a","banana","app","appl","ap","apply","apple"};
        assertEquals("apple", longestWord(words));
    }

    @Test
    public void testLongest2() {
        String[] words = new String[]{"b","br","bre","brea","break","breakf","breakfa","breakfas","breakfast",
                "l","lu","lun","lunc","lunch","d","di","din","dinn","dinne","dinner"};
        assertEquals("breakfast", longestWord(words));
    }
}
