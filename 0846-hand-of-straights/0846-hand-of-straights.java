class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length%groupSize!=0)
        return false;

        Arrays.sort(hand);
        
        Map<Integer,Integer> freq = new HashMap<>();

        for(int card: hand)
        freq.put(card, freq.getOrDefault(card,0)+1);

        for(int card: hand)
        {
            int count = freq.getOrDefault(card,0);

            if(count>0)
            {
                for(int i=0;i< groupSize;i++)
                {
                    int currentCard = card+i;
                    int currCardCount= freq.getOrDefault(currentCard,0);
                    if(currCardCount<count)
                    return false;

                    freq.put(currentCard, currCardCount -1);

                }
            }
        }
        return true;
    }
}