import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, new Comparator<int[]>() {
            @Override
            public int compare(int[] r1, int[] r2) {
                if (r1[1] == r2[1])
                    return r1[0] - r2[0];
                return r1[1] - r2[1];   
            }
        });
        
        int point = -30001;
        int count = 0;
        
        for (int i = 0; i < routes.length; i++) {
            if (point < routes[i][0]) {
                point = routes[i][1];
                count++;
            }
        } 
        
        return count;
    }
}