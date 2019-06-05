/*
possible traps:
- haystack = 12342345, needle = 2345, if count from i=2 will get false
- haystack = 12342345, needle = 3456, i+j out of haystack.length
*/

class Solution {
    public int strStr(String haystack, String needle) {
        int nLen = needle.length();
        int hLen = haystack.length();
        if (nLen==0){
            return 0;
        }
        if (hLen==0){
            return -1;
        }
        int meet = 0;
        for (int i=0; i<hLen; i++){
            if (haystack.charAt(i) == needle.charAt(0)){
                if (i+nLen > hLen){
                    return -1;
                }
                meet = 0;
                for (int j=0; j<nLen; j++){
                    if (haystack.charAt(i+j)!=needle.charAt(j)){
                        break;
                    }else{
                        meet++;
                    }
                }
                if (meet == nLen) {
                    return i;
                }
            }
        }
        return -1;
    }
}