package trie;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestTrie {
    @Test
    public void testTrie() {
        TrieBasedOnTree t = new TrieBasedOnTree();
        String word = "world";
        t.add(word);
        t.add("wor");
    }
    @Test
    public void testTrie1() {
        TrieBasedOnTree t = new TrieBasedOnTree();
        String[] words = new String[]{"w","wo","wor","worl","world"};
        for (String word : words) {
            t.add(word);
        }
        t.add("wwwww");
    }
    @Test
    public void testTrieContains() {
        TrieBasedOnTree t = new TrieBasedOnTree();
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
    public void testString() {
        String word = "world";
        word += 's';
        String s = word.substring(0, 2);
    }
}
