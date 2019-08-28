/* 84_Largest_Rectangle_in_Histogram
 * use two loops O(n^2), iterate from each value in x-axis, check the max rectangle starting with it.
 * How to check max rectangle in i: 
 * - iterate from i till end, if height >= height[i], go until height < height[i].
 * - iterate from i till start, do the same
 * skip if the current height is same as previous.
 *
 * Trap: will forget to count from i to start.
 * Followup: https://leetcode.wang/leetCode-84-Largest-Rectangle-in-Histogram.html
 */

class Solution {
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        int max = 0;
        for (int i = 0; i < len; i++) {
            if (i > 0 && heights[i] == heights[i - 1]) {
                continue;
            }
            int curMax = heights[i];
            for (int j = i + 1; j < len; j++) {
                if (heights[j] < heights[i]) {
                    break;
                }
                curMax += heights[i];
            }
            for (int j = i - 1; j >= 0; j--) {
                if (heights[j] < heights[i]) {
                    break;
                }
                curMax += heights[i];
            }
            max = Math.max(max, curMax);
        }
        return max;
    }
}