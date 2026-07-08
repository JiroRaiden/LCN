class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int index=0;
        Deque<Integer> dq = new ArrayDeque<>();
        int[] result = new int[n-k+1];

        for(int i=0;i<n;i++)
        {
            int x = nums[i];
            if(!(dq.isEmpty()) && dq.peekFirst()<i-k+1)
            dq.pollFirst();

            while(!(dq.isEmpty()) && x >= nums[dq.peekLast()])
            dq.pollLast();

            dq.offerLast(i);

            if(i>=k-1)
            result[index++]=nums[dq.peekFirst()];  
            
        }
        return result;
    }
}