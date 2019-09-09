/*
loop from each number from 1 to n
if i=1, result = numTrees(2~n)
if i=2, result = numTrees(3~n)
if i=3, result = numTrees(1~2) * numTrees(4~n)
...
*/

class Solution {
    public int numTrees(int n) {
        if (n <= 2) {
            return n;
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            if (i == 0 || i == n - 1) {
                result += numTrees(n-1);
            } else if (i == 1 || i == n - 2) {
                result += numTrees(n-2);
            } else {
                result += numTrees(i) * numTrees(n - i - 1);
            }
        }
        return result;
    }
}

/*
To avoid recalculation in recursion
*/
class Solution {
    public int numTrees(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        return numTreesHash(n, map).get(n);
    }
    
    private Map<Integer, Integer> numTreesHash(int n, Map<Integer, Integer> map) {
        if (map.get(n) != null) {
            return map;
        }
        if (n <= 2) {
            map.put(n, n);
            return map;
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            if (i == 0 || i == n - 1) {
                result += numTreesHash(n-1, map).get(n-1);
            } else if (i == 1 || i == n - 2) {
                result += numTreesHash(n-2, map).get(n-2);
            } else {
                result += numTreesHash(i, map).get(i) * numTreesHash(n - i - 1, map).get(n - i - 1);
            }
        }
        map.put(n, result);
        return map;
    }
}

/*
return int instead of map, but didnt improve space utilization.
*/
class Solution {
    public int numTrees(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        return numTreesHash(n, map);
    }
    
    private int numTreesHash(int n, Map<Integer, Integer> map) {
        if (map.get(n) != null) {
            return map.get(n);
        }
        if (n <= 2) {
            return n;
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            if (i == 0 || i == n - 1) {
                result += numTreesHash(n-1, map);
            } else if (i == 1 || i == n - 2) {
                result += numTreesHash(n-2, map);
            } else {
                result += numTreesHash(i, map) * numTreesHash(n - i - 1, map);
            }
        }
        map.put(n, result);
        return result;
    }
}