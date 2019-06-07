class Solution {
    public int[] searchRange(int[] nums, int target) {
        int nLen = nums.length;
        if (nLen==0){
            return new int[]{-1,-1};
        }
        if (nLen==1){
            int ret = target==nums[0] ? 0 : -1;
            return new int[]{ret, ret};
        }
        return searchRangeSE(nums, target, 0, nLen-1);
    }
    
    private int[] searchRangeSE(int[] nums, int target, int start, int end){
        //System.out.println(start+" "+end);
        if (end<start){
            return new int[]{-1,-1};
        }
        int len = end-start+1;
        if (len==1){
            int ret = target==nums[start] ? start : -1;
            return new int[]{ret, ret};
        }
        int i = len/2 + start;
        if (target==nums[i]){
            int retStart = i-1;
            while(retStart>=start && target==nums[retStart]){
                retStart--;
            }
            int retEnd = i+1;
            while(retEnd<=end && target==nums[retEnd]){
                retEnd++;
            }
            return new int[]{retStart+1, retEnd-1};
        }else if (target>nums[i]){
            return searchRangeSE(nums, target, i+1, end);
        }else{
            return searchRangeSE(nums, target, start, i-1);
        }
    }
}