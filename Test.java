class Test {
    public static void main(String[] arg) {
        System.out.println("c".contentEquals("r"));
    }
    public static int minCostToDestination(int[][] matrix, int x, int y) {
        int t =   minCostToDestinationUtil(matrix,x,y,0,0,"");
        System.out.println(t);
        return 1;
    }
    static int cost = 0;
    static int min = Integer.MAX_VALUE;
    public static int minCostToDestinationUtil(int[][] matrix,int x,int y,int row,int col,String c){

        if(c.contentEquals("r"))
            cost++;
        System.out.println("cost :"+cost);
        if(row <0 || col <0 ||
                x <0 || y <0 ||
                row >matrix.length-1 || col > matrix[0].length-1 ||
                x >matrix.length-1 || y > matrix[0].length-1
        )
            return min;
        if(matrix[x][y] == matrix[row][col])
        {
            min = Math.min(min,cost);
            System.out.println("min = "+min);
            cost = 0;
            return min;
        }

        minCostToDestinationUtil(matrix,x,y,row-1,col,"r");
        minCostToDestinationUtil(matrix,x,y,row,col+1,"c");
        minCostToDestinationUtil(matrix,x,y,row+1,col,"r");
        minCostToDestinationUtil(matrix,x,y,row,col-1,"c");

        return min;

    }

}