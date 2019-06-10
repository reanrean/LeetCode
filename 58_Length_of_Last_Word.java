/*
Beware of the input "a " so trim first.
*/

class Solution {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        String lastWord = s.substring(s.lastIndexOf(" ")+1);
        return lastWord.length();
    }
}