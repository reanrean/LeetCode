/*
Let m=rows, n=cols,
There will be m/2(round up) iterations.
First iteration is the most outer round, which contains (m-1)*2+(n-1)*2 elements
Second iteration is the second most outer, where m=m-2 and n=n-2
...
Need to consider exceptional case when m=1 or n=1 (no matter at first or after x iterations)
*/

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int m0 = matrix.length; //rows
        if (m0 == 0){
            return result;
        }
        int n0 = matrix[0].length; //cols
        if (n0 == 0){
            return result;
        }
        
        int nRow = m0 / 2 + m0 % 2;
        int m = m0;
        int n = n0;
        for (int i = 0; m > 0 && n > 0; i++){
            if (m == 1){
                for (int j = 0; j < m; j++){
                    result.add(matrix[i][i+j]);
                }
                return result;
            }else if (n == 1){
                for (int j = 0; j < n; j++){
                    result.add(matrix[i+j][i]);
                }
                return result;
            }
            for (int j = 0; j < n - 1; j++){
                result.add(matrix[i][i+j]);
            }
            for (int j = 0; j < m - 1; j++){
                result.add(matrix[i+j][n0-1-i]);
            }
            for (int j = 0; j < n - 1; j++){
                result.add(matrix[m0-1-i][n0-1-i-j]);
            }
            for (int j = 0; j < m - 1; j++){
                result.add(matrix[m0-1-i-j][i]);
            }
            n-=2;
            m-=2;
        }
        return result;
    }
}
