/*
Recursion solution: (very slow)
split every n into 2 numbers (e.g.4=1+3=2+2=3+1)
and do recursion every these numbers, combine them with combinations.
*/

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        if (n==1){
            result.add("()");
        }else{
            for (int i=1; i<=n-i; i++){
                List<String> iResult = generateParenthesis(i);
                List<String> niResult;
                if (i==n-i){
                    niResult = iResult;
                }else{
                    niResult = generateParenthesis(n-i);
                }
                Iterator it = iResult.iterator();
                while (it.hasNext()){
                    String iStr = (String) it.next();
                    Iterator nit = niResult.iterator();
                    while (nit.hasNext()){
                        String niStr = (String) nit.next();
                        String comb = iStr + niStr;
                        if (!result.contains(comb)){
                            result.add(comb);
                        }
                        comb = niStr + iStr;
                        if (!result.contains(comb)){
                            result.add(comb);
                        }
                        if (i==1){
                            comb = "(" + niStr + ")";
                            if (!result.contains(comb)){
                                result.add(comb);
                            }
                        }
                    }
                }
            }
        }
        return result;
    }
}

/*
optimized solution based on LC solution
*/

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        addList(result, "", 0, 0, n);
        return result;
    }
    public void addList(List<String> list, String cur, int open, int close, int n){
        //System.out.println(cur);
        if (cur.length() == n*2){
            list.add(cur);
        }else{
            if (open<n) {
                addList(list, cur+"(", open+1, close, n);
            }
            if (close<open) {
                addList(list, cur+")", open, close+1, n);
            }
        }
        return;
    }
}