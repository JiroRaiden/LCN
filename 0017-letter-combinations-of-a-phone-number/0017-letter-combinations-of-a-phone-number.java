class Solution {
        
    private static final String[] keypad = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {

        List<String> result= new ArrayList<>(); 
        if(digits.length()==0)
        return result;
        backtrack(0,digits,new StringBuilder(),result);
        return result;
    }

    public void backtrack(int index, String digits, StringBuilder curr,List<String> result )
    {
        if(index == digits.length())
        {
            result.add(curr.toString());
            return;
        }

        int digit = digits.charAt(index)-'0';
        String now = keypad[digit];
        for(int i =0; i< now.length();i++)
        {
            curr.append(now.charAt(i));
            backtrack(index+1,digits,curr,result);
            curr.deleteCharAt(curr.length()-1);
        }
    }
}