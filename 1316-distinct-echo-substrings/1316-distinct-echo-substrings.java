import java.util.*;

class Solution {
    public int distinctEchoSubstrings(String text) {
        int n = text.length();
        Set<String> uniqueEchoes = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int len = 1; i + 2 * len <= n; len++) {

                String lHalf = text.substring(i, i + len);
                String rHalf = text.substring(i + len, i + 2 * len);

                if (lHalf.equals(rHalf)) {
                    uniqueEchoes.add(text.substring(i, i + 2 * len));
                }
            }
        }

        return uniqueEchoes.size();
    }
}