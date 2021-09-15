package trie;

import java.util.HashMap;
import java.util.List;

public interface TrieSetWithWeight{
    /* Put a String into Trie with its frequency */
    void add(String content, int importance);
    boolean contains(String word);
    int size();
    default boolean isEmpty() {
        return size() == 0;
    }
    /* Return the k most frequent elements */
    List<String> topKFrequent(String prefix, int k);
}
