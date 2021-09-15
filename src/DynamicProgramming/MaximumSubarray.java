package DynamicProgramming;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Given an integer array nums,
 * find the contiguous subarray (containing at least one number)
 * which has the largest sum and return its sum.
 * A subarray is a contiguous part of an array.
 *
 * Example 1:
 *
 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 *
 * Example 2:
 *
 * Input: nums = [1]
 * Output: 1
 * Example 3:
 *
 * Input: nums = [5,4,-1,7,8]
 * Output: 23
 */

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int endAt = 0, max = nums[0];
        for (int num : nums) {
            endAt = Math.max(endAt + num, num);
            max = Math.max(max, endAt);
        }
        return max;
    }

    @Test
    public void testMaxSubarraySum() {
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        int expected = 6;
        int actual = maxSubArray(nums);
        assertEquals(expected, actual);
    }

    @Test
    public void testMaxSubarraySum1() {
        int[] nums = new int[]{1};
        int expected = 1;
        int actual = maxSubArray(nums);
        assertEquals(expected, actual);
    }

    @Test
    public void testMaxSubarraySum2() {
        int[] nums = new int[]{5,4,-1,7,8};
        int expected = 23;
        int actual = maxSubArray(nums);
        assertEquals(expected, actual);
    }
}
