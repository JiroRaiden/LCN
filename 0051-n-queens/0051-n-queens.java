class Solution {
    public List<List<String>> solveNQueens(int n) {
        
        List<List<String>> result = new ArrayList<>();
        if(n==0)
        return result;
        char[][] board = new char[n][n];

        for(char[]h:board)
        Arrays.fill(h,'.');

        int[] topCol = new int[n];
        int[] lowDiag = new int[2*n-1];
        int[] upDiag = new int[2*n-1];

        backtrack(0,n,topCol,lowDiag,upDiag,board,result);
            
        return result;
    }
    public void backtrack(int row, int n, int[] topCol, int[] lowDiag, int[] upDiag, char[][] board, List<List<String>> result)
    {
        if (row==n)
        {
            result.add(constructBoard(board));
            return;
        }
        for(int col=0;col<n;col++)
        {
            if(topCol[col]==0 && lowDiag[row+col]==0 && upDiag[(n-1)+row-col]==0)
            {
                board[row][col]= 'Q';
                topCol[col]=1;
                lowDiag[row+col]=1;
                upDiag[(n-1)+row-col]=1;

                backtrack(row+1,n,topCol, lowDiag, upDiag,board,result);

                board[row][col]= '.';
                topCol[col]=0;
                lowDiag[row+col]=0;
                upDiag[(n-1)+row-col]=0;
            }
        }
    }

    public List<String> constructBoard(char[][] board)
    {
        List<String> result = new ArrayList<>();
        for(int i=0;i < board.length;i++)
        result.add(new String(board[i]));

        return result;
    }
}