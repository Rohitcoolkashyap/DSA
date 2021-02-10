package graph;

import java.util.Arrays;

public class Adjacency_matrix {
    int[][] matrix;
    char[] vertices;
    public Adjacency_matrix(int numOfVertices)
    {
        matrix = new int[numOfVertices][numOfVertices];
        vertices = new char[numOfVertices];
    }
    void addVertices(char ...a){
        System.arraycopy(a, 0, vertices, 0, a.length);
    }
    void addEgde(int i,int j){
        matrix[i][j] = 1;
        matrix[j][i] = 1;
    }
    void removeEdge(int i,int j){
        matrix[i][j] = 0;
        matrix[j][i] = 0;
    }

    void show(){
        for (int[] a:matrix
             ) {
            System.out.println(Arrays.toString(a));

        }
    }
    public static void main(String[] arg){


        Adjacency_matrix gp = new Adjacency_matrix(4);
        gp.addVertices('a','b','c','d');
        gp.addEgde(0,1);
        gp.addEgde(0,2);
        gp.addEgde(0,3);
        gp.addEgde(1,2);

        System.out.println(Arrays.toString(gp.vertices));
        gp.show();
     }
}
