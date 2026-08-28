class Solution {
    public String lexPalindromicPermutation(String s, String target) {
        int n = s.length();
        int halfLen = n / 2;

        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        int odd = 0;
        int middle = -1;

        for (int i = 0; i < 26; i++) {
            if ((freq[i] & 1) == 1) {
                odd++;
                middle = i;
            }
        }

        if (odd > 1) {
            return "";
        }

        int[] halfFreq = new int[26];

        for (int i = 0; i < 26; i++) {
            halfFreq[i] = freq[i] / 2;
        }

        String equalCandidate = buildPalindrome(
            target.substring(0, halfLen),
            halfFreq,
            middle,
            n
        );

        if (equalCandidate != null && equalCandidate.compareTo(target) > 0) {
            return equalCandidate;
        }

        for (int pivot = halfLen - 1; pivot >= 0; pivot--) {
            int[] remaining = halfFreq.clone();
            boolean possible = true;

            for (int i = 0; i < pivot; i++) {
                int c = target.charAt(i) - 'a';

                if (remaining[c] == 0) {
                    possible = false;
                    break;
                }

                remaining[c]--;
            }

            if (!possible) {
                continue;
            }

            int targetChar = target.charAt(pivot) - 'a';
            int chosen = -1;

            for (int c = targetChar + 1; c < 26; c++) {
                if (remaining[c] > 0) {
                    chosen = c;
                    break;
                }
            }

            if (chosen == -1) {
                continue;
            }

            StringBuilder firstHalf = new StringBuilder();

            for (int i = 0; i < pivot; i++) {
                firstHalf.append(target.charAt(i));
            }

            firstHalf.append((char) ('a' + chosen));
            remaining[chosen]--;

            for (int c = 0; c < 26; c++) {
                while (remaining[c] > 0) {
                    firstHalf.append((char) ('a' + c));
                    remaining[c]--;
                }
            }

            return makePalindrome(firstHalf.toString(), middle, n);
        }

        return "";
    }

    private String buildPalindrome(
        String prefix,
        int[] halfFreq,
        int middle,
        int n
    ) {
        int[] remaining = halfFreq.clone();

        for (char c : prefix.toCharArray()) {
            int idx = c - 'a';

            if (remaining[idx] == 0) {
                return null;
            }

            remaining[idx]--;
        }

        StringBuilder firstHalf = new StringBuilder(prefix);

        for (int c = 0; c < 26; c++) {
            while (remaining[c] > 0) {
                firstHalf.append((char) ('a' + c));
                remaining[c]--;
            }
        }

        return makePalindrome(firstHalf.toString(), middle, n);
    }

    private String makePalindrome(String firstHalf, int middle, int n) {
        StringBuilder ans = new StringBuilder();

        ans.append(firstHalf);

        if (n % 2 == 1) {
            ans.append((char) ('a' + middle));
        }

        for (int i = firstHalf.length() - 1; i >= 0; i--) {
            ans.append(firstHalf.charAt(i));
        }

        return ans.toString();
    }
}