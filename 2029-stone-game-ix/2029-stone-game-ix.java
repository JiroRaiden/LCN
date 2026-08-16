class Solution {
    public boolean stoneGameIX(int[] stones) {
        int a = 0; 
        int b = 0; 
        int c = 0; 

        for (int stone : stones) {
            if (stone % 3 == 0) {
                c++;
            } else if (stone % 3 == 1) {
                a++;
            } else {
                b++;
            }
        }

        if (c % 2 == 0) {
            return a > 0 && b > 0;
        }

        return Math.abs(a - b) > 2;
    }
}