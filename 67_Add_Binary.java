class Solution {
    public String addBinary(String a, String b) {
        int aLen = a.length();
        int bLen = b.length();
        int carry = 0;
        String result = "";
        for (int i=1; i<=Math.max(aLen,bLen)+1; i++){
            int aVal = i>aLen ? 0 : a.charAt(aLen-i) - '0';
            int bVal = i>bLen ? 0 : b.charAt(bLen-i) - '0';
            int sum = aVal + bVal + carry;
            if (sum>=2){
                sum -= 2;
                carry = 1;
            }else{
                carry = 0;
            }
            result = sum + result;
        }
        while (result.charAt(0)=='0' && result.length()>1){
            result = result.substring(1);
        }
        return result;
    }
}