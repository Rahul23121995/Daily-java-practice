package day05;
public class Hard_BinaryTreeMaxPathSum {
    public static class TreeNode {
        int val; TreeNode left; TreeNode right;
        TreeNode(int val) { this.val = val; }
    }
    private static int max_sum;
    public static int maxPathSum(TreeNode root) {
        max_sum = Integer.MIN_VALUE;
        maxGain(root);
        return max_sum;
    }
    private static int maxGain(TreeNode node) {
        if (node == null) return 0;
        int leftGain = Math.max(maxGain(node.left), 0);
        int rightGain = Math.max(maxGain(node.right), 0);
        max_sum = Math.max(max_sum, node.val + leftGain + rightGain);
        return node.val + Math.max(leftGain, rightGain);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        assert maxPathSum(root) == 20;
        System.out.println("Tree Max Path Sum passed!");
    }
}