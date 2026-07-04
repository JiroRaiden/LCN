class Solution {
    public String removeKdigits(String num, int k) {
        int n = num.length();
        if(n==k)
        return "0";
        Stack<Character> s = new Stack<>();

        for(int i=0;i<n;i++)
        {
            char x = num.charAt(i);

            while(!(s.isEmpty()) && (x-'0' <(s.peek()-'0')) && k!=0)
            {
                s.pop();
                k--;
            }
            s.push(x);
        }

        while(k!=0)
        {
            s.pop();
            k--;
        }

        StringBuilder result = new StringBuilder();
        int p =1;
        for(int i=s.size()-1;i>=0;i--)
        {
            result.append(s.pop());
        }
        int i=0;
        result.reverse();
        while(i< result.length() && result.charAt(i)=='0')
        i++;

        if(i==result.length()) return "0";

        return result.substring(i).toString();
}
}