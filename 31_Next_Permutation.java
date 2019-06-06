/*
Used the solution provided. Actually I don't quite understand...
*/

class Solution {
    public void nextPermutation(int[] nums) {
        int nLen = nums.length;
        if (nLen<=1){
            return;
        }
        int i = nLen - 1;
        while (i>0){ // find the first decreasing number from right
            if (nums[i]>nums[i-1]){
                break;
            }
            i--;
        }
        if (i==0){ //sorted
            //System.out.println("sorted");
            Arrays.sort(nums);
            return;
        }
        int j = i-1; //find number just larger than nums[i]
        while (i<nLen-1){
            if (nums[i+1]<=nums[j]){
                break;
            }
            i++;
        }
        swap(nums, i, j);
        //System.out.println(j+" "+i);
        int l = j + 1;
        int r = nLen - 1;
        while(l<r){
            swap (nums, l, r);
            l++;
            r--;
        }
    }
    
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}