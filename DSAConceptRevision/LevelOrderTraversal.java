/*
 * https://takeuforward.org/plus/dsa-concept-revision/day-19/level-order-traversal
 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {
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

        List<List<Integer>> resultList = levelOrder(treeNode3);

        for (List<Integer> list : resultList) {
            System.out.println(list.toString());
        }

        System.out.println();

        // Example 2
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode4_1 = new TreeNode(4);
        TreeNode treeNode2 = new TreeNode(2);

        treeNode1.left = treeNode4;
        treeNode4.left = treeNode4_1;
        treeNode4.right = treeNode2;

        resultList = levelOrder(treeNode1);

        for (List<Integer> list : resultList) {
            System.out.println(list.toString());
        }

        System.out.println();

        // Example 3
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode1_3 = new TreeNode(1);
        TreeNode treeNode2_3 = new TreeNode(2);
        TreeNode treeNode8 = new TreeNode(8);
        TreeNode treeNode4_3 = new TreeNode(4);
        TreeNode treeNode5_3 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);

        treeNode5.left = treeNode1_3;
        treeNode5.right = treeNode2_3;
        treeNode1_3.left = treeNode8;
        treeNode2_3.left = treeNode4_3;
        treeNode2_3.right = treeNode5_3;
        treeNode8.right = treeNode6;

        resultList = levelOrder(treeNode5);

        for (List<Integer> list : resultList) {
            System.out.println(list.toString());
        }
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> currQueue = new LinkedList<>();
        Queue<TreeNode> backupQueue = new LinkedList<>();
        List<List<Integer>> resultList = new ArrayList<>();
        List<Integer> levelList = new ArrayList<>();
        if (root == null) {
            return resultList;
        }
        currQueue.add(root);
    
        while (!currQueue.isEmpty()) {
            TreeNode currNode = currQueue.poll();
            levelList.add(currNode.data);
            if (currNode.left != null) {
                backupQueue.add(currNode.left);
            }
            if (currNode.right != null) {
                backupQueue.add(currNode.right);
            }
            if (currQueue.isEmpty()) {
                currQueue = backupQueue;
                backupQueue = new LinkedList<>();
                resultList.add(levelList);
                levelList = new ArrayList<>();
            }
        }
        return resultList;
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