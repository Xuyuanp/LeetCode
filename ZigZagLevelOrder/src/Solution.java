import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
        int direction = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (direction == 1) {
                level.add(count, node.val);
            } else {
                level.add(0, node.val);
            }

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
                level = new ArrayList<Integer>(nodeNum);
                direction = -direction;
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
