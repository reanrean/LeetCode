/*
use backtracking stated in https://leetcode.wang/leetCode-51-N-Queens.html
*/

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        List<Integer> Queens = new ArrayList<>();
        solve(result, Queens, n);
        return result;
    }
    
    private void solve(List<List<String>> result, List<Integer> Queens, int n){
        if (Queens.size() == n){
            //add into result
            List<String> res = new ArrayList<>();
            for (Integer col : Queens){
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < n; i++) {
                    if (i == col){
                        sb.append("Q");
                    }else{
                        sb.append(".");
                    }
                }
                res.add(sb.toString());
            }
            result.add(res);
            return;
        }
        
        for (int i = 0; i < n; i++){
            if (!Queens.contains(i) && diagonalValid(Queens, i)){
                Queens.add(i);
                solve(result, Queens, n);
                //after Queens.size() == n (result is got or no result after n iterations)
                Queens.remove(Queens.size()-1);
            }
        }
    }
    
    private boolean diagonalValid(List<Integer> Queens, int col){
        int rows = Queens.size(); //count of existing rows, also equal to next row
        //(1,1) will conflict with (0,0) or (0,2), 1-0 = 1-0 or 1-0 = -(1-2)
        for (int i = 0; i < rows; i++){
            if (Math.abs(i - rows) == Math.abs(Queens.get(i) - col)){
                return false;
            }
        }
        return true;
    }
}