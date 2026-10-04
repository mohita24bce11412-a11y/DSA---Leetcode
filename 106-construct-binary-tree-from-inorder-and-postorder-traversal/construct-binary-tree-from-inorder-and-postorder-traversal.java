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
    private int postIndex;
    private Map<Integer, Integer> inorderIndexMap;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postIndex = postorder.length - 1;
        inorderIndexMap = new HashMap<>();

        for(int i = 0; i< inorder.length; i++){
            inorderIndexMap.put(inorder[i], i);
        }
        return buildTreeHelper(postorder, 0, inorder.length - 1);
        
    }

    private TreeNode buildTreeHelper(int[] postorder, int inStart, int inEnd) {
        if (inStart > inEnd) {
            return null;
        }

        int rootVal = postorder[postIndex--];
        TreeNode root = new TreeNode(rootVal);

        int inIndex = inorderIndexMap.get(rootVal);

        root.right = buildTreeHelper(postorder, inIndex + 1, inEnd);
        root.left = buildTreeHelper(postorder, inStart, inIndex - 1);

        return root;
    }


}