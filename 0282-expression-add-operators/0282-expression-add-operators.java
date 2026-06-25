class Solution {
    public List<String> addOperators(String num, int target) {
        List<String>result = new ArrayList<>();
        solve(num,target,result,new StringBuilder(),0,0,0);
        return result;
    }

    public void solve(String num, int target, List<String> result,StringBuilder curr,int index,long currVal, long multed)
    {
        if(index==num.length())
        {
            if(currVal==target)
            result.add(curr.toString());

            return;
        }

        long currNum=0;
        int len = curr.length();

        for(int i=index;i<num.length();i++)
        {
            if(i!=index && num.charAt(index) == '0')
            break;

            currNum = currNum*10 + num.charAt(i) -'0';
            
            if(index==0)
            {
                curr.append(currNum);
                solve(num,target,result,curr,i+1,currNum,currNum);
                curr.setLength(len);
            }
            else
            {
                curr.append('+').append(currNum);
                solve(num,target,result,curr,i+1,currVal+currNum,currNum);
                curr.setLength(len);

                curr.append('-').append(currNum);
                solve(num,target,result,curr,i+1,currVal-currNum,-currNum);
                curr.setLength(len);

                curr.append('*').append(currNum);
                solve(num,target,result,curr,i+1,currVal-multed+multed*currNum,multed*currNum);
                curr.setLength(len);
            }
        }

    }
}