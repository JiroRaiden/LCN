class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        int n = players.length;
        int m = trainers.length;

        Arrays.sort(players);
        Arrays.sort(trainers);
        
        int r = 0;
        int l = 0;
        while(r<m)
        {
            if(l<n && players[l]<= trainers[r])
            l++;

            r++;
        }
        return l;
    }
}