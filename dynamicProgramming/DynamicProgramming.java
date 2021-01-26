package dynamicProgramming;

import java.util.ArrayList;
import java.util.Scanner;

public class DynamicProgramming {
    static int[][] storage = new int[1000][1003];
    static int count = 0;

    public static void main(String[] arg) {
        Scanner sc = new Scanner(System.in);
//        Arrays.stream(storage).forEach(a -> Arrays.fill(a, -1));
//        ArrayList<Integer> p = new ArrayList<>(Arrays.asList(60, 100, 120));
//        ArrayList<Integer> w = new ArrayList<>(Arrays.asList(10, 20, 30));
//        int maxWeight = 50;
//        int n = p.size();
//        int maxProfit = knapsack_max_profit(w, p, maxWeight, n);
//        System.out.println(maxProfit);
       String s ="ab";
        String str ="ba";

        if((s.compareTo(str)) <0){
            System.out.println(str);
        }
        int[] a = {1,5,11,9};
//        int sum = 9;
//        System.out.println(subset_sum(a, a.length, sum));
        System.out.println(equal_sum_partition(a));
    }


//    public static int knapsack_max_profit(ArrayList<Integer> w, ArrayList<Integer> p, int maxWeight, int n) {
//        //System.out.println("count = " + (++count));
//        if (maxWeight == 0 || n == 0) {
//            return 0;
//        }
//
//        if (storage[n][maxWeight] != -1)
//            return storage[n][maxWeight];
//
//        if (w.get(n - 1) <= maxWeight) {
//            return storage[n][maxWeight] = Math.max(p.get(n - 1) + knapsack_max_profit(w, p, maxWeight - w.get(n - 1), n - 1),
//                    knapsack_max_profit(w, p, maxWeight, n - 1));
//        } else
//            return storage[n][maxWeight] = knapsack_max_profit(w, p, maxWeight, n - 1);
//    }


     // Top-down approach
    public static int knapsack_max_profit(ArrayList<Integer> w, ArrayList<Integer> p, int maxWeight, int n) {
        int[][] t = new int[n + 1][maxWeight + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < maxWeight + 1; j++) {
                if (i == 0 || j == 0)
                    t[i][j] = 0;
            }
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < maxWeight + 1; j++) {
                if (w.get(i - 1) <= j) {
                    t[i][j] = Math.max(p.get(i - 1) + t[i - 1][j - w.get(i - 1)], t[i - 1][j]);
                } else
                    t[i][j] = t[i - 1][j];
            }
        }
        return t[n][maxWeight];
    }

    static boolean subset_sum(int[] a, int n, int sum) {
        boolean[][] t = new boolean[n + 1][sum + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < sum + 1; j++) {
                if (i == 0)
                    t[i][j] = false;
                if (j == 0)
                    t[i][j] = true;
            }
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                if (a[i - 1] <= j) {
                    t[i][j] = t[i - 1][j - a[i - 1]] || t[i - 1][j];
                } else
                    t[i][j] = t[i - 1][j];
            }
        }
        return t[n][sum];



    }

    static boolean equal_sum_partition(int[] a) {
        int s = 0;
        for (int i : a
        ) {
            s += i;
        }
        if (s % 2 == 1)
            return false;
        return subset_sum(a, a.length, s / 2);
    }
}