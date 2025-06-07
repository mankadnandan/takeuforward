/*
 * https://takeuforward.org/plus/dsa-concept-revision/day-19/inorder-traversal
 */
import java.util.ArrayList;
import java.util.List;

public class InorderTraversal {
    public static void main(String[] args) {
        // Example 1
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode4_1 = new TreeNode(4);
        TreeNode treeNode2 = new TreeNode(2);
        treeNode1.left = treeNode4;
        treeNode4.left = treeNode4_1;
        treeNode4.right = treeNode2;
        List<Integer> result = inorder(treeNode1);
        for (Integer i : result) {
            System.out.print(i + " ");
        }
        System.out.println();

        // Example 2
        TreeNode treeNode1_2 = new TreeNode(1);
        TreeNode treeNode2_2 = new TreeNode(2);
        TreeNode treeNode3_2 = new TreeNode(3);
        treeNode1_2.right = treeNode2_2;
        treeNode2_2.left = treeNode3_2;
        result = inorder(treeNode1_2);
        for (Integer i : result) {
            System.out.print(i + " ");
        }
        System.out.println();

        // Example 3
        TreeNode treeNode1_3 = new TreeNode(1);
        TreeNode treeNode2_3 = new TreeNode(2);
        TreeNode treeNode4_3 = new TreeNode(4);
        TreeNode treeNode5_3 = new TreeNode(5);
        TreeNode treeNode5_3_1 = new TreeNode(5);
        TreeNode treeNode6_3 = new TreeNode(6);
        TreeNode treeNode8_3 = new TreeNode(8);
        treeNode5_3.left = treeNode1_3;
        treeNode5_3.right = treeNode2_3;
        treeNode1_3.left = treeNode8_3;
        treeNode2_3.left = treeNode4_3;
        treeNode2_3.right = treeNode5_3_1;
        treeNode8_3.right = treeNode6_3;
        result = inorder(treeNode5_3);
        for (Integer i : result) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static List<Integer> inorder(TreeNode root) {
        List<Integer> inOrderTraversal = new ArrayList<>();
        inorderRecursive(root, inOrderTraversal);
        return inOrderTraversal;
    }

    public static void inorderRecursive(TreeNode node, List<Integer> inOrderTraversal) {
        if (node == null) {
            return;
        }
        inorderRecursive(node.left, inOrderTraversal);
        inOrderTraversal.add(node.data);
        inorderRecursive(node.right, inOrderTraversal);
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