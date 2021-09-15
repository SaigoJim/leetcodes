package trie;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class TestTrieSet {
    @Test
    public void testTrieSet() {
        TrieSet tS = new TrieSetBasedOnHashTable();
        tS.add("w");
        tS.add("wo");
        tS.add("wor");
        tS.add("worl");
        tS.add("world");
        System.out.println(tS);
    }
    @Test
    public void testTrie1() {
        TrieSet tS = new TrieSetBasedOnHashTable();
        tS.add("w");
        tS.add("wo");
        tS.add("wor");
        tS.add("worl");
        tS.add("world");
        assertEquals(5, tS.size());
    }
    @Test
    public void testTrieContains() {
        TrieSet t = new TrieSetBasedOnHashTable();
        String[] words = new String[]{"w","wo","wor","worl","world"};
        for (String word : words) {
            t.add(word);
        }
        for (String word : words) {
            assertTrue(t.contains(word));
        }
        assertFalse(t.contains("worlds"));
        assertFalse(t.contains("wors"));
    }
    @Test
    public void testTrieKeysWithPrefix() {
        TrieSet t = new TrieSetBasedOnHashTable();
        String[] words = new String[]{"w","wo","wor","worl","world"};
        for (String word : words) {
            t.add(word);
        }
        List<String> ks = t.keysWithPrefix("w");
        ks = t.keysWithPrefix("wo");
        ks = t.keysWithPrefix("wor");
        ks = t.keysWithPrefix("worl");
        ks = t.keysWithPrefix("world");
        ks = t.keysWithPrefix("s");
    }

    @Test
    public void testlongestPrefixOf() {
        TrieSet t = new TrieSetBasedOnHashTable();
        String[] words = new String[]{"w","wo","wor","worl","world"};
        for (String word : words) {
            t.add(word);
        }
        t.add("sad");
        t.add("same");
        t.add("sam");
        t.add("sap");
        assertEquals("sam", t.longestPrefixOf("sample"));
        assertEquals("", t.longestPrefixOf("sa"));
    }
    @Test
    public void testStartWithPrefix() {
        TrieSet t = new TrieSetBasedOnHashTable();
        t.add("apple");
        assertTrue(t.startsWith("app"));
    }
}
