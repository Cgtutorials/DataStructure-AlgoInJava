package GraphAlgo;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class StronglyConnectedGraph {


    public static  boolean checkStronglyConnectedGraph(Graph g){
        int v=g.getVertices();
        boolean visited[]= new boolean[v];

        utilityFunction1(g,0,visited);

        for(int i=0;i<v;i++){
            System.out.print("before transpose " + visited[i] +" ");
            if(!visited[i]){
                return false;
            }
        }
        System.out.println();
        // ab ulta karke check karna ki sab kushal mangal hai ki nahi

        Graph g1= getTranspose(v,g);
        Arrays.fill(visited,false);
        utilityFunction(g1,0,visited);

        for(int i=0;i<v;i++){
            System.out.print("after transpose " + visited[i] +" ");
            if(!visited[i]){
                return false;
            }
        }
        System.out.println();
        return true;
    }
    public static void utilityFunction(Graph g, int v, boolean visited[]) {

        visited[v] = true;
        int temp;
        LinkedList < Integer > Llist[];
        Llist = g.getAdj();
        Iterator < Integer > i = Llist[v].iterator();
        while (i.hasNext()) {

            temp = i.next();
            if (!visited[temp])
                utilityFunction(g, temp, visited);
        }
    }

    private static void utilityFunction1(Graph g, int vertex, boolean[] visited) {

        visited[vertex]=true;
        LinkedList<Integer>[] list;
        list=g.getAdj();
        for(int i=0;i<list[vertex].size();i++){
            int temp= list[vertex].get(i);
            if(!visited[temp]){
                utilityFunction(g,temp,visited);
            }
        }

    }


    public static Graph getTranspose(int v,Graph g){

    for(int i=0;i<v;i++){
        Iterator<Integer> itr= g.adjacencyList[i].listIterator();
        while (itr.hasNext()){
            g.adjacencyList[itr.next()].add(i);
        }
    }
    return g;
}
    static class Graph {
        private int vertices; //number of vertices
        private LinkedList< Integer > adjacencyList[]; //Adjacency Lists
        @SuppressWarnings("unchecked")
            // Constructor
        Graph(int vert) {
            this.vertices = vert;
            this.adjacencyList = new LinkedList[vertices];
            for (int i = 0; i < this.vertices; ++i)
                this.adjacencyList[i] = new LinkedList();
        }

        // Function to add an edge into the graph
        void addEdge(int source, int destination) {
            this.adjacencyList[source].add(destination);
        }

        public int getVertices() {
            return this.vertices;
        }

        public LinkedList < Integer > [] getAdj() {
            return this.adjacencyList;
        }

        void printGraph() {

            for (int v = 0; v < this.vertices; v++) {
                System.out.print(v);
                for (Integer pCrawl: this.adjacencyList[v]) {
                    System.out.print("->" + pCrawl);
                }
                System.out.print("\n");
            }
        }
    };


    public static void main(String args[]) {
        Graph g1 = new Graph(5);
        g1.addEdge(0, 1);
        g1.addEdge(1, 2);
        g1.addEdge(2, 3);
        g1.addEdge(3, 0);
        g1.addEdge(2, 4);
        g1.addEdge(4, 2);

       // boolean x = StronglyConnectedGraph.checkStronglyConnectedGraph(g1);
       // System.out.println("Graph g1 is strongly connected? " + x);


        Graph g2 = new Graph(4);
        g2.addEdge(0, 1);
        g2.addEdge(1, 2);
        g2.addEdge(2, 3);

        boolean y =  StronglyConnectedGraph.checkStronglyConnectedGraph(g2);
        System.out.println("Graph g2 is strongly connected? " + y);
    }
}
