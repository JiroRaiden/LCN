class Solution {
    public List<String> generateParenthesis(int n) {
        
        List<String> result = new ArrayList<>();
        char[] ch = new char[2*n];
        backtrack(n,0,ch,result,0,0);
        return result;
    }

    public void backtrack(int n , int index, char[] ch, List<String> result,int open, int close)
    {

        if(index==2*n)
        {
            result.add(new String(ch));
            return;
        }
        if(open<n)
        {
            ch[index]='(';
            backtrack(n,index+1,ch,result,open+1,close);
        }
        
        if(open>close)
        {
            ch[index]=')';
            backtrack(n,index+1,ch,result,open,close+1);
        }
    }
}