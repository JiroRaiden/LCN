class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        char[] ans = new char[s.length()];
        char[] t = target.toCharArray();

        for (int i = 0; i < t.length; i++) {
            int x = t[i] - 'a';

            if (freq[x] > 0) {
                ans[i] = t[i];
                freq[x]--;
            } else {
                int bigger = -1;

                for (int c = x + 1; c < 26; c++) {
                    if (freq[c] > 0) {
                        bigger = c;
                        break;
                    }
                }

                if (bigger != -1) {
                    ans[i] = (char) ('a' + bigger);
                    freq[bigger]--;

                    int idx = i + 1;

                    for (int c = 0; c < 26; c++) {
                        while (freq[c] > 0) {
                            ans[idx++] = (char) ('a' + c);
                            freq[c]--;
                        }
                    }

                    return new String(ans);
                }

                for (int j = i - 1; j >= 0; j--) {
                    int prev = t[j] - 'a';
                    freq[prev]++;

                    for (int c = prev + 1; c < 26; c++) {
                        if (freq[c] > 0) {
                            ans[j] = (char) ('a' + c);
                            freq[c]--;

                            int idx = j + 1;

                            for (int k = 0; k < 26; k++) {
                                while (freq[k] > 0) {
                                    ans[idx++] = (char) ('a' + k);
                                    freq[k]--;
                                }
                            }

                            return new String(ans);
                        }
                    }
                }

                return "";
            }
        }

        // Entire target matched.
        // We still need a permutation strictly greater than target.
        for (int j = t.length - 1; j >= 0; j--) {
            int prev = t[j] - 'a';
            freq[prev]++;

            for (int c = prev + 1; c < 26; c++) {
                if (freq[c] > 0) {
                    ans[j] = (char) ('a' + c);
                    freq[c]--;

                    int idx = j + 1;

                    for (int k = 0; k < 26; k++) {
                        while (freq[k] > 0) {
                            ans[idx++] = (char) ('a' + k);
                            freq[k]--;
                        }
                    }

                    return new String(ans);
                }
            }
        }

        return "";
    }
}