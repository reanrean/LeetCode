/*
binary search for both height and length.
*/

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int height = matrix.length;
        if (height == 0 || matrix[0].length == 0){
            return false;
        }
        
        int left = 0;
        int right = height; //right: exclusive
        while (left < right){
            int mid = (right + left) / 2;
            if (target == matrix[mid][0]){
                return true;
            }else if (target < matrix[mid][0]){
                right = mid;
            }else if (mid == height-1 || target < matrix[mid+1][0]){ //target > matrix[mid][0]
                return searchInside(matrix[mid], target);
            }else{
                left = mid + 1;
            }
        }
        return false;
    }
    
    private boolean searchInside(int[] matrix, int target){
        int left = 0;
        int right = matrix.length;
        while (left < right){
            int mid = (right + left) / 2;
            if (target == matrix[mid]){
                return true;
            }else if (target < matrix[mid]){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return false;
    }
}