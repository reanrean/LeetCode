/*
The solution is from my own thoughts.
For normal binary addition, 1 + 1 = 1 0 where a carry is added to the next bit.
For negabinary, the carry will be negative of a normal carry: 1 + 1 = -1 0.
For -1, we need to "borrow" 1 from higher bits, which causes a +1 carry in higher bits.
Thus, 1 + 1 = -1 0 = 1 1 0.
1 1 0 means 4-2 = 2 = 1+1.
*/

class Solution {
    public int[] addNegabinary(int[] arr1, int[] arr2) {
        int longLen = Math.max(arr1.length, arr2.length);
        int shortLen = Math.min(arr1.length, arr2.length);
        if (arr1.length<arr2.length){
            int[] temp = arr1;
            arr1 = arr2;
            arr2 = temp;
        }
        int[] res1 = new int[longLen+2];
        int carry = 0;
        for (int i=0; i<longLen+2; i++){
            int num1 = (i>=longLen? 0 : arr1[longLen-1-i]);
            int num2 = (i>=shortLen? 0 : arr2[shortLen-1-i]);
            int sum = num1 + num2 + carry;
            if (sum>=2){
                sum -= 2;
                carry = -1;
            }else if (sum<0){
                sum += 2;
                carry = 1;
            }else{
                carry = 0;
            }
            //System.out.println(num1+" "+num2+" carry " +carry+" sum "+sum);
            res1[i] = sum;
        }
        int zeros = 0;
        for (int i=longLen+1; i>0; i--){
            if (res1[i]==0){
                zeros++;
            }else{
                break;
            }
        }
        int[] res = new int[longLen+2-zeros];
        for (int i=0; i<res.length; i++){
            res[i] = res1[longLen+1-zeros-i];
        }
        return res;
    }
}