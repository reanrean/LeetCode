/*
The operation of rotate image is rotating each group of 4 numbers.
For example, input matrix = 
[
  [1,2,3],
  [4,5,6],
  [7,8,9]
],
1->3->9->7
2->6->8->4
Just rotate in such groups can reach the solution.
For first row, do n-1 rotations.
For second row, do (n-2)-1 rotations.
For third row, do (n-4)-1 rotations.
...
Until n/2 rows.
*/

class Solution {
    public void rotate(int[][] matrix) {
        int mLen = matrix.length;
        int opsRow = mLen/2;
        for (int i = 0; i < opsRow; i++){
            //System.out.println("i"+i);
            int opsCol = (mLen - 2*i) - 1;
            for (int j = 0; j < opsCol; j++){
                //System.out.println("j"+j);
                int shift = i+j;
                int temp = matrix[i][shift]; //left top corner
                matrix[i][shift] = matrix[mLen-1-shift][i]; //left bottom
                matrix[mLen-1-shift][i] = matrix[mLen-1-i][mLen-1-shift]; //right bottom
                matrix[mLen-1-i][mLen-1-shift] = matrix[shift][mLen-1-i]; //right top
                matrix[shift][mLen-1-i] = temp; 
            }
        }
        return;
    }
}