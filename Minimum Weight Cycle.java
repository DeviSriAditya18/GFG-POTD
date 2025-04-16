/*
Given an undirected, weighted graph with V vertices numbered from 0 to V-1 and E edges, represented by a 2d array edges[][], where edges[i] = [u, v, w] represents the edge between the nodes u and v having w edge weight.
Your task is to find the minimum weight cycle in this graph.

Examples:

Input: V = 5, edges[][] = [[0, 1, 2], [1, 2, 2], [1, 3, 1], [1, 4, 1], [0, 4, 3], [2, 3, 4]]
Output: 6
Explanation: 
Minimum-weighted cycle is  0 → 1 → 4 → 0 with a total weight of 6(2 + 1 + 3)

Input: V = 5, edges[][] = [[0, 1, 3], [1, 2, 2], [0, 4, 1], [1, 4, 2], [1, 3, 1], [3, 4, 2], [2, 3, 3]]
Output: 5
Explanation: 
Minimum-weighted cycle is  1 → 3 → 4 → 1 with a total weight of 5(1 + 2 + 2)
*/

class Solution {
    public int findMinCycle(int V, int[][] edges) {
        // code here
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            graph.putIfAbsent(u, new ArrayList<>());
            graph.putIfAbsent(v, new ArrayList<>());
            graph.get(u).add(new int[]{v, w});
        }

        int INF = Integer.MAX_VALUE;
        int minCycle = INF;

        // For each edge, remove it and run Dijkstra
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            // Temporarily remove the edge u-v
            graph.get(u).removeIf(neighbor -> neighbor[0] == v && neighbor[1] == w);
            graph.get(v).removeIf(neighbor -> neighbor[0] == u && neighbor[1] == w);

            // Run Dijkstra from u to v
            int[] dist = new int[V];
            Arrays.fill(dist, INF);
            dist[u] = 0;
            PriorityQueue<int[]> heap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
            heap.offer(new int[]{0, u});

            while (!heap.isEmpty()) {
                int[] current = heap.poll();
                int d = current[0], node = current[1];

                if (d > dist[node]) {
                    continue;
                }

                for (int[] nei : graph.get(node)) {
                    int neighbor = nei[0], wt = nei[1];
                    if (dist[neighbor] > dist[node] + wt) {
                        dist[neighbor] = dist[node] + wt;
                        heap.offer(new int[]{dist[neighbor], neighbor});
                    }
                }
            }

            if (dist[v] != INF) {
                minCycle = Math.min(minCycle, dist[v] + w);
            }

            // Add the edge back
            graph.get(u).add(new int[]{v, w});
            graph.get(v).add(new int[]{u, w});
        }

        return minCycle != INF ? minCycle : -1;
    }
};
