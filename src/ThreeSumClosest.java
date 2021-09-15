import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int i = 0;
        int distance = Integer.MAX_VALUE, closest = 0;
        while (i < nums.length){
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int threeSum = nums[i] + nums[left] + nums[right];
                if (Math.abs(threeSum - target) < distance) {
                    distance = Math.abs(threeSum - target);
                    closest = threeSum;
                } else if (threeSum == target) {
                    return threeSum;
                }
                if (threeSum < target) {
                    left += 1;
                } else {
                    right -= 1;
                }
            }
            i += 1;
        }
        return closest;
    }

    @Test
    public void testThreeSumClosest() {
        int[] arr1 = new int[]{-1,2,1,-4};
        int target = 1;
        int expected = 2;
        int actual = threeSumClosest(arr1, target);
        assertEquals(expected, actual);
    }
}
