/*
a common solution is using a set to record 
which rows and columns need to be set to 0.
*/

/*
advanced solution: use first row and first col to record.
*/

class Solution {
    public void setZeroes(int[][] matrix) {
        int height = matrix.length;
        if (height == 0){
            return;
        }
        int length = matrix[0].length;
        if (length == 0){
            return;
        }
        boolean colTo0 = false;
        //int count = 0; //debug
        for (int i = 0; i < height; i++){
            for (int j = 0; j < length; j++){
                if (matrix[i][j] == 0){
                    if (j == 0){
                        colTo0 = true;
                    }else{
                        matrix[0][j] = 0;
                    }
                    matrix[i][0] = 0;
                }
            }
        }
        for (int i = 1; i < height; i++){
            if (matrix[i][0] == 0){
                for (int j = 0; j < length; j++){
                    matrix[i][j] = 0;
                }
            }
        }
        for (int j = 1; j < length; j++){
            if (matrix[0][j] == 0){
                for (int i = 0; i < height; i++){
                    matrix[i][j] = 0;
                }
            }
        }
        if (matrix[0][0] == 0){
            for (int j = 0; j < length; j++){
                matrix[0][j] = 0;
            }
        }
        if (colTo0){
            for (int i = 0; i < height; i++){
                matrix[i][0] = 0;
            }
        }
        //System.out.println(count);
        return;
    }
}