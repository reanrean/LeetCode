/*
Not sure whether can use pow LOL
*/

class Solution {
    public int mySqrt(int x) {
        double sqrt = Math.pow(x, 0.5);
        return (int) Math.floor(sqrt);
    }
}

/*
Binary Search from n/2
*/

class Solution {
    public int mySqrt(int x) {
        if (x <= 1){
            return x;
        }
        int min = 1;
        int max = x;
        int result = x / 2;
        while (min<max){
            if (x / result == result || (x/result>result && x/(result+1)<(result+1))){
                return result;
            }else if (x / result < result){ //result^2 > x
                max = result;
                result -= Math.max((result - min)/2, 1);
            }else{ //result^2 < x
                min = result;
                result += Math.max((max - result)/2, 1);
            }
        }
        return result;
    }
}