import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFSGraph {
    public void BFSTrversal(ArrayList<ArrayList<Node>> graph, int source){
        Queue<Integer> q = new LinkedList<>();
        int[] visited = new int[graph.size()];
        q.offer(source);
        int current,temp;
        while (!q.isEmpty()){
            current = q.poll();
            if(visited[current]!=1){
                visited[current] = 1;
                System.out.print(current+"----->");
                for(int i=0; i<graph.get(current).size(); i++){
                    temp = graph.get(current).get(i).getV();
                    if(visited[temp]!=1){
                        q.offer(temp);
                    }
                }
            }
        }
    }
}
