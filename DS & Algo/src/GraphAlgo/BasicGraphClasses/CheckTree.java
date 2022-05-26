package GraphAlgo.BasicGraphClasses;

import java.util.Stack;

import static GraphAlgo.CheckCycle.detectCycle;

public class CheckTree {
    private static boolean isTreeCycleDetechtion(GraphBasic1 g) {
            if(!checkOneFather(g))
                return false;
            
            if(detectCycle(g))
                return false;
            
            if(!checkConnected(g,0))
                return false;

        return true;
    }

    private static boolean checkConnected(GraphBasic1 g, int src) {
        int vertices=g.vertices;
        int vertices_reached=0;

        boolean[] visited= new boolean[vertices];
        Stack<Integer> stack= new Stack<>();

        stack.push(src);
        visited[src]=true;

        while (!stack.isEmpty()){
            int current_node= stack.pop();

            DoublyLinkedList<Integer>.Node temp=null;

            if(g.adjacencyList[current_node]!=null)
                temp=g.adjacencyList[current_node].headNode;
            while (temp!=null){
                 if(!visited[temp.data]){
                     stack.push(temp.data);
                     visited[temp.data]=true;
                     vertices_reached++;
                 }
                 temp=temp.nextNode;
            }
        }

        return (vertices_reached+1)==g.vertices;
    }

    private static boolean checkOneFather(GraphBasic1 g) {
        int vertices=g.vertices;
        boolean[] hasOneParent= new boolean[g.vertices];

        for(int i=0;i<vertices;i++){
            DoublyLinkedList<Integer>.Node temp=null;

            if(g.adjacencyList[i]!=null)
                temp=g.adjacencyList[i].headNode;
            while (temp!=null){
                if(hasOneParent[temp.data])
                    return false;
                hasOneParent[temp.data]=true;
                temp=temp.nextNode;
            }
        }

        for(int i=0;i<vertices;i++){
            if(i==0 && hasOneParent[i]){
                return false;
            }
            else if (i!=0 && hasOneParent[i]== false){
                return false;
            }

        }

        return true;

    }

    public static void main(String[] args) {
        GraphBasic1 g = new GraphBasic1(5);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(0, 3);
        g.addEdge(3, 4);
        g.printGraph();
        System.out.println("isTree : " + isTreeCycleDetechtion(g));

        GraphBasic1 g2 = new GraphBasic1(4);
        g2.addEdge(0, 1);
        g2.addEdge(0, 2);
        g2.addEdge(0, 3);
        g2.addEdge(3, 2);
        g2.printGraph();
        System.out.println("isTree : " + isTreeCycleDetechtion(g2));

        GraphBasic1 g3 = new GraphBasic1(6);
        g3.addEdge(0, 1);
        g3.addEdge(0, 2);
        g3.addEdge(0, 3);
        g3.addEdge(4, 5);
        g3.printGraph();
        System.out.println("isTree : " + isTreeCycleDetechtion(g3));

    }


}
