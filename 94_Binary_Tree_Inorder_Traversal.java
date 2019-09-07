/*
Note:
inorder traversal is:
    if tree is null, return;
    inorder(tree.left_subtree);
    print(tree.root);
    inorder(tree.right_subtree);
when inputting tree nodes, it always add to the left node. Need a null to indicate absence of left node.

to add the root into list instead of print it, pass the list as a variable of function
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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        return traversalHelper(root, result);
    }
    
    private List<Integer> traversalHelper(TreeNode root, List<Integer> list) {
        if (root == null) {
            return list;
        }
        list = traversalHelper(root.left, list);
        list.add(root.val);
        list = traversalHelper(root.right, list);
        return list;
    }
}

/*
use stack iteratively:
[1,null,2,3]
root=1 - push to stack: [1]
root=1.left(null) - stack.pop() [] add 1 to list
root=1.right(2) - push to stack: [2]
root=2.left(3) - push to stack: [2,3]
root=3.left(null) - stack.pop() [2] add 3 to list
root=3.right(null) - stack.pop() [] add 2 to list
root=2.right(null) - stack is empty
*/

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            result.add(root.val);
            root = root.right;
        }
        return result;
    }
}