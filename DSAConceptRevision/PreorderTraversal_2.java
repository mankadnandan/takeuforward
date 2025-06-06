import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreorderTraversal_2 {
    public static void main(String[] args) {
        // Example 1
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode4_1 = new TreeNode(4);
        TreeNode treeNode2 = new TreeNode(2);
        treeNode1.left = treeNode4;
        treeNode4.left = treeNode4_1;
        treeNode4.right = treeNode2;
        List<Integer> result = preorder(treeNode1);
        for (Integer i : result) {
            System.out.print(i + " ");
        }
        System.out.println();

        // Example 2
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode1_2 = new TreeNode(1);
        TreeNode treeNode2_2 = new TreeNode(2);
        TreeNode treeNode8 = new TreeNode(8);
        TreeNode treeNode4_2 = new TreeNode(4);
        TreeNode treeNode5_2 = new TreeNode(5);
        TreeNode treeNode6_2 = new TreeNode(6);
        
        treeNode5.left = treeNode1_2;
        treeNode5.right = treeNode2_2;
        treeNode1_2.left = treeNode8;
        treeNode8.right = treeNode6_2;
        treeNode2_2.left = treeNode4_2;
        treeNode2_2.right = treeNode5_2;

        result = preorder(treeNode5);
        for (Integer i : result) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static List<Integer> preorder(TreeNode root) {
        List<Integer> preOrderTraversal = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()) {
            TreeNode treeNode = stack.pop();
            preOrderTraversal.add(treeNode.data);
            if (treeNode.right != null) {
                stack.push(treeNode.right);
            }
            if (treeNode.left != null) {
                stack.push(treeNode.left);
            }
        }        

        return preOrderTraversal;
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
