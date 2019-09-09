/*
input 3:
1 -> 23
     2 -> 3
     3 -> 2
2 -> 13 (same tree)
3 -> 12
     1 -> 2
     2 -> 1

input 4:
1 -> 234
     2 -> 34
          3->4
          4->3
     3 -> 24
     4 -> 23
          2->3
          3->2
2 -> 134
     13 -> 4
     14 -> 3
3 -> 124
     14 -> 2
     24 -> 1
4 -> 123

first, generate n numbers as tree roots
for the rest numbers, divide them into "smaller than root.val" and "larger than root.val"
if there is only one value at either side, then the answer is fixed at that side. 
Then, the rest numbers can be calculated in recursion.
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            List<TreeNode> list = new ArrayList<>();
            return list;
        }
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }
        return generateTreesArray(nums);
    }
    
    private List<TreeNode> generateTreesArray(int[] nums) {
        List<TreeNode> list = new ArrayList<>();
        int nLen = nums.length;
        if (nLen == 1) {
            TreeNode root = new TreeNode(nums[0]);
            root.left = null;
            root.right = null;
            list.add(root);
            return list;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nLen; i++) {
            List<TreeNode> left = generateTreesArray(Arrays.copyOfRange(nums, 0, i));
            List<TreeNode> right = generateTreesArray(Arrays.copyOfRange(nums, i + 1, nLen));
            if (left.size() == 0) {
                for (TreeNode r : right) {
                    TreeNode root = new TreeNode(nums[i]);
                    root.left = null;
                    root.right = r;
                    list.add(root);
                }
            } else if (right.size() == 0) {
                for (TreeNode l : left) {
                    TreeNode root = new TreeNode(nums[i]);
                    root.left = l;
                    root.right = null;
                    list.add(root);
                }
            } else {
                for (TreeNode l : left) {
                    for (TreeNode r : right) {
                        TreeNode root = new TreeNode(nums[i]);
                        root.left = l;
                        root.right = r;
                        list.add(root);
                    }
                }
            }
        }
        return list;
    }
}