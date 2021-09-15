import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;

class Solution2 {
//    public int lengthOfLongestSubstring(String s) {
//        char[] charArray = s.toCharArray();
//        Set<Character> charSet = new HashSet<>();
//        int longest = 0;
//        int size = 0;
//        for (char c : charArray) {
//            if (charSet.contains(c)) {
//                if (size > longest) {
//                    longest = size;
//                }
//                charSet = new HashSet<>();
//                charSet.add(c);
//                size = 1;
//            } else {
//                size += 1;
//                charSet.add(c);
//            }
//        }
//        if (size > longest) {
//            longest = size;
//        }
//        return longest;
//    }
    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        HashMap<Character, Integer> charToPos = new HashMap<>();
        int pos = 0;
        int longest = 0;
        int curStart = pos;
        int substringLength = 0;
        for (char c : chars) {
            if (charToPos.containsKey(c)) {
                int accordingPos = charToPos.get(c);
                // Find the duplicate
                if (accordingPos >= curStart) {
                    //size = pos - curStart;
                    if (substringLength > longest) {
                        longest = substringLength;
                    }
                    curStart = accordingPos + 1;
                    substringLength = pos - curStart;
                }
            }
            charToPos.put(c, pos);
            substringLength += 1;
            if (substringLength > longest) {
                longest = substringLength;
            }
            pos += 1;
        }
        return longest;
    }
    public static void main(String[] args) {
        System.out.println(new Solution2().lengthOfLongestSubstring("abcdefbag"));
        System.out.println(new Solution2().lengthOfLongestSubstring("abcabcbb"));
        System.out.println(new Solution2().lengthOfLongestSubstring("abcad"));
        System.out.println(new Solution2().lengthOfLongestSubstring("bbbbb"));
        System.out.println(new Solution2().lengthOfLongestSubstring(""));
    }
}
