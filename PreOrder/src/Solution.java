import java.util.LinkedList;
import java.util.List;

/**
 * Created by xuyuanp on 5/31/14.
 */
public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<Integer>();
        preorder(root, result);
        return result;
    }

    private void preorder(TreeNode root, List<Integer> result) {
        if (root == null)
            return;
        result.add(root.val);
        preorder(root.left, result);
        preorder(root.right, result);
    }
}
