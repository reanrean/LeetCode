/*
If there is no 0, it must be able to jump to the end.
So the key is whether we can jump over 0.
Thus, when we encounter a 0, we look at numbers before it and see whether it can be jumped over.
Traps:
- end is 0, so we skip checking the last digit.
- [3,0,0] with continuous 0s, but the end still can be reached.
*/

class Solution {
    public boolean canJump(int[] nums) {
        int nLen = nums.length;
        if (nLen <= 1){
            return true;
        }
        int pos0 = -1;
        for (int i = nLen - 2; i >= 0; i--){
            if (pos0 > -1){
                if (nums[i] + i > pos0){
                    pos0 = -1;
                }
            }else if (nums[i] == 0){
                if (pos0 > -1){
                    return false;
                }
                pos0 = i;
            }
        }
        if (pos0 > -1){
            return false;
        }else{
            return true;
        }
    }
}

/*
Improve(?) according to https://leetcode.wang/leetCode-55-Jump-Game.html
Check the maximum distance can be jumped at each i,
return false when max[i] < i.
*/

class Solution {
    public boolean canJump(int[] nums) {
        int nLen = nums.length;
        int max = 0;
        for (int i = 0; i < nLen; i++){
            if (max < i){
                return false;
            }else{
                max = Math.max(max, nums[i] + i);
            }
        }
        return true;
    }
}