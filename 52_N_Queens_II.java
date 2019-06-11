/*
modify from 51, no need store output but an int
*/

class Solution {
    public int totalNQueens(int n) {
        int result = 0;
        List<Integer> Queens = new ArrayList<>();
        result = solve(result, Queens, n);
        return result;
    }
    
    private int solve(int result, List<Integer> Queens, int n){
        if (Queens.size() == n){
            //add into result
            result++;
            return result;
        }
        
        for (int i = 0; i < n; i++){
            if (!Queens.contains(i) && diagonalValid(Queens, i)){
                Queens.add(i);
                result = solve(result, Queens, n);
                //after Queens.size() == n (result is got or no result after n iterations)
                Queens.remove(Queens.size()-1);
            }
        }
        return result;
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