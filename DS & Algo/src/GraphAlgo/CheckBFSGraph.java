package GraphAlgo;

import GraphAlgo.BasicGraphClasses.DoublyLinkedList;
import GraphAlgo.BasicGraphClasses.GraphBasic1;

import java.util.LinkedList;
import java.util.Queue;

public class CheckBFSGraph {
    public static String bfs(GraphBasic1 g) {
        int v= g.vertices;
        String result = "";

        if(g.vertices<1){
            System.out.println(result);
            return result;
        }
        boolean[] visited= new boolean[g.vertices];
        for(int i=0;i< g.vertices;i++){
            if(!visited[i])
                result=result+ bfsHelper(g,i,visited);
        }
        return result;
    }

    private static String bfsHelper(GraphBasic1 g, int i, boolean[] visited) {
        String result = "";
        Queue<Integer> q1= new LinkedList<>();
        q1.add(i);
        visited[i]=true;
        while (!q1.isEmpty()){
            int curr_node= q1.poll();

            result+= String.valueOf(curr_node);

            DoublyLinkedList<Integer>.Node temp=null;
            if(g.adjacencyList[curr_node]!=null){
                temp=g.adjacencyList[curr_node].headNode;
            }

            while (temp!=null){
                if(!visited[temp.data]){
                    q1.add(temp.data);
                    visited[temp.data]=true;
                }
                temp=temp.nextNode;
            }
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
        System.out.println("BFS traversal of Graph1 : " + bfs(g));
        System.out.println();

        GraphBasic1 g2 = new GraphBasic1(5);
        g2.addEdge(0,1);
        g2.addEdge(0,4);
        g2.addEdge(1,2);
        g2.addEdge(3,4);
        System.out.println("Graph2:");
        g2.printGraph();
        System.out.println("BFS traversal of Graph2 : " + bfs(g2));
    }
}
