package trie;


import java.util.TreeMap;

public class TrieBasedOnTree {
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
    public TrieBasedOnTree() {
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
