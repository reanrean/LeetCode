class Solution {
    public int[] sortedSquares(int[] A) {
        int[] result = new int[A.length];
        if (A.length == 0) {
            return result;
        }
        int start = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] >= 0) {
                start = i;
                break;
            }
        }
        int l = start - 1;
        int r = start;
        int write = 0;
        while (l >= 0 || r < A.length) {
            if (l < 0) {
                result[write] = A[r] * A[r];
                r++;
            } else if (r >= A.length) {
                result[write] = A[l] * A[l];
                l--;
            } else if (A[r] > -A[l]) {
                result[write] = A[l] * A[l];
                l--;
            } else {
                result[write] = A[r] * A[r];
                r++;
            }
            write++;
        }
        return result;
    }
}