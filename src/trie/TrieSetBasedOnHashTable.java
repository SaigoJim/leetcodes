package trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TrieSetBasedOnHashTable implements TrieSet {
    private class Node {
        boolean isKey;
        HashMap<Character, Node> links;
        Node (boolean isEndOfString) {
            isKey = isEndOfString;
            links = new HashMap<>();
        }
    }
    private int size;
    private Node initial;
    public TrieSetBasedOnHashTable() {
        initial = new Node(false);
        size = 0;
    }

    @Override
    public void add(String word) {
        Node currNode = initial;
        for (int i = 0; i < word.length(); i += 1) {
            char content = word.charAt(i);
            boolean isEndOfString = (i == word.length() - 1);
            size += isEndOfString ? 1 : 0;
            Node nextNode = currNode.links.get(content);
            if (nextNode == null) {
                nextNode = new Node(isEndOfString);
                currNode.links.put(content, nextNode);
            } else if (isEndOfString) {
                nextNode.isKey = true;
            }
            currNode = currNode.links.get(content);
        }
    }

    @Override
    public boolean contains(String word) {
        if (!initial.links.containsKey(word.charAt(0))) {
            return false;
        }
        return containsHelper(word, 1, initial.links.get(word.charAt(0)));
    }

    private boolean containsHelper(String word, int i, Node node) {
        if (node == null) {
            return false;
        } else if (i == word.length()) {
            return node.isKey;
        }
        return containsHelper(word, i + 1, node.links.get(word.charAt(i)));
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public List<String> collect() {
        List<String> collector = new ArrayList<>();
        for (char c : initial.links.keySet()) {
            colHelper(Character.toString(c), collector, initial.links.get(c));
        }
        return collector;
    }

    @Override
    public List<String> keysWithPrefix(String prefix) {
        List<String> keysWithSamePrefix = new ArrayList<>();
        Node curr = initial;
        for (int i = 0; i < prefix.length(); i += 1) {
            char content = prefix.charAt(i);
            if (!curr.links.containsKey(content)) {
                return null;
            }
            curr = curr.links.get(content);
        }
        colHelper(prefix, keysWithSamePrefix, curr);
        return keysWithSamePrefix;
    }

    @Override
    public String longestPrefixOf(String str) {
        StringBuilder sb = new StringBuilder();
        String longest = "";
        Node curr = initial;
        for (int i = 0; i < str.length(); i += 1) {
            char content = str.charAt(i);
            if (!curr.links.containsKey(content)) {
                return longest;
            } else {
                sb.append(content);
                if (curr.links.get(content).isKey) {
                    longest = sb.toString();
                }
            }
            curr = curr.links.get(content);
        }
        return longest;
    }

    private void colHelper(String s, List<String> collector, Node node) {
        if (node.isKey) {
            collector.add(s);
        }
        for (char c : node.links.keySet()) {
            colHelper(s + c, collector, node.links.get(c));
        }
    }


    @Override
    public String toString() {
        return collect().toString();
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node currNode = initial;
        for (int i = 0; i < prefix.length(); i += 1) {
            char content = prefix.charAt(i);
            if (!currNode.links.containsKey(content)){
                return false;
            }
            currNode = currNode.links.get(content);
        }
        return true;
    }
}
