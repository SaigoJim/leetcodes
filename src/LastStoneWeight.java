import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

import static org.junit.Assert.*;

public class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i : stones) {
            maxHeap.add(i);
        }
        while (maxHeap.size() != 1) {
            int max = maxHeap.remove();
            int maxSecond = maxHeap.remove();
            int distance = max - maxSecond;
            maxHeap.add(distance);
        }
        int lastStone = maxHeap.remove();
        return lastStone;
    }
    @Test
    public void testLastStoneWeight() {
        int[] stones = new int[]{2,7,4,1,8,1};
        assertEquals(1, lastStoneWeight(stones));
    }
    @Test
    public void testPQ() {
        int[] stones = new int[]{2,7,4,1,8,1};
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i : stones) {
            maxHeap.add(i);
        }
        int max = maxHeap.remove();
        assertEquals(8, max);
    }
}
