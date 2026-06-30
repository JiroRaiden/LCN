class MinStack {
    long min = Long.MIN_VALUE;
    Stack<Long> s;
    public MinStack() {
        s = new Stack<>();
    }
    
    public void push(int value) {
        if(s.isEmpty())
        {
            min= (long)value;
            s.push((long)value);
        }
        else
        {
            if((long)value>=min)
            s.push((long)value);
            else
            {
                s.push(2*((long)value)-min);
                min=(long)value;
            }
        }
    }
    
    public void pop() {
        if(s.isEmpty())
        return;

        if(s.peek()>=min)
        s.pop();
        else
        min = 2*(min)- s.pop();
    }
    
    public int top() {
        if(s.peek()>=min)
        return s.peek().intValue();
        else
        return (int)min;
    }
    
    public int getMin() {
        return (int)min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */