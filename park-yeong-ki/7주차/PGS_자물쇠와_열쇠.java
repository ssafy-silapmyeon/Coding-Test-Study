import java.util.*;

class Solution {
    static int N, M;
    static class Point {
        int r, c;
        
        Point(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    
    public boolean solution(int[][] key, int[][] lock) {
        N = lock.length;
        M = key.length;
        List<Point> lList = savePoint(lock, false);
        if(lList.size() == 0) return true;
        
        List<Point> kList;
        for(int i=0; i<4; i++){
            kList = savePoint(key, true);
            if(kList.size() == 0) return false;
            
            for(Point k : kList){
                for(Point l : lList){
                    int dr = l.r - k.r;
                    int dc = l.c - k.c;
                    int cnt = 0;
                    boolean flag = true;
                    for(Point p : kList){ 
                        int mr = p.r + dr;
                        int mc = p.c + dc;
                        if(mr < 0 || mr >= N ||
                           mc < 0 || mc >= N) continue;
                        
                        if(lock[mr][mc] == 0){
                            cnt++;
                        } else {
                            flag = false;
                            break;
                        }
                    }
                                        
                    if(flag && cnt == lList.size()){
                        return true;
                    }
                }
            }
            key = rotateMap(key);
        }
        
        return false;
    }
    
    static int[][] rotateMap(int[][] key){
        int[][] nextMap = new int[key.length][key[0].length];
        
        for(int i=0; i<M; i++){
            for(int j=0; j<M; j++){
                nextMap[j][M-1-i] = key[i][j];
            }
        }
        
        return nextMap;
    }
    
    static List<Point> savePoint(int[][] map, boolean sort){
        int s = sort ? 1 : 0;
        List<Point> list = new ArrayList<>();
        for(int i=0; i<map.length; i++){
            for(int j=0; j<map.length; j++){
                if(map[i][j] == s){
                    list.add(new Point(i, j));
                }
            }
        }
        
        return list;
    }
}
