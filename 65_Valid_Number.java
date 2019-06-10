/*
By observation, we know that the number part before e and after e has different rules
number after e doesn't allow signs, while other conditions all the same.
Then we can write another isNumber function to check two parts (before and after e) separately.
*/

class Solution {
    public boolean isNumber(String s) {
        s = s.trim();
        //only leading and trailing spaces are allowed
        if (s.length() == 0){
            return false;
        }
        int idx = s.indexOf('e');
        if (idx > -1){
            return (isNumberSplit(s.substring(0,idx), true) && isNumberSplit(s.substring(idx+1), false));
        }else{
            return isNumberSplit(s, true);
        }
        //split by e: before e, sign+number+point+number; after e, sign+number
    }
    
    private boolean isNumberSplit(String s, boolean allowDecimal) {
        int sLen = s.length();
        if (sLen == 0){
            return false;
        }
        if (!allowDecimal){
            if (s.indexOf('.') > -1){
                return false;
            }
        }
        boolean hasSign = false;
        boolean hasNumber = false;
        boolean hasDecimal = false;
        for (int i = 0; i < sLen; i++){
            char c = s.charAt(i);
            if (!(c=='.' || c=='+' || c=='-' || (c-'0'>=0 && c-'0'<=9))){
                return false;
            }else if (c=='+' || c=='-'){
                if (hasSign || hasNumber || hasDecimal){
                    return false;
                }else{
                    hasSign = true;
                }
            }else if (c=='.'){
                if (hasDecimal){
                    return false;
                }else{
                    hasDecimal = true;
                }
            }else { //c = 0-9
                hasNumber = true;
            }
        }
        return hasNumber;
    }
}