/*
Similar to 63 sol.2, add up grid[i][j] with min of fromTop and fromLeft
for first col and first row, there is no fromLeft/fromTop, so just add up linearly
reuse grid to output result to speed up and save space.
*/

class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (i == 0 && j == 0){
                    continue;
                }else if (i == 0){
                    grid[i][j] = grid[i][j] + grid[i][j - 1];
                }else if (j == 0){
                    grid[i][j] = grid[i][j] + grid[i - 1][j];
                }else{
                    grid[i][j] = grid[i][j] + Math.min(grid[i][j - 1], grid[i - 1][j]);
                }
            }
        }
        return grid[m - 1][n - 1];
    }
}