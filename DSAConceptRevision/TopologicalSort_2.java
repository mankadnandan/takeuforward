/*
 * https://takeuforward.org/plus/dsa/problems/topological-sort-or-kahns-algorithm
 * 
 * BFS or Kahn's Algorithm
 * 
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TopologicalSort_2 {
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
        Integer indegree;

        Node(int val) {
            this.val = val;
            this.neighbours = new ArrayList<>();
            this.isVisited = false;
            this.indegree = 0;
        }
    }    

    public static int[] topoSort(int V, List<List<Integer>> adj) {

        // Init
        List<Node> nodeList = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            Node node = new Node(i);
            nodeList.add(node);
        }

        // Building the graph
        for (int i = 0; i < adj.size(); i++) {
            for (Integer neighbour : adj.get(i)) {
                nodeList.get(i).neighbours.add(nodeList.get(neighbour));
                nodeList.get(neighbour).indegree++;
            }
        }

        Queue<Node> queue = new LinkedList<>();
        for (int i = 0; i < nodeList.size(); i++) {
            if (nodeList.get(i).indegree == 0) {
                queue.add(nodeList.get(i));
            }            
        }

        List<Node> resultList = new ArrayList<>();
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            resultList.add(node);
            for (Node neigh : node.neighbours) {
                neigh.indegree--;
                if (neigh.indegree == 0) {
                    queue.add(neigh);
                }            
            }
        }
        int[] result = new int[V];

        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i).val;
        }

        return result;
    }    
}
