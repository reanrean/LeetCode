/*
Use recursion to solve.

For example, candidates = [2,3,6,7], target = 7,
at i=0 (candidates[i]=2), it is same as calculating [2,3,6,7],5. (add extra 2 in each result)

To avoid duplicate result, just remove all elements before it.
e.g. at i=1, all elements < i will not be considered. i.e. calculate [3,6,7],7
*/

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (candidates.length==0){
            return result;
        }
        Arrays.sort(candidates);
        for (int i=0; i<candidates.length; i++){
            if (candidates[i]>target){
                break;
            }else if (candidates[i]==target){
                List<Integer> res = new ArrayList<>();
                res.add(target);
                result.add(res);
            }else { //candidates[i]<target
                List<List<Integer>> less = addNum(combinationSum(slice(candidates,i), target-candidates[i]), candidates[i]);
                for (List<Integer> each : less) {
                    result.add(each);
                }
            }
        }
        return result;
    }
    
    private int[] slice(int[] nums, int start){
        int[] out = new int[nums.length-start];
        for (int i=0; i<nums.length-start; i++){
            out[i] = nums[i+start];
        }
        return out;
    }
    
    private List<List<Integer>> addNum(List<List<Integer>> res, int num){
		for (List<Integer> each : res) {
			each.add(num);
		}
        return res;
    }
}