import org.junit.Test;
import static org.junit.Assert.*;

public class MaxArea {
    // Using Dual Pointers method
    public int maxArea(int[] height) {
        int maxAreaValue = Integer.MIN_VALUE;
        int left = 0, right = height.length - 1;
        while (left < right) {
            int area = area(height, left, right);
            maxAreaValue = Math.max(maxAreaValue, area);
            if (height[left] < height[right]) {
                left += 1;
            } else {
                right -= 1;
            }
        }
        return maxAreaValue;
    }

    private int area(int[] height, int i, int j) {
        int h = Math.min(height[i], height[j]);
        int w = Math.abs(i - j);
        return h * w;
    }

    @Test
    public void testMaxArea() {
        int[] arr0 = new int[]{1,1};
        assertEquals(1, maxArea(arr0));
        int[] arr1 = new int[]{1,8,6,2,5,4,8,3,7};
        assertEquals(49, maxArea(arr1));
        int[] arr2  = new int[]{4,3,2,1,4};
        assertEquals(16, maxArea(arr2));
    }
}
