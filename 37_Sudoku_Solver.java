/*
using backtracking.
https://leetcode.wang/leetCode-37-Sudoku-Solver.html

Followup: https://leetcode.com/problems/sudoku-solver/discuss/296535/3ms-java-solution-faster-than-97-memory-less-than-93-use-three-boolean-arrays.
*/

class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }
    
    private boolean solve(char[][] board){
        for (int i=0; i<9; i++){
            for (int j=0; j<9; j++){
                if (board[i][j]=='.'){
                    char trial = '1';
                    while (trial <= '9'){
                        if (isValid(board, i, j, trial)){
                            //System.out.println(i+" "+j+" "+trial);
                            board[i][j] = trial;
                            if (solve(board)){
                                return true;
                            }else{
                                board[i][j] = '.';
                            }
                        }
                        trial++;
                    }
                    return false;
                }
            }
        }
        return true;
    }
    
    private boolean isValid(char[][] board, int row, int col, char c){
        //row & col
        for (int i=0; i<9; i++){
            //System.out.println("valid: "+row + col + board[row][i] + board[i][col]);
            if (board[row][i]==c || board[i][col]==c){
                return false;
            }
        }
        //box
        int bRow = row/3 * 3;
        int bCol = col/3 * 3;
        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++){
                if (board[bRow+i][bCol+j]==c){
                    return false;
                }
            }
        }
        return true;
    }
}