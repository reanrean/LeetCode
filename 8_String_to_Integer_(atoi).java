/*
Note: got wrong again to determine whether integer out of range!!!!

And take a clear look at the requirement.
*/

class Solution {
    public int myAtoi(String str) {
        int out = 0;
        int sLen = str.length();
        int sign = 1;
        boolean hasNumber = false;
        boolean hasSign = false;
        for (int i=0; i<sLen; i++){
            char c = str.charAt(i);
            int ascii = (int)c;
            if (ascii==32 && !(hasNumber||hasSign)){
                continue;
            }
            if (c=='-'||c=='+'){
                if (hasNumber||hasSign){
                    break;
                }
                else {
                    hasSign = true;
                    if (c=='-'){
                        sign = -1;
                    }
                }
            }
            else if (!(ascii>=48 && ascii<=57)) {
                break;
            }
            else { //if (ascii>=48 && ascii<=57)
                int thisNum = ascii-48;
                if (out>Integer.MAX_VALUE/10){
                    if (sign==1) {
                        return Integer.MAX_VALUE;
                    }
                    else {
                        return Integer.MIN_VALUE;
                    }
                }
                else if (out==Integer.MAX_VALUE/10){
                    if (sign==1 && thisNum>Integer.MAX_VALUE%10){
                        return Integer.MAX_VALUE;
                    }
                    else if (sign==-1 && thisNum>Integer.MAX_VALUE%10+1){
                        return Integer.MIN_VALUE;
                    }
                }
                if (hasNumber){
                    out *= 10;
                }
                out += thisNum;
                hasNumber = true;
            }
        }
        return out*sign;
    }
}