class Solution {
    public boolean isValid(String S) {
        while(S.indexOf("abc") >= 0){
            if (S.equals("abc")) {
                return true;
            }
            S = String.join("",S.split("abc"));
        }
        if (S.equals("")) {
            return true;
        }
        return false;
    }
}