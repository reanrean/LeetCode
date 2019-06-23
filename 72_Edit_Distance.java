/*
https://leetcode.wang/leetCode-72-Edit-Distance.html
word1 = "horse", word2 = "ros"
create matrix 6x4
e.g. matrix[3][3] = hor to ros

at i=3, j=3
delete = hor to ro +1
add = ho to ros +1
replace = ho to ro + r==s?
*/

class Solution {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int[][] matrix = new int[len1 + 1][len2 + 1];
        for (int i = 0; i <= len1; i++){
            matrix[i][0] = i;
        }
        for (int j = 0; j <= len2; j++){
            matrix[0][j] = j;
        }
        for (int i = 1; i <= len1; i++){
            for (int j = 1; j <= len2; j++){
                int delete = matrix[i][j-1] + 1;
                int add = matrix[i-1][j] + 1;
                int replace = matrix[i-1][j-1] + (word1.charAt(i-1)==word2.charAt(j-1) ? 0 : 1);
                matrix[i][j] = Math.min(replace, Math.min(delete, add));
            }
        }
        return matrix[len1][len2];
    }
}