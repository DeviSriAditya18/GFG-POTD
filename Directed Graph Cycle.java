/*
Given a Directed Graph with V vertices (Numbered from 0 to V-1) and E edges, check whether it contains any cycle or not.
The graph is represented as a 2D vector edges[][], where each entry edges[i] = [u, v] denotes an edge from verticex u to v.

Examples:

Input: V = 4, edges[][] = [[0, 1], [1, 2], [2, 3], [3, 3]]
Output: true
Explanation: 3 -> 3 is a cycle

Input: V = 3, edges[][] = [[0, 1], [1, 2]]
Output: false
Explanation: no cycle in the graph 
*/

class Solution {
    public boolean isCyclic(int V, int[][] edges) {
        // code here
        boolean[] vis = new boolean[V];
        boolean[] pathvis = new boolean[V];
        
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++)
        {
            List<Integer> l = new ArrayList<>();
            adj.add(l);
        }
        
        for(int i=0;i<edges.length;i++)
        {
            if(edges[i][0]==edges[i][1])
            {
                return true;
            }
            else{
                adj.get(edges[i][0]).add(edges[i][1]);
            }
        }
        
        for(int i=0;i<V;i++)
        {
            if(!vis[i])
            {
                if(dfs(i,vis,pathvis,adj))
                {
                    return true;
                }
            }
        }
        
     return false;
    }
    public boolean dfs(int i, boolean[] vis, boolean[] pathvis,List<List<Integer>> adj)
    {
        vis[i]=true;
        pathvis[i]= true;
        
        for(int x:adj.get(i))
        {
            if(!vis[x])
            {
                if(dfs(x,vis,pathvis,adj))
                return true;
            }
            else if(pathvis[x])
            {
                return true;
            }
        }
        
        pathvis[i] = false;
        return false;
    }
}