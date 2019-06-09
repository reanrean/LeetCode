/*
An inefficient solution. Check duplicated everytime adding into result.

followup: swap method
https://leetcode.com/problems/permutations-ii/discuss/306736/Simple-Java-Solution-with-Detailed-Explanation.-2ms-runtime
*/

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int nLen = nums.length;
        if (nLen==0){
            return result;
        }
        Arrays.sort(nums);
        List<Integer> res = new ArrayList<>();
        res.add(nums[0]);
        result.add(res);
        if (nLen==1){
            return result;
        }
        for (int i = 1; i < nLen; i++){
            result = addPermute(nums[i], result);
        }
        return result;
    }
    
    private List<List<Integer>> addPermute(int ins, List<List<Integer>> nums){
        List<List<Integer>> result = new ArrayList<>();
        int size = nums.get(0).size();
        for (List<Integer> list : nums){
            for (int i = 0; i <= size; i++){
                List<Integer> res = cloneList(list);
                res.add(i,ins);
                if (!result.contains(res)){
                    result.add(res);
                }
                /*boolean add = true;
                for (List<Integer> prev : result){
                    if (prev.equals(res)){
                        add = false;
                        break;
                    }
                }
                if (add){
                    result.add(res);
                }*/
                /*if (i==size || !(res.get(i)==ins)){
                    System.out.println(ins+" "+i+" "+size);
                    res.add(i,ins);
                    result.add(res);
                }*/
            }
        }
        return result;
    }
    
    private List<Integer> cloneList (List<Integer> list){
        List<Integer> result = new ArrayList<>();
        for (Integer i : list){
            result.add(i);
        }
        return result;
    }
}