class Solution {
    public boolean isValid(String s) {
        int n = s.length();
        if(n%2==1)
        return false;
       Stack<Character> s1 = new Stack<>(); 
       
        for(char h: s.toCharArray())
        {
            if(h=='(' || h=='{' || h=='[')
            {
            s1.push(h);
            continue;
            }
            else
            {
                if(s1.isEmpty())
                return false;
            }
            char top = s1.pop();
            if(h==')' && top!='(')return false;
            if(h=='}' && top!='{')return false;
            if(h==']' && top!='[')return false;
        }
        return (s1.isEmpty());
    }
}