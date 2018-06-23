package coding4fun;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * Given a list of pairs of host and app names, return a list of possible clusters
 * where a cluster is a group of hosts and apps that are related to each other.
 * 
 * <pre>
 * Input : [("h1","a1"), ("h1","a2"), ("h2","a1"), ("h2","a3"), ("h3","a4")]
 * Output: [[("h1","a1"), ("h1","a2"), ("h2","a1"), ("h2","a3")],
 *          [("h3","a4")]]
 *
 * Input : [("h1","a1"), ("h1","a2"), ("h2","a1"), ("h2","a3"), ("h3","a4"), ("h3","a3")]
 * Output: [[("h1","a1"), ("h1","a2"), ("h2","a1"), ("h2","a3"), ("h3","a4"). ("h3","a3")]]
 * </pre>
 */
public class Problem55 {
    private static class Node {
        private final String host;
        private final String app;

        public Node(String host, String app) {
            this.host = host;
            this.app = app;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return Objects.equals(host, node.host) &&
                Objects.equals(app, node.app);
        }

        @Override
        public int hashCode() {
            return Objects.hash(host, app);
        }

        @Override
        public String toString() {
            return "" + host + ": " + app + ")";
        }
    }

    public static List<List<Node>> cluster(List<Node> nodes) {
        Map<String, List<Node>> graph = buildGraph(nodes);
        int clusterId = 0; // Can be anything as long as it's unique.
        Set<String> visited = new HashSet<>();
        Map<Integer, Set<Node>> groups = new HashMap<>();
        for (Node node : nodes) {
            if (!visited.contains(node.host)) {
                dfs(graph, node.host, node, visited, groups, clusterId);
            }
            if (!visited.contains(node.app)) {
                dfs(graph, node.app, node, visited, groups, clusterId);
            }
            clusterId++;
        }
        List<List<Node>> result = new ArrayList<>();
        groups.forEach((key, value) -> result.add(new ArrayList<>(value)));
        return result;
    }

    private static void dfs(Map<String, List<Node>> graph,
                            String source,
                            Node node,
                            Set<String> visited,
                            Map<Integer, Set<Node>> clusters,
                            int clusterId) {
        visited.add(source);
        // Associate the cluster node with the cluster ID.
        if (!clusters.containsKey(clusterId)) {
            Set<Node> newSet = new HashSet<>();
            newSet.add(node);
            clusters.put(clusterId, newSet);
        } else {
            clusters.get(clusterId).add(node);
        }
        List<Node> neighbors = graph.get(source);
        if (neighbors == null) {
            return;
        }
        for (Node neighbor : neighbors) {
            if (!visited.contains(neighbor.host)) {
                dfs(graph, neighbor.host, neighbor, visited, clusters, clusterId);
            }
            if (!visited.contains(neighbor.app)) {
                dfs(graph, neighbor.app, neighbor, visited, clusters, clusterId);
            }
        }
    }

    private static Map<String, List<Node>> buildGraph(List<Node> nodes) {
        // Undirected graph.
        Map<String, List<Node>> graph = new HashMap<>();
        for (Node node : nodes) {
            updateGraph(graph, node.host, node);
            updateGraph(graph, node.app, node);
        }
        return graph;
    }

    private static void updateGraph(Map<String, List<Node>> graph,
                                    String host,
                                    Node node) {
        if (!graph.containsKey(host)) {
            List<Node> newList = new ArrayList<>();
            newList.add(node);
            graph.put(host, newList);
        } else {
            graph.get(host).add(node);
        }
    }

    private static void print(List<List<Node>> nodes) {
        for (int i = 0; i < 72; i++) {
            System.out.print("-");
        }
        System.out.println();
        nodes.forEach(System.out::println);
    }

    public static void main(String[] args) throws Exception {
        print(cluster(Arrays.asList(
            new Node("h1", "a1"),
            new Node("h1", "a2"),
            new Node("h2", "a1"),
            new Node("h2", "a3"),
            new Node("h3", "a4"))));

        print(cluster(Arrays.asList(
            new Node("h1", "a1"),
            new Node("h1", "a2"),
            new Node("h2", "a1"),
            new Node("h2", "a3"),
            new Node("h3", "a4"),
            new Node("h3", "a3"))));
    }
}
