class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums2.length;
        int n2= nums1.length;
        int[] result = new int[n2];
        Map<Integer,Integer> nge = new HashMap<>();
        Stack<Integer> s = new Stack<>();
        for(int i=n-1; i>=0;i--)
        {
            int x = nums2[i];

            while(!(s.isEmpty()) && s.peek()<x)
            {
                s.pop();
            }

            if(s.isEmpty())
            nge.put(x,-1);
            else
            nge.put(x,s.peek());

            s.push(nums2[i]);
        }
        for(int i=0;i<n2;i++)
        {
            int x = nums1[i];
            result[i]=nge.get(x);
        }
        return result;
    }
}
