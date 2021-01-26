package graph;

import java.util.*;

public class AdjacencyList_generic<T> {

    // We use Hashmap to store the edges in the graph
    private final Map<T, List<T>> adjList = new HashMap<>();

    // This function adds a new vertex to the graph
    public void addVertex(T vertex) {
        adjList.put(vertex, new LinkedList<>());
    }

    // This function adds the edge
    // between source to destination
    public void addEdge(T source, T destination, boolean biDir) {
        if (!adjList.containsKey(source))
            addVertex(source);
        if (!adjList.containsKey(destination))
            addVertex(destination);

        adjList.get(source).add(destination);
        if (biDir) {
            adjList.get(destination).add(source);
        }
    }

    // This function gives the count of vertices
    public void getVertexCount() {
        System.out.println("The graph has "
                + adjList.keySet().size()
                + " vertex");
    }


    // This function gives the count of edges
    public void getEdgesCount(boolean bidirection) {
        int count = 0;
        for (T v : adjList.keySet()) {
            count += adjList.get(v).size();
        }
        if (bidirection) {
            count = count / 2;
        }
        System.out.println("The graph has "
                + count
                + " edges.");
    }

    // This function gives whether
    // a vertex is present or not.
    public void hasVertex(T s) {
        if (adjList.containsKey(s)) {
            System.out.println("The graph contains "
                    + s + " as a vertex.");
        } else {
            System.out.println("The graph does not contain "
                    + s + " as a vertex.");
        }
    }

    // This function gives whether an edge is present or not.
    public void hasEdge(T s, T d) {
        if (adjList.get(s).contains(d)) {
            System.out.println("The graph has an edge between "
                    + s + " and " + d + ".");
        } else {
            System.out.println("The graph has no edge between "
                    + s + " and " + d + ".");
        }
    }

    // Prints the adjancency list of each vertex.
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        for (T v : adjList.keySet()) {
            builder.append(v.toString()).append(": ");
            for (T w : adjList.get(v)) {
                builder.append(w.toString()).append(" ");
            }
            builder.append("\n");
        }

        return (builder.toString());
    }

    // BFS
    public void bfs(T source) {
        Queue<T> q = new LinkedList<>();
        Set<T> isVisited = new HashSet<>();
        q.offer(source);
        isVisited.add(source);
        System.out.println("BFS");
        while (!q.isEmpty()) {
            T node = q.peek();
            System.out.print(node + " ");
            q.remove();

            // for the neighbours of the current node , if not visited
            for (T neighbour : adjList.get(node)
            ) {
                if (!isVisited.contains(neighbour)) {
                    q.offer(neighbour);
                    isVisited.add(neighbour);
                }
            }
        }
    }
    // BFS shortest path
    public void bfs_shortest_path(T source) {
        Queue<T> q = new LinkedList<>();
        Map<T,Integer> distances = new HashMap<>();
        Map<T,T> parent = new HashMap<>();

        q.offer(source);
        distances.put(source,0);
        while (!q.isEmpty()) {
            T node = q.peek();
            System.out.print(node + " ");
            q.remove();

            // for the neighbours of the current node , if not visited
            for (T neighbour : adjList.get(node)
            ) {
                if (!distances.containsKey(neighbour)) {
                    q.offer(neighbour);
                    distances.put(neighbour,distances.get(node)+1);
                    parent.put(neighbour,node);
                }
            }
        }
        for (T i:distances.keySet()
             ) {
            System.out.println("\ndist of node "+i+" from "+source+" is "+distances.get(i));

        }
    }

    public void dfdUtil(T vertex, Set<T> isVisited) {
        isVisited.add(vertex);
        System.out.print(vertex+" ");

        // for the neighbours of the current node , if not visited

        for (T neighbour : adjList.get(vertex)
        ) {
            if (!isVisited.contains(neighbour)) {
                dfdUtil(neighbour, isVisited);
            }
        }
    }

    public void dfs(T source) {
        Set<T> isVisited = new HashSet<>();
        System.out.println("DFS");
        dfdUtil(source, isVisited);
    }

    // Topological sort
//    public void topologicalSortUtil(int i,boolean[] visited,Stack<Integer> stack){
//        visited[i] = true;
//
//        for (T neighbours:adjList.get()
//             ) {
//
//        }
//
//    }
//    public  void topologicalSort(){
//        Stack<Integer> stack = new Stack<>();
//        int v =  adjList.keySet().size();
//        boolean[] visited = new boolean[v];
//
//        for (int i = 0; i < v; i++) {
//            if(!visited[i])
//                topologicalSortUtil(i,visited,stack);
//
//        }
//    }
    
    void dfsTopologicalSort(){
        Map<T,Boolean> visited = new HashMap<>();
        List<T> ordering = new LinkedList<>();

        for (T vertex:adjList.keySet()
             ) {
            
        }
    }

    public static void main(String[] arg) {

        // Object of graph is created.
        AdjacencyList_generic<Integer> g = new AdjacencyList_generic<>();

        // edges are added.
        // Since the graph is bidirectional,
        // so boolean bidirectional is passed as true.

        g.addEdge(0, 1, true);
        g.addEdge(0, 4, true);
        g.addEdge(1, 2, true);
        g.addEdge(1, 3, true);
        g.addEdge(1, 4, true);
        g.addEdge(2, 3, true);
        g.addEdge(3, 4, true);
        // print the graph.
        System.out.println("Graph:\n"
                + g.toString());


 /*       // gives the no of vertices in the graph.
        g.getVertexCount();

        // gives the no of edges in the graph.
        g.getEdgesCount(true);

        // tells whether the edge is present or not.
        g.hasEdge(3, 4);

        // tells whether vertex is present or not
        g.hasVertex(5);*/

//        g.bfs(0);
//        System.out.println();
//        g.dfs(0);


        g.bfs_shortest_path(2);
       // g.topologicalSort();
    }

}
