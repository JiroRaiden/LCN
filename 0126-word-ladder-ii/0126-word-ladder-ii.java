class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict= new HashSet<>(wordList);
        
        List<List<String>> ans = new ArrayList<>();
        Map<String, Integer> mpp = new HashMap<>();
        Queue<String> q = new LinkedList<>();

        q.offer(beginWord);
        mpp.put(beginWord,1);
        dict.remove(beginWord);
        //Phase 1 BFS
        while(!q.isEmpty())
        {
            String word = q.peek();
            int steps= mpp.get(word);
            for(int i=0;i<word.length();i++)
            {
                for(char c='a';c<='z';c++)
                {
                    char[] stringToChar = word.toCharArray();
                    stringToChar[i] = c;
                    String newWord = new String(stringToChar);

                    if(dict.contains(newWord))
                    {
                        q.offer(newWord);
                        mpp.put(newWord, steps+1);
                        dict.remove(newWord);
                    }
                }
            }
            q.poll();
        }

        //Phase 2 DFS

        if(mpp.containsKey(endWord))
        {
            List<String> path = new ArrayList<>();
            path.add(endWord);

            dfs(endWord,beginWord, path,  mpp,ans);
        }
        return ans;
    }

    public void dfs(String currWord,String beginWord, List<String> path, Map<String,Integer> mpp, List<List<String>> ans)
    {
        if(currWord.equals(beginWord))
        {
            List<String> validPath = new ArrayList<>(path);
            Collections.reverse(validPath);
            ans.add(validPath);
            return;
        }

        char[] chars = currWord.toCharArray();
        int steps = mpp.get(currWord);
        int size = currWord.length();
        for(int i = 0;i<size;i++)
        {
            char original = chars[i];
            for(char c='a';c<='z';c++)
            {
                if(c == original) continue;

                chars[i] = c;
                String prevWord = new String(chars);

                if(mpp.containsKey(prevWord) && mpp.get(prevWord) == (steps-1))
                {
                    path.add(prevWord);
                    dfs(prevWord, beginWord, path, mpp, ans);
                    path.remove(path.size()-1);
                }
            }
            chars[i]=original;
        } 
    }
}               