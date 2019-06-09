/*
Sort each string by character, and then use the sorted result as key,
add them to the map, so anagrams has same key in map.

Note: 
- use str.toCharArray() and Arrays.toString(arr) to swich from array and string directly;
- use List<String> as map element directly.
*/

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;
        List<List<String>> result  = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < n; i++){
            String sorted = sortString(strs[i]);
            if (map.containsKey(sorted)){
                map.get(sorted).add(strs[i]);
            }else{
                List<String> res = new ArrayList<>();
                res.add(strs[i]);
                map.put(sorted, res);
                result.add(res);
            }
        }
        return result;
    }
    
    private String sortString(String str){
        char[] arr = str.toCharArray();
        Arrays.sort(arr);
        return Arrays.toString(arr);
    }
}