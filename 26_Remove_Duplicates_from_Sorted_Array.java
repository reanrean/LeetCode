class Solution {
    public int removeDuplicates(int[] nums) {
        int resultLen = 0;
        int prev = 0;
        for(int i=0; i<nums.length; i++){
            if (i>0 && nums[i]==prev){
                continue;
            }else{
                prev = nums[i];
                nums[resultLen] = prev;
                resultLen++;
            }
        }
        return resultLen;
    }
}