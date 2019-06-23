/*
3C1:
list of 3 elements
4C2:
i=1, 3C1 + 4
i=2, 2C1 + 3
i=3, 1C1 + 2
5C3:
i=1, 4C2 + 5
i=2, 3C2 + 4
i=3, 2C2 + 3
...
*/

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> output = new ArrayList<>();
        if (k > 1){
            for (int i = 1; i <= n; i++){
                List<List<Integer>> lower = combine(n - i, k - 1);
                for (List<Integer> subList : lower){
                    subList.add(n - i + 1);
                    output.add(subList);
                }
            }
        }else{
            for (int i = 1; i <= n; i++){
                List<Integer> subList = new ArrayList<>();
                subList.add(i);
                output.add(subList);
            }
        }
        return output;
    }
}

