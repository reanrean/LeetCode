/*
It's easy to think of this approach. However, need to rethink whether it is always true.
*/

class Solution {
    public int maxArea(int[] height) {
        int len = height.length;
        int l = 0;
        int r = len-1;
        int maxA = 0;
        while(l<r){
            int A = Math.min(height[l],height[r]) * (r-l);
            maxA = Math.max(maxA, A);
            if (height[l]>height[r]){
                r--;
            }else{
                l++;
            }
        }
        return maxA;
    }
}