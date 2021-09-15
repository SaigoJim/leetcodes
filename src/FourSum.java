import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> listOfLists = new ArrayList<>();
        Arrays.sort(nums);
        if (nums.length < 3) {
            return listOfLists;
        }
        for (int first = 0; first < nums.length; first = nextDiffIndex(nums, first, 1)) {
            for (int second = first + 1; second < nums.length; second = nextDiffIndex(nums, second, 1)) {
                int left = second + 1, right = nums.length - 1;
                int subTarget = target - nums[first] - nums[second];
                while (left < right) {
                    int twoSum = nums[left] + nums[right];
                    if (twoSum == subTarget) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[first]);
                        list.add(nums[second]);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        listOfLists.add(list);
                        left = nextDiffIndex(nums, left, 1);
                    } else if (twoSum > subTarget) {
                        right = nextDiffIndex(nums, right, -1);
                    } else {
                        left = nextDiffIndex(nums, left, 1);
                    }
                }
            }
        }
        return listOfLists;
    }
    private int nextDiffIndex(int[] nums, int index, int i) {
        int val = nums[index];
        while (index >= 0 && index < nums.length && nums[index] == val) {
            index += i;
        }
        return index;
    }
    @Test
    public void testFourSum() {
        int[] arr1 = new int[]{1,0,-1,0,-2,2};
        int target1 = 0;
        List<List<Integer>> ts1 = fourSum(arr1, target1);
        int[] arr2 = new int[]{2,2,2,2,2};
        int target2 = 8;
        List<List<Integer>> ts2 = fourSum(arr2, target2);
    }
}
