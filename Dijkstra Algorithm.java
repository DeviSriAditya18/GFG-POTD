/*
Given an undirected, weighted graph with V vertices numbered from 0 to V-1 and E edges, represented by 2d array edges[][], where edges[i]=[u, v, w] represents the edge between the nodes u and v having w edge weight.
You have to find the shortest distance of all the vertices from the source vertex src, and return an array of integers where the ith element denotes the shortest distance between ith node and source vertex src.

Note: The Graph is connected and doesn't contain any negative weight edge.

Examples:

Input: V = 3, edges[][] = [[0, 1, 1], [1, 2, 3], [0, 2, 6]], src = 2
Output: [4, 3, 0]
Explanation:
Shortest Paths:
For 2 to 0 minimum distance will be 4. By following path 2 -> 1 -> 0
For 2 to 1 minimum distance will be 3. By following path 2 -> 1
For 2 to 2 minimum distance will be 0. By following path 2 -> 2

Input: V = 5, edges[][] = [[0, 1, 4], [0, 2, 8], [1, 4, 6], [2, 3, 2], [3, 4, 10]], src = 0
Output: [0, 4, 8, 10, 10]
Explanation: 
Shortest Paths: 
For 0 to 1 minimum distance will be 4. By following path 0 -> 1
For 0 to 2 minimum distance will be 8. By following path 0 -> 2
For 0 to 3 minimum distance will be 10. By following path 0 -> 2 -> 3 
For 0 to 4 minimum distance will be 10. By following path 0 -> 1 -> 4
*/

class iPair{
    int first, second;
    iPair(int first, int second){
        this.first=first;
        this.second=second;
    }
}
// User function Template for Java
class Solution {
    public int[] dijkstra(int V, int[][] edges, int src) {
        // Initialize distance array
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        
        // Priority queue for Dijkstra's algorithm
        PriorityQueue<iPair> pq = new PriorityQueue<>((a, b) -> a.first - b.first);
        pq.add(new iPair(0, src));
        
        // Adjacency list representation of graph
        List<iPair>[] graph = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }
        
        // Building the graph from the edges array
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];
            graph[u].add(new iPair(v, weight));
            graph[v].add(new iPair(u, weight));  // Assuming undirected graph
        }
        
        // Dijkstra's algorithm
        while (!pq.isEmpty()) {
            iPair current = pq.poll();
            int d = current.first;  // current distance
            int u = current.second; // current node
            
            // Process neighbors of u
            for (iPair neighbor : graph[u]) {
                int v = neighbor.first;
                int weight = neighbor.second;
                
                // Relaxation step
                if (dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    pq.add(new iPair(dist[v], v));
                }
            }
        }
        
        return dist; // Return the final distance array
    }
}
