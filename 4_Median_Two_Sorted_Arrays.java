class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int brk = (m+n)/2 + 1;
        int odd = (m+n)%2;
        int med1 = 0;
        int cur;
        for (int i=0, j=0, k=1; k<=brk; k++){
            if (i==m) {
                cur = nums2[j];
                j++;
            }
            else if (j==n) {
                cur = nums1[i];
                i++;
            }
            else if(nums1[i]<nums2[j]) {
                cur = nums1[i];
                i++;
            }
            else {
                cur = nums2[j];
                j++;
            }
            if (odd==1 && k==brk){
                return (double)cur;
            }
            else if (odd==0 && k==brk-1){
                med1 = cur;
            }
            else if (odd==0 && k==brk) {
                return ((double)(med1+cur))/2;
            }
        }
        return 0;
    }
}