/*
Compare newInterval with each element in intervals and calculate replaceStart and replaceEnd.

Trap1: compare with next start, not current end
Trap2: no next start e.g. [[1,5]],[0,3], or [[1,3],[6,9]],[0,10]
Trap3: insert interval between e.g. [[3,5],[12,15]],[6,6]
Trap4: [],[5,7] when considering trap3
*/

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        int start = newInterval[0];
        int end = newInterval[1];
        
        int replaceStart = -1;
        int replaceEnd = -1;
        int insert = 0; //insert before i if replaceStart = replaceEnd = -1
        
        for (int i = 0; i < n; i++){
            if ((start >= intervals[i][0] && start <= intervals[i][1]) || 
                (start < intervals[i][0] && end >= intervals[i][0] && replaceStart == -1)){
                replaceStart = i;
            }
            if (end < intervals[i][0] && replaceEnd == -1 && replaceStart != -1){
                replaceEnd = i-1;
            }
            if (i > 0 && start > intervals[i-1][1] && end <intervals[i][0]){
                insert = i;
            }
            if (i == n-1){
                if (start > intervals[i][1]){
                    replaceStart = n;
                    replaceEnd = n;
                }
                else if (replaceStart > -1 && replaceEnd == -1){
                    replaceEnd = i;
                }
                else if (replaceEnd > -1 && replaceStart == -1){
                    replaceStart = replaceEnd;
                }
            }
        }
        //replaceStart = replaceEnd = -1 : new interval before *or middle
        //0 <= replaceStart, replaceEnd < n : combine intervals
        //replaceStart = n : new interval after
        
        int combine = replaceEnd - replaceStart;
        int resultLen = n - combine + ((replaceStart == -1 || replaceStart == n) ? 1 : 0);
        //System.out.println(replaceStart + " "+ replaceEnd+" " + resultLen);
        int[][] result = new int[resultLen][2];
        int count = 0;
        if (n == 0){
            result[count] = newInterval;
        }
        for (int i = 0; i < n; i++){
            if (replaceStart == -1 && count == insert){
                result[count] = newInterval;
                count++;
            }
            if (i == replaceStart){
                result[count][0] = Math.min(intervals[i][0], start);
                i += combine;
                result[count][1] = Math.max(intervals[i][1], end);
            }else{
                result[count] = intervals[i];
            }
            count++;
        }
        if (replaceStart == n){
            result[count] = newInterval;
        }
        return result;
    }
}