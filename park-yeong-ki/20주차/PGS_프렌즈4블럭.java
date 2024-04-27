class Solution {
    static char[][] map;
    static boolean[][] checkMap;
    static int row, col;
    public int solution(int m, int n, String[] board) {
        row = m;
        col = n;
        map = new char[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                map[i][j] = board[i].charAt(j);
            }
        }
        checkMap = new boolean[m][n];
        
        int answer = 0;
        int current;
        while(true){
            findBlock();
            current = removeBlock();
            if(current == 0) break;
            answer += current;
            moveBlock();
        }
        
        return answer;
    }
    
    static void moveBlock(){
        for(int c = 0; c < col; c++){
            int b = -1;
            for(int r=row-1; r>=0; r--){
                if(map[r][c] == ' '){
                    b = r;
                    break;
                }
            }
            
            for(int r=b-1; r>=0; r--){
                if(map[r][c] != ' '){
                    map[b][c] = map[r][c];
                    map[r][c] = ' ';
                    b--;
                }
            }
        }
    }
    
    static int removeBlock(){
        int cnt = 0;
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(checkMap[i][j]){
                    map[i][j] = ' ';
                    cnt++;
                    checkMap[i][j] = false;
                }
            }
        }
        
        return cnt;
    }
    
    static boolean is4Block(int i, int j){
        for(int x=i; x<i+2; x++){
            for(int y=j; y<j+2; y++){
                if(x >= row || y >= col || map[i][j] != map[x][y]){
                    return false;
                }
            }
        }
        
        return true;
    }
    
    static void findBlock(){
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(map[i][j] != ' ' && is4Block(i, j)){
                    for(int x=i; x<i+2; x++){
                        for(int y=j; y<j+2; y++){
                            checkMap[x][y] = true;
                        }
                    }
                }
            }
        }
    }
}
