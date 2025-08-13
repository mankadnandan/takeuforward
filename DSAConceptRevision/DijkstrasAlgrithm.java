import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class DijkstrasAlgrithm {

    static class Node {
        int val;
        List<Node> neighbour;
        List<Integer> neighbourWeight;
        int distanceFromSource;

        Node(int val) {
            this.val = val;
            this.neighbour = new ArrayList<>();
            this.neighbourWeight = new ArrayList<>();
            this.distanceFromSource = Integer.MAX_VALUE;
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> l1 = new ArrayList<>();
        l1.add(1);
        l1.add(1);
        ArrayList<Integer> l2 = new ArrayList<>();
        l2.add(3);
        l2.add(2);
        ArrayList<Integer> l3 = new ArrayList<>();
        l3.add(0);
        l3.add(1);
        ArrayList<Integer> l4 = new ArrayList<>();
        l4.add(2);
        l4.add(4);
        ArrayList<Integer> l5 = new ArrayList<>();
        l5.add(1);
        l5.add(4);
        ArrayList<Integer> l6 = new ArrayList<>();
        l6.add(3);
        l6.add(3);
        ArrayList<Integer> l7 = new ArrayList<>();
        l7.add(0);
        l7.add(2);
        ArrayList<Integer> l8 = new ArrayList<>();
        l8.add(2);
        l8.add(3);

        ArrayList<ArrayList<Integer>> lists1 = new ArrayList<>();
        lists1.add(l1);
        lists1.add(l2);
        ArrayList<ArrayList<Integer>> lists2 = new ArrayList<>();
        lists2.add(l3);
        lists2.add(l4);
        ArrayList<ArrayList<Integer>> lists3 = new ArrayList<>();
        lists3.add(l5);
        lists3.add(l6);
        ArrayList<ArrayList<Integer>> lists4 = new ArrayList<>();
        lists4.add(l7);
        lists4.add(l8);

        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>();
        adj.add(lists1);
        adj.add(lists2);
        adj.add(lists3);
        adj.add(lists4);
        int[] shortestDistanceFromSource = dijkstra(4, adj, 0);
        System.out.println(Arrays.toString(shortestDistanceFromSource));
    }

    public static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
       Map<Integer, Node> graphMap = buildGraph(V, adj);

       // The structure of PQ is [distance from Source, node val]
       PriorityQueue<Integer[]> pq = new PriorityQueue<>((Integer[] p1, Integer[] p2) -> {
            return Integer.compare(p1[0], p2[0]);
       });
       graphMap.get(S).distanceFromSource = 0;
       pq.add(new Integer[]{0, S});

       while (!pq.isEmpty()) {
           Integer[] pqArr = pq.poll();
           int distance = pqArr[0];
           int nodeVal = pqArr[1];
           Node currNode = graphMap.get(nodeVal);
           for (int i = 0; i < currNode.neighbour.size(); i++) {
                Node neighNode = currNode.neighbour.get(i);
                if ((distance + currNode.neighbourWeight.get(i)) < neighNode.distanceFromSource) {
                    neighNode.distanceFromSource = distance + currNode.neighbourWeight.get(i);
                    pq.add(new Integer[]{neighNode.distanceFromSource, neighNode.val});
                }
           }
       }
       int[] result = new int[V];
       for (Node node : graphMap.values()) {
        result[node.val] = node.distanceFromSource;       
       }
       return result;
    }

    private static Map<Integer, Node> buildGraph(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) {
        Map<Integer, Node> nodeMap = new HashMap<>();

        for (int i = 0; i < V; i++) {
            Node node = new Node(i);
            nodeMap.put(i, node);
        }

        for (int i = 0; i < adj.size(); i++) {
            Node fromNode = nodeMap.get(i);
            for (int j = 0; j < adj.get(i).size(); j++) {
                Node toNode = nodeMap.get(adj.get(i).get(j).get(0));
                Integer weight = adj.get(i).get(j).get(1);
                fromNode.neighbour.add(toNode);
                fromNode.neighbourWeight.add(weight);
            }
        }
        return nodeMap;
    }
}