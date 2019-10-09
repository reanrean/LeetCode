/*
twitter OA.

approach of dfs. starting from each matrix, search any friends it may know and count +1 each iteration. 
*/

class Solution {
    public int findCircleNum(int[][] M) {
        if (M.length == 0 || M[0].length == 0) {
            return 0;
        }
        int[] visited = new int[M.length];
        int count = 0;
        for (int i = 0; i < M.length; i++) {
            if (visited[i] == 0) {
                search(M, visited, i);
                count++;
            }
        }
        return count;
    }
    
    private void search(int[][] M, int[] visited, int idx) {
        for (int i = 0; i < M.length; i++) {
            if ((M[idx][i] == 1 || M[i][idx] == 1) && visited[i] == 0) {
                visited[i] = 1;
                search(M, visited, i);
            }
        }
    }
}