import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by xuyuanp on 5/31/14.
 */
public class Solution {
    public List<Integer> postOrderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<Integer>();

        postOrder(root, result);

        return result;
    }

    private void postOrder(TreeNode root, List<Integer> result) {
        if (root == null)
            return;
        postOrder(root.left, result);
        postOrder(root.right, result);
        result.add(root.val);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        System.out.println(new Solution().postOrderTraversal(root));
    }
}
