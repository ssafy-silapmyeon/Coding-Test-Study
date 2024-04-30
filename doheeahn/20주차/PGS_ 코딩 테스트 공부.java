import java.util.*;
class Solution {
    public int solution(int alp, int cop, int[][] problems) {
        int answer = 0;
        int maxA =0;
        int maxC =0;
        for(int i=0;i<problems.length;i++){
            maxA = maxA < problems[i][0] ? problems[i][0] : maxA;
            maxC = maxC < problems[i][1] ? problems[i][1] : maxC;
        }
        
        int dp[][] = new int[maxA+1][maxC+1];
        if(alp > maxA){
            alp = maxA;
        }
        if(cop > maxC){
            cop =maxC;
        }
        for(int i=alp;i<=maxA;i++){
            for(int j=cop;j<=maxC;j++){
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        dp[alp][cop] =0;
        
        for(int i=alp;i<=maxA;i++){
            for(int j= cop;j<=maxC;j++){
                if(i == maxA && j==maxC){
                    answer = dp[i][j];
                    continue;
                }
                if(i+1 <= maxA){
                    dp[i+1][j] = Math.min(dp[i][j]+1,dp[i+1][j]);
                }
                if(j+1 <= maxC){
                    dp[i][j+1] = Math.min(dp[i][j]+1,dp[i][j+1]);
                }
                
                for(int p=0;p<problems.length;p++){
                    if(problems[p][0]<= i && problems[p][1] <=j){
                        int a = problems[p][2];
                        int c = problems[p][3];
                        int t = problems[p][4];
                        int nexti = i+a;
                        int nextj =j+c;
                        if(nexti > maxA){
                            nexti = maxA;
                        }
                        if(nextj > maxC){
                            nextj = maxC;
                        }
                        dp[nexti][nextj] = Math.min(dp[i][j]+t, dp[nexti][nextj]);
                    }
                }
            }
        }
        return answer;
    }
}