package GraphAlgo;

import java.util.LinkedList;
import java.util.Stack;

public class CountPaths {


    public static int countPaths(Graph g, int start, int destination) {

        int count=0;

        return countPathsRecursive(g,start,destination,count);

    }

    private static int countPathsRecursive(Graph g, int start, int destination, int count) {
        if(start==destination){
            count++;
        }
        LinkedList<Integer>[] list;
        list=g.getAdj();

        for(int i=0;i<list[start].size();i++){
            int adjVertex= list[start].get(i);
            count=countPathsRecursive(g,adjVertex,destination,count);
        }

        return count;

    }

    public static void main(String[] args) {
        int answer;

        Graph g1 = new Graph(6);
        g1.addEdge(0, 1);
        g1.addEdge(0, 2);
        g1.addEdge(1, 2);
        g1.addEdge(1, 3);
        g1.addEdge(3, 4);
        g1.addEdge(2, 3);
        g1.addEdge(4, 5);

        answer = CountPaths.countPaths(g1, 0, 5);
        System.out.println(answer);

        Graph g2 = new Graph(7);
        g2.addEdge(0, 1);
        g2.addEdge(1, 2);
        g2.addEdge(1, 5);
        g2.addEdge(2, 3);
        g2.addEdge(2, 4);
        g2.addEdge(5, 3);
        g2.addEdge(5, 6);
        g2.addEdge(3, 6);

        answer = CountPaths.countPaths(g2, 0, 3);
        System.out.println(answer);
    }

    static class Graph{
       private int vertices;
       private LinkedList<Integer>[] adjacencyList;


       Graph(int v) {
           this.vertices = v;
           this.adjacencyList = new LinkedList[vertices];
           for (int i = 0; i < v; i++) {
               this.adjacencyList[i] = new LinkedList<>();
           }
       }

           public void addEdge(int src,int dest){
               this.adjacencyList[src].add(dest);
           }

           public int getVertices() {
        return this.vertices;
       }

       public LinkedList<Integer>[] getAdj(){
           return this.adjacencyList;
       }
    }
}
