class Solution {
    public List<List<String>> partition(String s) {
        
        List<List<String>> result = new ArrayList<>();
        if(s.length() == 0)
        return result;
        List<String> curr = new ArrayList<>();
        backtrack(0,s,curr, result);
        return result;
    }

    public void backtrack(int start, String s, List<String> curr, List<List<String>> result)
    {
        if(start==s.length())
        {
            result.add(new ArrayList<>(curr));
            return;
        }

        for(int end = start; end< s.length(); end++)
        {
            if(palindrome(s,start,end))
            {
                curr.add(s.substring(start, end+1));
                backtrack(end+1,s,curr,result);
                curr.remove(curr.size()-1);
            }
        }
    }

    public boolean palindrome(String s, int start, int end)
    {
        while(start<end)
        {
            if(s.charAt(start)!=s.charAt(end))
            return false;
            
            start++;
            end--;
        }
        return true;
    }
}