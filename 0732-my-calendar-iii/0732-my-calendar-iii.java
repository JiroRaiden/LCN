class MyCalendarThree {
    private TreeMap<Integer, Integer> event;
    public MyCalendarThree() {
        event = new TreeMap<>();
    }
    
    public int book(int startTime, int endTime) {
        event.put(startTime, event.getOrDefault(startTime, 0)+1);
        event.put(endTime, event.getOrDefault(endTime,0)-1);

        int count = 0;
        int maxEve = 0;
        for(int sweep: event.values())
        {
            count += sweep;
            maxEve = Math.max(count, maxEve);
        }
        return maxEve;
    }
}

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(startTime,endTime);
 */