class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<>();

        int ans =0;
        for(int i=0;i<tokens.length;i++)
        {
            if(tokens[i].equals("+")||tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/"))
            {
                int top1 = s.pop();
                int top2 = s.pop();
                switch(tokens[i])
                {
                    case "+": ans = top2+top1;
                    break;
                    case "-": ans = top2-top1;
                    break;
                    case "*": ans = top2*top1;
                    break;
                    case "/": ans = top2/top1;
                    break;
                }
                s.push(ans);
            }
            else
            {
                s.push(Integer.parseInt(tokens[i]));
            }
        } 
       return s.peek();
    }
}