package GraphAlgo.BasicGraphClasses;

import java.util.LinkedList;

public class GraphBasic1 {
    public int vertices;
    public  DoublyLinkedList<Integer> adjacencyList[];

    public GraphBasic1(int vertices) {
        this.vertices = vertices;
        this.adjacencyList =  new DoublyLinkedList[vertices];

        for(int i=0;i<vertices;i++){
            adjacencyList[i]= new DoublyLinkedList<>();
        }
    }

    public void addEdge(int source,int destination){
        if(source <vertices && destination <vertices){
            this.adjacencyList[source].insertAtTail(destination);
        }
    }

    public DoublyLinkedList< Integer >[] getAdj() {
        return this.adjacencyList;
    }
    public void printGraph()
    {
        System.out.println(">>Adjacency List of Directed Graph<<");
        for (int i = 0; i < vertices; i++)
        {
            if(adjacencyList[i]!=null){
                System.out.print("|" + i + "| => ");

                DoublyLinkedList<Integer>.Node temp = adjacencyList[i].getHeadNode();
                while (temp != null)
                {
                    System.out.print("[" + temp.data + "] -> ");
                    temp = temp.nextNode;
                }
                System.out.println("null");
            }
            else{

                System.out.println("|" + i + "| => "+ "null");
            }
        }
        }

}
