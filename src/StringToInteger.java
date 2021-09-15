import org.junit.Test;
import static org.junit.Assert.*;
public class StringToInteger {
    public int myAtoi(String s) {
        long returnInteger = 0;
        boolean negative = false;
        boolean nextMustBeNumber = false;
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                if (nextMustBeNumber) {
                    break;
                }
                continue;
            } else if (c == '-') {
                if (nextMustBeNumber) {
                    break;
                }
                nextMustBeNumber = true;
                negative = true;
                continue;
            } else if (c == '+') {
                if (nextMustBeNumber) {
                    break;
                }
                nextMustBeNumber = true;
                continue;
            } else if (c < '0' || c > '9') {
                break;
            }
            nextMustBeNumber = true;
            returnInteger = returnInteger * 10 + Character.getNumericValue(c);
            if (negative && -returnInteger < -Math.pow(2, 31)) {
                return -(int) Math.pow(2, 31) - 1;
            } else if (returnInteger > Math.pow(2, 31) - 1) {
                return (int) (Math.pow(2, 31) - 1);
            }
        }
        returnInteger = negative?-returnInteger:returnInteger;
        return (int) returnInteger;

    }
    @Test
    public void testAtoi() {
        assertEquals(2147483647, myAtoi("9223372036854775808"));
        assertEquals(0, myAtoi("00000-42a1234"));
        assertEquals(2147483647, myAtoi("21474836460"));
        assertEquals(0, myAtoi("+-12"));
        assertEquals(42, myAtoi("42"));
        assertEquals(-42, myAtoi("-42"));
        assertEquals(-42, myAtoi("           -42"));
        assertEquals(0, myAtoi("words"));
        assertEquals(-2147483648, myAtoi("-91283472332"));
    }
}
