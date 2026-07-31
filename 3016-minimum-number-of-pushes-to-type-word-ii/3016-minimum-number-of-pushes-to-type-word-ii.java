class Solution {
    public int minimumPushes(String word) {
        int n = word.length();
        int c = 8;
        int type = 0;
        int[] freq = new int[26];
        for(int i =0;i<n;i++)
        {
            freq[word.charAt(i)-'a']++;
        }
        Arrays.sort(freq);
        for(int i=25;i>=0;i--)
        {
            if(freq[i]>0)
            {
                type+=c/8*freq[i];
                c++;
            }
        }

        return type;
    }
}