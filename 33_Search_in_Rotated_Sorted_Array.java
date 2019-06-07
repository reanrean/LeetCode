class Solution {
    public int search(int[] nums, int target) {
        int nLen = nums.length;
        if (nLen == 0){
            return -1;
        }
        return searchSE(nums, target, 0, nLen-1);
    }
    
    private int searchSE(int[] nums, int target, int start, int end) {
        //System.out.println("start:"+start+" end:"+end);
        if (end<start){
            return -1;
        }
        if (end==start){
            return target==nums[start] ? start : -1;
        }
        
        int first = nums[start];
        int last = nums[end];
        if (target == first){
            return start;
        }
        else if (target == last){
            return end;
        }
        else if (target<first && target>last){
            return -1;
        }
        
        int len = end-start+1;
        int i = len/2 + start;
        if (target == nums[i]){
            return i;
        }else if (nums[i]>nums[start]){ //left ascending
            if (target<nums[i] && target>first){
                return searchSE(nums, target, start+1, i-1);
            }else{
                return searchSE(nums, target, i+1, end-1);
            }
        }else if (nums[i]<last){ //right ascending
            if (target>nums[i] && target<last){
                return searchSE(nums, target, i+1, end-1);
            }else{
                return searchSE(nums, target, start+1, i-1);
            }
        }else{
            return -1;
        }
    }
}