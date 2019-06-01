/*
algorithm stated in https://zh.wikipedia.org/wiki/3SUM
For each nums[i], use its negative as the target, and then
move two pointers until they meet.
To avoid duplicate result, move 1 more time if the pointer 
is at same number as previous.
*/

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        int nLen = nums.length;
        if (nLen<3) return ret;
        Arrays.sort(nums);
        for (int i=0; i<nLen; i++){
            if (i>0 && nums[i]==nums[i-1]){
                continue;
            }
            int target = -1 * nums[i];
            int l = i+1;
            int r = nLen-1;
            while (l<r){
                int sum = nums[l] + nums[r];
                if (sum==target){
                    List<Integer> result = new ArrayList<>();
                    result.add(nums[i]);
                    result.add(nums[l]);
                    result.add(nums[r]);
                    ret.add(result);
                    do{
                        l++;
                    }while (l<r && nums[l]==nums[l-1]);
                    do{
                        r--;
                    }while (r>l && nums[r]==nums[r+1]);
                }else if(sum>target){
                    r--;
                }else{
                    l++;
                }
            }
        }
        return ret;
    }
}