package DynamicProgramming;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 *
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
 *
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 * Example 1:
 *
 * Input: prices = [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 * Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
 * Example 2:
 *
 * Input: prices = [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transactions are done and the max profit = 0.
 *
 * Constraints:
 *
 * 1 <= prices.length <= 105
 * 0 <= prices[i] <= 104
 * */
public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int max = 0;
        int prevProfit = 0, currProfit;
        for (int i = 1; i < prices.length; i += 1) {
            int buyPrice = prices[i - 1] - prevProfit;
            currProfit = prices[i] - buyPrice;
            currProfit = currProfit > 0 ? currProfit : 0;
            max = max > currProfit ? max : currProfit;
            prevProfit = currProfit;
        }
        return max;
    }
    public int maxProfitWithExplicitEndAt(int[] prices) {
        int[] profits = new int[prices.length];
        profits[0] = 0;
        int max = profits[0];
        for (int i = 1; i < profits.length; i += 1) {
            int prevProfit = profits[i - 1];
            int boughtPrice = prices[i - 1] - prevProfit;
            profits[i] = prices[i] - boughtPrice;
            profits[i] = Math.max(0, profits[i]);
            max = Math.max(max, profits[i]);
        }
        return max;
    }

    @Test
    public void testMaxProfit() {
        int[] prices = new int[]{7,1,5,3,6,4};
        int expected = 5;
        int actual = maxProfit(prices);
        assertEquals(expected, actual);
    }
    @Test
    public void testMaxProfit1() {
        int[] prices = new int[]{7,6,4,3,1};
        int expected = 0;
        int actual = maxProfit(prices);
        assertEquals(expected, actual);
    }
}
