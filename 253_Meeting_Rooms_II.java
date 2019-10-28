class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int max = 0;
        for (int i = 0; i < intervals.length; i++) {
            max = Math.max(intervals[i][1], max);
        }
        int[] arr = new int[max];
        for (int i = 0; i < intervals.length; i++) {
            for (int j = intervals[i][0]; j < intervals[i][1]; j++) {
                arr[j]++;
            }
        }
        int retMax = 0;
        for (int i = 0; i < arr.length; i++) {
            retMax = Math.max(retMax, arr[i]);
        }
        return retMax;
    }
}