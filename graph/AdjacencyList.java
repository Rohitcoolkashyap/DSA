package graph;

import java.util.ArrayList;
public class AdjacencyList {
    ArrayList<ArrayList<Integer>> list;
    public AdjacencyList(int numVertices)
    {
        list = new ArrayList<ArrayList<Integer>>(numVertices);
        for (int i = 0; i <numVertices ; i++) {
            list.add(new ArrayList<Integer>());
        }
    }
    void addEdge(int i,int j){
        list.get(i).add(j);
        list.get(j).add(i);
    }
    public static void main(String[] arg){
        AdjacencyList graph = new AdjacencyList(4);
        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(0,3);
        graph.addEdge(1,2);
        System.out.println(graph.list);
    }
}