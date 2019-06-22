/*
The key point is how to know the window contains all the letters.
Approach 1. use HashMap to record appear times for each letter in t
Approach 2. use an int[] to record in ascii
Approach 3. use string operation? seems not efficient?
*/

/*
https://leetcode.wang/leetCode-76-Minimum-Window-Substring.html
Approach 2 is very hard to think:
first initialize counts in t,
-1 every time when left and right covers any character in s,
if any character count > 0, that means it does not cover t.
use a count(tLen) to record how many words we lack to cover t.
*/

class Solution {
    public String minWindow(String s, String t) {
        int[] ts = new int[58];
        int tLen = t.length();
        int sLen = s.length();
        for (int i = 0; i < tLen; i++){
            int c = t.charAt(i) - 'A';
            ts[c]++;
        }
        int left = 0;
        int right = 0;
        int outLeft = -1;
        int outRight = -1;
        while (right < sLen){
            int c = s.charAt(right) - 'A';
            ts[c]--;
            if (ts[c] >= 0){
                tLen--;
            }
            
            while (tLen == 0){
                if ((outLeft == -1 && outRight == -1) || //first time
                    (right - left < outRight - outLeft) ){ //less window
                    outLeft = left;
                    outRight = right;
                }
                int l = s.charAt(left) - 'A';
                ts[l]++;
                if (ts[l] > 0){
                    tLen++;
                }
                left++;
            }
            right++;
        }
        if (outLeft == -1 && outRight == -1){
            return "";
        }else{
            return s.substring(outLeft, outRight+1);
        }
    }
}