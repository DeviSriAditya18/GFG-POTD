/*
Given a 2D array houses[][], consisting of n 2D coordinates {x, y} where each coordinate represents the location of each house, the task is to find the minimum cost to connect all the houses of the city.

The cost of connecting two houses is the Manhattan Distance between the two points (xi, yi) and (xj, yj) i.e., |xi – xj| + |yi – yj|, where |p| denotes the absolute value of p.

Examples :

Input: n = 5 houses[][] = [[0, 7], [0, 9], [20, 7], [30, 7], [40, 70]]
Output: 105
Explanation:
Connect house 1 (0, 7) and house 2 (0, 9) with cost = 2
Connect house 1 (0, 7) and house 3 (20, 7) with cost = 20
Connect house 3 (20, 7) with house 4 (30, 7) with cost = 10 
At last, connect house 4 (30, 7) with house 5 (40, 70) with cost 73.
All the houses are connected now.
The overall minimum cost is 2 + 10 + 20 + 73 = 105.

Input: n = 4 houses[][] = [[0, 0], [1, 1], [1, 3], [3, 0]]
Output: 7
Explanation: 
Connect house 1 (0, 0) with house 2 (1, 1) with cost = 2
Connect house 2 (1, 1) with house 3 (1, 3) with cost = 2 
Connect house 1 (0, 0) with house 4 (3, 0) with cost = 3 
The overall minimum cost is 3 + 2 + 2 = 7.
*/

class DisjointSet{
    List<Integer> parent=new ArrayList<>();
    List<Integer> size=new ArrayList<>();
    public DisjointSet(int n){
        for(int i=0;i<n;i++){
            parent.add(i);
            size.add(1);
        }
    }
    public int findpar(int n){
        if(n==parent.get(n)) return n;
        int ulp = findpar(parent.get(n));
        parent.set(n,ulp);
        return parent.get(n);
    }
    public boolean union(int u,int v){
        int ulp_u=findpar(u);
        int ulp_v=findpar(v);
        if(ulp_u==ulp_v) return false;
        parent.set(ulp_v,ulp_u);
        return true;
    }
}

class Solution {

    public int minCost(int[][] houses) {
        // code here
        int n = houses.length;
        //use min heap  priority queue to track the minimum cost edge 
        //add the 2 points and cost to heap
        //apply union find and keep track of cost 
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b)->a[2]-b[2]);
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int dist = Math.abs(houses[i][0]-houses[j][0])+Math.abs(houses[i][1]-houses[j][1]);
                pq.add(new int[]{i,j,dist});
            }
        }
        DisjointSet ds = new DisjointSet(n+1);
        int mincost =0;
        int edges=0;
        while(!pq.isEmpty()){
            int [] node = pq.poll();
            int a = node[0];
            int b = node[1];
            if(ds.union(a,b)){
                edges++;
                mincost+=node[2];
            }
            if(edges==n-1)return mincost;
        }
        return mincost;
        
    }
}
