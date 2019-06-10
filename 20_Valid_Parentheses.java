/*
Note: Need to beware of two corner cases: "(" and ")"
*/

class Solution {
    public boolean isValid(String s) {
        int sLen = s.length();
        Stack<Character> stack = new Stack<>();
        for (int i=0; i<sLen; i++){
            Character c = s.charAt(i);
            if (c=='(' || c=='[' || c=='{'){
                stack.push(c);
            }
            else{
                if (stack.empty()){
                    return false;
                }
                Character top = stack.peek();
                if ((c==')' && top=='(') || (c==']' && top=='[') || (c=='}' && top=='{')){
                    stack.pop();
                }
                else{
                    return false;
                }
            }
        }
        if (stack.empty()){
            return true;
        }
        else{
            return false;
        }
    }
}