/*
 * https://takeuforward.org/plus/dsa/binary-search-trees/theory-and-basics/search-in-bst
 */

public class SearchInBST {
    public static void main(String[] args) {
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode3 = new TreeNode(3);

        treeNode4.left = treeNode2;
        treeNode4.right = treeNode7;
        treeNode2.left = treeNode1;
        treeNode2.right = treeNode3;

        TreeNode result = searchBST(treeNode4, 5);
        if (result != null) {
            printInOrder(result);            
        } else {
            System.out.println("No match found");
        }
    }

    public static TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }

        if (root.data == val) {
            return root;
        } else if (root.data > val) {
            return searchBST(root.left, val);
        } else {
            return searchBST(root.right, val);
        }
    }

    private static void printInOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + ", ");
        printInOrder(node.left);
        printInOrder(node.right);
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