class Solution {
    public int romanToInt(String s) {
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        map.put('M',1000);
        map.put('D',500);
        map.put('C',100);
        map.put('L',50);
        map.put('X',10);
        map.put('V',5);
        map.put('I',1);
        int ret = 0;
        int lastVal = 0;
        for (int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            int thisVal = (int)map.get(c);
            if (lastVal<thisVal){
                lastVal = thisVal - lastVal;
            }else{
                ret += lastVal;
                lastVal = thisVal;
            }
        }
        ret += lastVal;
        return ret;
    }
}