import java.util.*;
class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        int[][] map = new int[N+1][N+1];
        
        for(int i=1;i<=N;i++){
            for(int j=1;j<=N;j++){
                if(i==j){
                    continue;
                }
                else{
                    map[i][j] = 500000;
                }
            }
        }
        
        for(int i=0;i<road.length;i++){
            int a = road[i][0];
            int b = road[i][1];
            int c = road[i][2];
            map[b][a] = Math.min(map[b][a],c);
            map[a][b] =Math.min(map[a][b],c);
        }
        
        
        for(int i=1;i<=N;i++){//경유지
            for(int j=1;j<=N;j++){//출발지
                for(int k=1;k<=N;k++){//도착지
                    map[j][k] = Math.min(map[j][k],map[j][i]+map[i][k]);
                    
                }
            }
        }

        for(int i=1;i<=N;i++){
            if(map[1][i]<=K){
                answer++;
            }
        }
        return answer;
    }
}