package dynamicProgramming;

public class Longest_common_subsequence {
    public static void main(String[] arg) {
        String s1 = "heap";
        String s2 = "pea";
        // dp = new int[s1.length() + 1][s2.length() + 1];
        // Arrays.stream(dp).forEach(i -> Arrays.fill(i, -1));
        //System.out.println(lcs(s1, s2, s1.length(), s2.length()));
        //System.out.println(lcss(s1, s2, s1.length(), s2.length()));
        //System.out.println(Longest_common_subPrint(s1, s2, s1.length(), s2.length()));
        // System.out.println(shortest_common_superSequence(s1, s2, s1.length(), s2.length()));
        min_opertation_to_convert_string(s1, s2, s1.length(), s2.length());
    }

    //    public static int lcs(String s1, String s2, int n, int m) {
//        if (n == 0 || m == 0) return 0;
//
//        if (s1.charAt(n - 1) == s2.charAt(m - 1))
//            return 1 + lcs(s1, s2, n - 1, m - 1);
//        else
//            return Math.max(lcs(s1, s2, n, m - 1), lcs(s1, s2, n - 1, m));
//    }

    //    static int[][] dp;
//
//    public static int lcs(String s1, String s2, int n, int m) {
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
    public static int lcs(String s1, String s2, int n, int m) {

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

    // Longest Common Substring recursion
//    static int lcs(String s1, String s2, int n, int m, int count) {
//        if (n == 0 || m == 0) return count;
//        if (s1.charAt(n - 1) == s2.charAt(m - 1))
//            count = lcs(s1, s2, n - 1, m - 1, count + 1);
//        count = Math.max(count,
//                Math.max(lcs(s1, s2, n, m - 1, 0), lcs(s1, s2, n - 1, m, 0)));
//        return count;
//    }
    // Longest Common Substring dp

    // static int max = Integer.MIN_VALUE;

//    public static int lcss(String s1, String s2, int n, int m) {
//
//        int[][] dp = new int[n + 1][m + 1];
//        for (int i = 0; i < n + 1; i++) {
//            for (int j = 0; j < m + 1; j++) {
//                if (i == 0 || j == 0)
//                    dp[i][j] = 0;
//            }
//
//        }
//        for (int i = 1; i < n + 1; i++) {
//            for (int j = 1; j < m + 1; j++) {
//
//                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
//                    dp[i][j] = 1 + dp[i - 1][j - 1];
//                    max = Math.max(dp[i][j], max);
//                } else {
//                    dp[i][j] = 0;
//                }
//            }
//        }
//        return max;
//    }

    // Longest common subsequence
//    public static String Longest_common_subPrint(String s1, String s2, int n, int m) {
//
//        int[][] dp = new int[n + 1][m + 1];
//        for (int i = 0; i < n + 1; i++) {
//            for (int j = 0; j < m + 1; j++) {
//                if (i == 0 || j == 0)
//                    dp[i][j] = 0;
//            }
//
//        }
//        for (int i = 1; i < n + 1; i++) {
//            for (int j = 1; j < m + 1; j++) {
//
//                if (s1.charAt(i - 1) == s2.charAt(j - 1))
//                    dp[i][j] = 1 + dp[i - 1][j - 1];
//                else
//                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
//            }
//        }
//
//        int i = n;
//        int j = m;
//        StringBuilder s = new StringBuilder();
//        while (i > 0 && j > 0) {
//            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
//                s.append(s1.charAt(i - 1));
//                i--;
//                j--;
//            } else {
//                if (dp[i][j - 1] > dp[i - 1][j])
//                    j--;
//                else
//                    i--;
//
//            }
//        }
//        return s.reverse().toString();
//
//    }
//
//    public static int shortest_common_superSequence(String s1, String s2, int n, int m) {
//        return n + m - lcs(s1, s2, n, m);
//    }

    // Minimum Number of Insertion and Deletion to convert String a to String b
    public static void min_opertation_to_convert_string(String s1, String s2, int n, int m) {
        int deletion = s1.length() - lcs(s1, s2, n, m);
        int insertion = s2.length() - lcs(s1, s2, n, m);
        System.out.println("deletion = " + deletion);
        System.out.println("insertion = " + insertion);
    }
}
