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
//dft matrix
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
//dft list
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

//0/1 knapsack dynamic
import java.util.Scanner;

public class KnapsackDP {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input number of items
        System.out.print("Enter number of items: ");
        int n = sc.nextInt();

        int[] weight = new int[n];
        int[] value = new int[n];

        // Input weights and values
        System.out.println("Enter weights of items:");
        for (int i = 0; i < n; i++) {
            weight[i] = sc.nextInt();
        }

        System.out.println("Enter values of items:");
        for (int i = 0; i < n; i++) {
            value[i] = sc.nextInt();
        }

        // Input capacity
        System.out.print("Enter knapsack capacity: ");
        int W = sc.nextInt();

        // Solve using DP
        int maxProfit = knapsack(weight, value, n, W);
        System.out.println("Maximum value in knapsack: " + maxProfit);
    }

    public static int knapsack(int[] weight, int[] value, int n, int W) {
        int[][] dp = new int[n + 1][W + 1];

        // Build dp[][] table
        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= W; w++) {
                if (weight[i - 1] <= w) {
                    dp[i][w] = Math.max(value[i - 1] + dp[i - 1][w - weight[i - 1]], dp[i - 1][w]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        // Uncomment below to print DP table

        return dp[n][W]; // Maximum value
    }
}
//0/1 knapsack back tracking
import java.util.Scanner;

public class KnapsackBacktracking {

    // Function to find the maximum value using backtracking
    public static int knapsack(int[] weight, int[] value, int n, int W) {
        return knapsackRec(weight, value, n - 1, W, 0);  // Start from the last item
    }

    // Recursive function for backtracking
    private static int knapsackRec(int[] weight, int[] value, int n, int W, int currentValue) {
        // Base Case: No items left or knapsack capacity is 0
        if (n < 0 || W == 0) {
            return currentValue;
        }

        // Exclude the current item and move to the next item
        int exclude = knapsackRec(weight, value, n - 1, W, currentValue);

        // Include the current item, if it fits in the knapsack
        int include = 0;
        if (weight[n] <= W) {
            include = knapsackRec(weight, value, n - 1, W - weight[n], currentValue + value[n]);
        }

        // Return the maximum value between including and excluding the current item
        return Math.max(exclude, include);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input number of items
        System.out.print("Enter number of items: ");
        int n = sc.nextInt();

        int[] weight = new int[n];
        int[] value = new int[n];

        // Input weights and values
        System.out.println("Enter weights of items:");
        for (int i = 0; i < n; i++) {
            weight[i] = sc.nextInt();
        }

        System.out.println("Enter values of items:");
        for (int i = 0; i < n; i++) {
            value[i] = sc.nextInt();
        }

        // Input capacity
        System.out.print("Enter knapsack capacity: ");
        int W = sc.nextInt();

        // Solve using backtracking
        int maxProfit = knapsack(weight, value, n, W);
        System.out.println("Maximum value in knapsack: " + maxProfit);
    }
}
//min heap
import java.util.ArrayList;

public class MinHeap {
    // ArrayList to store heap elements
    ArrayList<Integer> heap = new ArrayList<>();

    // Insert a value into the heap
    public void insert(int value) {
        heap.add(value); // Add to the end
        heapifyUp(heap.size() - 1); // Restore heap
    }

    // Delete a specific value from the heap
    public void delete(int value) {
        int index = heap.indexOf(value);

        if (index == -1) {
            System.out.println("Value " + value + " not found in heap.");
            return;
        }

        int lastIndex = heap.size() - 1;

        // If deleting the last element, just remove it
        if (index == lastIndex) {
            heap.remove(lastIndex);
            return;
        }

        // Replace with last element and remove last
        heap.set(index, heap.get(lastIndex));
        heap.remove(lastIndex);

        // Restore heap property
        heapifyDown(index);
        heapifyUp(index);
    }

    // Heapify up: fix heap from bottom to top
    private void heapifyUp(int index) {
        int parent = (index - 1) / 2;

        if (index > 0 && heap.get(index) < heap.get(parent)) {
            swap(index, parent);
            heapifyUp(parent);
        }
    }

    // Heapify down: fix heap from top to bottom
    private void heapifyDown(int index) {
        int smallest = index;
        int left = 2 * index + 1;
        int right = 2 * index + 2;

        if (left < heap.size() && heap.get(left) < heap.get(smallest)) {
            smallest = left;
        }

        if (right < heap.size() && heap.get(right) < heap.get(smallest)) {
            smallest = right;
        }

        if (smallest != index) {
            swap(index, smallest);
            heapifyDown(smallest);
        }
    }

    // Swap two elements in the heap
    private void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    // Display the contents of the heap
    public void display() {
        System.out.println("Heap contents: " + heap);
    }

    // Main method to test
    public static void main(String[] args) {
        MinHeap heap = new MinHeap();

        // Insert elements into the heap
        heap.insert(10);
        heap.insert(4);
        heap.insert(15);
        heap.insert(20);
        heap.insert(0);
        heap.insert(8);

        // Display initial heap
        heap.display();

        // Delete some elements
        heap.delete(15);
        heap.display();

        heap.delete(4);
        heap.display();

        heap.delete(100); // Value not in heap
    }
}


/// max heap
import java.util.ArrayList;

public class MaxHeap {
    ArrayList<Integer> heap = new ArrayList<>();

    // Insert a value into the max heap
    public void insert(int value) {
        heap.add(value);
        heapifyUp(heap.size() - 1);
    }

    // Delete any value from the heap
    public void delete(int value) {
        int index = heap.indexOf(value);

        if (index == -1) {
            System.out.println("Value " + value + " not found in heap.");
            return;
        }

        int lastIndex = heap.size() - 1;

        if (index == lastIndex) {
            heap.remove(lastIndex);
            return;
        }

        // Replace with last element and remove last
        heap.set(index, heap.get(lastIndex));
        heap.remove(lastIndex);

        // Restore heap property
        heapifyDown(index);
        heapifyUp(index);
    }

    // Heapify up for max heap (used after insert)
    private void heapifyUp(int index) {
        int parent = (index - 1) / 2;

        if (index > 0 && heap.get(index) > heap.get(parent)) {
            swap(index, parent);
            heapifyUp(parent);
        }
    }

    // Heapify down for max heap (used after delete)
    private void heapifyDown(int index) {
        int largest = index;
        int left = 2 * index + 1;
        int right = 2 * index + 2;

        if (left < heap.size() && heap.get(left) > heap.get(largest)) {
            largest = left;
        }

        if (right < heap.size() && heap.get(right) > heap.get(largest)) {
            largest = right;
        }

        if (largest != index) {
            swap(index, largest);
            heapifyDown(largest);
        }
    }

    // Swap helper method
    private void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    // Display the heap
    public void display() {
        System.out.println("Heap contents: " + heap);
    }

    // Main method to test the max heap
    public static void main(String[] args) {
        MaxHeap heap = new MaxHeap();

        // Insert elements
        heap.insert(10);
        heap.insert(4);
        heap.insert(15);
        heap.insert(20);
        heap.insert(0);
        heap.insert(8);

        // Display heap
        heap.display();

        // Delete a few elements
        heap.delete(15);
        heap.display();

        heap.delete(4);
        heap.display();

        heap.delete(100); // Not found
    }
}
