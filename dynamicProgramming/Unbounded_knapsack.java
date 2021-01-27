package dynamicProgramming;

public class Unbounded_knapsack {
    public static void main(String[] arg) {

//        int[] prices = {1, 5, 8, 9, 10, 17, 17, 20};
//        int l = prices.length;
//        // Create array of length of rod
//        int[] length = new int[l];
//        for (int i = 0; i < l; i++) {
//            length[i] = i + 1;
//        }

        // Rod cutting problem
        //System.out.println(rod_cutting(length, length.length, l, prices));
        // coin change 1
        int[] coins = {9, 6, 5, 1};
        int w = 11;
        //System.out.println(coin_change(coins, coins.length, w));
        System.out.println(coin_change2(coins, coins.length, w));
    }

   /*  Rod cutting problem

    static int rod_cutting(int[] length, int n, int l, int[] prices) {
        int[][] dp = new int[n + 1][l + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < l + 1; j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = 0;
            }

        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < l + 1; j++) {
                if (length[i - 1] <= j) {
                    dp[i][j] = Math.max(prices[i - 1] + dp[i][j - length[i - 1]],
                            dp[i - 1][j]);
                } else
                    dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[n][l];
    }*/

    // Coin change problem

    public static int coin_change(int[] coins, int n, int w) {
        int[][] dp = new int[n + 1][w + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < w + 1; j++) {
                if (i == 0)
                    dp[i][j] = 0;
                if (j == 0)
                    dp[i][j] = 1;
            }

        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < w + 1; j++) {
                if (coins[i - 1] <= j) {
                    dp[i][j] = dp[i][j - coins[i - 1]] + dp[i - 1][j];
                } else
                    dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[n][w];
    }

    // Minimum number of coins
    public static int coin_change2(int[] coins, int n, int w) {
        int[][] dp = new int[n + 1][w + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < w + 1; j++) {
                if (i == 0)
                    dp[i][j] = Integer.MAX_VALUE - 1;
                if (j == 0)
                    dp[i][j] = 0;
                // optional
                if(i==1)
                    dp[i][j] = j % coins[i-1] == 0 ? j / coins[i-1]: Integer.MAX_VALUE-1 ;
            }

        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < w + 1; j++) {
                if (coins[i - 1] <= j) {
                    dp[i][j] = Math.min(1 + dp[i][j - coins[i - 1]],
                            dp[i - 1][j]);
                } else
                    dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[n][w];
    }
}
