import java.util.Arrays;

class Solution {

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