/*
Very simple solution to add one only in last digit and calculate carry.
Note the method of copy array is different to Arrays.copyOfRange
*/

class Solution {
    public int[] plusOne(int[] digits) {
        int nLen = digits.length;
        int carry = 0;
        for (int i = nLen - 1; i >= 0; i--){
            if (i == nLen - 1){
                digits[i] = digits[i] + 1 + carry;
            }else{
                digits[i] = digits[i] + carry;
            }
            if (digits[i] >= 10){
                carry = digits[i] / 10;
                digits[i] = digits[i] % 10;
            }else{
                carry = 0;
            }
        }
        if (carry > 0){
            int[] newDigits = new int[nLen + 1];
            System.arraycopy(digits, 0, newDigits, 1, nLen);
            newDigits[0] = carry;
            return newDigits;
        }else{
            return digits;
        }
    }
}