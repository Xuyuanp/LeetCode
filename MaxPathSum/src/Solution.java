/**
 * Created by xuyuanp on 5/31/14.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}

public class Solution {
    int result = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        this.result = root.val;
        postOrder(root);
        return this.result;
    }

    private int postOrder(TreeNode node) {
        if (node.left == null && node.right == null) {
            this.result = max2(node.val, this.result);
            return node.val;
        }
        if (node.left == null) {
            int mr = postOrder(node.right);
            int max = max2(node.val, node.val + mr);
            this.result = max3(this.result, max, mr);
            return max;
        }
        if (node.right == null) {
            int ml = postOrder(node.left);
            int max = max2(node.val, node.val + ml);
            this.result = max3(this.result, max, ml);
            return max;
        }
        int ml = postOrder(node.left);
        int mr = postOrder(node.right);

        int outMax = max3(node.val, node.val + ml, node.val + mr);
        int singleMax = max3(node.val, ml, mr);
        int innerMax = max3(node.val + ml + mr, node.val + ml, node.val + mr);

        int max = max3(outMax, singleMax, innerMax);

        this.result = max2(this.result, max);
        return outMax;
    }

    private int max2(int a, int b) {
        return a > b ? a : b;
    }

    private int max3(int a, int b, int c) {
        return max2(max2(a, b), c);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(10);
        root = new TreeNode(-3);
        System.out.println(new Solution().maxPathSum(root));
    }
}
