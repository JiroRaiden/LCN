class Solution {
    public String smallestPalindrome(String s) {
        int[] freq = new int[26];
        for(int i =0;i< s.length();i++)
        freq[s.charAt(i)-'a']++;

        StringBuilder result = new StringBuilder();
        for(int i = 0;i<26 ;i++)
        {
            if(freq[i]!=0)
            {
                int currFreq = freq[i];
                for (int j = 0; j < currFreq / 2; j++)
                {
                    result.append((char)(i+'a'));
                }
                freq[i]%=2;
            }
        }

        for(int i = 0;i<26 ;i++)
        {
            if(freq[i]==1)
            {
                result.append((char)(i+'a'));
                freq[i]--;
                break;
            }
        }

        int len = s.length()/2;

        for(int i=len-1;i>=0;i--)
        {
            result.append(result.charAt(i));
        }


        return result.toString();
    }
}