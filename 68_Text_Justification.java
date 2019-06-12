/*
Use stack to store strings and record their total size. 
While the total size reach the limit, pop from stack and add whitespaces accordingly.
Trap: total length = maxWidth, no need add space after it. And it can be the last line!
Followup: use only left and right pointers to record
*/

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        Stack<String> stack  = new Stack<>();
        int sumSize = 0;
        for (int i = 0; i < words.length; i++){
            String s = words[i];
            int len = s.length();
            int stackSize = stack.size();
            if (sumSize + stackSize + len == maxWidth){ //output = "strA strB strC" i=2
                StringBuilder sb = new StringBuilder();
                sb.append(s);
                while (!stack.isEmpty()){
                    sb.insert(0, " ");
                    sb.insert(0, stack.pop());
                }
                result.add(sb.toString());
                sumSize = 0;
            }else if (sumSize + stackSize + len > maxWidth){ //output = "strA   strB" i=2
                int extraSpaces = maxWidth - sumSize;
                StringBuilder sb = new StringBuilder();
                if (stackSize == 1){
                    for (int j = 0; j < extraSpaces; j++){
                        sb.append(" ");
                    }
                    sb.insert(0, stack.pop());
                }else{
                    int insert = stackSize - 1;
                    int each = extraSpaces/insert;
                    int extraEach = extraSpaces%insert;
                    sb.append(stack.pop());
                    while (!stack.isEmpty()){
                        for (int j = 0; j < each; j++){
                            sb.insert(0, " ");
                        }
                        if (stack.size() <= extraEach){ //one more extra space
                            sb.insert(0, " ");
                        }
                        sb.insert(0, stack.pop());
                    }
                }
                result.add(sb.toString());
                stack.push(s);
                sumSize = len;
            }else { //not reach output yet
                stack.push(s);
                sumSize += len;
            }
        }
        if (!stack.isEmpty()){ //last output
            int extraSpaces = maxWidth - sumSize - stack.size();
            StringBuilder sb = new StringBuilder();
            if (extraSpaces < 0){
                sb.append(stack.pop());
            }else{
                for (int j = 0; j < extraSpaces; j++){
                    sb.append(" ");
                }
            }
            while (!stack.isEmpty()){
                sb.insert(0, " ");
                sb.insert(0, stack.pop());
            }
            result.add(sb.toString());
        }
        return result;
    }
}

/*
optimized with less "if"
*/

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        Stack<String> stack  = new Stack<>();
        int sumSize = 0;
        for (int i = 0; i < words.length; i++){
            String s = words[i];
            int len = s.length();
            int stackSize = stack.size();
            if (sumSize + stackSize + len <= maxWidth){ //not reach output yet, even reach do it in next iteration
                stack.push(s);
                sumSize += len;
            }else{
                int extraSpaces = maxWidth - sumSize;
                StringBuilder sb = new StringBuilder();
                if (stackSize == 1){
                    for (int j = 0; j < extraSpaces; j++){
                        sb.append(" ");
                    }
                    sb.insert(0, stack.pop());
                }else{
                    int insert = stackSize - 1;
                    int each = extraSpaces/insert;
                    int extraEach = extraSpaces%insert;
                    sb.append(stack.pop());
                    while (!stack.isEmpty()){
                        for (int j = 0; j < each; j++){
                            sb.insert(0, " ");
                        }
                        if (stack.size() <= extraEach){ //one more extra space
                            sb.insert(0, " ");
                        }
                        sb.insert(0, stack.pop());
                    }
                }
                result.add(sb.toString());
                stack.push(s);
                sumSize = len;
            }
        }
        if (!stack.isEmpty()){ //last output
            int extraSpaces = maxWidth - sumSize - stack.size();
            StringBuilder sb = new StringBuilder();
            if (extraSpaces < 0){
                sb.append(stack.pop());
            }else{
                for (int j = 0; j < extraSpaces; j++){
                    sb.append(" ");
                }
            }
            while (!stack.isEmpty()){
                sb.insert(0, " ");
                sb.insert(0, stack.pop());
            }
            result.add(sb.toString());
        }
        return result;
    }
}