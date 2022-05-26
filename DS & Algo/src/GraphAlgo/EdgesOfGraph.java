package GraphAlgo;

import GraphAlgo.BasicGraphClasses.DoublyLinkedList;
import GraphAlgo.BasicGraphClasses.GraphBasic1;

public class EdgesOfGraph {

    private static int numEdges(GraphBasic1 g) {

        int sum=0;
        for(int i=0;i<g.vertices;i++){
            DoublyLinkedList<Integer>.Node temp=null;
            if(g.adjacencyList[i]!=null)
                temp=g.adjacencyList[i].headNode;

            while (temp!=null){
                sum++;
                temp=temp.nextNode;
            }
        }
        //Directed return sum, undirecter return sum/2
        return sum;

    }
    public static void main(String args[]) {

        GraphBasic1 g = new GraphBasic1(9);
        g.addEdge(0,2);
        g.addEdge(0,5);
        g.addEdge(2,3);
        g.addEdge(2,4);
        g.addEdge(5,3);
        g.addEdge(5,6);
        g.addEdge(3,6);
        g.addEdge(6,7);
        g.addEdge(6,8);
        g.addEdge(6,4);
        g.addEdge(7,8);


        g.printGraph();
        System.out.println("Number of edges: " + numEdges(g));
        System.out.println();

        GraphBasic1 g2 = new GraphBasic1(7);
        g2.addEdge(1,2);
        g2.addEdge(1,3);
        g2.addEdge(3,4);
        g2.addEdge(3,5);
        g2.addEdge(2,5);
        g2.addEdge(2,4);
        g2.addEdge(4,6);
        g2.addEdge(4,5);
        g2.addEdge(6,5);

        //For DIrected
       /* >>Adjacency List of Directed Graph<<
                |0| => [2] -> [5] -> null
                |1| => null
                |2| => [3] -> [4] -> null
                |3| => [6] -> null
                |4| => null
                |5| => [3] -> [6] -> null
                |6| => [7] -> [8] -> [4] -> null
                |7| => [8] -> null
                |8| => null*/
        //for UnDirected
       /* |0| => [2] -> [5] -> null
                |1| => null
                |2| => [0] -> [3] -> [4] -> null
                |3| => [2] -> [5] -> [6] -> null
                |4| => [2] -> [6] -> null
                |5| => [0] -> [3] -> [6] -> null
                |6| => [5] -> [3] -> [7] -> [8] -> [4] -> null
                |7| => [6] -> [8] -> null
                |8| => [6] -> [7] -> null*/
        g2.printGraph();
        System.out.println("Number of edges: " + numEdges(g2));}


    }
