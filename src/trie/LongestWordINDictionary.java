package trie;
import org.junit.Test;
import static org.junit.Assert.*;
public class LongestWordINDictionary {
    String longestWord = "";
    public String longestWord(String[] words) {
        TrieBasedOnTree t = new TrieBasedOnTree();
        for (String word : words) {
            t.add(word);
        }
        dfs(t);
        return longestWord;
    }

    private void dfs(TrieBasedOnTree t) {
        TrieBasedOnTree.Node startVertex = t.dict;
        if (startVertex.links.isEmpty()) {
            return;
        }
        for (TrieBasedOnTree.Node v : startVertex.links.values()) {
            dfsHelper(v, "");
        }
    }
    private void dfsHelper(TrieBasedOnTree.Node v, String word) {
        if (!v.isKey) {
            return;
        }
        word += v.content;
        if (word.length() > longestWord.length()) {
            longestWord = word;
        }
        for (TrieBasedOnTree.Node nextV : v.links.values()) {
            dfsHelper(nextV, word);
        }
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
}
