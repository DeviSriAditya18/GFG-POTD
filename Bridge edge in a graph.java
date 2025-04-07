/*
Given an undirected graph with V vertices numbered from 0 to V-1 and E edges, represented by 2d array edges[][], where edges[i]=[u,v] represents the edge between the vertices u and v. Determine whether a specific edge between two vertices (c, d) is a bridge.

Note:

An edge is called a bridge if removing it increases the number of connected components of the graph.
if there’s only one path between c and d (which is the edge itself), then that edge is a bridge.
Examples :

Input:
c = 1, d = 2
Output: true
Explanation: From the graph, we can clearly see that blocking the edge 1-2 will result in disconnection of the graph.
Hence, it is a Bridge.

Input:
c = 0, d = 2
Output: false
Explanation:
Blocking the edge between nodes 0 and 2 won't affect the connectivity of the graph.
So, it's not a Bridge Edge. All the Bridge Edges in the graph are marked with a blue line in the above image.
*/

class Solution {
    public boolean isBridge(int V, int[][] edges, int u, int v) {
        // code here
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            adj.get(a).add(b);
            adj.get(b).add(a);
        }

        // Step 2: Count components before removing the edge
        boolean[] visited = new boolean[V];
        int componentsBefore = countComponents(V, adj, visited);

        // Step 3: Remove the edge (u, v)
        adj.get(u).remove((Integer) v);
        adj.get(v).remove((Integer) u);

        // Step 4: Count components after removing the edge
        visited = new boolean[V]; // Reset visited
        int componentsAfter = countComponents(V, adj, visited);

        // Step 5: If the number of components increases, it's a bridge
        return componentsAfter > componentsBefore;
    }
    private int countComponents(int V, List<List<Integer>> adj, boolean[] visited) {
        int count = 0;
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(i, adj, visited);
                count++;
            }
        }
        return count;
    }

    private void dfs(int node, List<List<Integer>> adj, boolean[] visited) {
        visited[node] = true;
        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, adj, visited);
            }
        }
    }
}
