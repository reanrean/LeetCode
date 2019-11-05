class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int low = prices[0];
        int high = prices[0];
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < high) {
                //System.out.println(i + " " + high + " " + low);
                max += high - low;
                low = prices[i];
                high = prices[i];
            } else {
                low = Math.min(low, prices[i]);
                high = Math.max(high, prices[i]);
            }
        }
        max += high - low;
        return max;
    }
}