/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public boolean isUnivalTree(TreeNode root) {
        if(root.left != null && root.right != null){
            return root.left.val == root.right.val && root.left.val == root.val && isUnivalTree(root.left) && isUnivalTree(root.right);
        }
        else if(root.left != null){
            return root.val == root.left.val && isUnivalTree(root.left);
        }
        else if(root.right != null){
            return root.right.val == root.val && isUnivalTree(root.right);
        }
        return true;
    }
}

// optimal solution

// if (root == null) {
//     return true;
// }

// if (root.left != null && root.left.val != root.val) {
//     return false;
// }

// if (root.right != null && root.right.val != root.val) {
//     return false;
// }

// return isUnivalTree(root.left) && isUnivalTree(root.right);