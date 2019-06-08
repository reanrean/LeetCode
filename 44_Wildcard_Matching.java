/*
This solution will cause Time Limit Exceeded....
*/
class Solution {
    public boolean isMatch(String s, String p) {
        //System.out.println("s "+s+" p "+p);
        int sLen = s.length();
        int pLen = p.length();
        if (pLen==0){
            return sLen==0;
        }
        for (int i=0; i<pLen; i++){
            if (p.charAt(i)=='*'){
                int j = i+1;
                while(pLen>j && p.charAt(j)=='*'){
                    j++;
                }
                if (j>i+1){
                    p = p.substring(0,i+1) + p.substring(j);
                    pLen -= (j-i-1);
                }
                return ( (sLen>i && isMatch(s.substring(i+1),p.substring(i))) 
                    || (sLen>=i && pLen>i && isMatch(s.substring(i), p.substring(i+1))) );
            }else if(i==pLen-1 && sLen!=pLen) {
                return false;
            }else if(sLen>i && (p.charAt(i)==s.charAt(i) || p.charAt(i)=='?')) {
                continue;
            }else {
                return false;
            }
        }
        return true;
    }
}

/*
Solution 2 at 
https://leetcode.wang/leetCode-44-Wildcard-Matching.html
*/

class Solution {
    public boolean isMatch(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();
        if (pLen==0){
            return sLen==0;
        }
        int si = 0;
        int pi = 0;
        int markp = -1;
        int marks = -1;
        while (si < sLen){
            if (pi<pLen && (p.charAt(pi)==s.charAt(si) || p.charAt(pi)=='?')) {
                si++;
                pi++;
            }else if (pi<pLen && p.charAt(pi)=='*'){
                markp = pi;
                marks = si;
                pi++;
            }else if(markp>-1) {
                pi = markp + 1;
                marks++;
                si = marks;
            }else {
                return false;
            }
        }
        while (pi<pLen && p.charAt(pi)=='*'){
            pi++;
        }
        return pi==pLen;
    }
}