/*
Note: learn the way to rewrite comparator and copyOfRange!
To rewrite comparator of List<Integer>, refer to: https://leetcode.wang/leetCode-56-Merge-Intervals.html

First sort intervals base on their start
Then compare first interval vs second, if they overlap create new 1st element, if not copy 1st and 2nd element
Compare the next interval with the last element in result (as it will only increase after sorted)
*/

class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        if (n <= 1){
            return intervals;
        }
        
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] a1, int[] a2){
                return(Integer.valueOf(a1[0]).compareTo(a2[0]));
            }
        });
        
        int[][] result = new int[n][2];
        int count = 0;
        result[0] = intervals[0];
        
        for (int i = 1; i < n; i++){
            if (intervals[i][0] <= result[count][1]){
                //intervals[i][0] must be >= intervals[i-1][0] >=result[count][0]
                //overlap will occur in this condition
                //merge current interval with last item in result
                result[count][1] = Math.max(intervals[i][1], result[count][1]);
            }else{
                count++;
                result[count] = intervals[i];
            }
        }
        return Arrays.copyOfRange(result, 0, count+1);
    }
}