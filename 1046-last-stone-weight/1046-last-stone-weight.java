class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int stone: stones)
        pq.offer(stone);

        while(pq.size()>1)
        {
            int a = pq.poll();
            int b = pq.poll();

            int diff = a-b;

            if(diff>0)
            pq.offer(diff);
        }

        return (pq.isEmpty())?0:pq.poll();
    }
}