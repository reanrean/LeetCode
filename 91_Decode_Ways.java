/*
Take 1122 as an example, it can be 1 + f(122) and 11 + f(22).
Thus, we can use recursion to decode the string.
Trap: 
- defind s.charAt(1) <= 6 still need to use ascii code.
- beware when s.charAt(0) == '0'
*/

class Solution {
    public int numDecodings(String s) {
        int sLen = s.length();
        if (sLen > 0 && s.charAt(0) == '0') {
            return 0;
        } 
        if (sLen <= 1) {
            return 1;
        }
        if (s.charAt(0) == '1') {
            return numDecodings(s.substring(1)) + numDecodings(s.substring(2));
        } else if (s.charAt(0) == '2' && s.charAt(1) - 48 <= 6) {
            return numDecodings(s.substring(1)) + numDecodings(s.substring(2));
        } else {
            return numDecodings(s.substring(1));
        }
    }
}