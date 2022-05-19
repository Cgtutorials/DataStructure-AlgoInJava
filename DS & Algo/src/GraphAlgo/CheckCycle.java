package GraphAlgo;

import GraphAlgo.BasicGraphClasses.DoublyLinkedList;
import GraphAlgo.BasicGraphClasses.GraphBasic1;

public class CheckCycle {

    private static boolean detectCycle(GraphBasic1 g2) {
        int vertices= g2.vertices;

        boolean[] visited= new boolean[vertices];
        boolean[] pathCrossed= new boolean[vertices];

        for(int i=0;i<vertices;i++){
            if(detectCycleHelper(g2,i,visited,pathCrossed))
                return true;
        }

        return false;

    }

    private static boolean detectCycleHelper(GraphBasic1 g2, int currentVertex, boolean[] visited, boolean[] pathCrossed) {
        if(pathCrossed[currentVertex]){
            return true;
        }

        if(visited[currentVertex]){
            return false;
        }

        visited[currentVertex] = true;
        pathCrossed[currentVertex]= true;

        DoublyLinkedList<Integer>.Node temp=null;
        if(g2.adjacencyList[currentVertex]!=null)
            temp= g2.adjacencyList[currentVertex].headNode;
        while (temp!=null){
            if(detectCycleHelper(g2,temp.data,visited,pathCrossed))
                return true;
            temp=temp.nextNode;
        }

        pathCrossed[currentVertex]= false;

        return false;


    }

    public static void main(String args[]) {
        GraphBasic1 g1 = new GraphBasic1(4);
        g1.addEdge(0,1);
        g1.addEdge(1,2);
        g1.addEdge(1,3);
        g1.addEdge(3,0);
        g1.printGraph();
        System.out.println(detectCycle(g1));

        System.out.println();
        GraphBasic1 g2 = new GraphBasic1(3);
        g2.addEdge(0,1);
        g2.addEdge(1,2);
        g2.printGraph();
        System.out.println(detectCycle(g2));
    }


}
