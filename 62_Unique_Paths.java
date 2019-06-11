/*
use backtrack: Time Limit Exceeded
*/

class Solution {
    public int uniquePaths(int m, int n) {
        int[] cur = new int[]{0,0};
        int[] dest = new int[]{n - 1, m - 1}; //m is cols, n is rows
        return backtrack(0, cur, dest);
    }
    
    private int backtrack(int result, int[] cur, int[] dest){
        //System.out.println(cur[0]+" "+ cur[1]);
        if (cur[0] == dest[0] && cur[1] == dest[1]){
            result++;
        //System.out.println("result:"+result);
            return result;
        }
        for (int i = 0; i <= 1; i++){
            if (isValid(cur, dest, i)){
                cur[i]++;
                result = backtrack(result, cur, dest);
                cur[i]--;
            }
        }
        return result;
    }
    
    private boolean isValid (int[] cur, int[] dest, int move){
        //move=0 means cur[0]+1 (down), move=1 means cur[1]+1 (right)
        if (cur[move] + 1 > dest[move]){
            return false;
        }
        return true;
    }
}

/*
Approach 3 at https://leetcode.wang/leetCode-62-Unique-Paths.html

For input = 3,2, The result is just permutataion of 3 words: R R D
It is like drawing balls from a basket of such 3 balls
So the total possible permutataion is (m+n)! / (m!n!) where m=2,n=1
- Note: math thinking: if give all balls a number, there will be (m+n)! permutataion
        but we do not consider permutataion inside m and n, so divide by those cases.
- Trap: there will be int overflow if calculate (m+n)! directly, 
        so we transform the formula to (m+1)(m+2)...(m+n)/n! where n is the smaller
        However, overflow still appear.. use long to avoid overflow.
*/

class Solution {
    public int uniquePaths(int m, int n) {
        int small = Math.min(m - 1, n - 1);
        int large = Math.max(m - 1, n - 1);
        long result = 1;
        for (int i = 1; i <= small; i++){
            result = result * (large + i) / i;
        }
        return (int)result;
    }
}