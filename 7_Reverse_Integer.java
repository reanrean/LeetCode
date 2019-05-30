/*
use stack instead of array!
*/

class Solution {
    public int reverse(int x) {
        int sign = (x<0 ? -1 : 1);
        int out = 0;
        Stack<Integer> st = new Stack<Integer>();
        
        while(x!=0){
            st.push(Math.abs(x%10));
            x /= 10;
        }
        int tens = 1;
        while (!st.empty()){
            if (tens>Integer.MAX_VALUE/10 && out>Integer.MAX_VALUE%tens && st.peek()>=2 && sign==1){
                return 0;
            }else if (tens>Integer.MAX_VALUE/10 && out>Integer.MAX_VALUE%tens+1 && st.peek()>=2 && sign==-1){
                return 0;
            }
            out += st.pop() * tens;
            tens *= 10;
        }
        
        return out*sign;
    }
}

/*
but not yet the fastest and uses an extra stack.
similar algorithm as solution provided:

the important idea is to know Integer.MAX_VALUE=2147483647 and Integer.MIN_VALUE=-2147483648
and handle overflow.
*/

class Solution {
    public int reverse(int x) {
        int out = 0;
        while(x!=0){
            //System.out.println(out);
            if (Math.abs(out)>Integer.MAX_VALUE/10){
                return 0;
            }
            else if (Math.abs(out)==Integer.MAX_VALUE/10){
                if ((out>0 && x>6) || (out<0 && x<-7)){
                    return 0;
                }
            }
            out *= 10;
            out += x%10;
            x /= 10;
        }
        return out;
    }
}