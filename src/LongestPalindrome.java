import org.junit.Test;
import static org.junit.Assert.*;
public class LongestPalindrome {
    public String longestPalindrome(String s) {
        for (int i = 0; i < s.length(); i += 1) {

        }
        return null;
    }
    public String findHeadLongestPalindrome (String s) {
        int length = s.length();
        while (length > 1) {
            char head = s.charAt(0);
            char end = s.charAt(mirroredIndex(0, length));
            if (head == end) {
                
            }
        }
        return s.substring(0, length);
    }
    private int mirroredIndex(int index, int length) {
        return length - 1 - index;
    }
    @Test
    public void testLongestPalindrome() {
        String s1 = "babad";
        String actual = longestPalindrome(s1);
        assertEquals("bab", actual);
        String s2 = "cbbd";
        assertEquals("bb", longestPalindrome(s2));
    }
    @Test
    public void testFindHead() {
        System.out.println("a".substring(0, 1));
    }
}
