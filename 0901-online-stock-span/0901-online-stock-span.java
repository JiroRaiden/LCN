
class StockSpanner {
    Stack<int[]> s;
    public StockSpanner() {
        s= new Stack<>();
    }
    
    public int next(int price) {
        int currSpan=1;

        while(!(s.isEmpty()) && price>=s.peek()[0])
        {
            currSpan+=s.peek()[1];
            s.pop();
        }

        s.push(new int[]{price, currSpan});
    return currSpan;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */