/*
Time Complexity:(n!)
Do from n=1, insert each number to each different positions, and clone the output to the list.
e.g. n=1, output = [1].
when n=2, insert 2 before and after 1, to produce [1,2] and [2,1].
when n=3, for each of the two outputs, insert 3 into the three possible slots (each time create a clone).
*/

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int nLen = nums.length;
        if (nLen == 0){
            return result;
        }
        List<Integer> res = new ArrayList<>();
        res.add(nums[0]);
        result.add(res);
        if (nLen == 1){
            return result;
        }
        for (int i = 1; i < nLen; i++){
            result = addPermute(nums[i], result);
        }
        return result;
    }
    
    private List<List<Integer>> addPermute(int ins, List<List<Integer>> nums) {
        List<List<Integer>> result = new ArrayList<>();
        int size = nums.get(0).size();
        for (List<Integer> list : nums){
            for (int i = 0; i <= size; i++){
                List<Integer> res = cloneList(list);
                res.add(i,ins);
                result.add(res);
            }
        }
        return result;
    }
    
    private List<Integer> cloneList(List<Integer> list){
        List<Integer> result = new ArrayList<>();
        for (Integer i : list){
            result.add(i);
        }
        return result;
    }
}