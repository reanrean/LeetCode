class Solution {
    public int searchInsert(int[] nums, int target) {
        int nLen = nums.length;
        if (nLen==0){
            return 0;
        }
        return searchInsertSE(nums, target, 0, nLen-1);
    }
    
    private int searchInsertSE(int[] nums, int target, int start, int end){
        if (start>=end){
            return target>nums[start] ? start+1 : start;
        }
        if (target <= nums[start]){
            return start;
        }
        if (target ==nums[end]){
            return end;
        }
        if (target > nums[end]){
            return end+1;
        }
        int len = end-start+1;
        int i = len/2 + start;
        if (target == nums[i]){
            return i;
        }else if (target>nums[i]){
            return searchInsertSE(nums, target, i+1, end);
        }else{
            return searchInsertSE(nums, target, start, i-1);
        }
    }
}