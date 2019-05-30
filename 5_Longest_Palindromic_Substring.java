class Solution {
    public String longestPalindrome(String s) {
        //a solution with Approach 4: Expand Around Center
        int sLen = s.length();
        if(sLen==0){
            return s;
        }
        int outLen = 0;
        int outLen2 = 0;
        int center = 0;
        int center2 = 0;
        String out = "";
        for (int i=0; i<sLen; i++){
            //center: letter
            int maxSide = Math.min(i, sLen-i-1);
            int currMax = 1;
            //String curr = "" + s.charAt(i);
            for (int j=1; j<=maxSide; j++){
                if (s.charAt(i-j)==s.charAt(i+j)){
                    currMax += 2;
                    //curr = s.charAt(i-j) + curr + s.charAt(i-j);
                }else{
                    break;
                }
            }
            if(currMax > outLen){
                outLen = currMax;
                center = i;
                //out = curr;
            }
            //center: between letter
            maxSide = Math.min(i+1, sLen-i-1);
            int currMax2 = 0;
            //curr = "";
            for (int j=0; j<maxSide; j++){
                if (s.charAt(i-j)==s.charAt(i+j+1)){
                    currMax2 += 2;
                    //curr = s.charAt(i-j) + curr + s.charAt(i+j+1);
                }else{
                    break;
                }
            }
            if(currMax2 > outLen2){
                outLen2 = currMax2;
                center2 = i;
                //out = curr;
            }
        }
        if(outLen>outLen2){
            out = s.substring(center-outLen/2, center+outLen/2+1);
        }else{
            out = s.substring(center2-outLen2/2+1, center2+outLen2/2+1);
        }
        return out;
    }
}


/*
a good analysis:
https://leetcode.windliang.cc/leetCode-5-Longest-Palindromic-Substring.html

Note:
1) substring(startIndex, endIndex) 
   where startIndex is inclusive, and endIndex is notinclusive!

2) if use out to record everytime, runtime error will occur. 
   need to use as less operations as possible. 

3) beware in counting. I always commit mistakes in maxSide counting etc.

4) the code in the analysis only use 6 ms while mine use 31 ms. 
   next challenge: minimized the difference!
*/