package trie;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class TestTrieAutoComplete {
    @Test
    public void testAdd() {
        TrieSetWithWeight t = new TrieSetAutocomplete();
        String[] words = new String[]{"w","wo","wor","worl","world"};
        int i = 0;
        for (String word : words) {
            t.add(word, i);
            i += 1;
        }
    }

    @Test
    public void testAdd1() {
        TrieSetWithWeight t = new TrieSetAutocomplete();
        t.add("buck", 10);
        t.add("sad", 12);
        t.add("smog", 5);
        t.add("spit", 15);
        t.add("spite", 20);
        t.add("spy", 7);
    }
    @Test
    public void testAutoComplete() {
        TrieSetWithWeight t = new TrieSetAutocomplete();
        t.add("buck", 10);
        t.add("sad", 12);
        t.add("smog", 5);
        t.add("spit", 15);
        t.add("spite", 20);
        t.add("spy", 7);
        List<String> l = t.topKFrequent("s", 3);
    }
}
