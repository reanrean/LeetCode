/*
Use DP. ways[i] = ways[i-1] (climb 1 step) + ways[i-2] (climb 2 steps)
*/

class Solution {
    public int climbStairs(int n) {
        if (n <= 2){
            return n;
        }
        int[] ways = new int[n];
        ways[0] = 1;
        ways[1] = 2;
        for (int i = 2; i < n; i++){
            ways[i] = ways[i - 1] + ways[i - 2];
        }
        return ways[n - 1];
    }
}

/*
discard array, it is just a fibonacci sequence!!
*/

class Solution {
    public int climbStairs(int n) {
        if (n <= 2){
            return n;
        }
        int prev1 = 1;
        int prev2 = 2;
        int result = 0;
        for (int i = 2; i < n; i++){
            result = prev1 + prev2;
            prev1 = prev2;
            prev2 = result;
        }
        return result;
    }
}