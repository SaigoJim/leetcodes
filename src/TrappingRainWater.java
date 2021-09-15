import org.junit.Test;
import static org.junit.Assert.*;

public class TrappingRainWater {
    public int trap(int[] height) {
        int rainArea = 0;
        int lowestHeight = 0;
        int left = 0, right = height.length - 1;
        int curr = left;    // Track the current pointer
        while (left < right) {
            int lH = height[left];
            int rH = height[right];
            int lowestBetweenLR = Math.min(lH, rH);
            // Subtract the bar area
            if (height[curr] > lowestHeight) {
                rainArea -= lowestHeight;
            } else {
                rainArea -= height[curr];
            }
            // Note: Both bars arise, Update the rainwater's area
            if (lowestBetweenLR > lowestHeight) {
                int rainAreaBetweenLR = area(left, right, lowestBetweenLR);
                // Suppose the height doesn't change, calculate the supposed area
                int rainAreaBetweenLRWithOriginalHeight = area(left, right, lowestHeight);
                rainArea -= rainAreaBetweenLRWithOriginalHeight;
                rainArea += rainAreaBetweenLR;
                lowestHeight = lowestBetweenLR;
            }
            if (lH < rH) {
                left += 1;
                curr = left;
            } else {
                right -= 1;
                curr = right;
            }
        }
        return rainArea;
    }
    private int area(int i, int j, int h) {
        return Math.abs(i - j) * h - h;
    }
    @Test
    public void testMaxArea() {
        int[] arr0 = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        assertEquals(6, trap(arr0));
        int[] arr1 = new int[]{4,2,0,3,2,5};
        assertEquals(9, trap(arr1));
    }
}
