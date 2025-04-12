/*
Given a connected undirected graph represented by adjacency list, adjList[][] with n nodes, having a distinct label from 0 to n-1, where each adj[i] represents the list of vertices connected to vertex i.

Create a clone of the graph, where each node in the graph contains an integer val and an array (neighbors) of nodes, containing nodes that are adjacent to the current node.

class Node {
    val: integer
    neighbors: List[Node]
}
Your task is to complete the function cloneGraph( ) which takes a starting node of the graph as input and returns the copy of the given node as a reference to the cloned graph.

Note: If you return a correct copy of the given graph, then the driver code will print true; and if an incorrect copy is generated or when you return the original node, the driver code will print false.

Examples :

Input: n = 4, adjList[][] = [[1, 2], [0, 2], [0, 1, 3], [2]]
Output: true
Explanation: 
As the cloned graph is identical to the original one the driver code will print true.

Input: n = 3, adjList[][] = [[1, 2], [0], [0]]
Output: true
Explanation: 
As the cloned graph is identical to the original one the driver code will print true.
*/

class Solution {
    Node cloneGraph(Node node) {
        // code here
        HashMap<Integer, Node> hm = new HashMap();
        HashSet<Integer> visited = new HashSet();
        Queue<Node> q = new LinkedList();
        
        //Initial Adding
        q.add(node);
        hm.put(node.val, new Node(node.val, new ArrayList()));
        
        while(!q.isEmpty()){
            // put node in visited
            Node cur = q.remove();
            visited.add(cur.val);
            ArrayList<Node> neighbours = hm.get(cur.val).neighbors ;
            
            // traverse the entire arraylist
            for(Node n : cur.neighbors){
                if( !visited.contains(n.val)){
                    q.add(n);
                    hm.put(n.val,  new Node(n.val, new ArrayList()));   
                }
                neighbours.add(hm.get(n.val));
            }
        }
        return hm.get(node.val);

    }
}