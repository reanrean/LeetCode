/*
greedy algorithm: find the best practice each time!

Trap point: compare destination of possible next steps, not next step's numbers!
e.g.[10,9,8,7,6,5,4,3,2,1,1,0]
*/

class Solution {
    public int jump(int[] nums) {
        int nLen = nums.length;
        if (nLen<=1){
            return 0;
        }
        int i = 0;
        int count = 0;
        while (i < nLen){
            //System.out.println("i:"+i+" count:"+count);
            int cur = nums[i];
            if (i + cur >= nLen-1){
                count++;
                break;
            }
            int max = 0;
            int jump = 0;
            for (int j = 1; j <= cur; j++){
                if (i+j+nums[i+j]>=max){
                    max = i+j+nums[i+j];
                    jump = j;
                }
            }
            //System.out.println("max:"+max);
            i += jump;
            count++;
        }
        return count;
    }
}