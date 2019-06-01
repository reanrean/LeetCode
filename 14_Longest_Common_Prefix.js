/*
Horizontal Scanning (with recursion)
*/

/**
 * @param {string[]} strs
 * @return {string}
 */
var longestCommonPrefix = function(strs) {
        if (strs.length==0) {
            return "";
        }
        else if (strs.length==1){
            return strs[0];
        }
        var pref = "";
        for (var i=0; i<Math.min(strs[0].length,strs[1].length); i++){
            if (strs[0].charAt(i)==strs[1].charAt(i)){
                pref += strs[0].charAt(i);
            }else{
                break;
            }
        }
        strs[1] = pref;
        return longestCommonPrefix(strs.slice(1));
};