class Solution {
    public int maximumWidth(int[] planks) {
        int maxPlank = 0;
        int maxHeight = 0;
        HashMap<Integer,Integer> freq = new HashMap<>();

        for(int i: planks)
            freq.put(i,freq.getOrDefault(i,0)+1);

        int[] keys = new int[freq.size()];
        int idx = 0;
        for(int k : freq.keySet())
            {
                keys[idx++] = k;
            }

        HashMap<Integer,Integer> target = new HashMap<>();

        for(int i: keys)
            {
                target.put(i,freq.get(i));
            }

        for(int i=0;i<keys.length;i++)
            {
                for(int j = i;j< keys.length;j++)
                    {
                        int x = keys[i];
                        int y = keys[j];
                        int tgt = x + y;

                        int c = (x==y)?freq.get(x)/2:Math.min(freq.get(x),freq.get(y));
                        if(c>0)
                        {
                            target.put(tgt, target.getOrDefault(tgt,0)+c);
                        }
                    }
            }
        int maxWidth = 0;
        for(int i: target.values())
            {
                maxPlank=Math.max(maxPlank,i);
            }
        return maxPlank;
    }
}