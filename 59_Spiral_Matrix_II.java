/*
For n, number count = n*n
Similar to Spiral Matrix, there will be n/2+n%2 rounds, 4 iterations each round
In first round, n-1 * 4 numbers
In second round, (n-2)-1 * 4 numbers if n-2>1, one number if n-2=1
*/

class Solution {
    public int[][] generateMatrix(int n) {
        int n0 = n;
        int[][] result = new int [n][n];
        //int rounds = n / 2 + n % 2;
        int num =  1;
        for (int i = 0; n > 0; i++){
            int each = n - 1;
            if (n == 1){
                result[i][i] = num;
            }else{
                for (int j = 0; j < each; j++){
                    result[i][i+j] = num + j;
                    result[i+j][n0-1-i] = num + j + each;
                    result[n0-1-i][n0-1-i-j] = num + j + each*2;
                    result[n0-1-i-j][i] = num + j + each*3;
                }
                num += each * 4;
            }
            n -= 2;
        }
        return result;
    }
}