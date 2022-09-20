package example.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;


public class EdgeListUndirectedGraph implements Graph {

    private final List<Edge> edges;

    public EdgeListUndirectedGraph() {
        edges = new ArrayList<>();
    }

    @Override
    public boolean insertEdge(int u, int v) {
        Edge edge = new Edge(u, v);

        if (edges.contains(edge)) {
            return false;
        }

        edges.add(edge);

        return true;
    }

    @Override
    public List<Integer> dfs(int source) {
        List<Integer> traversed = new LinkedList<>();

        Set<Integer> visited = new HashSet<>();
        utilDfs(source, traversed, visited);

        return traversed;
    }

    @Override
    public List<Integer> bfs(int source) {
        List<Integer> traversed = new LinkedList<>();
        Set<Integer> discovered = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        queue.add(source);
        discovered.add(source);

        while (!queue.isEmpty()) {
            Integer current = queue.poll();

            traversed.add(current);

            for (Integer neighbour : getNeighbours(current)) {
                if (!discovered.contains(neighbour)) {
                    discovered.add(neighbour);
                    queue.add(neighbour);
                }
            }
        }

        return traversed;
    }

    @Override
    public boolean containsCycle(int source) {
        Set<Integer> visited = new HashSet<>();

        return utilContainsCycle(source, visited, -1);
    }

    private boolean utilContainsCycle(int node, Set<Integer> visited, int parent) {
        visited.add(node);

        for (Integer neighbour : getNeighbours(node)) {
            if (!visited.contains(neighbour)) {
                if (utilContainsCycle(neighbour, visited, node)) {
                    return true;
                } else {
                    if (parent != neighbour) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private void utilDfs(int source, List<Integer> traversed, Set<Integer> visited) {
        visited.add(source);

        traversed.add(source);

        for (Integer neighbour : getNeighbours(source)) {
            if (!visited.contains(neighbour)) {
                utilDfs(neighbour, traversed, visited);
            }
        }
    }

    private List<Integer> getNeighbours(int node) {
        LinkedList<Integer> neighbours = new LinkedList<>();

        for (Edge edge : edges) {
            if (edge.getU() == node) {
                neighbours.add(edge.getV());
            } else if (edge.getV() == node) {
                neighbours.add(edge.getU());
            }
        }

        return neighbours;
    }


    private class Edge {
        private int u;
        private int v;

        public Edge(int u, int v) {
            this.u = u;
            this.v = v;
        }

        public int getU() {
            return u;
        }

        public void setU(int u) {
            this.u = u;
        }

        public int getV() {
            return v;
        }

        public void setV(int v) {
            this.v = v;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Edge edge = (Edge) o;
            return u == edge.u && v == edge.v;
        }

        @Override
        public int hashCode() {
            return Objects.hash(u, v);
        }
    }
}
