/*
Horizontal Scanning (with recursion)
*/
//Since there is no slice in Java, it's not efficient. I will give it in JavaScript.

/*
Vertical Scanning
*/

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length==0) {
            return "";
        }
        else if (strs.length==1){
            return strs[0];
        }
        String pref = "";
        int minLen = strs[0].length();
        for (int i=1; i<strs.length; i++){
            minLen = Math.min(minLen, strs[i].length());
        }
        for (int j=0; j<minLen; j++){
            char c = strs[0].charAt(j);
            for (int i=1; i<strs.length; i++){
                if (strs[i].charAt(j)!=c){
                    return pref;
                }
            }
            pref += c;
        }
        return pref;
    }
}