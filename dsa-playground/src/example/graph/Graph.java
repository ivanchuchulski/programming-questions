package example.graph;

import java.util.List;

public interface Graph {

    boolean insertEdge(int u, int v);

    List<Integer> dfs(int source);

    List<Integer> bfs(int source);

    boolean containsCycle(int source);
}

