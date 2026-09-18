class Solution {
    private boolean isSafe(char[][] mat , int row, int col){
        int n = mat.length;
        int i , j ;
        //column wise
        for( i =0 ; i<row;i++){
            if(mat[i][col] == 'Q'){
                return false;
            }
        }
        //diagonal left upper
        for(i = row -1 , j= col-1 ; i>=0 && j>=0 ; i--, j--){
            if(mat[i][j] == 'Q'){
                return false;
            }
        }
        //diagonal right upper
        for(i = row -1 , j= col+1 ; i>=0 && j<n ; i--, j++){
            if(mat[i][j] == 'Q'){
                return false;
            }
        }
        return true;
    }
    private void placeQueens(char[][] mat, int row ,List<List<String>> result ){
        int n = mat.length;
        if( row == n){
            List<String> temp = new ArrayList<>();
            for(int i =0 ; i< n ;i++){
                temp.add( new String(mat[i]));
            }
            result.add(temp);
            return;
        }

        for( int i =0 ; i< n; i++){
            if(isSafe(mat, row, i)){
                mat[row][i] = 'Q';
                placeQueens(mat, row+1, result); //backtrack
                mat[row][i] = '.';
            }
        }
    
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char [][] mat = new char[n][n];
        for (int i = 0 ; i<n ;i++) {
            Arrays.fill(mat[i],'.');
        }
        placeQueens(mat, 0, result);
        return result;
    }
    public int totalNQueens(int n) {
        List<List<String>> result = solveNQueens(n);
        int count = 0;
        for(List<String> q : result){
            count++;
            
        }
        return count ;
    }
}