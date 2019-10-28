class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    grid[i][j] = '0';
                    visit(grid, i, j);
                }
            }
        }
        return count;
    }
    
    private void visit(char[][]grid, int row, int col) {
        List<Integer[]> moves = legalMove(grid, row, col);
        for (Integer[] arr : moves) {
            int r = arr[0];
            int c = arr[1];
            if (grid[r][c] == '1') {
                grid[r][c] = '0';
                visit(grid, r, c);
            }
        }
    }
    
    private List<Integer[]> legalMove(char[][] grid, int row, int col){
        List<Integer[]> list = new ArrayList<>();
        
        if (row > 0 && grid[row - 1][col] != '0') {
            list.add(new Integer[]{row - 1, col});
        }
        if (col > 0 && grid[row][col - 1] != '0') {
            list.add(new Integer[]{row, col - 1});
        }
        if (row < grid.length - 1 && grid[row + 1][col] != '0') {
            list.add(new Integer[]{row + 1, col});
        }
        if (col < grid[0].length - 1 && grid[row][col + 1] != '0') {
            list.add(new Integer[]{row, col + 1});
        }
        return list;
    }
}