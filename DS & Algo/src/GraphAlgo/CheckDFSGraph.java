package GraphAlgo;

import GraphAlgo.BasicGraphClasses.DoublyLinkedList;
import GraphAlgo.BasicGraphClasses.GraphBasic1;

import java.util.Stack;

public class CheckDFSGraph {
    public static String dfs(GraphBasic1 g) {
        StringBuilder sb= new StringBuilder();
        int v= g.vertices;
        if(g.vertices<1){
            return "";
        }
        boolean[] visited= new boolean[g.vertices];

        for(int i=0;i<v;i++){
            if(!visited[i]){
                String s= dfsHelper(i,g,visited);
                sb.append(s);
            }
        }

       return  sb.toString();
    }

    private static String dfsHelper(int i, GraphBasic1 g, boolean[] visited) {

        Stack<Integer> s1= new Stack<>();
        StringBuilder sb= new StringBuilder();
        s1.push(i);

        while (!s1.isEmpty()){
            int current_node= s1.pop();
            sb.append(current_node);

            DoublyLinkedList<Integer>.Node temp=null;
            if(g.adjacencyList[current_node]!=null){
                temp= g.adjacencyList[current_node].headNode;
            }
            while(temp!=null){
                if(!visited[temp.data]){
                    s1.push(temp.data);
                }
                temp=temp.nextNode;
            }

            //Only Change Here is this
            visited[current_node]=true;

        }

            return sb.toString();
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
