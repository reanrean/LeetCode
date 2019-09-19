/*
Trap: root=null, root child val = root val, all sub-values need to be the same
Note: can use Integer to allow null int

if root = null return true
check left bst with lower=null, upper=root value
check right bst with lower=root value, upper=null
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
    public boolean isValidBST(TreeNode root) {
        return isValidBSTBounds(root, null, null);
    }
    
    private boolean isValidBSTBounds(TreeNode root, Integer lower, Integer upper) {
        //System.out.println(lower + " "+ upper);
        if (root == null) {
            return true;
        }
        if (root.left != null) {
            if (!isValidBSTBounds(root.left, lower, compUpper(upper, root.val))) {
                return false;
            }
        }
        if (root.right != null) {
            if (!isValidBSTBounds(root.right, compLower(lower, root.val), upper)) {
                return false;
            }
        }
        if (lower != null && root.val <= lower) {
            return false;
        }
        if (upper != null && root.val >= upper) {
            return false;
        }
        return true;
    }
    private int compLower(Integer orig, int newint) {
        if (orig == null) {
            return newint;
        } else {
            return Math.max(orig, newint);
        }
    }
    private int compUpper(Integer orig, int newint) {
        if (orig == null) {
            return newint;
        } else {
            return Math.min(orig, newint);
        }
    }
}