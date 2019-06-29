/*
Similar to previous permutation problem
for [1,2,3], on top fo the result of [2,3], duplicate a set and add 1 to each element.
Since the blank element will be duplicated and added 1, no need to add extra 1 and blank element.

Trap:
ConcurrentModificationException will occur if we use for (subList : list)
can use list.size and list.get(i) for list iteration.

Followup:
use 1 and 0 to represent each element status: in subset and not in subset.
nums = [1,2,3]:
1 2 3
0 0 0 -> [     ]
0 0 1 -> [    3]
0 1 0 -> [  2  ]   
0 1 1 -> [  2 3]  
1 0 0 -> [1    ]
1 0 1 -> [1   3] 
1 1 0 -> [1 2  ]
1 1 1 -> [1 2 3]
*/

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> res = new ArrayList<>(); //blank list
        list.add(res);
        if (nums.length == 0) {
            return list;
        }else {
            return appendSubsets(nums, list);
        }
    }
    
    private List<List<Integer>> appendSubsets(int[] nums, List<List<Integer>> list) {
        int nLen = nums.length;
        if (nLen == 1) {
            List<Integer> res = new ArrayList<>();
            res.add(nums[0]);
            list.add(res);
            return list;
        }
        else {
            List<List<Integer>> next = appendSubsets(Arrays.copyOfRange(nums, 0, nLen-1), list);
            int listLen = next.size();
            for (int i = 0; i < listLen; i++) {
                List<Integer> res = cloneList(next.get(i));
                res.add(nums[nLen-1]);
                list.add(res);
            }
            return list;
        }
    }
    
    private List<Integer> cloneList(List<Integer> list){
        List<Integer> res = new ArrayList<>();
        for (Integer i : list){
            res.add(i);
        }
        return res;
    }
}