import java.util.*;

class Solution {
    static int[] parents;
    public int solution(int n, int[][] costs) {
        Arrays.sort(costs, new Comparator<int[]>() {
            @Override
            public int compare(int[] c1, int[] c2) {
                return Integer.compare(c1[2], c2[2]);
            }
        });
        
        makeSet(n);
        
        int answer = 0;
        int count = 0;
        for (int i = 0; i < costs.length; i++) {
            if (union(costs[i][0], costs[i][1])) {
                answer += costs[i][2];
                count++;
            }
            
            if (count == n - 1)
                break;
        }
        
        return answer;
    }
    
    static void makeSet(int n) {
        parents = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }
    }
    
    static boolean union(int A, int B) {
        int parentA = findSet(A);
        int parentB = findSet(B);
        
        if (parentA == parentB) {
            return false;
        } else {
            parents[parentB] = parentA;
            return true;
        }
    }
    
    static int findSet(int x) {
        if (parents[x] == x)
            return x;
        
        return parents[x] = findSet(parents[x]);
    }
}