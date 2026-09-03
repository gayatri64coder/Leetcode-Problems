/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    private Map<Node, Node> cloned = new HashMap<>();

    public Node cloneGraph(Node node) {
        if(node == null){
            return null;
        }
        if(cloned.containsKey(node)){
            return cloned.get(node);
        }
        Node one = new Node(node.val);
        cloned.put(node, one);
        for(Node neighbors: node.neighbors){
            one.neighbors.add(cloneGraph(neighbors));
        }
        return one ;
    }
}