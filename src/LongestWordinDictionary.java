import java.util.TreeMap;
import org.junit.Test;
import static org.junit.Assert.*;
public class LongestWordinDictionary {
    String longestWord = "";
    public String longestWord(String[] words) {
        Trie t = new Trie();
        for (String word : words) {
            t.add(word);
        }
        dfs(t);
        return longestWord;
    }

    private void dfs(Trie t) {
        Trie.Node startVertex = t.dict;
        if (startVertex.links.isEmpty()) {
            return;
        }
        for (Trie.Node v : startVertex.links.values()) {
            dfsHelper(v, "");
        }
    }
    private void dfsHelper(Trie.Node v, String word) {
        if (!v.isKey) {
            return;
        }
        word += v.content;
        if (word.length() > longestWord.length()) {
            longestWord = word;
        }
        for (Trie.Node nextV : v.links.values()) {
            dfsHelper(nextV, word);
        }
    }
    public class Trie {
        public class Node {
            char content;
            boolean isKey;
            TreeMap<Character, Node> links;
            Node() {
                content = '0';
                isKey = false;
                links = new TreeMap<>();
            }
            Node(char ch, boolean key) {
                this();
                content = ch;
                isKey = key;
            }
        }
        Node dict;
        public Trie() {
            dict = new Node();
        }

        public void add(String str) {
            Node curNode = dict;
            for (int i = 0; i < str.length(); i += 1) {
                char curChar = str.charAt(i);
                boolean endOfString = false;
                if (i == str.length() - 1) {
                    endOfString = true;
                }
                if (!curNode.links.containsKey(curChar)) {
                    Node newNode = new Node(curChar, endOfString);
                    curNode.links.put(curChar, newNode);
                }
                curNode = curNode.links.get(curChar);
                if (endOfString) {
                    curNode.isKey = endOfString;
                }
            }
        }

        public boolean contains(String str) {
            Node curNode = dict;
            for (int i = 0; i < str.length(); i += 1) {
                char curChar = str.charAt(i);
                if (curNode.links.containsKey(curChar)) {
                    curNode = curNode.links.get(curChar);
                } else {
                    return false;
                }
            }
            return curNode.isKey;
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
