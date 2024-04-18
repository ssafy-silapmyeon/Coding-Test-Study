import java.util.*;

class PGS_섬_연결하기 {
    public int solution(int n, int[][] costs) {
        Arrays.sort(costs, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                return Integer.compare(o1[2], o2[2]);
            }
        });

        makeSet(n);

        int ans = 0;
        int cnt = 0;
        for(int i=0; i<costs.length; i++){
            if(union(costs[i][0], costs[i][1])){
                ans += costs[i][2];
                if(++cnt == n-1) break;
            }
        }

        return ans;
    }

    static int[] parents;
    static void makeSet(int n){
        parents = new int[n];
        for(int i=0; i<n; i++){
            parents[i] = i;
        }
    }

    static int findSet(int p){
        if(parents[p] == p){
            return p;
        }

        return parents[p] = findSet(parents[p]);
    }

    static boolean union(int a, int b){
        int rootA = findSet(a);
        int rootB = findSet(b);

        if(rootA == rootB) return false;

        parents[rootB] = rootA;
        return true;
    }
}