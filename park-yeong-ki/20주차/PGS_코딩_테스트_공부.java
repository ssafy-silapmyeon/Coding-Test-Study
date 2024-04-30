class Solution {
    static int[][] visited;
    static int[][] sProblems;
    static int ma, mc;
    public int solution(int alp, int cop, int[][] problems) {
        ma = mc = 0;
        for(int[] p : problems){
            ma = Math.max(p[0], ma);
            mc = Math.max(p[1], mc);
        }
        
        visited = new int[ma+1][mc+1];
        for(int i=0; i<=ma; i++){
            for(int j=0; j<=mc; j++){
                visited[i][j] = 300;
            }
        }
        sProblems = problems;
        
        dfs(alp, cop, 0);
        
        return visited[ma][mc];
    }
    
    static void dfs(int a, int c, int t){
        if(ma < a) a = ma;
        if(mc < c) c = mc;
        
        if(visited[a][c] <= t){
            return;
        }
        visited[a][c] = t;
        
        for(int[] p : sProblems){
            if(p[0] <= a && p[1] <= c){
                dfs(a+p[2], c+p[3], t+p[4]);
            }
        }
        dfs(a+1, c, t+1);
        dfs(a, c+1, t+1);
    }
}
