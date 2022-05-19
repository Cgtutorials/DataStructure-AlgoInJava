package GraphAlgo;

import GraphAlgo.BasicGraphClasses.DoublyLinkedList;
import GraphAlgo.BasicGraphClasses.GraphBasic1;

import java.util.Stack;

public class CheckDFSGraph {

    public static String dfs(GraphBasic1 g){
        String result="";
        if(g.vertices<1){
            return "";
        }

        boolean[] visited= new boolean[g.vertices];

        for(int i=0;i<g.vertices;i++){
            if(!visited[i]){
                result += dfsHelper(g,i,visited);
            }
        }

        return result;
    }

    private static String dfsHelper(GraphBasic1 g, int currentVertex, boolean[] visited) {
        String result="";
        Stack<Integer> stack= new Stack<>();
        stack.push(currentVertex);

        while(!stack.isEmpty()){
            int current_node= stack.pop();
            result+= String.valueOf(current_node);

            DoublyLinkedList<Integer>.Node temp=null;
            if(g.adjacencyList[current_node]!=null)
                temp=g.adjacencyList[current_node].headNode;

            while (temp!=null){
                if(!visited[temp.data]){
                    stack.push(temp.data);
                }
                temp=temp.nextNode;
            }

            visited[current_node]=true;
        }
        return result;
    }

    public static void main(String[] args) {
        GraphBasic1 g = new GraphBasic1(5);
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(1,3);
        g.addEdge(1,4);
        System.out.println("Graph1:");
        g.printGraph();
        System.out.println("DFS traversal of Graph1 : " + dfs(g));
        System.out.println();

        GraphBasic1 g2 = new GraphBasic1(5);
        g2.addEdge(0,1);
        g2.addEdge(0,4);
        g2.addEdge(1,2);
        g2.addEdge(4,3);
        System.out.println("Graph2:");
        g2.printGraph();
        System.out.println("DFS traversal of Graph2 : " + dfs(g2));
    }
}
