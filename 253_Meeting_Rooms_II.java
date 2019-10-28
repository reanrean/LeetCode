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

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(intervals.length, new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return a - b;
            }
        });
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        pq.add(intervals[0][1]);
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= pq.peek()) {
                pq.poll();
            }
            pq.add(intervals[i][1]);
        }
        return pq.size();
    }
}