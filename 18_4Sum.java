/*
A solution just like what I did in 3Sum.
*/

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int nLen = nums.length;
        if (nLen<4){
            return result;
        }
        Arrays.sort(nums);
        for (int i=0; i<nLen-3; i++){
            if (i>0 && nums[i]==nums[i-1]){
                continue;
            }
            int first = nums[i];
            int target3 = target - first;
            for (int j=i+1; j<nLen-2; j++){
                if (j>i+1 && nums[j]==nums[j-1]){
                    continue;
                }
                int second = nums[j];
                int target2 = target3 - second;
                int l = j+1;
                int r = nLen - 1;
                while (l<r){
                    int sum = nums[l] + nums[r];
                    if (sum==target2){
                        List<Integer> resultChild = new ArrayList<Integer>();
                        resultChild.add(first);
                        resultChild.add(second);
                        resultChild.add(nums[l]);
                        resultChild.add(nums[r]);
                        result.add(resultChild);
                        //System.out.println(i+" " + j + " " + l + " " + r+ " " +result.size());
                        do {
                            l++;
                        }while (nums[l]==nums[l-1] && l<r);
                        do {
                            r--;
                        }while (nums[r]==nums[r+1] && l<r);
                    }else if(sum<target2){
                        l++;
                    }else{
                        r--;
                    }
                }
            }
        }
        return result;
    }
}