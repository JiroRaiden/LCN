class Solution {
    long LIMIT;
    int[] primes;
    int primeCnt;

    public String smallestPalindrome(String s, int k) {
        LIMIT = k;

        int n = s.length();
        int halfLen = n / 2;

        int[] freq = new int[26];
        for (char c : s.toCharArray())
            freq[c - 'a']++;

        char mid = 0;
        int[] half = new int[26];

        for (int i = 0; i < 26; i++) {
            half[i] = freq[i] / 2;
            if ((freq[i] & 1) == 1)
                mid = (char) ('a' + i);
        }

        sieve(halfLen);

        if (countWays(half, halfLen) < k)
            return "";

        StringBuilder first = new StringBuilder();

        for (int pos = 0; pos < halfLen; pos++) {
            for (int c = 0; c < 26; c++) {
                if (half[c] == 0)
                    continue;

                half[c]--;

                long ways = countWays(half, halfLen - pos - 1);

                if (ways >= k) {
                    first.append((char) ('a' + c));
                    break;
                }

                k -= ways;
                half[c]++;
            }
        }

        StringBuilder ans = new StringBuilder(first);

        if (mid != 0)
            ans.append(mid);

        ans.append(new StringBuilder(first).reverse());

        return ans.toString();
    }

    void sieve(int n) {
        boolean[] comp = new boolean[n + 1];
        primes = new int[n + 1];
        primeCnt = 0;

        for (int i = 2; i <= n; i++) {
            if (!comp[i]) {
                primes[primeCnt++] = i;
                for (long j = 1L * i * i; j <= n; j += i)
                    comp[(int) j] = true;
            }
        }
    }

    long countWays(int[] half, int total) {
        int[] exp = new int[primeCnt];

        addFact(exp, total, 1);

        for (int x : half)
            addFact(exp, x, -1);

        long res = 1;

        for (int i = 0; i < primeCnt; i++) {
            int p = primes[i];
            int e = exp[i];

            while (e-- > 0) {
                if (res > LIMIT / p)
                    return LIMIT;
                res *= p;
            }
        }

        return Math.min(res, LIMIT);
    }

    void addFact(int[] exp, int n, int sign) {
        for (int i = 0; i < primeCnt; i++) {
            int p = primes[i];
            if (p > n)
                break;

            int t = n;
            while (t > 0) {
                t /= p;
                exp[i] += sign * t;
            }
        }
    }
}