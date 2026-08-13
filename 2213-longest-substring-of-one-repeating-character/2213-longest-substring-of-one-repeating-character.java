class Solution {
    int[] tree_max, tree_prefLen, tree_suffLen, tree_size;
    char[] tree_prefChar, tree_suffChar;

    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
        int n = s.length();
        int k = queryIndices.length;

        tree_max = new int[4 * n];
        tree_prefLen = new int[4 * n];
        tree_suffLen = new int[4 * n];
        tree_size = new int[4 * n];
        tree_prefChar = new char[4 * n];
        tree_suffChar = new char[4 * n];
        
        char[] arr = s.toCharArray();
        build(1, 0, n - 1, arr);
        
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            update(1, 0, n - 1, queryIndices[i], queryCharacters.charAt(i));
            ans[i] = tree_max[1];
        }
        
        return ans;
    }
    
    private void build(int node, int start, int end, char[] arr) {
        if (start == end) {
            tree_max[node] = 1;
            tree_prefLen[node] = 1;
            tree_suffLen[node] = 1;
            tree_size[node] = 1;
            tree_prefChar[node] = arr[start];
            tree_suffChar[node] = arr[start];
            return;
        }
        int mid = start + (end - start) / 2;
        int left = 2 * node;
        int right = 2 * node + 1;
        
        build(left, start, mid, arr);
        build(right, mid + 1, end, arr);
        merge(node, left, right);
    }
    
    private void update(int node, int start, int end, int idx, char c) {
        if (start == end) {
            tree_prefChar[node] = c;
            tree_suffChar[node] = c;
            return;
        }
        int mid = start + (end - start) / 2;
        int left = 2 * node;
        int right = 2 * node + 1;
        
        if (idx <= mid) {
            update(left, start, mid, idx, c);
        } else {
            update(right, mid + 1, end, idx, c);
        }
        merge(node, left, right);
    }
    
    private void merge(int parent, int left, int right) {
        tree_size[parent] = tree_size[left] + tree_size[right];
        
        tree_prefChar[parent] = tree_prefChar[left];
        tree_suffChar[parent] = tree_suffChar[right];
        
        // Calculate prefix length
        tree_prefLen[parent] = tree_prefLen[left];
        if (tree_prefLen[left] == tree_size[left] && tree_prefChar[left] == tree_prefChar[right]) {
            tree_prefLen[parent] += tree_prefLen[right];
        }
        
        // Calculate suffix length
        tree_suffLen[parent] = tree_suffLen[right];
        if (tree_suffLen[right] == tree_size[right] && tree_suffChar[right] == tree_suffChar[left]) {
            tree_suffLen[parent] += tree_suffLen[left];
        }
        
        // Calculate maximum repeating substring in this segment
        tree_max[parent] = Math.max(tree_max[left], tree_max[right]);
        if (tree_suffChar[left] == tree_prefChar[right]) {
            tree_max[parent] = Math.max(tree_max[parent], tree_suffLen[left] + tree_prefLen[right]);
        }
    }
}