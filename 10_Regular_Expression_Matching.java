/*
It is a very difficult question. I cannot think of a solution by myself 
so this is the algorithm of LC. 

I tried to use less checking against the solution but dont know why it takes more time.
*/

class Solution {
    public boolean isMatch(String s, String p) {
        //System.out.println("isMatch: s="+s+" p="+p+" ");
        int sLen = s.length();
        int pLen = p.length();
        
        if (pLen==0) {
            return sLen==0;
        }
        int WC = p.indexOf('*'); //WC must =-1 or >=1
        int matchLen = Math.min(sLen,(WC<0 ? pLen : WC-1));
        for (int i=0; i<matchLen; i++){ //check characters before WC first
            if (s.charAt(i)!=p.charAt(i) && p.charAt(i)!='.'){
                return false;
            }
        }
        if (WC==1){
            if (isMatch(s,p.substring(2))) {
                return true;
            }
            else{
                if (sLen>0){
                    return ((s.charAt(0)==p.charAt(0)||p.charAt(0)=='.') && isMatch(s.substring(1),p));
                }
                else {
                    return false;
                }
            }
        }
        else if (WC>0){
            if (sLen<WC-1) {
                return false;
            }
            else {
                return isMatch(s.substring(WC-1),p.substring(WC-1));
            }
        }
        else{
            return pLen==sLen;
        }
    }
}