/*
https://leetcode.wang/leetCode-53-Maximum-Subarray.html
Use dynamic programming.
Each dp stores the maximum value end at each element.
Then dp[0] must be nums[0].
For each element, if dp[i-1]<0, we wont include the previous result and dp[i]=nums[i]
                  if dp[i-1]>0, dp[i] must be the sum of dp[i-1] and nums[i]
The maximum of each dp[] will be the result.
*/

class Solution {
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        if (len==0){
            return 0;
        }
        int[] dp = new int[len]; //stores the maximum value end at each element
        dp[0] = nums[0];
        int result = dp[0];
        for (int i = 1; i < len; i++){
            if (dp[i - 1] < 0){
                dp[i] = nums[i];
            }else{
                dp[i] = dp[i - 1] + nums[i];
            }
            result = Math.max(result, dp[i]);
        }
        return result;
    }
}