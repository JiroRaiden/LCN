class Solution {
    public int minimumPushes(String word) {
        int n = word.length();
        int type = 0;
        int c=1;
        for(int i=0;i<n;i++)
        {
            type+=i/8 + 1;
        }

        return type;
    }
}