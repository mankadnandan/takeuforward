/*
 * https://takeuforward.org/plus/dsa/problems/topological-sort-or-kahns-algorithm
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class TopologicalSort {

    public static void main(String[] args) {
        List<List<Integer>> adj = new ArrayList<>();

        List<Integer> list = Arrays.asList();
        adj.add(list);

        list = Arrays.asList();
        adj.add(list);

        list = Arrays.asList(3);
        adj.add(list);

        list = Arrays.asList(1);
        adj.add(list);

        list = Arrays.asList(0, 1);
        adj.add(list);

        list = Arrays.asList(0, 2);
        adj.add(list);
        
        System.out.println(Arrays.toString(topoSort(6, adj)));
    }

    static class Node {
        int val;
        List<Node> neighbours;
        boolean isVisited;

        Node(int val) {
            this.val = val;
            this.neighbours = new ArrayList<>();
            this.isVisited = false;
        }
    }    

    public static int[] topoSort(int V, List<List<Integer>> adj) {
        List<Node> nodes = new ArrayList<>();
        // Creating nodes
        HashMap<Integer, Node> nodeHashMap = new HashMap<>();
        for (int i = 0; i < V; i++) {
            Node node = new Node(i);
            nodeHashMap.put(i, node);
            nodes.add(node);
        }
        
        // Building Graph
        for (int i = 0; i < adj.size(); i++) {
            List<Integer> neighIntegers = adj.get(i);
            for (Integer nodeVal : neighIntegers) {
                nodeHashMap.get(i).neighbours.add(nodeHashMap.get(nodeVal));
            }
        }

        Stack<Integer> topoSortStack = new Stack<>();
       
        for (Node node : nodes) {
            if (!node.isVisited) {
                dfs(node, topoSortStack);
            }                        
        }
        int[] result = new int[V];
        int i = 0;
        while (!topoSortStack.isEmpty()) {
            result[i] = topoSortStack.pop();
            i++;
        }
        return result;
    }
    
    private static void dfs(Node node, Stack<Integer> topoSortStack) {
        for (Node neighNode : node.neighbours) {
            if (!neighNode.isVisited) {
                dfs(neighNode, topoSortStack);                
            }
        }
        node.isVisited = true;
        topoSortStack.add(node.val);
    }
}
