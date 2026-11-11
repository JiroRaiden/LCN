class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        
        int[] dp = new int[n+1];

        for(int i=1;i<=m;i++)
        {
            int diagonal = 0;
            for(int j=1;j<=n;j++)
            {
                int temp = dp[j];

                if(text1.charAt(i-1)==text2.charAt(j-1))
                dp[j] = diagonal + 1;
                else
                dp[j] = Math.max(dp[j], dp[j-1]);

                diagonal = temp;
            }
        }
        return dp[n];
    }
}