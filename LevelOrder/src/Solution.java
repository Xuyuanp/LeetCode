import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by xuyuanp on 5/31/14.
 */

public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();

        if (root == null)
            return result;

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int nodeNum = 1;
        int nextNodeNum = nodeNum * 2;
        int count = 0;
        List<Integer> level = new ArrayList<Integer>(nodeNum);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            level.add(count, node.val);

            if (node.left != null) {
                queue.add(node.left);
            } else {
                nextNodeNum--;
            }
            if (node.right != null) {
                queue.add(node.right);
            } else {
                nextNodeNum--;
            }

            count++;
            if (count == nodeNum) {
                nodeNum = nextNodeNum;
                nextNodeNum = nodeNum * 2;
                count = 0;
                result.add(level);
                // for level order 2
                // result.add(0, level);
                level = new ArrayList<Integer>(nodeNum);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        System.out.println(new Solution().levelOrder(root));
    }
}
