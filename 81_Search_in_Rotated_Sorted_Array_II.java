/*
81_Search_in_Rotated_Sorted_Array_II
Approach similar to 33. but need to consider duplicate situation:
we dont know which is ascending when nums[start] = nums[i] or nums[i] = nums[end]
therefore we need to do a shift (start++/end--) while this happens.
Trap: 
1) after shifting, one of the half will be disappeared and we need to handle this!
2) after shifting, start/end is not yet checked, so don't use start+1/end-1 as parameter
*/

class Solution {
    public boolean search(int[] nums, int target) {
        int nLen = nums.length;
        if (nLen == 0){
            return false;
        }
        return searchSE(nums, target, 0, nLen-1);
    }
    
    // search in given portion of array
    private boolean searchSE(int[] nums, int target, int start, int end) {
        //invalid input
        if (end < start) {
            return false;
        }
        
        //sub array length = 1
        if (end == start) {
            return target==nums[start];
        }
        
        //check first and last
        if (target == nums[start] || target == nums[end]) {
            return true;
        }
        //if last < first and target is between them
        else if (target < nums[start] && target > nums[end]) {
            return false;
        }
        
        int len = end - start+1;
        int i = len/2 + start; //middle
        if (target == nums[i]){
            return true;
        }
        
        //solve the problem: mid = first or last
        while (nums[i] == nums[start] && start < i) {
            start++;
        }
        while (nums[i] == nums[end] && i < end) {
            end--;
        }
        //System.out.println("start:"+start+"end:"+end+"i:"+i);
        
        //handle when one of the half array disappeared
        if (start == i) { //right ascending
            return searchSE(nums, target, i+1, end);
        }
        if (end == i) { //left ascending
            return searchSE(nums, target, start, i-1);
        }
        
        if (nums[i]>nums[start]){ //left ascending
            if (target<nums[i] && target>nums[start]){
                return searchSE(nums, target, start+1, i-1);
            }else{
                return searchSE(nums, target, i+1, end-1);
            }
        }else if (nums[i]<nums[end]){ //right ascending
            if (target>nums[i] && target<nums[end]){
                return searchSE(nums, target, i+1, end-1);
            }else{
                return searchSE(nums, target, start+1, i-1);
            }
        }else{
            return false;
        }
    }
}