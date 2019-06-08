/*
Similar logic to 39, but:
- add checking when length=1 (result is obvious)
- slice one more in recursion (no duplicate element is allowed)
*/

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (candidates.length==0){
            return result;
        }
        if (candidates.length==1){
            if (candidates[0]==target){
                List<Integer> res = new ArrayList<>();
                res.add(target);
                result.add(res);
            }
            return result;
        }
        Arrays.sort(candidates);
        for (int i=0; i<candidates.length; i++){
            if (i>0 && candidates[i]==candidates[i-1]){
                continue;
            }
            if (candidates[i]>target){
                break;
            }else if (candidates[i]==target){
                List<Integer> res = new ArrayList<>();
                res.add(target);
                result.add(res);
            }else { //candidates[i]<target
                List<List<Integer>> less = addNum(combinationSum2(slice(candidates,i+1), target-candidates[i]), candidates[i]);
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