package trie;

import java.util.List;

public interface TrieSet {
    /* Put a String to TrieSet */
    void add(String word);
    /*  */
    boolean contains(String word);
    int size();
    default boolean isEmpty() {
        return size() == 0;
    }
    List<String> collect();
    /* Finding all keys that match a given prefix */
    List<String> keysWithPrefix(String prefix);
    /* Finding the longest prefix of a string */
    String longestPrefixOf(String str);
    /** Returns if there is any word in the trie that starts with the given prefix. */
    boolean startsWith(String prefix);

}
