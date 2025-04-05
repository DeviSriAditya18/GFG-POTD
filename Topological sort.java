/*
Given a Directed Acyclic Graph (DAG) of V (0 to V-1) vertices and E edges represented as a 2D list of edges[][], where each entry edges[i] = [u, v] denotes an directed edge u -> v. Return topological sort for the given graph.

Topological sorting for Directed Acyclic Graph (DAG) is a linear ordering of vertices such that for every directed edge u -> v, vertex u comes before v in the ordering.
Note: As there are multiple Topological orders possible, you may return any of them. If your returned Topological sort is correct then the output will be true else false.

Examples:

Input: V = 4, E = 3, edges[][] = [[3, 0], [1, 0], [2, 0]]
Output: true
Explanation: The output true denotes that the order is valid. Few valid Topological orders for the given graph are:
[3, 2, 1, 0]
[1, 2, 3, 0]
[2, 3, 1, 0]

Input: V = 6, E = 6, edges[][] = [[1, 3], [2, 3], [4, 1], [4, 0], [5, 0], [5,2]]
Output: true
Explanation: The output true denotes that the order is valid. Few valid Topological orders for the graph are:
[4, 5, 0, 1, 2, 3]
[5, 2, 4, 0, 1, 3]
*/

class Solution {
    public static ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        ArrayList<ArrayList<Integer>>adjList=new ArrayList<>();
        for (int i=0;i<V;i++){
            adjList.add(new ArrayList<>());
        }
        for (int[] edge:edges){
            int u=edge[0];
            int v=edge[1];
            adjList.get(u).add(v);
        }
        int [] visited=new int [V];
        Stack<Integer>stack=new Stack<>();
        
        for(int i=0;i<V;i++){
            if (visited[i]==0){
                dfs(i,visited,stack,adjList);
            }
        }
        ArrayList<Integer>res=new ArrayList<>();
        while(!stack.isEmpty()){
            res.add(stack.pop());
        }
    return res;
    }
    private static void dfs(int ver,int [] visited,Stack<Integer>stack,ArrayList<ArrayList<Integer>>adjList){
        visited[ver]=1;
        for (int neighbour:adjList.get(ver)){
            if (visited[neighbour]==0){
                dfs(neighbour,visited,stack,adjList);
            }
        }
        stack.push(ver);
    }
}