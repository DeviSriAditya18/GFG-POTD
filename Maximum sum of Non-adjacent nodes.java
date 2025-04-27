/*
Given a binary tree with a value associated with each node. Your task is to select a subset of nodes such that the sum of their values is maximized, with the condition that no two selected nodes are directly connected that is, if a node is included in the subset, neither its parent nor its children can be included.

Examples:

Input: root[] = [11, 1, 2]
Output: 11
Explanation: The maximum sum is obtained by selecting the node 11.

Input: root[] = [1, 2, 3, 4, N, 5, 6]
Output: 16
Explanation: The maximum sum is obtained by selecting the nodes 1, 4, 5, and 6, which are not directly connected to each other. Their total sum is 16.  
*/

class Solution {
    // Function to return the maximum sum of non-adjacent nodes.
    public int getMaxSum(Node root) {
        // Call the helper function with the root node.
        int[] result = helper(root);
        // We return the maximum of include or exclude the root.
        return Math.max(result[0], result[1]);
    }
    private int[] helper(Node node) {
        // Base case: If the node is null, return (0, 0)
        if (node == null) {
            return new int[]{0, 0};
        }

        // Recursively calculate the results for the left and right children
        int[] left = helper(node.left);
        int[] right = helper(node.right);

        // Include the current node: we add its value and the exclude results from its children
        int include = node.data + left[1] + right[1];

        // Exclude the current node: we take the maximum of including or excluding the children
        int exclude = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

        // Return the result as an array [include, exclude]
        return new int[]{include, exclude};
    }
}
