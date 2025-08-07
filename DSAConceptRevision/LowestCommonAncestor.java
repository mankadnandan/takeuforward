/*
 * https://takeuforward.org/plus/dsa/problems/lowest-common-ancestor-of-a-binary-tree-ii
 */
import java.util.Stack;

public class LowestCommonAncestor {

    static boolean pFound = false;
    static boolean qFound = false;

    public static void main(String[] args) {
        TreeNode node0 = new TreeNode(0);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        TreeNode node9 = new TreeNode(9);

        node3.left = node5;
        node3.right = node1;
        node5.left = node6;
        node5.right = node2;
        node2.left = node7;
        node2.right = node4;
        node1.left = node0;
        node1.right = node8;


        TreeNode lca = lowestCommonAncestor(node3, node5, node9);
        System.out.println(lca != null ? lca.data : "null");
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Stack<TreeNode> pTrav = new Stack<>();
        Stack<TreeNode> qTrav = new Stack<>();
        lowestCommonAncestorHelper(root, p, q, pTrav, qTrav);
        TreeNode lca = null;
        int size = pTrav.size() < qTrav.size() ? pTrav.size() : qTrav.size();
        for (int i = 0; i < size; i++) {
            TreeNode pVal = pTrav.get(i);
            TreeNode qVal = qTrav.get(i);
            if (pVal.data == qVal.data) {
                lca = pVal;
            } else {
                break;
            }
        }        
        return lca;
    }

    private static void lowestCommonAncestorHelper(TreeNode node, TreeNode p, TreeNode q, Stack<TreeNode> pTrav, Stack<TreeNode> qTrav) {
        if (node == null) {
            return;
        }

        if (!pFound) {
            pTrav.push(node);
        }

        if (!qFound) {
            qTrav.push(node);
        }

        if (node.data == p.data) {
            pFound = true;
        }

        if (node.data == q.data) {
            qFound = true;
        }

        lowestCommonAncestorHelper(node.left, p, q, pTrav, qTrav);
        lowestCommonAncestorHelper(node.right, p, q, pTrav, qTrav);
        if (!pFound) {
            pTrav.pop();        
        }
        if (!qFound) {
            qTrav.pop();            
        }
    }

    static class TreeNode {
      int data;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { data = x; }
  }
}