import java.util.*;

class PGS_석유_시추 {
    static int r, c;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static int num, cnt, ans;
    static Map<Integer, Integer> map;

    public int solution(int[][] land) {
        r = land.length;
        c = land[0].length;

        num = 1;
        map = new HashMap<>();
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(land[i][j] != 1) continue;
                num++;
                cnt = 0;
                dfs(i, j, land);
                map.put(num, cnt);
            }
        }

        ans = 0;
        searchColumn(land);

        return ans;
    }

    static void updateAns(Set<Integer> set){
        List<Integer> list = new ArrayList<>(set);

        int sum = 0;
        for(int n : list){
            sum += map.get(n);
        }

        ans = Math.max(ans, sum);
    }

    static void searchColumn(int[][] land){
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<c; i++){
            for(int j=0; j<r; j++){
                if(land[j][i] < 2) continue;
                set.add(land[j][i]);
            }
            updateAns(set);
            set.clear();
        }
    }

    static void dfs(int row, int col, int[][] land){
        land[row][col] = num;
        cnt++;

        for(int i=0; i<4; i++){
            int tr = row + dr[i];
            int tc = col + dc[i];

            if(tr < 0 || tr >= r || tc < 0 || tc >= c) continue;
            if(land[tr][tc] != 1) continue;
            dfs(tr, tc, land);
        }
    }
}