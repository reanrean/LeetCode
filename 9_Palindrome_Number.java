/*
Note: my solution reverted the whole number.
But solution on LC reverted only half.
*/

class Solution {
    public boolean isPalindrome(int x) {
        if (x<0) return false;
        int rev = 0;
        int xTmp = x;
        while (xTmp!=0){
            rev *= 10;
            rev += xTmp%10;
            xTmp /= 10;
        }
        if (rev==x) {
            return true;
        } 
        else {
            return false;
        } 
    }
}