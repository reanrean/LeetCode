/*
https://leetcode.com/problems/longest-valid-parentheses/solution/
Very hard logic. Cannot think of it!
*/

class Solution {
    public int longestValidParentheses(String s) {
        int result = 0;
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(-1);
        for (int i=0; i<s.length(); i++){
            if (s.charAt(i)=='('){
                stack.push(i);
            }else{
                stack.pop();
                if (stack.empty()){
                    stack.push(i);
                }else{
                    int current = i - stack.peek();
                    result = Math.max(current, result);
                }
            }
        }
        return result;
    }
}