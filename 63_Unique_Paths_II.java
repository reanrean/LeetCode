/*
backtrack: Time Limit Exceeded again...
*/

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }
        int[] cur = new int[]{0,0};
        return backtrack(0, cur, obstacleGrid);
    }
    
    private int backtrack(int result, int[] cur, int[][] obstacleGrid){
        if (cur[0] == obstacleGrid.length - 1 && cur[1] == obstacleGrid[0].length - 1 && obstacleGrid[cur[0]][cur[1]] != 1){
            //cur = dest
            result++;
            return result;
        }
        for (int i = 0; i <= 1; i++){
            if (isValid(cur, obstacleGrid, i)){
                cur[i]++;
                result = backtrack(result, cur, obstacleGrid);
                cur[i]--;
            }
        }
        return result;
    }
    
    private boolean isValid (int[] cur, int[][] obstacleGrid, int move){
        //move=0 means cur[0]+1 (down), move=1 means cur[1]+1 (right)
        int row = cur[0] + (move == 0 ? 1 : 0);
        int col = cur[1] + (move == 1 ? 1 : 0);
        if (row >= obstacleGrid.length || col >= obstacleGrid[0].length || obstacleGrid[row][col] == 1){
            return false;
        }
        return true;
    }
}

/*
https://leetcode.com/problems/unique-paths-ii/discuss/309297/JavaScript-beats-99-linear-intuitive-solution
A DP Solution.

Create a m x n matrix, set the first element to 1. 
(if first element is obstacle, return 0)
Loop through the matrix, from left to right then from top to bottom,
if exist its top or its left, arr[i] = arr[top] + arr[left];
if it is obstacle, arr[i] = 0;
*/

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1){
            return 0;
        }
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] path = new int[m][n];
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (i == 0 && j == 0){
                    path[i][j] = 1;
                    continue;
                }
                if (obstacleGrid[i][j] == 1){
                    path[i][j] = 0;
                    continue;
                }
                int fromTop = i>0 ? path[i-1][j] : 0;
                int fromLeft = j>0 ? path[i][j-1] : 0;
                path[i][j] = fromTop + fromLeft;
            }
        }
        return path[m-1][n-1];
    }
}