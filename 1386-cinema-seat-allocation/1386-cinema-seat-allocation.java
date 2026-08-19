class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int[] seat : reservedSeats) {
            int row = seat[0];
            int s = seat[1];

            if (s >= 2 && s <= 9) {
                int mask = map.getOrDefault(row, 0);
                mask |= (1 << s);
                map.put(row, mask);
            }
        }

        int answer = (n - map.size()) * 2;

        int left = (1 << 2) | (1 << 3) | (1 << 4) | (1 << 5);
        int right = (1 << 6) | (1 << 7) | (1 << 8) | (1 << 9);
        int middle = (1 << 4) | (1 << 5) | (1 << 6) | (1 << 7);

        for (int mask : map.values()) {
            boolean canLeft = (mask & left) == 0;
            boolean canRight = (mask & right) == 0;
            boolean canMiddle = (mask & middle) == 0;

            if (canLeft && canRight) {
                answer += 2;
            } else if (canLeft || canMiddle || canRight) {
                answer += 1;
            }
        }

        return answer;
    }
}