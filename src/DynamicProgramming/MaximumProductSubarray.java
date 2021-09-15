package DynamicProgramming;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Given an integer array nums,
 * find a contiguous non-empty subarray within the array that has the largest product,
 * and return the product.
 *
 * It is guaranteed that the answer will fit in a 32-bit integer.
 *
 * A subarray is a contiguous subsequence of the array.
 *
 * Example 1:
 *
 * Input: nums = [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 * Example 2:
 *
 * Input: nums = [-2,0,-1]
 * Output: 0
 * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 *
 * Constraints:
 *
 * 1 <= nums.length <= 2 * 104
 * -10 <= nums[i] <= 10
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 * */

public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int max, endAtI, prevMin, prevMax;
        prevMax = prevMin = max = nums[0];
        for (int i = 1; i < nums.length; i += 1) {
            int val = nums[i];
            int currMax = Math.max(Math.max(val * prevMax, val), val * prevMin);
            int currMin = Math.min(Math.min(val * prevMin, val), val * prevMax);
            endAtI = Math.max(currMax, val);
            max = Math.max(max, endAtI);
            prevMax = currMax;
            prevMin = currMin;
        }
        return max;
    }

    @Test
    public void testMaxProduct() {
        int[] nums = new int[]{2,3,-2,4};
        int expected = 6;
        int actual = maxProduct(nums);
        assertEquals(expected, actual);
    }

    @Test
    public void testMaxProduct1() {
        int[] nums = new int[]{-2,0,-1};
        int expected = 0;
        int actual = maxProduct(nums);
        assertEquals(expected, actual);
    }

    @Test
    public void testMaxProduct2() {
        int[] nums = new int[]{0, 2};
        int expected = 2;
        int actual = maxProduct(nums);
        assertEquals(expected, actual);
    }

    @Test
    public void testMaxProduct3() {
        int[] nums = new int[]{-2, 3, -4};
        int expected = 24;
        int actual = maxProduct(nums);
        assertEquals(expected, actual);
    }

    @Test
    public void testMaxProduct4() {
        int[] nums = new int[]{-3,0,1,-2};
        int expected = 1;
        int actual = maxProduct(nums);
        assertEquals(expected, actual);
    }

    @Test
    public void testMaxProduct5() {
        int[] nums = new int[]{2,-5,-2,-4,3};
        int expected = 24;
        int actual = maxProduct(nums);
        assertEquals(expected, actual);
    }
}
