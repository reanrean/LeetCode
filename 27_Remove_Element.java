class Solution {
    public int removeElement(int[] nums, int val) {
        int nLen = nums.length;
        int nextPos = 0;
        for (int i=0; i<nLen; i++){
            if (nums[i]==val){
                continue;
            }else{
                nums[nextPos] = nums[i];
                nextPos++;
            }
        }
        return nextPos;
    }
}