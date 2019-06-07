class Solution {
    public int firstMissingPositive(int[] nums) {
        if (nums.length==0){
            return 1;
        }
        Arrays.sort(nums);
        int next = 1;
        for (int i=0; i<nums.length; i++){
            if (nums[i]<next){
                continue;
            }else if (nums[i]>next){
                return next;
            }else{ // if (nums[i]==next)
                next++;
            }
        }
        return next;
    }
}