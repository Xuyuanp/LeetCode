/**
 * Created by xuyuanp on 5/31/14.
 */
public class Solution {
    public boolean isBalanced(TreeNode root) {
        int height = getBalanceHeight(root);
        return height != -1;
    }

    private int getBalanceHeight(TreeNode node) {
        if (node == null)
            return 0;
        if (node.left == null && node.right == null) {
            return 1;
        }
        int hl = getBalanceHeight(node.left);
        int hr = getBalanceHeight(node.right);
        if (hr == -1 || hl == -1 || Math.abs(hr - hl) > 1) {
            return -1;
        }
        return (hl > hr ? hl : hr) + 1;
    }
}
