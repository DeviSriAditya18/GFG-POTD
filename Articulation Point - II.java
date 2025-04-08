/*
You are given an undirected graph with V vertices and E edges. The graph is represented as a 2D array edges[][], where each element edges[i] = [u, v] indicates an undirected edge between vertices u and v.
Your task is to return all the articulation points (or cut vertices) in the graph.
An articulation point is a vertex whose removal, along with all its connected edges, increases the number of connected components in the graph.

Note: The graph may be disconnected, i.e., it may consist of more than one connected component.
If no such point exists, return {-1}.

Examples :

Input: V = 5, edges[][] = [[0, 1], [1, 4], [4, 3], [4, 2], [2, 3]]
Output: [1, 4]
Explanation: Removing the vertex 1 or 4 will disconnects the graph as-
   
Input: V = 4, edges[][] = [[0, 1], [0, 2]]
Output: [0]
Explanation: Removing the vertex 0 will increase the number of disconnected components to 3. 
*/

class Solution {
    static boolean[] articulationPoint;
    static ArrayList<Integer> articulationPoints(int V, int[][] edges) {
        // code here
        boolean[] visited = new boolean[V];
        int[] parent = new int[V];
        int[] discovery = new int[V];
        int[] low = new int[V];
        articulationPoint = new boolean[V+1];
        Set<Integer> vertices = new HashSet<>();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int[] nums : edges){
            vertices.add(nums[0]);
            vertices.add(nums[1]);
            adj.get(nums[0]).add(nums[1]);
            adj.get(nums[1]).add(nums[0]);
        }
        
        ArrayList<Integer> res = new ArrayList<>();
        for(int v : vertices){
            parent[v] = -1;
            dfs(v,0,adj,visited,parent,discovery,low);
            ArrayList<Integer> ans = new ArrayList<>();
            for(int i=0;i<=V;i++){
                if(articulationPoint[i]) ans.add(i);
            }
            if(ans.size()>0) res=ans;
        }
        if(res.size()==0){
            res.add(-1);
        }
        return res;
    }
    public static void dfs(int u, int timer, ArrayList<ArrayList<Integer>> adj, boolean[] visited, int[] parent, int[] discovery, int[] low){
        visited[u] = true;
        discovery[u] = timer;
        low[u] = timer;
        int count = 0;
        for(int v : adj.get(u)){
            
            if(visited[v]==true && parent[u]==v){
                continue;
            }
            else if(visited[v] == true){
                low[u] = Math.min(low[u],discovery[v]);
            }
            else{
                parent[v] = u;
                count++;
                dfs(v,timer+1,adj,visited,parent,discovery,low);
                low[u] = Math.min(low[u],low[v]);
                if(parent[u] == -1){
                    if(count>=2) articulationPoint[u] = true;
                }
                else if(low[v]>=discovery[u]){
                    articulationPoint[u] = true;
                }
            }
        }
    }
}