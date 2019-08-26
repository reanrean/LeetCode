/*
Simple array modification. Use int diff to record which record it is writing.
First match - write it to cur; Second match - boolean true; Third match - increase diff
Write the current letter to the array according to diff.
*/

class Solution {
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return len;
        }
        int cur = nums[0];
        int diff = 0;
        boolean appeared = false;
        for (int i = 1; i < len; i++) {
            if (nums[i] == cur && appeared) {
                diff++;
            }else if (nums[i] == cur) {
                appeared = true;
            }else {
                cur = nums[i];
                appeared = false;
            }
            if (diff > 0) {
                nums[i - diff] = nums[i];
            }
        }
        return len - diff;
    }
}