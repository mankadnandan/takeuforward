import java.util.ArrayList;
import java.util.List;

public class PostorderTraversal {
    public static void main(String[] args) {
        // Example 1
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode4_1 = new TreeNode(4);
        TreeNode treeNode2 = new TreeNode(2);
        treeNode1.left = treeNode4;
        treeNode4.left = treeNode4_1;
        treeNode4.right = treeNode2;
        List<Integer> result = postorder(treeNode1);
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
        result = postorder(treeNode1_2);
        for (Integer i : result) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static List<Integer> postorder(TreeNode root) {
        //your code goes here
        List<Integer> postorderTraversal = new ArrayList<>();

        postorderRecursive(root, postorderTraversal);

        return postorderTraversal;
    }

    private static void postorderRecursive(TreeNode node, List<Integer> postorderTraversal) {
        if (node == null) {
            return;
        }
        postorderRecursive(node.left, postorderTraversal);
        postorderRecursive(node.right, postorderTraversal);
        postorderTraversal.add(node.data);
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