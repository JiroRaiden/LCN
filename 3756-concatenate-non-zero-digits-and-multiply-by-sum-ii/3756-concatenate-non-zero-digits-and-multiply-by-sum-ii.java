class Solution {
    static final long MOD = 1_000_000_007L;

    public int[] sumAndMultiply(String s, int[][] queries) {
        int n = s.length();

       
        int[] nonZeroPrefix = new int[n + 1];

        for (int i = 0; i < n; i++) {
            nonZeroPrefix[i + 1] = nonZeroPrefix[i];
            if (s.charAt(i) != '0') {
                nonZeroPrefix[i + 1]++;
            }
        }

        int k = nonZeroPrefix[n];

        
        long[] pow10 = new long[k + 1];
        long[] invPow10 = new long[k + 1];

        pow10[0] = 1;
        invPow10[0] = 1;

        long inv10 = modPow(10, MOD - 2);

        for (int i = 1; i <= k; i++) {
            pow10[i] = (pow10[i - 1] * 10) % MOD;
            invPow10[i] = (invPow10[i - 1] * inv10) % MOD;
        }

        long[] prefixSum = new long[k + 1];
        long[] prefixWeighted = new long[k + 1];

        int idx = 0;
        for (int i = 0; i < n; i++) {
            int d = s.charAt(i) - '0';
            if (d == 0) continue;

            idx++;

            prefixSum[idx] = prefixSum[idx - 1] + d;

            prefixWeighted[idx] =
                    (prefixWeighted[idx - 1] + d * invPow10[idx]) % MOD;
        }

        int[] ans = new int[queries.length];

        for (int qi = 0; qi < queries.length; qi++) {
            int l = queries[qi][0];
            int r = queries[qi][1];

            int left = nonZeroPrefix[l] + 1;
            int right = nonZeroPrefix[r + 1];

            if (left > right) {
                ans[qi] = 0;
                continue;
            }

            long sumDigits = prefixSum[right] - prefixSum[left - 1];

            long val =
                    (prefixWeighted[right] - prefixWeighted[left - 1] + MOD) % MOD;

            val = (val * pow10[right]) % MOD;

            ans[qi] = (int) ((val * (sumDigits % MOD)) % MOD);
        }

        return ans;
    }

    private static long modPow(long a, long b) {
        long res = 1;
        while (b > 0) {
            if ((b & 1) == 1) {
                res = (res * a) % MOD;
            }
            a = (a * a) % MOD;
            b >>= 1;
        }
        return res;
    }
}