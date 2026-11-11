class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a,b)->Integer.compare(b[1],a[1]));
        int totalUnits = 0;

        for(int[] box: boxTypes)
        {
            int boxToTake = Math.min(box[0],truckSize);
            totalUnits+= box[1]*boxToTake;

            truckSize-= boxToTake;

            if(truckSize==0)
            return totalUnits;

        }
        return totalUnits;
    }
}