/**
 * Created by xuyuanp on 5/26/14.
 */
public class Solution {

    public int maxProfit(int[] prices) {
        if (prices == null) {
            return 0;
        }
        int min = prices[0];
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            int profit = prices[i] - min;
            if (profit > maxprofit) {
                maxprofit = profit;
            }
            if (prices[i] < min) {
                min = prices[i];
            }
        }
        return maxprofit;
    }

    public int maxProfit2(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int maxprofit = 0;

        for (int i = 1; i < prices.length; i++) {
            int profit = prices[i] - prices[i - 1];
            if (profit > 0) {
                maxprofit += profit;
            }
        }

        return maxprofit;
    }

    public int maxProfit3(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int maxprofit = 0;

        int[] left = new int[prices.length];
        int[] right = new int[prices.length];

        int min = prices[0];

        for (int i = 0; i < prices.length; i++) {
            int profit = prices[i] - min;
            if (profit > maxprofit) {
                maxprofit = profit;
            }
            left[i] = maxprofit;
            if (prices[i] < min) {
                min = prices[i];
            }
        }

        maxprofit = 0;
        int max = prices[prices.length - 1];

        for (int i = prices.length - 1; i >= 0; i--) {
            int profit = max - prices[i];
            if (profit > maxprofit) {
                maxprofit = profit;
            }
            right[i] = maxprofit;
            if (prices[i] > max) {
                max = prices[i];
            }
        }

        maxprofit = left[0] + right[0];
        for (int i = 0; i < prices.length; i++) {
            int profit = left[i] + right[i];
            if (profit > maxprofit) {
                maxprofit = profit;
            }
        }

        return maxprofit;
    }
}
