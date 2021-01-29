class Solution {

    public static void main(String[] arg) {
        String s1 = "abc";
        String s2 = "abcd";
        int count = 0;
        int t = lcs(s1, s2, s1.length(), s2.length(), count);
        System.out.println(t);
    }

    static int lcs(String s1, String s2, int n, int m, int count) {
        if (n == 0 || m == 0) return count;
        if (s1.charAt(n - 1) == s2.charAt(m - 1))
            count = lcs(s1, s2, n - 1, m - 1, count + 1);
        count = Math.max(count,
                Math.max(lcs(s1, s2, n, m - 1, 0), lcs(s1, s2, n - 1, m, 0)));
        return count;
    }
}