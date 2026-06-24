class Solution {
    private static final long MOD = 1000000007;

    
    private long[][] multiply(long[][] A, long[][] B, int size) {
        long[][] C = new long[size][size];
        for (int i = 0; i < size; i++) {
            for (int k = 0; k < size; k++) {
                if (A[i][k] == 0) continue; 
                for (int j = 0; j < size; j++) {
                    C[i][j] = (C[i][j] + A[i][k] * B[k][j]) % MOD;
                }
            }
        }
        return C;
    }

    
    private long[][] power(long[][] A, long p, int size) {
        long[][] res = new long[size][size];
        for (int i = 0; i < size; i++) res[i][i] = 1;
        
        while (p > 0) {
            if (p % 2 == 1) {
                res = multiply(res, A, size);
            }
            A = multiply(A, A, size);
            p /= 2;
        }
        return res;
    }

    public int zigZagArrays(int n, int l, int r) {
        if (n < 2) return 0;
        
        int k = r - l + 1;
        
        
        long[] V = new long[k];
        for (int v = 0; v < k; ++v) {
            V[v] = v;
        }

       
        long[][] M = new long[k][k];
        for (int v = 0; v < k; ++v) {
            for (int x = k - v; x < k; ++x) {
                M[v][x] = 1;
            }
        }

       
        long[][] M_n_minus_2 = power(M, n - 2, k);

      
        long totalUp = 0;
        for (int i = 0; i < k; ++i) {
            long currentVal = 0;
            for (int j = 0; j < k; ++j) {
                currentVal = (currentVal + M_n_minus_2[i][j] * V[j]) % MOD;
            }
            totalUp = (totalUp + currentVal) % MOD;
        }

     
        return (int) ((totalUp * 2) % MOD);
    }
}