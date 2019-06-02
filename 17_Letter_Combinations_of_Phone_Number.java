class Solution {
    public List<String> letterCombinations(String digits) {
        Map<Character, String> map = new HashMap<Character, String>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        List<String> res = new ArrayList<String>();
        for (int i=0; i<digits.length(); i++){
            res = addPref(res, map.get(digits.charAt(i)));
        }
        return res;
    }
    
    public List<String> addPref(List<String> list, String s) {// add each char in s as prefix
        if(list.isEmpty()){
            for (int i=0; i<s.length(); i++){
                list.add("" + s.charAt(i));
            }
            return list;
        }else{
            List<String> newList = new ArrayList<String>();
            Iterator<String> it = list.iterator();
            while (it.hasNext()){
                String sCur = it.next();
                for (int i=0; i<s.length(); i++){
                    newList.add(sCur + s.charAt(i));
                }
            }
            return newList;
        }
    }
}