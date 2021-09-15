import java.util.*;

import org.junit.Test;
import static org.junit.Assert.*;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> numsToIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i += 1) {
            if (numsToIndex.containsKey(target - nums[i])) {
                return new int[]{numsToIndex.get(target - nums[i]), i};
            }
            numsToIndex.put(nums[i], i);
        }
        return null;
    }

    @Test
    public void testTwoSum1() {
        int[] arr1 = new int[]{2,7,11,15};
        int target1 = 9;
        int[] actual = twoSum(arr1, target1);
    }
}
