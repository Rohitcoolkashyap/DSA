package dynamicProgramming;

public class Longest_common_subsequence {
    public static void main(String[] arg) {
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";
        // dp = new int[s1.length() + 1][s2.length() + 1];
        // Arrays.stream(dp).forEach(i -> Arrays.fill(i, -1));
        System.out.println(lcb(s1, s2, s1.length(), s2.length()));

    }

    //    public static int lcb(String s1, String s2, int n, int m) {
//        if (n == 0 || m == 0) return 0;
//
//        if (s1.charAt(n - 1) == s2.charAt(m - 1))
//            return 1 + lcb(s1, s2, n - 1, m - 1);
//        else
//            return Math.max(lcb(s1, s2, n, m - 1), lcb(s1, s2, n - 1, m));
//    }

    //    static int[][] dp;
//
//    public static int lcb(String s1, String s2, int n, int m) {
//        if (n == 0 || m == 0) return 0;
//
//        if (dp[n][m] != -1)
//            return dp[n][m];
//        if (s1.charAt(n - 1) == s2.charAt(m - 1))
//            return dp[n][m] = 1 + lcb(s1, s2, n - 1, m - 1);
//        else
//            return dp[n][m] = Math.max(lcb(s1, s2, n, m - 1), lcb(s1, s2, n - 1, m));
//    }
    // Top down approach
    public static int lcb(String s1, String s2, int n, int m) {

        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = 0;
            }

        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {

                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
            }
        }
        return dp[n][m];
    }
}
