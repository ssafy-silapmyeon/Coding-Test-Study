class Solution {
    static int[] di = {1,0,-1,0};
    static int[] dj = {0,1,0,-1};
    
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int ans = 1;
        int[][] arr = new int[rows][columns];
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                arr[i][j] = ans++;
            }
        }
        for(int i=0;i<queries.length;i++){
            int x1= queries[i][0]-1;
            int y1 = queries[i][1]-1;
            int x2 = queries[i][2]-1;
            int y2 = queries[i][3]-1;
            int tmp = arr[x1][y1];
            answer[i] = rotate(x1,y1,x2,y2,arr,arr[x1][y1]);
            arr[x1][y1+1] = tmp;
            
        }
        return answer;
    }
    
    public int rotate(int x1,int y1, int x2, int y2, int[][] arr,int min){
        int x = x1;
        int y = y1;
        
        for(int d=0;d<4;d++){
            while(!(d==0 && x==x2 && y==y1) && !(d==1 && x==x2 && y==y2)
            && !(d==2 && x==x1 &&y==y2) && !(d==3 && x==x1 && y==y1)){

                arr[x][y] = arr[x+di[d]][y+dj[d]];
                if(min> arr[x][y]){
                    min = arr[x][y];
                }
                x +=di[d];
                y +=dj[d];
            }
        }
        return min;
    }
}