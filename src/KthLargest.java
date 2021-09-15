import org.junit.Test;
import static org.junit.Assert.*;
import java.util.PriorityQueue;

class KthLargest {
    PriorityQueue<Integer> maxHeap;
    int k;
    int kthLargest;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        maxHeap = new PriorityQueue<>();
        kthLargest = Integer.MIN_VALUE;
        for (int i : nums) {
            maxHeap.add(i);
        }
        while (maxHeap.size() > k - 1) {
            kthLargest = maxHeap.remove();
        }
    }

    public int add(int val) {
        if (maxHeap.size() < k - 1) {
            maxHeap.add(val);
            kthLargest = maxHeap.peek();
        } else if (val <= kthLargest) {
            return kthLargest;
        } else {
            maxHeap.add(val);
            kthLargest = maxHeap.remove();
        }
        return kthLargest;
    }
}
