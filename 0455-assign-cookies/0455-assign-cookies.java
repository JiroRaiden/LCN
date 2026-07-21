class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int n = s.length;
        int m = g.length;

        int r = 0;
        int l = 0;

        while(r<n)
        {
            if(l<m && g[l]<=s[r])
            l++;

            r++;
        }

        return l;
    }
}