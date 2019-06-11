/*
For n=3, total 1*2*3=6 numbers, first 6/3=2 start with 1
For n=4, total 1*2*3*4=24 numbes, first 24/4=6 start with 1, the 6 numbers are permutation of 2,3,4. 
With in the 6 numbers, first 6/3=2 start with 2.
*/

class Solution {
    public String getPermutation(int n, int k) {
        int p = 1;
        StringBuilder numbers = new StringBuilder();
        for (int i = 1; i <= n; i++){
            p *= i;
            numbers.append(i);
        }
        
        StringBuilder result = new StringBuilder();
        k--;
        for (int i = 0; i < n; i++){
            p /= (n - i);
            int parts = k / p;
            //parts range from 0 to n-1
            result.append(numbers.charAt(parts));
            numbers.delete(parts, parts + 1);
            k = k % p;
        }
        
        return result.toString();
    }
}