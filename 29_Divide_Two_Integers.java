/*
A not efficient solution. 
*/

class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == 0) {
            return 0;
        }
        if (divisor == 1 ){
            return dividend;
        }
        if (divisor == -1 && dividend == Integer.MIN_VALUE) {
            return Integer.MAX_VALUE;
        }
        int output = 0;
        int div1 = dividend;
        if (dividend<0){
            while (div1<0){
                if (divisor<0){
                    div1 -= divisor;
                    if (div1<=0) output ++;
                }else{
                    div1 += divisor;
                    if (div1<=0) output --;
                }
            }
        }else {
            while (div1>0){
                if (divisor>0){
                    div1 -= divisor;
                    if (div1>=0) output++;
                }else{
                    div1 += divisor;
                    if (div1>=0) output--;
                }
            }
        }
        return output;
    }
}

/*
use binary search to speed up
use negative to avoid overflow
*/

class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == 0) {
            return 0;
        }
        if (divisor == 1 ){
            return dividend;
        }
        if (divisor == -1 && dividend == Integer.MIN_VALUE) {
            return Integer.MAX_VALUE;
        }
        
        boolean neg = false;
        if ((dividend<0 && divisor>0) || (dividend>0 && divisor<0)){
            neg = true;
        }
        
        dividend = dividend>0 ? -dividend : dividend;
        divisor = divisor>0 ? -divisor : divisor;
        
        int output = negDivide(dividend, divisor);
        
        return neg? -output : output;
    }
    
    public int negDivide(int dividend, int divisor){
        if (dividend>divisor){ //abs(dividend)<abs(multiple)
            return 0;
        }
        int multiple = divisor;
        int output = 1;
        while(dividend - multiple < multiple){
            multiple += multiple;
            output += output;
        }
        dividend = dividend - multiple;
        return output + negDivide(dividend, divisor);
    } 
}