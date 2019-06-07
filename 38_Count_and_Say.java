class Solution {
    public String countAndSay(int n) {
        int i = 1;
        String output = "1";
        while (i<n){
            String newOutput = "";
            int count = 1;
            char c = output.charAt(0);
            int pointer = 1;
            while (pointer<output.length()){
                if (output.charAt(pointer) != c){
                    newOutput = newOutput + count + c;
                    count = 1;
                    c = output.charAt(pointer);
                }else{
                    count++;
                }
                pointer++;
            }
            newOutput = newOutput + count + c;
            output = newOutput;
            i++;
        }
        return output;
    }
}

/*
Use StringBuilder to speed up
*/

class Solution {
    public String countAndSay(int n) {
        if (n==1){
            return "1";
        }
        String output = countAndSay(n-1);
        StringBuilder newOutput = new StringBuilder();
        int count = 1;
        char c = output.charAt(0);
        int pointer = 1;
        while (pointer<output.length()){
            if (output.charAt(pointer) != c){
                newOutput.append(count).append(c);
                count = 1;
                c = output.charAt(pointer);
            }else{
                count++;
            }
            pointer++;
        }
        newOutput.append(count).append(c);
        return newOutput.toString();
    }
}