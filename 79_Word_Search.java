/*
Using backtrack. First find the letter in board that matches with the first letter, 
then search for its 4 neighbors for nextChar. Mark itself as '.' to avoid revisiting itself.
If neighbors unmatch, revoke the change and do the next search.

Trap: 
1) visited
2) there may be multiple neighbors satisfy next word

Note:
Beware of when should revoke mark of "."
*/

class Solution {
    public boolean exist(char[][] board, String word) {
        if (word.length() == 0) {
            return false;
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    //System.out.println("main:"+i + " "+j);
                    if (solve(board, word.substring(1), i, j)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    private boolean solve(char[][] board, String word, int row, int col) {
        if (word.length() == 0) {
            return true;
        }
        char thisChar = board[row][col];
        char nextChar = word.charAt(0);
        List<Integer[]> match = checkNeighbor(board, row, col, nextChar);
        if (match.size() > 0) {
            //System.out.println(match.size() + " " + thisChar + nextChar);
            for (Integer[] matchList : match) {
                board[row][col] = '.';
                if (solve(board, word.substring(1), row + matchList[0], col + matchList[1])) {
                    return true;
                }
            }
        }
        board[row][col] = thisChar;
        return false;
    }
    
    private List<Integer[]> checkNeighbor(char[][] board, int row, int col, char target) {
        int m = board.length;
        int n = board[0].length;
        List<Integer[]> ret = new ArrayList<Integer[]>();
        if (row > 0) {
            if (board[row - 1][col] == target) {
                Integer[] element = new Integer[]{-1,0};
                ret.add(element);
            }
        }
        if (col > 0) {
            if (board[row][col - 1] == target) {
                ret.add(new Integer[]{0, -1});
            }
        }
        if (row < m - 1) {
            if (board[row + 1][col] == target) {
                ret.add(new Integer[]{1, 0});
            }
        }
        if (col < n - 1) {
            if (board[row][col + 1] == target) {
                ret.add(new Integer[]{0, 1});
            }
        }
        return ret;
    }
}