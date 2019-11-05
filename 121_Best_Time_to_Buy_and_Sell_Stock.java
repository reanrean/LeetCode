class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                max = Math.max(prices[j] - prices[i], max);
            }
        }
        return max;
    }
}

class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int max = 0;
        int low = prices[0];
        for (int i = 0; i < prices.length; i++) {
            max = Math.max(max, prices[i] - low);
            low = Math.min(low, prices[i]);
        }
        return max;
    }
}