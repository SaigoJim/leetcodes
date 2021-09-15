import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
public class ZConvert {
    public String convert(String s, int numRows) {
        if (numRows < 2) {
            return s;
        }
        List<StringBuilder> sbs = new ArrayList<>();
        for (int i = 0; i < numRows; i += 1) {
            sbs.add(new StringBuilder());
        }
        int zIndex = 0;
        boolean down = true;
        for (int i = 0; i < s.length(); i += 1) {
            StringBuilder sb = sbs.get(zIndex);
            sb.append(s.charAt(i));
            if (down) {
                zIndex += 1;
            } else {
                zIndex -= 1;
            }
            if (zIndex == numRows - 1 || zIndex == 0) {
                down = !down;
            }
        }
        StringBuilder returnStringB = new StringBuilder();
        for (int i = 0; i < numRows; i += 1) {
            returnStringB.append(sbs.get(i));
        }
        return returnStringB.toString();
    }

    @Test
    public void testConvert() {
        String s1 = "AB";
        int numRows1 = 1;
        assertEquals("AB", convert(s1, numRows1));
        String s2 = "PAYPALISHIRING";
        int numRows2 = 3;
        assertEquals("PAHNAPLSIIGYIR", convert(s2, numRows2));
        String s3 = "PAYPALISHIRING";
        int numRows3 = 4;
        assertEquals("PINALSIGYAHRPI", convert(s3, numRows3));
    }

    public static void main(String[] args) {
        System.out.println();
    }
}
