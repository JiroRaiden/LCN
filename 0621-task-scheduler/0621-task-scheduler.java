class Solution {
    public int leastInterval(char[] tasks, int n) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int[] freq = new int[26];

        for(int i =0;i< tasks.length;i++)
        freq[tasks[i] - 'A'] ++;

        for(int i: freq)
        {
            if(i>0)
            pq.offer(i);
        }

        int time = 0;
        while(!pq.isEmpty())
        {
            List<Integer> temp = new ArrayList<>();
            int counter = 0;
            while(counter!=n+1)
            {
                if(!pq.isEmpty())
                {
                    int currFreq = pq.poll();
                    currFreq--;
                    temp.add(currFreq);
                }
                counter++;
            }

            for(int i:temp)
            {
                if(i>0)
                pq.offer(i);
            }

            if(pq.isEmpty())
            time+=temp.size();
            else
            time+=n+1;
        }

        return time;
    }
}