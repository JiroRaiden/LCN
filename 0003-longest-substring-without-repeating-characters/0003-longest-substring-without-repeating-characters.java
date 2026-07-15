class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int[] seen = new int[256];
        Arrays.fill(seen,-1);
        int left = 0;
        int maxLen=0;

        for(int right=0;right<n;right++)
        {
            char c = s.charAt(right);
            left = Math.max(left, seen[c]+1);
            maxLen = Math.max(maxLen, right - left + 1 );
            seen[c] = right;
        }
        return maxLen;
    }
}