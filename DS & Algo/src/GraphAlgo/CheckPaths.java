package GraphAlgo;

import GraphAlgo.BasicGraphClasses.DoublyLinkedList;
import GraphAlgo.BasicGraphClasses.GraphBasic1;

import java.util.Stack;

public class CheckPaths {

    private static boolean checkPath(GraphBasic1 g2, int src, int dest) {

        if(src==dest)
            return true;

        boolean visited[]= new boolean[g2.vertices];

        Stack<Integer> stack= new Stack<>();

        stack.push(src);

        while(!stack.isEmpty()){
            int current_vertex= stack.pop();

            DoublyLinkedList<Integer>.Node temp=null;
            if(g2.adjacencyList[current_vertex]!=null)
                temp= g2.adjacencyList[current_vertex].headNode;
            while (temp!=null){
                if(!visited[temp.data]){
                    if(temp.data==dest)
                        return true;
                    stack.push(temp.data);
                    visited[temp.data]=true;
                }

                temp=temp.nextNode;

            }
        }

        return false;

    }
    public static void main(String[] args) {


        GraphBasic1 g1 = new GraphBasic1(9);
        g1.addEdge(0, 2);
        g1.addEdge(0, 5);
        g1.addEdge(2, 3);
        g1.addEdge(2, 4);
        g1.addEdge(5, 3);
        g1.addEdge(5, 6);
        g1.addEdge(3, 6);
        g1.addEdge(6, 7);
        g1.addEdge(6, 8);
        g1.addEdge(6, 4);
        g1.addEdge(7, 8);
        g1.printGraph();
        System.out.println("Path exists: " + checkPath(g1, 0, 7));
        System.out.println();
        GraphBasic1 g2 = new GraphBasic1(4);
        g2.addEdge(0, 1);
        g2.addEdge(1, 2);
        g2.addEdge(1, 3);
        g2.addEdge(2, 3);

        g2.printGraph();
        System.out.println("Path exists: " + checkPath(g2, 3, 0));


    }


}
