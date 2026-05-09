import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TraversalTechniques_2 {

    public static void main(String[] args) {
        int V = 5;
        List<List<Integer>> edges = new ArrayList<>(5);

        edges.add(new ArrayList<>(Arrays.asList(0, 2)));
        edges.add(new ArrayList<>(Arrays.asList(0, 3)));
        edges.add(new ArrayList<>(Arrays.asList(0, 1)));
        edges.add(new ArrayList<>(Arrays.asList(2, 4)));

        List<Integer> result = dfsOfGraph(V, edges);
        System.out.println(result.toString());
        result = bfsOfGraph(V, edges);
        System.out.println(result.toString());
    }

    public static List<Integer> dfsOfGraph(int V, List<List<Integer>> edges) {
        List<List<Integer>> adj = getAdjListFromEdges(V, edges);
        List<Integer> result = new ArrayList<>();
        List<Boolean> isVisited = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            isVisited.add(false);
        }
        // undirected connected graph, so if we start dfs from 1 node we know it will
        // cover all the no0des.
        dfs(adj, result, isVisited, 0);
        return result;
    }

    public static List<Integer> bfsOfGraph(int V, List<List<Integer>> edges) {
        List<List<Integer>> adj = getAdjListFromEdges(V, edges);
        List<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        List<Boolean> isVisited = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            isVisited.add(false);
        }
        queue.add(0);
        isVisited.set(0, true);
        while (!queue.isEmpty()) {
            Integer idx = queue.remove();
            result.add(idx);

            for (int i = 0; i < adj.get(idx).size(); i++) {
                if (!isVisited.get(adj.get(idx).get(i))) {
                    queue.add(adj.get(idx).get(i));
                    isVisited.set(adj.get(idx).get(i), true);
                }
            }
        }
        return result;
    }

    private static void dfs(List<List<Integer>> adj, List<Integer> result, List<Boolean> isVisited,
            Integer currNode) {
        isVisited.set(currNode, true);
        result.add(currNode);

        for (int i = 0; i < adj.get(currNode).size(); i++) {
            if (!isVisited.get(adj.get(currNode).get(i))) {
                dfs(adj, result, isVisited, adj.get(currNode).get(i));
            }
        }
    }

    private static List<List<Integer>> getAdjListFromEdges(int V, List<List<Integer>> edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (List<Integer> edge : edges) {
            int u = edge.get(0);
            int v = edge.get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        return adj;
    }
}