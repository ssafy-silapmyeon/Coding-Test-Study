import java.util.*;

class PGS_단속카메라 {
    public int solution(int[][] routes) {
        Arrays.sort(routes, new Comparator<>(){
            @Override
            public int compare(int[] o1, int[] o2){
                return Integer.compare(o1[1], o2[1]);
            }
        });

        int idx = 0;
        int cnt = 1;
        for(int i=1; i<routes.length; i++){
            if(routes[idx][1] < routes[i][0]){
                cnt++;
                idx = i;
            }
        }

        return cnt;
    }
}