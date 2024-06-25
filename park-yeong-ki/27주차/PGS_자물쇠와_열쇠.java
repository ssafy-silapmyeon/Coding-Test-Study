import java.util.*;

class Solution {
    int N, M;
    int[][] newLock;
    public boolean solution(int[][] key, int[][] lock) {
        N = lock.length;
        M = key.length;
                
        for(int i=0; i<4; i++){
            for(int r=-M+1; r<N; r++){
                for(int c=-M+1; c<N; c++){
                    newLock = new int[N][N];
                    for(int j=0; j<N; j++){
                        for(int k=0; k<N; k++){
                            newLock[j][k] = lock[j][k];
                        }
                    }
                    
                    for(int kr=0; kr<M; kr++){
                        for(int kc=0; kc<M; kc++){
                            int tr = r + kr;
                            int tc = c + kc;
                            if(tr < 0 || tr >= N || tc < 0 || tc >= N) continue;
                            newLock[tr][tc] ^= key[kr][kc];
                        }
                    }
                                        
                    if(isAvailable()){
                        return true;
                    }
                    
                }
            }
            
            key = rotateKey(key);
        }
        
        return false;
    }
    
    boolean isAvailable(){
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(newLock[i][j] == 0){
                    return false;
                }
            }
        }
        return true;
    }
    
    int[][] rotateKey(int[][] key){
        int[][] newKey = new int[M][M];
        for(int i=0; i<M; i++){
            for(int j=0; j<M; j++){
                newKey[j][M-1-i] = key[i][j];
            }
        }
        return newKey;
    }
}
