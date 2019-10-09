/*
twitter OA

In this solution, I will rewrite the costs matrix into the cost of sum amount.
for example,
[[17,2,17],
 [16,16,5],
 [14,3,19]]
 will become
[[17,2,17],
 [18,33,7],
 [21,10,37]]

For each row, sum the amount of painting with the least smallest amount (not its neighbor).
*/

class Solution {
    public int minCost(int[][] costs) {
        if (costs.length == 0 || costs[0].length == 0) {
            return 0;
        }
        for (int i = 1; i < costs.length; i++) {
            for (int j = 0; j < costs[0].length; j++){
                int lastMin = Integer.MAX_VALUE;
                for (int k = 0; k < costs[0].length; k++) {
                    if (j == k) {
                        continue;
                    }
                    lastMin = Math.min(lastMin, costs[i-1][k]);
                }
                costs[i][j] += lastMin;
            }
        }
        int min = Integer.MAX_VALUE;
        for (int j = 0; j < costs[0].length; j++){
            min = Math.min(min, costs[costs.length - 1][j]);
        }
        return min;
    }
}