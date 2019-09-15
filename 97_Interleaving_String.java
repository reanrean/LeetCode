/*Time Limit Exceeded*/

class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int s1Len = s1.length();
        int s2Len = s2.length();
        int s3Len = s3.length();
        if (s1Len + s2Len != s3Len) {
            return false;
        }
        if (s1Len == 0) {
            return s3.equals(s2);
        } else if (s2Len == 0) {
            return s3.equals(s1);
        } else {
            return (s3.charAt(0) == s1.charAt(0) && isInterleave(s1.substring(1), s2, s3.substring(1))) ||
                (s3.charAt(0) == s2.charAt(0) && isInterleave(s1, s2.substring(1), s3.substring(1)));
        }
    }
}

/*Note: remember to use memoization when there are a lot of re-calculations*/

class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int s1Len = s1.length();
        int s2Len = s2.length();
        int s3Len = s3.length();
        if (s1Len + s2Len != s3Len) {
            return false;
        }
        HashMap<String, Boolean> map = new HashMap<>();
        return isInterleaveMap(s1, s2, s3, map);
    }
    
    private boolean isInterleaveMap(String s1, String s2, String s3, HashMap<String, Boolean> map) {
        int s1Len = s1.length();
        int s2Len = s2.length();
        int s3Len = s3.length();
        if (map.containsKey(s1Len + "/" + s2Len)) {
            return map.get(s1Len + "/" + s2Len);
        }
        if (s1Len == 0) {
            map.put(s1Len + "/" + s2Len, true);
            return s3.equals(s2);
        } else if (s2Len == 0) {
            map.put(s1Len + "/" + s2Len, true);
            return s3.equals(s1);
        } else {
            if ((s3.charAt(0) == s1.charAt(0) && isInterleaveMap(s1.substring(1), s2, s3.substring(1), map)) ||
                (s3.charAt(0) == s2.charAt(0) && isInterleaveMap(s1, s2.substring(1), s3.substring(1), map))) {
                map.put(s1Len + "/" + s2Len, true);
                return true;
            } else {
                map.put(s1Len + "/" + s2Len, false);
                return false;
            }
        }
    }
}