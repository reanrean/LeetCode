/*88_Merge_Sorted_Array
  https://leetcode.wang/leetCode-88-Merge-Sorted-Array.html
  Insert to the end from largest to smallest
  Trap: consider n/m < 0
*/

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        m--;
        n--;
        int i = nums1.length - 1;
        while (i >= 0) {
            if (n < 0) {
                nums1[i] = nums1[m];
                m--;
            }
            else if (m < 0) {
                nums1[i] = nums2[n];
                n--;
            }
            else if (nums1[m] >= nums2[n]) {
                nums1[i] = nums1[m];
                m--;
            }
            else {
                nums1[i] = nums2[n];
                n--;
            }
            i--;
        }
        return;
    }
}