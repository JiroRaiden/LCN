class Solution {
    public String minWindow(String s, String t) {
        
        int[] freq = new int[256];

        for(char c: t.toCharArray())
        freq[c]++;

        int left=0;
        int minLen = Integer.MAX_VALUE;
        int required = t.length();
        int startLeft = 0;

        for(int right = 0; right< s.length();right++)
        {
            char curr = s.charAt(right);

            if(freq[curr]>0)
            required--;

            freq[curr]--;

            while(required==0)
            {
                if(right-left+1<minLen)
                {
                    minLen = right - left + 1;
                    startLeft = left;
                }

                char out = s.charAt(left);

                freq[out]++;

                if(freq[out]>0)
                required++;

                left++;
            }
        }
        return (minLen==Integer.MAX_VALUE)?"":s.substring(startLeft,startLeft+minLen);
    }
}