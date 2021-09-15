package DynamicProgramming;
import java.util.HashMap;
import org.junit.Test;
import static org.junit.Assert.*;

public class ClimbingStairs {
    public int climbStairs(int n) {
        HashMap<Integer, Integer> stepsBook = new HashMap<>();
        stepsBook.put(1, 1);
        stepsBook.put(2, 2);
        return climbStairsWithMemoization(n, stepsBook);
    }

    private int climbStairsWithMemoization(int n, HashMap<Integer, Integer> stepsBook) {
        if (stepsBook.containsKey(n)) {
            return stepsBook.get(n);
        }
        int steps = climbStairsWithMemoization(n - 1, stepsBook) +
                climbStairsWithMemoization(n - 2, stepsBook);
        stepsBook.put(n, steps);
        return steps;
    }

    public int climbStairsByDynamicProgramming(int n) {
        int prevPrev = 0, prev = 1;
        int endAt = 0;
        for (int i = 0; i < n; i += 1) {
            endAt = prevPrev + prev;
            prevPrev = prev;
            prev = endAt;
        }
        return endAt;
    }
    @Test
    public void testDynamicProgramming() {
        for (int i = 1; i < 46; i += 1) {
            int stepsRecursion = climbStairs(i);
            int stepsDynamic = climbStairsByDynamicProgramming(i);
            assertEquals(stepsRecursion, stepsDynamic);
        }
    }
}
