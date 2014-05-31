import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by xuyuanp on 5/31/14.
 */

public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null)
            return null;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        List<Integer> result = new LinkedList<Integer>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            if (!stack.isEmpty()) {
                node = stack.pop();
                result.add(node.val);
                node = node.right;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        System.out.println(new Solution().inorderTraversal(root));
    }
}
