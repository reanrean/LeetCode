/*
method provided by the question
*/

class Solution {
    public void sortColors(int[] nums) {
        int[] count = new int[]{0,0,0};
        for (int i = 0; i < nums.length; i++){
            count[nums[i]]++;
        }
        for (int i = 0; i < nums.length; i++){
            if (i < count[0]){
                nums[i] = 0;
            }else if (i < count[0] + count[1]){
                nums[i] = 1;
            }else{
                nums[i] = 2;
            }
        }
        return;
    }
}

/*
one pass

Input: [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]

n=0,
output = [2,0,2,1,1,0]
insert = [0,0,1]

n=1,
output = [0,2,2,1,1,0]
output[insert[2]] = 2
insert = [1,1,2]

n=2,
output = [0,2,2,1,1,0]
insert = [1,1,3]

n=3, 
output = [0,1,2,2,1,0]
output[insert[1]] = 1
output[insert[2]] = 2
insert = [1,2,4]

n=4,
output = [0,1,1,2,2,0]
output[insert[1]] = 1
output[insert[2]] = 2
insert = [1,3,5]

n=5,
output = [0,0,1,1,2,2]
output[insert[0]] = 1
output[insert[1]] = 1
output[insert[2]] = 2
insert = [2,4,6]
*/

class Solution {
    public void sortColors(int[] nums) {
        int[] insert = new int[]{0,0,0};
        for (int i = 0; i < nums.length; i++){
            switch (nums[i]) {
                case 0:
                    nums[insert[0]] = 0;
                    if (insert[1] != insert[0]) {
                        nums[insert[1]] = 1;
                    }
                    if (insert[2] != insert[1]) {
                        nums[insert[2]] = 2;
                    }
                    insert[0]++;
                    insert[1]++;
                    insert[2]++;
                    break;
                case 1:
                    nums[insert[1]] = 1;
                    if (insert[2] != insert[1]) {
                        nums[insert[2]] = 2;
                    }
                    insert[1]++;
                    insert[2]++;
                    break;
                case 2:
                    nums[insert[2]] = 2;
                    insert[2]++;
                    break;
            }
            //System.out.println(nums[0]+""+nums[1]+""+nums[2]+""+nums[3]+""+nums[4]+""+nums[5]);
            //System.out.println("insert "+insert[0]+""+insert[1]+""+insert[2]);
        }
        return;
    }
}