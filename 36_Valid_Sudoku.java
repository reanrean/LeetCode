/*
Use HashSet to check 1-9 repeat only 1 time.

1st way: go through board 3 times.
*/

class Solution {
    public boolean isValidSudoku(char[][] board) {
        //check row
        for (int i=0; i<9; i++){
            boolean check = isValidNineNumbers(board[i]);
            if (!check) {
                return false;
            }
        }
        
        //check column
        for (int i=0; i<9; i++){
            char[] column = new char[9];
            for (int j=0; j<9; j++){
                column[j] = board[j][i];
            }
            boolean check = isValidNineNumbers(column);
            if (!check) {
                return false;
            }
        }
        
        //check boxes
        for (int i=0; i<9; i+=3){
            for (int j=0; j<9; j+=3){
                char[] box = new char[9];
                int c = 0;
                for (int a=0; a<3; a++){
                    for (int b=0; b<3; b++){
                        box[c] = board[i+a][j+b];
                        c++;
                    }
                }
                boolean check = isValidNineNumbers(box);
                if (!check) {
                    return false;
                }
            }
        }
        
        return true;
    }
    private boolean isValidNineNumbers(char[] nums){
        Set<Character> set = new HashSet<Character>();
        for (int i=0; i<nums.length; i++){
            if (nums[i]=='.'){
                continue;
            }else if (nums[i]-'0' > 9 || nums[i]-'0' < 0){
                return false;
            }else {
                boolean add = set.add(nums[i]);
                if (!add){
                    return false;
                }
            }
        }
        return true;
    }
}

/*
2nd way: go through only 1 time
but didnt improve time
*/

class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> set = new HashSet<String>();
        for (int i=0; i<9; i++){
            for (int j=0; j<9; j++){
                char c = board[i][j];
                if (c=='.'){
                    continue;
                }else if (c-'0' < 0 || c-'0' > 9){
                    return false;
                }else{
                    boolean check;
                    //row
                    check = set.add("r"+i+"-"+c);
                    if (!check){
                        return false;
                    }
                    //column
                    check = set.add("c"+j+"-"+c);
                    if (!check){
                        return false;
                    }
                    //boxes
                    int bGroup = (i/3)*3 + j/3;
                    check = set.add("b"+bGroup+"-"+c);
                    if (!check){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}