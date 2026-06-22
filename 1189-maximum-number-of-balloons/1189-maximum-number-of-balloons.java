class Solution {
    public int maxNumberOfBalloons(String text) {
        String str1 = "balloon";
        int freq1[] = new int[26];
        for(int i =0;i<str1.length();i++)
        freq1[str1.charAt(i)-'a']++;

        int freq2[] = new int[26];

        for(int i =0;i<text.length();i++)
        freq2[text.charAt(i)-'a']++;

        int min=Integer.MAX_VALUE;
        for(int i=0;i<str1.length();i++)
        {
            min = Math.min(min, freq2[str1.charAt(i)-'a']/freq1[str1.charAt(i)-'a']);
        }
        return min;
    }
}