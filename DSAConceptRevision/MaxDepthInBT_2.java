/*
 * https://takeuforward.org/plus/dsa-concept-revision/day-19/maximum-depth-in-bt
 * 
 * This is iterative solution, which uses concepts from level order traversals.
 * 
 */
import java.util.LinkedList;
import java.util.Queue;

public class MaxDepthInBT_2 {
    public static void main(String[] args) {
        // Example 1
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode9 = new TreeNode(9);
        TreeNode treeNode20 = new TreeNode(20);
        TreeNode treeNode15 = new TreeNode(15);
        TreeNode treeNode7 = new TreeNode(7);

        treeNode3.left = treeNode9;
        treeNode3.right = treeNode20;
        treeNode20.left = treeNode15;
        treeNode20.right = treeNode7;

        int maxDepth = maxDepth(treeNode3);
        System.out.println(maxDepth);

        // Example 2
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3_2 = new TreeNode(3);
        TreeNode treeNode6 = new TreeNode(6);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3_2;
        treeNode3_2.right = treeNode6;

        maxDepth = maxDepth(treeNode1);
        System.out.println(maxDepth);

        // Example 3
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode1_3 = new TreeNode(1);
        TreeNode treeNode2_3 = new TreeNode(2);
        TreeNode treeNode8 = new TreeNode(8);
        TreeNode treeNode5_3 = new TreeNode(5);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode7_3 = new TreeNode(7);

        treeNode5.left = treeNode1_3;
        treeNode5.right = treeNode2_3;
        treeNode1_3.left = treeNode8;
        treeNode2_3.right = treeNode5_3;
        treeNode8.right = treeNode4;
        treeNode4.left = treeNode7_3;

        maxDepth = maxDepth(treeNode5);
        System.out.println(maxDepth);
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 0;

        while (!queue.isEmpty()) {
            int currSize = queue.size();
            for (int i = 0; i < currSize; i++) {
                TreeNode currNode = queue.poll();
                if (currNode.left != null) {
                    queue.add(currNode.left);
                }
                if (currNode.right != null) {
                    queue.add(currNode.right);
                }
            }
            depth++;
        }
        return depth;
    }

    public static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            data = val;
            left = null;
            right = null;
        }
    }
}