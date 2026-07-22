import java.util.*;

class Solution {

    static class Group {
        int start;
        int length;

        Group(int s, int l) {
            start = s;
            length = l;
        }
    }

    static class SparseTable {
        int[][] st;
        int[] lg;

        SparseTable(int[] arr) {
            int n = arr.length;
            if (n == 0) {
                st = new int[1][0];
                lg = new int[1];
                return;
            }

            lg = new int[n + 1];
            for (int i = 2; i <= n; i++)
                lg[i] = lg[i / 2] + 1;

            st = new int[lg[n] + 1][n];
            System.arraycopy(arr, 0, st[0], 0, n);

            for (int k = 1; k < st.length; k++) {
                for (int i = 0; i + (1 << k) <= n; i++) {
                    st[k][i] = Math.max(
                            st[k - 1][i],
                            st[k - 1][i + (1 << (k - 1))]);
                }
            }
        }

        int query(int l, int r) {
            if (l > r) return Integer.MIN_VALUE;
            int k = lg[r - l + 1];
            return Math.max(st[k][l], st[k][r - (1 << k) + 1]);
        }
    }

    public List<Integer> maxActiveSectionsAfterTrade(String s, int[][] queries) {
        int n = s.length();

        int ones = 0;
        for (char c : s.toCharArray())
            if (c == '1') ones++;

        List<Group> zeroGroups = new ArrayList<>();
        int[] zeroGroupIndex = new int[n];

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0') {
                if (i > 0 && s.charAt(i - 1) == '0')
                    zeroGroups.get(zeroGroups.size() - 1).length++;
                else
                    zeroGroups.add(new Group(i, 1));
            }
            zeroGroupIndex[i] = zeroGroups.size() - 1;
        }

        if (zeroGroups.isEmpty()) {
            List<Integer> ans = new ArrayList<>();
            for (int i = 0; i < queries.length; i++)
                ans.add(ones);
            return ans;
        }

        int[] merge = new int[Math.max(0, zeroGroups.size() - 1)];
        for (int i = 0; i + 1 < zeroGroups.size(); i++)
            merge[i] = zeroGroups.get(i).length + zeroGroups.get(i + 1).length;

        SparseTable st = new SparseTable(merge);

        List<Integer> ans = new ArrayList<>();

        for (int[] q : queries) {

            int l = q[0];
            int r = q[1];

            int left = -1;
            if (zeroGroupIndex[l] != -1) {
                Group g = zeroGroups.get(zeroGroupIndex[l]);
                left = g.length - (l - g.start);
            }

            int right = -1;
            if (zeroGroupIndex[r] != -1) {
                Group g = zeroGroups.get(zeroGroupIndex[r]);
                right = r - g.start + 1;
            }

            int startAdj = zeroGroupIndex[l] + 1;
            int endGroup = (s.charAt(r) == '1')
                    ? zeroGroupIndex[r]
                    : zeroGroupIndex[r] - 1;
            int endAdj = endGroup - 1;

            int best = ones;

            if (s.charAt(l) == '0'
                    && s.charAt(r) == '0'
                    && zeroGroupIndex[l] + 1 == zeroGroupIndex[r]) {

                best = Math.max(best, ones + left + right);

            } else if (startAdj <= endAdj) {

                best = Math.max(best, ones + st.query(startAdj, endAdj));
            }

            if (s.charAt(l) == '0'
                    && zeroGroupIndex[l] + 1 <= endGroup) {

                best = Math.max(best,
                        ones + left + zeroGroups.get(zeroGroupIndex[l] + 1).length);
            }

            if (s.charAt(r) == '0'
                    && zeroGroupIndex[l] < zeroGroupIndex[r] - 1) {

                best = Math.max(best,
                        ones + right + zeroGroups.get(zeroGroupIndex[r] - 1).length);
            }

            ans.add(best);
        }

        return ans;
    }
}