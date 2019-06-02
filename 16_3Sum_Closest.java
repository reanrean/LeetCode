/*
Similar to the algorithm in 15_3Sum, just adjust the target from 0 to target.
*/

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closest = nums[0] + nums[1] + nums[nums.length-1];
        int diff = Math.abs(closest - target);
        int nLen = nums.length;
        //System.out.println("diff: "+diff);
        for (int i=0; i<nLen; i++){
        //System.out.println("i: "+i);
            int cur = nums[i];
            int tar = target - cur;
            int l = i+1;
            int r = nums.length-1;
            while (l<r){
                int sum = nums[l] + nums[r];
                //System.out.println("l: "+l);
                //System.out.println("r: "+r);
                if (sum==tar){
                    return target;
                }else if (sum<tar){
                    l++;
                }else{ //sum>tar
                    r--;
                }
                int diffCur = Math.abs(sum - tar);
                //System.out.println("diffCur: "+diffCur);
                if (diffCur<diff){
                    diff = diffCur;
                    closest = sum + cur;
                    //System.out.println(closest);
                }
            }
        }
        return closest;
    }
}