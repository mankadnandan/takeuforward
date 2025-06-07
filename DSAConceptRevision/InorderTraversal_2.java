/*
 * https://takeuforward.org/plus/dsa-concept-revision/day-19/inorder-traversal
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InorderTraversal_2 {
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
    }

    public static List<Integer> inorder(TreeNode root) {
        List<Integer> inOrderTraversal = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        TreeNode currNode = root;

        while (!stack.isEmpty() || currNode != null) {
            while (currNode != null) {
                stack.push(currNode);
                currNode = currNode.left;
            }
            currNode = stack.pop();
            inOrderTraversal.add(currNode.data);
            currNode = currNode.right;
        }

        return inOrderTraversal;
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