/*
- To avoid overflow of Math.abs(Integer.MIN_VALUE), plus power 1 at last
- For negative power, calculate 1/x at last
- To avoid Time Limit Exceeded, power/2 every time. For those not 2's multiple:
  e.g. x = 2, power = 7:
       2^7 = 2^(2(2+1)+1) = 2*(2*2) * 2*2 * 2
  Therefore, use rem to save the extra 2*2 and 2
*/
class Solution {
    public double myPow(double x, int n) {
        if (n==0) {
            return 1;
        }
        boolean plusOne = false;
        boolean neg = n < 0;
        if (n==Integer.MIN_VALUE){
            plusOne = true;
            n = Integer.MAX_VALUE;
        }
        n = Math.abs(n);
        double output = x;
        double rem = 1;
        while (n/2 > 0){
            if (n%2 > 0) {
                rem = rem * output;
            }
            output = output * output;
            n = n/2;
        }
        output = output * rem;
        if (plusOne) {
            output = output * x;
        }
        if (neg) {
            output = 1 / output;
        }
        return output;
    }
}