import java.util.*;

class Solution {
    static int[] di = { 1, 0, 0, -1 };
    static int[] dj = { 0, -1, 1, 0 };
    static char[] ch = {'d', 'l', 'r', 'u'};
    
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        int distance = Math.abs(x - r) + Math.abs(y - c);
        if (distance > k || (distance - k) % 2 != 0) {
            return "impossible";
        }
        
        int count = 0;
        int i = x;
        int j = y;
        String route = "";
        int nexti = -1;
        int nextj = -1;
        while (count + distance < k) {
            for (int d = 0; d < 4; d++) {
                nexti = i + di[d];
                nextj = j + dj[d];
                
                if (nexti > 0 && nexti <= n && nextj > 0 & nextj <= m &&
                   Math.abs(nexti - r) + Math.abs(nextj - c) + count + 1 <= k) {
                    route += ch[d];
                    distance = Math.abs(nexti - r) + Math.abs(nextj - c);
                    count++;
                    break;
                }
            }
            
            i = nexti;
            j = nextj;
        }
        
        int down = r - i;
        int right = c - j;

        if (down > 0) {
            for (int d = 0; d < down; d++) {
                route += 'd';
            }
        }

        if (right > 0) {
            for (int d = 0; d < right; d++) {
                route += 'r';
            }
        } else {
            for (int d = 0; d < (-1) * right; d++) {
                route += 'l';
            }
        }

        if (down < 0) {
            for (int d = 0; d < (-1) * down; d++) {
                route += 'u';
            }
        }

        return route;
    }
}