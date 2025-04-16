//bft ajs matrix
import java.util.*;

public class GraphBFT {

    // Perform Breadth-First Traversal from a given start node
    public static void bfs(int[][] graph, int start) {
        int n = graph.length; // number of nodes
        boolean[] visited = new boolean[n]; // track visited nodes
        Queue<Integer> queue = new LinkedList<>();

        // Start from the given node
        visited[start] = true;
        queue.add(start);

        System.out.print("BFS Traversal: ");

        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.print(current + " ");

            // Visit all adjacent nodes
            for (int i = 0; i < n; i++) {
                if (graph[current][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }

        System.out.println();
    }

    public static void main(String[] args) {
        // Sample graph represented by adjacency matrix
        // Graph: 0 - 1 - 2
        //         \     /
        //           3

        int[][] graph = {
            {0, 1, 0, 1}, // edges from node 0 to 1 and 3
            {1, 0, 1, 0}, // edges from node 1 to 0 and 2
            {0, 1, 0, 1}, // edges from node 2 to 1 and 3
            {1, 0, 1, 0}  // edges from node 3 to 0 and 2
        };

        int startNode = 0;
        bfs(graph, startNode);
    }
}
// ads list
import java.util.*;

public class GraphBFT_AdjList {

    // Perform BFS from a given starting node
    public static void bfs(List<List<Integer>> adjList, int start) {
        int n = adjList.size(); // number of nodes
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.add(start);

        System.out.print("BFS Traversal: ");

        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.print(current + " ");

            // Traverse all adjacent nodes
            for (int neighbor : adjList.get(current)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }

        System.out.println();
    }

    public static void main(String[] args) {
        // Sample graph (undirected)
        // 0 -- 1 -- 2
        // |         |
        // +---- 3 --+

        int numVertices = 4;
        List<List<Integer>> adjList = new ArrayList<>();

        // Initialize adjacency list
        for (int i = 0; i < numVertices; i++) {
            adjList.add(new ArrayList<>());
        }

        // Add edges (undirected)
        addEdge(adjList, 0, 1);
        addEdge(adjList, 0, 3);
        addEdge(adjList, 1, 2);
        addEdge(adjList, 2, 3);

        int startNode = 0;
        bfs(adjList, startNode);
    }

    // Helper function to add edges
    public static void addEdge(List<List<Integer>> adjList, int u, int v) {
        adjList.get(u).add(v);
        adjList.get(v).add(u); // remove this line for directed graph
    }
}
//dft
import java.util.*;

public class GraphDFT {

    // Perform DFS recursively
    public static void dfs(int[][] graph, boolean[] visited, int current) {
        visited[current] = true;
        System.out.print(current + " ");

        for (int i = 0; i < graph.length; i++) {
            // If there is an edge and node is not visited
            if (graph[current][i] == 1 && !visited[i]) {
                dfs(graph, visited, i);
            }
        }
    }

    public static void main(String[] args) {
        // Example graph (undirected):
        // 0 - 1 - 2
        //  \     /
        //    3

        int[][] graph = {
            {0, 1, 0, 1}, // edges from node 0 to 1 and 3
            {1, 0, 1, 0}, // edges from node 1 to 0 and 2
            {0, 1, 0, 1}, // edges from node 2 to 1 and 3
            {1, 0, 1, 0}  // edges from node 3 to 0 and 2
        };

        int startNode = 0;
        boolean[] visited = new boolean[graph.length];

        System.out.print("DFS Traversal: ");
        dfs(graph, visited, startNode);
    }
}
//list
import java.util.*;

public class GraphDFT_AdjList {

    // Perform DFS recursively
    public static void dfs(List<List<Integer>> adjList, boolean[] visited, int current) {
        visited[current] = true;
        System.out.print(current + " ");

        for (int neighbor : adjList.get(current)) {
            if (!visited[neighbor]) {
                dfs(adjList, visited, neighbor);
            }
        }
    }

    public static void main(String[] args) {
        // Example graph:
        // 0 -- 1 -- 2
        // |         |
        // +---- 3 --+

        int numVertices = 4;
        List<List<Integer>> adjList = new ArrayList<>();

        // Initialize the adjacency list
        for (int i = 0; i < numVertices; i++) {
            adjList.add(new ArrayList<>());
        }

        // Add edges (undirected)
        addEdge(adjList, 0, 1);
        addEdge(adjList, 0, 3);
        addEdge(adjList, 1, 2);
        addEdge(adjList, 2, 3);

        boolean[] visited = new boolean[numVertices];
        int startNode = 0;

        System.out.print("DFS Traversal: ");
        dfs(adjList, visited, startNode);
    }

    // Helper method to add edges
    public static void addEdge(List<List<Integer>> adjList, int u, int v) {
        adjList.get(u).add(v);
        adjList.get(v).add(u); // For undirected graph
    }
}
