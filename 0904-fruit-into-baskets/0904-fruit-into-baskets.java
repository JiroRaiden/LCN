class Solution {
    public int totalFruit(int[] fruits) {
        int[] freq = new int[fruits.length];
        int left = 0;
        int right = 0;
        int distinctFruit = 0;
        int k = 2;

        for(right = 0;right< fruits.length; right++)
        {
            if(freq[fruits[right]]==0)
            distinctFruit++;

            freq[fruits[right]]++;

            if(distinctFruit>k)
            {
                freq[fruits[left]]--;

                if(freq[fruits[left]]==0)
                distinctFruit--;

                left++;
            }
        }
        return right-left;
    }
}