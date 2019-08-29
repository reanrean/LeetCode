/*
89_Gray_Code

n=3

000
001
011
010
110
111
101
100

it is actually addition.
i = 0, output is 0 by default. 
i = 1, add 2^0=1 to each element, 0 -> 0 1.
i = 2, add 2^1=2 to each element (reversely), 0 1 -> 0 1 1+2 0+2 -> 0 1 3 2
i = 3, add 2^2=4 to each element (reversely), 0 1 3 2 -> 0 1 3 2 2+4 3+4 1+4 0+4
*/

class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<Integer>();
        int out = 0;
        result.add(out);
        for (int i = 1; i <= n; i++) {
            int curLen = result.size();
            for (int j = curLen - 1; j >= 0; j--) {
                out = result.get(j)+(int)Math.pow(2, i - 1);
                result.add(out);
            }
        }
        return result;
    }
}