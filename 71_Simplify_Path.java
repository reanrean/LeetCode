/*
Use split to cater input one by one,
join the output string at last

Trap:
- "/a/../../" (output size = 0 when there is ../)
- cannot use s == "." for equal
*/

class Solution {
    public String simplifyPath(String path) {
        String[] wordArr = path.split("/");
        List<String> output = new ArrayList<>();
        for (int i = 0; i < wordArr.length; i++){
            String s = wordArr[i];
            if (s.length() == 0 || s.equals(".")){
                continue;
            }else if(s.equals("..")){
                if (output.size() > 0){
                    output.remove(output.size() - 1);
                }
            }else{
                output.add(s);
            }
        }
        String outputStr = "/" + String.join("/", output);
        return outputStr;
    }
}