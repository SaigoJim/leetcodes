import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> listOfLists = new ArrayList<>();
        if (nums.length < 3) {
            return listOfLists;
        }
        Arrays.sort(nums);
        int i = 0;
        while (i < nums.length){
            int left = i + 1, right = nums.length - 1;
            int target = 0 - nums[i];
            while (left < right) {
                int twoSum = nums[left] + nums[right];
                if (twoSum == target) {
                    List<Integer> list = makeList(nums, i, left, right);
                    listOfLists.add(list);
                    left = nextDiffIndex(nums, left, 1);
                } else if (twoSum > target) {
                    right = nextDiffIndex(nums, right, -1);
                } else {
                    left = nextDiffIndex(nums, left, 1);
                }
            }
            i = nextDiffIndex(nums, i, 1);
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

    private List<Integer> makeList(int[] nums, int i, int left, int right) {
        List<Integer> returnedList = new ArrayList<>();
        returnedList.add(nums[i]);
        returnedList.add(nums[left]);
        returnedList.add(nums[right]);
        return returnedList;
    }

    @Test
    public void testThreeSum() {
        int[] arr1 = new int[]{-1,0,1,2,-1,-4};
        List<List<Integer>> ts = threeSum(arr1);
        int[] arr2 = new int[]{1, 1, 1};
        List<List<Integer>> ts2 = threeSum(arr2);
    }
    @Test
    public void testAllDuplicates() {
        int[] arr2 = new int[]{1, 1, 1};
        List<List<Integer>> ts2 = threeSum(arr2);
    }
}
