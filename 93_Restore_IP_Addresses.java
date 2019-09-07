/*
use recursion: find the possible first digit, e.g. 255/25/2, then see whether the rest digits are able to form ip address.

25525511135
-> 2 + "5525511135" x (too long)
-> 25 + "525511135" x (525 is bad)
-> 255 + "25511135"
        -> 2 + "5511135" x (too long)
        -> 25 + "511135" x (511 is bad)
        -> 255 + "11135"
                -> 1 + "1135" x (too long)
                -> 11 + "135" good
                -> 111 + "35" good

Trap: 
- length too short in for() loop
- ip will not start with 0
*/

class Solution {
    public List<String> restoreIpAddresses(String s) {
        return restoreHelper(s, 4);
    }
    
    private List<String> restoreHelper(String s, int num) {
        List<String> list = new ArrayList<>();
        int sLen = s.length();
        if (sLen > num * 3 || sLen < num) { //length checking
            return list;
        }
        if (sLen == num * 3) { //check first number if full length
            if (Integer.parseInt(s.substring(0, 3)) > 255) {
                return list;
            }
        }
        if (num == 1) {
            if (s.charAt(0) == '0' && sLen > 1) {
                
            }
            else if (Integer.parseInt(s) <= 255) {
                list.add(s);
            }
            return list;
        }
        for (int i = 1; i <= 3; i++) {
            if (sLen < i) {
                break;
            }
            if (s.charAt(0) == '0' && i > 1) {
                break;
            }
            if (Integer.parseInt(s.substring(0, i)) <= 255) {
                List<String> subList = restoreHelper(s.substring(i), num - 1);
                if (subList.size() > 0) { //sublist is possible to consist of ip
                    for (String item : subList) {
                        list.add(s.substring(0, i) + "." + item);
                    }
                }
            }
        }
        return list;
    }
}