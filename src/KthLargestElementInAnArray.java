import org.junit.Test;

import java.util.PriorityQueue;

import static org.junit.Assert.*;

public class KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i : nums) {
            if (minHeap.size() == k && i < minHeap.peek()) {
                continue;
            }
            minHeap.add(i);
            if (minHeap.size() > k) {
                minHeap.remove();
            }
        }
        int kthLargest = minHeap.peek();
        return kthLargest;
    }
    @Test
    public void testFindK() {
        int[] nums = new int[]{3,2,1,5,6,4};
        int k = 2;
        assertEquals(5, findKthLargest(nums, k));
    }
}
