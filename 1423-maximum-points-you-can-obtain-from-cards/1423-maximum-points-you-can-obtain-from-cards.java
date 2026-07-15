class Solution {
    public int maxScore(int[] cardPoints, int k) {
        
        int n = cardPoints.length;
        int currScore = 0;

        for(int i = 0;i<k;i++)
        {
            currScore += cardPoints[i];
        }

        if(k==n)
        return currScore;

        int maxScore = currScore;

        for(int i =0;i<k;i++)
        {
            currScore = currScore - cardPoints[k-1-i] + cardPoints[n-1-i];
            maxScore = Math.max(maxScore,currScore);
        }

        return maxScore;
    }
}