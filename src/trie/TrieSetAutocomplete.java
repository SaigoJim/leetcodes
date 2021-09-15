package trie;

import java.util.*;

public class TrieSetAutocomplete implements TrieSetWithWeight{
    private class Node {
        boolean isKey;
        char item;
        String selfString;
        int ownValue;
        int bestValue;
        HashMap<Character, Node> links;
        Node (Character content, boolean isEndOfString, int selfValue, int best, String str) {
            item = content;
            isKey = isEndOfString;
            links = new HashMap<>();
            ownValue = selfValue;
            bestValue = best;
            selfString = str;
        }
    }
    private int size;
    private Node initial;

    public TrieSetAutocomplete() {
        initial = new Node('0', false, Integer.MIN_VALUE, Integer.MIN_VALUE, "");
        size = 0;
    }
    @Override
    public void add(String word, int importance) {
        Node currNode = initial;
        for (int i = 0; i < word.length(); i += 1) {
            char content = word.charAt(i);
            boolean isEndOfString = (i == word.length() - 1);
            size += isEndOfString ? 1 : 0;
            if (importance > currNode.bestValue) {
                currNode.bestValue = importance;
            }
            Node next = currNode.links.get(content);
            if (next == null) {
                int selfValue = Integer.MIN_VALUE;
                int best = importance;
                if (isEndOfString) {
                    selfValue = importance;
                    next = new Node(content, isEndOfString, selfValue, best, word);
                } else {
                    next = new Node(content, isEndOfString, selfValue, best, "");
                }
                currNode.links.put(content, next);
            } else if (isEndOfString){
                next.ownValue = importance;
                next.isKey = true;
            }
            currNode = currNode.links.get(content);
        }
    }

    @Override
    public boolean contains(String word) {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public List<String> topKFrequent(String prefix, int k) {
        PriorityQueue<Node> matches = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if (o1.bestValue == o2.bestValue) {
                    return o1.item - o2.item;
                }
                return o2.bestValue - o1.bestValue;
            }
        });
        List<String> topKMatches = new ArrayList<>();
        Node curr = initial;
        for (int i = 0; i < prefix.length(); i += 1) {
            char content = prefix.charAt(i);
            if (!curr.links.containsKey(content)) {
                return null;
            }
            curr = curr.links.get(content);
        }
        for (Node next : curr.links.values()) {
            matches.add(next);
        }
        while (topKMatches.size() < k && !matches.isEmpty()) {
            Node searchedNode = matches.remove();
            for (Node next : searchedNode.links.values()) {
                matches.add(next);
            }
            if (searchedNode.isKey) {
                topKMatches.add(searchedNode.selfString);
            }
        }
        return topKMatches;
    }
}
