package example.graph;

public class GraphDemo {
    public static void demo() {
        Graph edgeListUndirectedGraph = new EdgeListUndirectedGraph();

        edgeListUndirectedGraph.insertEdge(1, 2);
        edgeListUndirectedGraph.insertEdge(1, 3);
        edgeListUndirectedGraph.insertEdge(2, 3);

        System.out.println(edgeListUndirectedGraph.bfs(1));

        System.out.println(edgeListUndirectedGraph.containsCycle(1));

    }
}
