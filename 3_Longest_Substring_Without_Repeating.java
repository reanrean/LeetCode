class Solution {
    public int lengthOfLongestSubstring(String s) {
        //naive approach
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int maxLen = s.length();
        int maxSize = 0;
        int i,j;
        for (i = 0; i<maxLen; i++){
            for (j = i; j<maxLen; j++){
                char c = s.charAt(j);
                boolean b = map.containsKey(c);
                if (!b){
                    //System.out.println("put:" + c +" i:"+i+" j:"+j);
                    map.put(c, j);
                }
                else {
                    //System.out.println("else i:"+i+" j:"+j);
                    int pos = map.get(c);
                    i = pos;
                    break;
                }
            }
            maxSize = Math.max(maxSize, map.size());
            //System.out.println(map.size());
            map.clear();
            if (j==maxLen) {
                break;
            }
        }
        return maxSize;
    }
}

class Solution {
    public int lengthOfLongestSubstring(String s) {
        //2n times
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int maxLen = s.length();
        int maxSize = 0;
        int start = 0;
        for (int j = 0; j<maxLen; j++){
            char c = s.charAt(j);
            boolean b = map.containsKey(c);
            if (b) {
                maxSize = Math.max(maxSize, map.size());
                //System.out.println(maxSize);
                int pos = map.get(c);
                for (int i=start; i<=pos; i++){
                    map.remove(s.charAt(i));
                }
                start = pos+1;
            }
            //System.out.println("c="+c+" j="+j);
            map.put(c, j);
        }
        maxSize = Math.max(maxSize, map.size());
        return maxSize;
    }
}

class Solution {
    public int lengthOfLongestSubstring(String s) {
        //using optimized logic in solution provided
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int maxLen = s.length();
        int maxSize = 0;
        int start = -1; //to avoid input="", because first input have position=0
        int j;
        for (j = 0; j<maxLen; j++){
            char c = s.charAt(j);
            boolean b = map.containsKey(c);
            if (b) {
                maxSize = Math.max(maxSize, j-1-start); //because maxSize is "previous" character
                //System.out.println(maxSize);
                start = Math.max(start, map.get(c));
            }
            map.put(c, j);
            //System.out.println("put:" + c +" j:"+j);
        }
        maxSize = Math.max(maxSize, j-1-start); //adjustment of j++ at the end
        //System.out.println(maxSize);
        return maxSize;
    }
}