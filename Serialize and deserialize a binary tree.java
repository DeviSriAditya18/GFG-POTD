/*
Serialization is to store a tree in an array so that it can be later restored and deserialization is reading tree back from the array. Complete the functions

serialize() : stores the tree into an array a and returns the array.
deSerialize() : deserializes the array to the tree and returns the root of the tree.
Note: Multiple nodes can have the same data and the node values are always positive integers. Your code will be correct if the tree returned by deSerialize(serialize(input_tree)) is same as the input tree. Driver code will print the in-order traversal of the tree returned by deSerialize(serialize(input_tree)).

Examples :

Input: root = [1, 2, 3]  
Output: [2, 1, 3]

Input: root = [10, 20, 30, 40, 60, N, N]
Output: [40, 20, 60, 10, 30]
*/

class Tree {
    // Function to serialize a tree and return a list containing nodes of tree.
    public ArrayList<Integer> serialize(Node root) {
        // code here
        ArrayList<Integer> a=new ArrayList<>();
        if(root==null) return a;
        Queue<Node> q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            Node curr=q.poll();
            if(curr!=null){
                a.add(curr.data);
                q.offer(curr.left);
                q.offer(curr.right);
            }
            else a.add(-1);
        }
        return a;
    }

    // Function to deserialize a list and construct the tree.
    public Node deSerialize(ArrayList<Integer> arr) {
        // code here
        if(arr == null || arr.isEmpty()) return null;
        int i=0;
        Node root=new Node(arr.get(i++));
        Queue<Node> q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            Node curr=q.poll();
            int lv=arr.get(i++);
            if(lv!=-1){
                curr.left=new Node(lv);
                q.offer(curr.left);
            }
            int rv=arr.get(i++);
            if(rv!=-1){
                curr.right=new Node(rv);
                q.offer(curr.right);
            }
        }
        return root;
    }
};