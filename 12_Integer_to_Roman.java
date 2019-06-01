/*
The first solution I can think of is using a map of string (with 4,9 recorded)
LinkedHashMap preserved the insertion order
However, it is not fast or space saving.
*/

class Solution {
    public String intToRoman(int num) {
        Map<Integer,String> map = new LinkedHashMap<Integer,String>();
        map.put(1000,"M");
        map.put(900,"CM");
        map.put(500,"D");
        map.put(400,"CD");
        map.put(100,"C");
        map.put(90,"XC");
        map.put(50,"L");
        map.put(40,"XL");
        map.put(10,"X");
        map.put(9,"IX");
        map.put(5,"V");
        map.put(4,"IV");
        map.put(1,"I");
        String out = "";
        Set<Integer> set = map.keySet();
        Iterator it = set.iterator();
        while(it.hasNext()){
            int i = (int)it.next();
            while(num>=i){
                num -= i;
                out += map.get(i);
            }
        }
        return out;
    }
}