import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class DFSGraph {
    public void DFSTraversal(ArrayList<ArrayList<Node>> graph, int source){
        Stack<Integer> stack = new Stack<>();
        int[] visited = new int[graph.size()];
        stack.push(source);
        int current,temp;
        while (!stack.isEmpty()){
            current = stack.pop();
            if(visited[current]!=1){
                visited[current] = 1;
                System.out.print(current+"----->");
                for(int i=0; i<graph.get(current).size(); i++){
                    temp = graph.get(current).get(i).getV();
                    if(visited[temp]!=1){
                        stack.push(temp);
                    }
                }
            }
        }
    }
}
