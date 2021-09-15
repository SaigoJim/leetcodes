package DynamicProgramming;
import org.junit.Test;
import static org.junit.Assert.*;

/** You are given an integer array cost where cost[i] is the cost of ith step on a staircase.
 * Once you pay the cost, you can either climb one or two steps.
 * You can either start from the step with index 0, or the step with index 1.
 * Return the minimum cost to reach the top of the floor.
 * Example 1:
 *
 * Input: cost = [10,15,20]
 * Output: 15
 * Explanation: Cheapest is: start on cost[1], pay that cost, and go to the top.
 * Example 2:
 *
 * Input: cost = [1,100,1,1,1,100,1,1,100,1]
 * Output: 6
 * Explanation: Cheapest is: start on cost[0], and only step on 1s, skipping cost[3].
*/

public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        int prev = 0, prevPrev = 0;
        int curr = 0;
        for (int i = 2; i < cost.length + 1; i += 1) {
            int oneStep = prev + cost[i - 1];
            int twoStep = prevPrev + cost[i - 2];
            curr = Math.min(oneStep, twoStep);
            prevPrev = prev;
            prev = curr;
        }
        return curr;
    }
    public int minCostClimbingStairsWithMutingArray(int[] cost) {
        for (int i = 2; i < cost.length; i += 1) {
            cost[i] += Math.min(cost[i - 1], cost[i - 2]);
        }
        return Math.min(cost[cost.length - 1], cost[cost.length - 2]);
    }
    public int minCostClimbingStairsUsingExplicitEndAt(int[] cost) {
        int n = cost.length;
        int[] costOfEndAt = new int[n + 1];
        costOfEndAt[0] = 0;
        costOfEndAt[1] = 0;
        for (int i = 2; i < costOfEndAt.length; i += 1) {
            int oneStep = costOfEndAt[i - 1] + cost[i - 1];
            int twoStep = costOfEndAt[i - 2] + cost[i - 2];
            costOfEndAt[i] = Math.min(oneStep, twoStep);
        }
        return costOfEndAt[n];
    }
    @Test
    public void testMinCostClimbingStairs() {
        int[] cost = new int[]{10,15,20};
        int expected = 15;
        int actual = minCostClimbingStairs(cost);
        assertEquals(expected, actual);
    }
    @Test
    public void testMinCostClimbingStairs1() {
        int[] cost = new int[]{1,100,1,1,1,100,1,1,100,1};
        int expected = 6;
        int actual = minCostClimbingStairs(cost);
        assertEquals(expected, actual);
    }
}
