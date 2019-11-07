class Solution {
    public boolean checkValidString(String s) {
        int sLen = s.length();
        int lo = 0;
        int hi = 0;
        for (int i = 0; i < sLen; i++){
            char c = s.charAt(i);
            if (c == '(') {
                lo++;
                hi++;
            }
            if (c == ')') {
                lo--;
                hi--;
            }
            if (c == '*') {
                lo--;
                hi++;
            }
            if (hi < 0) return false;
            lo = Math.max(lo, 0);
        }
        return lo == 0;
    }
}