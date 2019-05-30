/*
numRows=3:
1 3 5
12345
1 3 5

numRows=4:
1  4  7
1 34 67
12 45 7
1  4  7

numRows=5:
1   5   9
1  45  89
1 3 5 7 9
12  56  9
1   5   9

When we convert string sequence into this pattern:
n=1: 1st, 9th(1+4+4), 17th(1+4+4+4+4)
n=2: 2nd(1+2-1), 8th(1+4+4-(2-1)), 10th(1+4+4+(2-1)), 16th(1+4+4+4+4-(2-1)), 18th(1+4+4+4+4+(2-1))
n=3: 3rd(1+3-1), 7th(1+4+4-(3-1)), 11th(1+4+4+(3-1)), 15th(1+4+4+4+4-(3-1)), 19th(1+4+4+4+4+(3-1))
...
n=5: 5th(1+5-1), 13th(1+4+4+(5-1)), 21th(1+4+4+4+4+(5-1))
rewrite n=1 as:
n=1: 1st(1+1-1), 9th(1+4+4+(1-1)), 17th(1+4+4+4+4+(1-1))
we can see they all follow such pattern. 
remove the leading 1 to align with string index, it's still valid.

thus, for an index i in a string, and offset n start with 0:
when i%8=0, n=0
when i%8=1 or 7, n=1
when i%8=2 or 6, n=2
when i%8=3 or 5, n=3
when i%8=4, n=4
where 8=(numRows-1)*2

I can think of two ways to do this:
1) create array of length numRows, and output in sequence *beware of array can be null!
2) use forloop for numRows times.

*/

class Solution {
    public String convert(String s, int numRows) {
        int sLen = s.length();
        String out = "";
        if (numRows<=1) return s;
        int divisor = (numRows-1)*2;
        for (int i=0; i<numRows; i++){
            //System.out.println();
            for (int j=i; j<sLen; j++){
                //System.out.print(j+" ");
                out += s.charAt(j);
                if(i==0 || i==numRows-1){
                    j+=divisor-1; //-1 to offset j++ at the end
                }
                else if(j%divisor==i) {
                    j+=divisor-1-i*2;
                }
                else{//j%divisor==(numRows-i)
                    j+=-1+i*2;
                }
            }
            //System.out.println(out);
        }
        return out;
    }
}

class Solution {
    public String convert(String s, int numRows) {
        int sLen = s.length();
        String out = "";
        if (numRows<=1) return s;
        int divisor = (numRows-1)*2;
        String[] outArr = new String[numRows];
        for (int i=0; i<sLen; i++){
            int rem = i%divisor;
            if (rem>divisor/2) {
                rem = divisor - rem;
            }
            if (outArr[rem]==null){
                outArr[rem] = "";
            }
            outArr[rem] += s.charAt(i);
        }
        for (int i=0; i<numRows; i++){
            if (outArr[i]!=null) out+=outArr[i];
        }
        return out;
    }
}