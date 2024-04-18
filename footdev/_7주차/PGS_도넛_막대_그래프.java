package footdev._7주차;

import java.util.*;

public class PGS_도넛_막대_그래프 {

    Set<Integer> s = new HashSet<>();
    ArrayList<Integer>[] g;

    int[] in, out, ans = new int[4];

    public static void main(String[] args) {
        PGS_도넛_막대_그래프 obj = new PGS_도넛_막대_그래프();
        int[][] input = {{4, 11}, {1, 12}, {8, 3}, {12, 7}, {4, 2}, {7, 11}, {4, 8}, {9, 6}, {10, 11}, {6, 10}, {3, 5}, {11, 1}, {5, 3}, {11, 9}, {3, 8}};
        int[] ans = obj.solution(input);
        System.out.println(Arrays.toString(ans));
    }

    public int[] solution(int[][] edges) {

        //노드 개수 세기
        for (int i = 0; i < edges.length; i++) {
            s.add(edges[i][0]);
            s.add(edges[i][1]);
        }

        in = new int[s.size() + 1];
        out = new int[s.size() + 1];
        g = new ArrayList[s.size() + 1];

        for (int i = 1; i <= s.size(); i++) {
            g[i] = new ArrayList<>();
        }
        
        //그래프 만들기 및 in, out 차수 구하기
        for (int i = 0; i < edges.length; i++) {
            int from  = edges[i][0];
            int to = edges[i][1];
            
            in[to]++;
            out[from]++;

            g[from].add(to);
        }

        //생성된 정점 찾기 들어오는 간선 0, 나가는 간선 2개 이상
        for (int i = 1; i <= s.size(); i++) {
            if (in[i] == 0 && out[i] >= 2) {
                ans[0] = i;
                break;
            }
        }

        //생성된 정점과 연결된 간선의 개수 세기 (모양 그래프 총 개수)
        int sum = g[ans[0]].size();

        //생성된 정점과 연결된 간선 모두 삭제
        for (int adj : g[ans[0]]) {
            in[adj]--;
        }
        g[ans[0]].clear();
        out[ans[0]] = 0;

        //들어오는 간선이 없는 정점의 개수 혹은 나가는 간선이 없는 정점 찾기 (막대 그래프)
        for (int i = 1; i <= s.size(); i++) {
            if (i == ans[0]) continue;
            if (out[i] == 0) {
                ans[2]++;
            }
            //들어오는 간선이 2개 면서 나가는 간선 또한 2개인 정점 찾기 (8자 그래프)
            else if (in[i] == 2 && out[i] == 2) {
                ans[3]++;
            }
        }

        //sum - 4, 5번에서 샌 개수 빼기 (도넛 그래프)
        ans[1] = sum - (ans[2] + ans[3]);



        return ans;
    }
}
