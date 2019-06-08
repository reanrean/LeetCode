/*
https://leetcode.wang/leetCode-43-Multiply-Strings.html

   123 (i = 0,1,2)
   456 (j = 0,1,2)
------
    18
   12
   6
   15
  10
  5
  12
  8
 4

loop from i and each j,
e.g. i=0 and j=0, sum = 1*4, so sum[i+j]+=0, sum[i+j+1]+=4
     i=3 and j=3, sum = 3*6, so sum[i+j]+=1, sum[i+j+1]+=8
There will be another problem of the sum of sum[x]>=10, 
to solve it, do one carry again before printint output.
Use StringBuilder to speed up.
*/
 
class Solution {
    public String multiply(String num1, String num2) {
        int Len1 = num1.length();
        int Len2 = num2.length();
        int[] sum = new int[Len1+Len2];
        for (int i=0; i<Len1; i++){
            int n1 = num1.charAt(i) - '0';
            for (int j=0; j<Len2; j++){
                int n2 = num2.charAt(j) - '0';
                int mult = n1*n2;
                sum[i+j] += mult/10;
                sum[i+j+1] += mult%10;
            }
        }
        for (int i=sum.length-1; i>=0; i--){
            if (sum[i]>=10){
                sum[i-1] += sum[i]/10;
                sum[i] = sum[i]%10;
            }
        }
        StringBuilder output = new StringBuilder();
        for (int i=0; i<sum.length; i++){
            if (output.length()==0 && sum[i]==0 && i!=sum.length-1){
                continue;
            }else{
                output.append(sum[i]);
            }
        }
        return output.toString();
    }
}