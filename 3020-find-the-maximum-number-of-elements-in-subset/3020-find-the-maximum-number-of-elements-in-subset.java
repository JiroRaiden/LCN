class Solution {
    public int maximumLength(int[] nums) {
        Map<Long, Integer> count = new HashMap<>();
        for (int num : nums) {
            long val = (long) num;
            count.put(val, count.getOrDefault(val, 0) + 1);
        }
        
        int maxLen = 1;
        
        if (count.containsKey(1L)) {
            int ones = count.get(1L);
            maxLen = Math.max(maxLen, ones % 2 == 0 ? ones - 1 : ones);
        }
        
        for (Map.Entry<Long, Integer> entry : count.entrySet()) {
            long x = entry.getKey();
            
            if (x == 1) continue;
            
            long sqrt = (long) Math.sqrt(x);
            if (sqrt * sqrt == x && count.getOrDefault(sqrt, 0) >= 2) {
                continue;
            }
            
            int currentLen = 0;
            long curr = x;
          
            while (count.getOrDefault(curr, 0) >= 2) {
                currentLen += 2;
                curr = curr * curr;
            }
            
            
            if (count.getOrDefault(curr, 0) >= 1) {
                currentLen += 1; 
            } else {
                currentLen -= 1; 
            }
            
            maxLen = Math.max(maxLen, currentLen);
        }
        
        return maxLen;
    }
}