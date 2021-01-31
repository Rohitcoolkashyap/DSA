package dynamicProgramming;

import java.util.Arrays;

public class Matrix_Chain_Multiplication {
    static int[][] dp = new int[1001][1001];

    public static void main(String[] arg) {
        Arrays.stream(dp).forEach(a -> Arrays.fill(a, -1));
        /*int arr[] = new int[]{1, 2, 3, 4, 3};
        int n = arr.length;

        System.out.println(
                "Minimum number of multiplications is "
                        + mcm(arr, 1, n - 1));*/
        /*String s = "nitin";
        int i = 0, j = s.length() - 1;
        System.out.println("palindrome_partitioning = " + palindrome_partitioning(s, i, j));*/
    }

    // 34 Matrix Chain Multiplication Recursive
//    public static int mcm(int[] arr, int i, int j) {
//        if (i >= j) return 0;
//
//        int min = Integer.MAX_VALUE;
//        for (int k = i; k <= j - 1; k++) {
//            int tempAns = mcm(arr, i, k) + mcm(arr, k + 1, j)
//                    + arr[i - 1] * arr[k] * arr[j];
//            min = Math.min(min, tempAns);
//
//        }
//        return min;
//    }

    // 35 Matrix chain multiplication Memoization
//    public static int mcm(int[] arr, int i, int j) {
//        if (i >= j) return 0;
//
//        if (dp[i][j] != -1)
//            return dp[i][j];
//        int min = Integer.MAX_VALUE;
//        for (int k = i; k <= j - 1; k++) {
//            int tempAns = mcm(arr, i, k) + mcm(arr, k + 1, j)
//                    + arr[i - 1] * arr[k] * arr[j];
//            min = Math.min(min, tempAns);
//        }
//        return dp[i][j] = min;
//    }

    // 36 find min Palindrome Partitioning Memoization
//    public static int palindrome_partitioning(String s, int i, int j) {
//        if (i >= j) return 0;
//        int min = Integer.MAX_VALUE;
//
//        if (isPalindrome(s, i, j))
//            return 0;
//        if (dp[i][j] != -1)
//            return dp[i][j];
//        for (int k = i; k <= j - 1; k++) {
//            int tempAns = 1 + palindrome_partitioning(s, i, k) + palindrome_partitioning(s, k + 1, j);
//            min = Math.min(min, tempAns);
//
//        }
//        return dp[i][j] = min;
//    }
    // 36 Palindrome Partitioning Memoization optimize
//    public static int palindrome_partitioning(String s, int i, int j) {
//        if (i >= j) return 0;
//        int min = Integer.MAX_VALUE;
//
//        if (isPalindrome(s, i, j))
//            return 0;
//        if (dp[i][j] != -1)
//            return dp[i][j];
//        for (int k = i; k <= j - 1; k++) {
//            int left, right;
//            if (dp[i][k] != -1)
//                left = dp[i][k];
//            else {
//                left = palindrome_partitioning(s, i, k);
//                dp[i][k] = left;
//            }
//            if (dp[k + 1][j] != -1)
//                right = dp[k + 1][j];
//            else {
//                right = palindrome_partitioning(s, k + 1, j);
//                dp[k + 1][j] = right;
//            }
//            int tempAns = 1 + left + right;
//            min = Math.min(min, tempAns);
//
//        }
//        return dp[i][j] = min;
//    }
//
//    public static boolean isPalindrome(String s, int i, int j) {
//        while (i < j) {
//            if (s.charAt(i) != s.charAt(j))
//                return false;
//            i++;
//            j--;
//        }
//        return true;
//    }


}
