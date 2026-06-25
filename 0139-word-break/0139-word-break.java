class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        int n = s.length();
        boolean[] dp = new boolean[n+1];

        dp[0]= true;

        int maxLen=0;
        for(String h: wordDict)
        {
            maxLen= Math.max(maxLen,h.length());
        }

        for(int i=0;i<n;i++)
        {
            if(dp[i]==false) continue;

            for(int j =i+1;j<=maxLen+i && j<=n;j++)
            {
                String str = s.substring(i,j);
                if(dict.contains(str))
                dp[j]=true;
            }
        }
        if(dp[n]==true)
        return true;
        return false;
    }
}