import org.junit.Test;
import static org.junit.Assert.*;

public class DecodeString {
    public String decodeString(String s) {
        StringBuilder resultSB = new StringBuilder();
        int times = 0;
        int i = 0;
        while (i < s.length()) {
            char currentChar = s.charAt(i);
            if (currentChar >= '0' && currentChar <= '9') {
                times = times * 10 + Character.getNumericValue(currentChar);
            } else if (currentChar == '[') {
                int stringIndex = findNextIndex(s, i);
                String nextString = s.substring(i + 1, stringIndex);
                String returnedNextString = decodeString(nextString);
                String repeated = repeatNTimesString(returnedNextString, times);
                resultSB.append(repeated);
                times = 0;
                i = stringIndex + 1;
                continue;
            } else {
                resultSB.append(currentChar);
            }
            i += 1;
        }
        return resultSB.toString();
    }

    private String repeatNTimesString(String s, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i += 1) {
            sb.append(s);
        }
        return sb.toString();
    }
    private int findNextIndex(String s, int index) {
        int nums = 0;
        int returndeIndex = 0;
        for (int i = index; i < s.length(); i += 1) {
            char currentChar = s.charAt(i);
            if (currentChar == '[') {
                nums += 1;
            } else if (currentChar == ']') {
                nums -= 1;
            }
            
            if (nums == 0) {
                returndeIndex = i;
                break;
            }
        }
        return returndeIndex;
    }

    @Test
    public void testDecodeString() {
        String s1 = "3[a]2[bc]";
        assertTrue("aaabcbc".equals(decodeString(s1)));
    }
    @Test
    public void testDecodeString1() {
        String s2 = "3[a2[c]]";
        assertTrue("accaccacc".equals(decodeString(s2)));
    }
    @Test
    public void testDecodeString2() {
        String s3 = "2[abc]3[cd]ef";
        String s = decodeString(s3);
        assertTrue("abcabccdcdcdef".equals(decodeString(s3)));
    }

    @Test
    public void testDecodeString3() {
        String s3 = "100[leetcode]";
        String s = decodeString(s3);
        //assertTrue("abccdcdcdxyz".equals(decodeString(s3)));
    }
    @Test
    public void testSubstring() {
        String s = "3[a2[c]]".substring(0 + 2, 7);
    }
    @Test
    public void testString() {
        String s3 = "100[leetcode]";
        String s = "ssssss";
    }
}
