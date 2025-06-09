/*
 * https://takeuforward.org/plus/dsa-concept-revision/day-25/traversal-techniques
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TraversalTechniques {
    public static void main(String[] args) {
        // Example 1
        List<List<Integer>> adj = new ArrayList<>();
        List<Integer> v0 = Arrays.asList(2, 3, 1);
        List<Integer> v1 = Arrays.asList(0);
        List<Integer> v2 = Arrays.asList(0, 4);
        List<Integer> v3 = Arrays.asList(0);
        List<Integer> v4 = Arrays.asList(2);
        adj.add(v0);
        adj.add(v1);
        adj.add(v2);
        adj.add(v3);
        adj.add(v4);
        List<Integer> dfsOrder = dfsOfGraph(5, adj);
        System.out.println(dfsOrder);
        List<Integer> bfsOrder = bfsOfGraph(5, adj);
        System.out.println(bfsOrder);

        // Example 2
        adj = new ArrayList<>();
        v0 = Arrays.asList(1,3);
        v1 = Arrays.asList(2,0);
        v2 = Arrays.asList(1);
        v3 = Arrays.asList(0);
        adj.add(v0);
        adj.add(v1);
        adj.add(v2);
        adj.add(v3);
        dfsOrder = dfsOfGraph(4, adj);
        System.out.println(dfsOrder);
        bfsOrder = bfsOfGraph(4, adj);
        System.out.println(bfsOrder);

        // Example 3
        adj = new ArrayList<>();
        v0 = Arrays.asList(1,2);
        v1 = Arrays.asList(0);
        v2 = Arrays.asList(0);
        adj.add(v0);
        adj.add(v1);
        adj.add(v2);
        dfsOrder = dfsOfGraph(3, adj);
        System.out.println(dfsOrder);
        bfsOrder = bfsOfGraph(3, adj);
        System.out.println(bfsOrder);
    }

    public static List<Integer> dfsOfGraph(int V, List<List<Integer>> adj) {
        boolean[] visited = new boolean[V];
        List<Integer> dfsOrder = new ArrayList<>();
        dfs(adj, visited, 0, dfsOrder);
        return dfsOrder;
    }

    public static List<Integer> bfsOfGraph(int V, List<List<Integer>> adj) {
        boolean[] visited = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> bfsOrder = new ArrayList<>();
        queue.add(0);
        visited[0] = true;
        while (!queue.isEmpty()) {
            Integer currNode = queue.poll();
            bfsOrder.add(currNode);
            for (int i = 0; i < adj.get(currNode).size(); i++) {
                Integer neighbourNode = adj.get(currNode).get(i);
                if (!visited[neighbourNode]) {
                    queue.add(neighbourNode);
                    visited[neighbourNode] = true;
                }
            }
        }
        return bfsOrder;
    }

    private static void dfs(List<List<Integer>> adj, boolean[] visited, int currNode, List<Integer> dfsOrder) {
        visited[currNode] = true;
        dfsOrder.add(currNode);
        for (int i = 0; i < adj.get(currNode).size(); i++) {
            Integer neighbourNodeInt = adj.get(currNode).get(i);
            if (!visited[neighbourNodeInt]) {
                dfs(adj, visited, neighbourNodeInt, dfsOrder);
            }
        }
    }
}