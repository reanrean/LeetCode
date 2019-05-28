class Solution {
    public int[] twoSum(int[] nums, int target) {
        int result[]=new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i=0; i<nums.length; i++) {
            int a = nums[i];
            int b = target - a;
            if (map.containsKey(b)) {
                int bKey = map.get(b);
                if (i==bKey) {
                    continue;
                }
                result[0] = i;
                result[1] = bKey;
                break;
            }
        }
        return result;
    }
}

/*
Note: 
Use HashMap, and put(number, key) to get the reverse relationship quickly.
Avoid self-reference, i.e. target = 2*a

Further question: Difference between HashMap, HashSet, HashTable?
- https://blog.csdn.net/wds1181977/article/details/51424839
- HashSet no keys, not allow duplicates
- HashTable is dictionary and HashMap is map
- HashTable is synchronized, safe to use in multi-thread environment,
  While HashMap is not synchronized, faster
- HashMap allows null while HashTable not
- ...
*/