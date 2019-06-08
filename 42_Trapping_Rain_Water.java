/*
Use two pointers l and r, add result when height[r]<height[l].
When height[r]>height[l], move l to r.
It will cause missing calculation after maximum.
To solve it, get a maximum position first, 
do twice from left hand side to max_pos, and then do from right hand side to max_pos.
*/
class Solution {
    public int trap(int[] height) {
        int nLen = height.length;
        if(nLen<=2){
            return 0;
        }
        int result = 0;
        int max1 = 0;
        int max1_pos = 0;
        for (int i=0; i<nLen; i++){
            if (height[i]>max1){
                max1 = height[i];
                max1_pos = i;
            }
        }
        //System.out.println("max1_pos "+max1_pos);
        int l = 0;
        int r = 0;
        while (l<max1_pos){
            if (height[l]==0 && height[r]==0){
                l++;
                continue;
            }
            else{
                r = l;
                while (r<max1_pos && height[r]<=height[l]){
                    if (height[r]<height[l]){
                        //System.out.println((height[l]-height[r]));
                        result += (height[l]-height[r]);
                    }
                    r++;
                }
                l = r;
            }
        }
        //System.out.println();
        l = nLen-1;
        r = nLen-1;
        while (l>max1_pos){
            if (height[l]==0 && height[r]==0){
                l--;
                continue;
            }else{
                r = l;
                while (r>max1_pos && height[r]<=height[l]){
                    if (height[r]<height[l]){
                        //System.out.println((height[l]-height[r]));
                        result += (height[l]-height[r]);
                    }
                    r--;
                }
                l = r;
            }
        }
        return result;
    }
}