class Solution {
    public int distinctSubseqII(String s) {
        final long MOD = 1_000_000_007;
        int n = s.length();
        long[] dp = new long[n + 1];
        int[] last = new int[26];

        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            int idx = s.charAt(i - 1) - 'a';

            dp[i] = (2 * dp[i - 1]) % MOD;

            if (last[idx] != 0) {
                dp[i] = (dp[i] - dp[last[idx] - 1] + MOD) % MOD;
            }

            last[idx] = i;
        }

        return (int)((dp[n] - 1 + MOD) % MOD);
    }
}