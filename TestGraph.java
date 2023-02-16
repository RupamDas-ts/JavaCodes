import java.util.ArrayList;

class Node{
    private int v;
    private int w;
    public Node(int v,int w){
        this.v = v;
        this.w = w;
    }
    public int getV(){
        return v;
    }
    public int getW(){
        return w;
    }
}

class Graph{
    ArrayList<ArrayList<Node>> adj;
    public Graph(int n){
        adj = new ArrayList<ArrayList<Node>>(n);
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<Node>());
        }
    }
    public void addEdge(int parent, int child, int weight){
        adj.get(parent).add(new Node(child,weight));
        adj.get(child).add(new Node(parent,weight));
    }

    public void printGraph(){
        for(int j=0; j<adj.size(); j++){
            for (int k=0; k<adj.get(j).size(); k++){
                System.out.print(j+"----> ");
                System.out.print(adj.get(j).get(k).getV()+"---"+adj.get(j).get(k).getW());
                System.out.println();
            }
        }
    }

    public ArrayList<ArrayList<Node>> getGraph(){
        return adj;
    }
}

public class TestGraph {
    public static void main(String[] args) {
        Graph g = new Graph(5);
        g.addEdge(0, 1,4);
        g.addEdge(0, 4,6);
        g.addEdge(1, 2,7);
        g.addEdge(1, 3,1);
        g.addEdge(1, 4,2);
        g.addEdge(2, 3,3);
        g.addEdge(3, 4,5);

        g.printGraph();

        System.out.println("BFS Traversal from 0: ");
        BFSGraph bfs = new BFSGraph();
        bfs.BFSTrversal(g.getGraph(),0);

        System.out.println();
        System.out.println("DFS Traversal from 0: ");
        DFSGraph dfs = new DFSGraph();
        dfs.DFSTraversal(g.getGraph(),0);
    }
}
