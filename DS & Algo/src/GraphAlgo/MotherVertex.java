package GraphAlgo;

import GraphAlgo.BasicGraphClasses.DoublyLinkedList;
import GraphAlgo.BasicGraphClasses.GraphBasic1;

import java.util.Arrays;

//O(V+E)
public class MotherVertex {
    //Kosaraju’s Strongly Connected Component Algorithm
    //Run DFS and check every vertex is visited
    //Theory is the last vertex visited in the recursive DFS will be true
    //Because at the last vertex all slots in visited would be true (DFS will stop when all node are visited)
    //So keep track of last vertex V

    //Then reset visisteda array and run the DFS only on the lastV, if every node is true then yes otherwise no

    private static int getMotherVertex(GraphBasic1 g) {

        boolean[] visited= new boolean[g.vertices];
        int lastV=0;

        for(int i=0;i<visited.length;i++){
            if(!visited[i]){
                DFS(g,i,visited);
                lastV=i;
            }
        }

        Arrays.fill(visited,false);
        DFS(g,lastV,visited);

        for(int i=0;i<visited.length;i++){
            if(visited[i]==false){
                return -1;
            }
        }


        return lastV;

    }

    private static void DFS(GraphBasic1 g, int current_vertex, boolean[] visited) {
        visited[current_vertex]=true;
        DoublyLinkedList<Integer>.Node temp=null;
        if(g.adjacencyList[current_vertex]!=null)
            temp=g.adjacencyList[current_vertex].headNode;
        while(temp!=null){
            if(visited[temp.data]){
               temp= temp.nextNode;
            }
            else{
                visited[temp.data]=true;
                DFS(g,temp.data,visited);
                temp=temp.nextNode;
            }
        }
    }


    public static void main(String args[]) {

        GraphBasic1 g = new GraphBasic1(4);
        g.addEdge(0,1);
        g.addEdge(1,2);
        g.addEdge(3,0);
        g.addEdge(3,1);
        g.printGraph();
        System.out.println("Mother Vertex is: " + MotherVertex.getMotherVertex(g));

    }


}
