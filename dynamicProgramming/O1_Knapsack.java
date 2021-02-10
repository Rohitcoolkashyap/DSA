package dynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class O1_Knapsack {
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
//        String s = "ab";
//        String str = "ba";
//
//        if ((s.compareTo(str)) < 0) {
//            System.out.println(str);
//        }
        int[] a = {0, 0, 0, 0, 0, 0, 0, 0, 1};
        //int sum = 10;
        // System.out.println(subset_sum1(a, a.length, sum));
        //System.out.println(subset_sum_diff(a));
        // System.out.println(equal_sum_partition(a));
        int diff = 1;
        count_subsets_equal_to_diff(a, diff);
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
//    public static int knapsack_max_profit(ArrayList<Integer> w, ArrayList<Integer> p, int maxWeight, int n) {
//        int[][] t = new int[n + 1][maxWeight + 1];
//        for (int i = 0; i < n + 1; i++) {
//            for (int j = 0; j < maxWeight + 1; j++) {
//                if (i == 0 || j == 0)
//                    t[i][j] = 0;
//            }
//        }
//        for (int i = 1; i < n + 1; i++) {
//            for (int j = 1; j < maxWeight + 1; j++) {
//                if (w.get(i - 1) <= j) {
//                    t[i][j] = Math.max(p.get(i - 1) + t[i - 1][j - w.get(i - 1)], t[i - 1][j]);
//                } else
//                    t[i][j] = t[i - 1][j];
//            }
//        }
//        return t[n][maxWeight];
//    }

    // Subset recursive code
//    static boolean solveUtil(ArrayList<Integer> a, int b, int n) {
//        if (n == 0 && b == 0)
//            return true;
//        if (n == 0)
//            return false;
//        if (b == 0)
//            return true;
//
//
//        if (a.get(n - 1) <= b)
//            return solveUtil(a, b - a.get(n - 1), n - 1) || solveUtil(a, b, n - 1);
//        else
//            return solveUtil(a, b, n - 1);
//    }
//
//    static boolean subset_sum(int[] a, int n, int sum) {
//        boolean[][] t = new boolean[n + 1][sum + 1];
//
//        for (int i = 0; i < n + 1; i++) {
//            for (int j = 0; j < sum + 1; j++) {
//                if (i == 0)
//                    t[i][j] = false;
//                if (j == 0)
//                    t[i][j] = true;
//            }
//        }
//        for (int i = 1; i < n + 1; i++) {
//            for (int j = 1; j < sum + 1; j++) {
//                if (a[i - 1] <= j) {
//                    t[i][j] = t[i - 1][j - a[i - 1]] || t[i - 1][j];
//                } else
//                    t[i][j] = t[i - 1][j];
//            }
//        }
//        return t[n][sum];
//    }

    // 9 Count of Subsets Sum with a Given Sum
    static int subset_sum_count(int[] a, int n, int sum) {
        int[][] t = new int[n + 1][sum + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < sum + 1; j++) {
                if (i == 0)
                    t[i][j] = 0;
                if (j == 0)
                    t[i][j] = 1;
            }
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                if (a[i - 1] <= j) {
                    t[i][j] = t[i - 1][j - a[i - 1]] + t[i - 1][j];
                } else
                    t[i][j] = t[i - 1][j];
            }
        }
        return t[n][sum];


    }

    // 9 Equal sum partition
//    static boolean equal_sum_partition(int[] a) {
//        int s = 0;
//        for (int i : a
//        ) {
//            s += i;
//        }
//        if (s % 2 == 1)
//            return false;
//        return subset_sum(a, a.length, s / 2);
//    }

    // 10 Minimum Subset Sum Difference
//    static ArrayList<Integer> subset_sum_util(int[] a, int n, int sum) {
//        boolean[][] t = new boolean[n + 1][sum + 1];
//        ArrayList<Integer> list = new ArrayList<>();
//
//
//        for (int i = 0; i < n + 1; i++) {
//            for (int j = 0; j < sum + 1; j++) {
//                if (i == 0)
//                    t[i][j] = false;
//                if (j == 0)
//                    t[i][j] = true;
//            }
//        }
//        for (int i = 1; i < n + 1; i++) {
//            for (int j = 1; j < sum + 1; j++) {
//                if (a[i - 1] <= j) {
//                    t[i][j] = t[i - 1][j - a[i - 1]] || t[i - 1][j];
//                } else
//                    t[i][j] = t[i - 1][j];
//            }
//        }
//
//        int row = t.length - 1;
//
//        for (int j = 0; j <= sum / 2; j++) {
//            if (t[row][j]) {
//                list.add(j);
//            }
//        }
//        return list;
//
//
//    }

//    public static int subset_sum_diff(int[] arr) {
//        int range = Arrays.stream(arr).sum();
//        ArrayList<Integer> s1 = subset_sum_util(arr, arr.length, range);
//        int diff = 1;
//        int count = 0;
//        int min = Integer.MAX_VALUE;
//        for (int i : s1
//        ) {
//            min = Math.min(min, range - 2 * i);
//            if (range - 2 * i == diff)
//                count++;
//
//        }
//        System.out.println(count);
//        return min;
//
//    }

    //
    public static void count_subsets_equal_to_diff(int[] arr, int diff) {
        long sum = Arrays.stream(arr).sum();
        int s1 = (int) ((diff + sum) / 2);
        //System.out.println(s1);

        int count = subset_sum_count(arr, arr.length, s1);
        System.out.println(count);
    }

    // Target sum
    public int findTargetSumWays(int[] nums, int diff) {
        int sum = 0;
        sum = Arrays.stream(nums).sum();
        int s1 = ((diff + sum) / 2);
        int n = nums.length;

        if (diff > sum) return 0;
        if ((diff + sum) % 2 != 0) return 0;

        return count_subsets_equal_to_diff(nums, n, s1);

    }

    public static int count_subsets_equal_to_diff(int[] nums, int n, int diff) {
        int t[][] = new int[n + 1][diff + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < diff + 1; j++) {
                if (i == 0)
                    t[i][j] = 0;
                if (j == 0)
                    t[i][j] = 1;
            }
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 0; j < diff + 1; j++) {
                if (nums[i - 1] <= j)
                    t[i][j] = t[i - 1][j] + t[i - 1][j - nums[i - 1]];
                else
                    t[i][j] = t[i - 1][j];
            }
        }
        return t[n][diff];
    }
}