/*
For n unique numbers, all subsets is equal to subset of n-1 numbers + (each subset of n-1 numbers + the nth number).
For the case where n-1th number = nth number, all subsets is equal to subset of n-1 numbers + (each increment of subset at n-1th number + the nth number).
Trap: 
- note the linkage to objects. New an arraylist anytime!
- for the first element, [] is previous set and nums[0] is the increment set.
*/

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        result.add(subset);
        if (nums.length == 0) {
            return result;
        }
        Arrays.sort(nums);
        List<List<Integer>> incre = new ArrayList<>();
        subset = new ArrayList<>();
        subset.add(nums[0]);
        incre.add(subset);
        return genSubset(result, incre, 1, nums);
    }
    
    private List<List<Integer>> genSubset(List<List<Integer>> prevSubsets, List<List<Integer>> increSubsets, int curIdx, int[] nums) {
        if (curIdx >= nums.length) {
            return combineSets(prevSubsets, increSubsets);
        }
        List<List<Integer>> newSubsets = new ArrayList<>();
        for (List<Integer> set : increSubsets) {
            List<Integer> newSet = new ArrayList<>(set);
            newSubsets.add(newSet);
        }
        if (nums[curIdx] != nums[curIdx - 1]) {
            for (List<Integer> set : prevSubsets) {
                List<Integer> newSet = new ArrayList<>(set);
                newSubsets.add(newSet);
            }
        }
        //System.out.println("curIdx="+curIdx+" " + newSubsets.size());
        for (List<Integer> set : newSubsets) {
            set.add(nums[curIdx]);
        }
        return genSubset(combineSets(prevSubsets, increSubsets), newSubsets, curIdx + 1, nums);
    }
    
    private List<List<Integer>> combineSets(List<List<Integer>> setsA, List<List<Integer>> setsB) {
        for (List<Integer> set : setsB) {
            setsA.add(set);
        }
        return setsA;
    }
}