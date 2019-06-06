/*
https://leetcode.wang/leetCode-30-Substring-with-Concatenation-of-All-Words.html

use the same logic, but not fast enough
*/

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<Integer>();
        int wNum = words.length;
        int sLen = s.length();
        if (wNum == 0 || sLen == 0){
            return result;
        }
        int wLen = words[0].length();
        if (wLen == 0){
            return result;
        }
        int subLen = wLen * wNum;
        List<Integer> skip = new ArrayList<Integer>();
        
        Map<String,Integer> allWords = new HashMap<String,Integer>();
        for (String w : words){
            int times = allWords.getOrDefault(w, 0);
            allWords.put(w, times+1);
        }
        
        Map<String,Integer> containWords = new HashMap<String,Integer>();
        for (int i = 0; i<=(sLen - subLen); i++) {
            if (skip.contains(i)){
                continue;
            }
            containWords.clear();
            int j = 0;
            for (j = 0; j<wNum; j++){
                String check = s.substring(i + j*wLen, i + (j+1)*wLen);
                if (allWords.containsKey(check)){
                    int times = containWords.getOrDefault(check, 0);
                    containWords.put(check, times+1);
                    if (times+1 > allWords.get(check)){
                        String sub = s.substring(i, i+subLen);
                        int appear = sub.indexOf(check)/wLen;
                        for (int k=0; k<appear; k++){ // skip until passed this word
                            skip.add(i + k*wLen);
                        }
                        break;
                    }
                }else{
                    for (int k=1; k<j; k++){ // skip until passed this word
                        skip.add(i + k*wLen);
                    }
                    break;
                }
            }
            if (j==wNum){
                result.add(i);
            }
        }
        return result;
    }
}

/*
optimized a little
*/

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<Integer>();
        int wNum = words.length;
        int sLen = s.length();
        if (wNum == 0 || sLen == 0){
            return result;
        }
        int wLen = words[0].length();
        if (wLen == 0){
            return result;
        }
        int subLen = wLen * wNum;
        
        Map<String,Integer> allWords = new HashMap<String,Integer>();
        for (String w : words){
            int times = allWords.getOrDefault(w, 0);
            allWords.put(w, times+1);
        }
        
        Map<String,Integer> containWords = new HashMap<String,Integer>();
        for (int move = 0; move < wLen; move++){
            for (int i = move; i<=(sLen - subLen); i+=wLen) {
                containWords.clear();
                int j = 0;
                for (j = 0; j<wNum; j++){
                    String check = s.substring(i + j*wLen, i + (j+1)*wLen);
                    if (allWords.containsKey(check)){
                        int times = containWords.getOrDefault(check, 0);
                        containWords.put(check, times+1);
                        if (times+1 > allWords.get(check)){
                            String sub = s.substring(i, i+subLen);
                            int appear = sub.indexOf(check);
                            i += appear;
                            break;
                        }
                    }else{
                        i += j*wLen;
                        break;
                    }
                }
                if (j==wNum){
                    result.add(i);
                }
            }
        }
        return result;
    }
}

/*
to study:
https://leetcode.com/problems/substring-with-concatenation-of-all-words/discuss/303362/Java-7ms-with-single-map
*/