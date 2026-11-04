class Solution {

    class MedianWindow {

        TreeMap<Integer, Integer> low = new TreeMap<>();
        TreeMap<Integer, Integer> high = new TreeMap<>();

        int lowSize = 0, highSize = 0;
        long lowSum = 0, highSum = 0;

        void addMap(TreeMap<Integer, Integer> map, int val) {
            map.put(val, map.getOrDefault(val, 0) + 1);
        }

        void removeMap(TreeMap<Integer, Integer> map, int val) {
            int count = map.get(val);

            if (count == 1) map.remove(val);
            else map.put(val, count - 1);
        }

        void add(int val) {

            if (low.isEmpty() || val <= low.lastKey()) {
                addMap(low, val);
                lowSize++;
                lowSum += val;
            } else {
                addMap(high, val);
                highSize++;
                highSum += val;
            }

            balance();
        }

        void remove(int val) {

            if (low.containsKey(val)) {
                removeMap(low, val);
                lowSize--;
                lowSum -= val;
            } else {
                removeMap(high, val);
                highSize--;
                highSum -= val;
            }

            balance();
        }

        void balance() {

            int target = (lowSize + highSize + 1) / 2;

            while (lowSize > target) {
                int val = low.lastKey();

                removeMap(low, val);
                lowSize--;
                lowSum -= val;

                addMap(high, val);
                highSize++;
                highSum += val;
            }

            while (lowSize < target) {
                int val = high.firstKey();

                removeMap(high, val);
                highSize--;
                highSum -= val;

                addMap(low, val);
                lowSize++;
                lowSum += val;
            }
        }

        long getCost() {

            long median = low.lastKey();

            return median * lowSize - lowSum
                    + highSum - median * highSize;
        }
    }

    public long minOperations(int[] nums, int x, int k) {

        int n = nums.length;
        int m = n - x + 1;

        long[] cost = new long[m];

        // Calculate cost of every window
        MedianWindow window = new MedianWindow();

        for (int i = 0; i < x; i++) {
            window.add(nums[i]);
        }

        for (int i = 0; i < m; i++) {

            cost[i] = window.getCost();

            if (i < m - 1) {
                window.remove(nums[i]);
                window.add(nums[i + x]);
            }
        }

        // Dynamic Programming
        long INF = Long.MAX_VALUE / 4;

        long[] prev = new long[n + 1];
        long[] curr = new long[n + 1];

        for (int j = 1; j <= k; j++) {

            java.util.Arrays.fill(curr, INF);

            for (int i = 1; i <= n; i++) {

                // Skip current element
                curr[i] = curr[i - 1];

                // Select a window of size x
                if (i >= x && prev[i - x] != INF) {

                    long take = prev[i - x] + cost[i - x];

                    curr[i] = Math.min(curr[i], take);
                }
            }

            prev = curr.clone();
        }

        return prev[n];
    }
}