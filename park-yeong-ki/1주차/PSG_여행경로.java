import java.util.*;

class PSG_여행경로 {
    static Map<String , List<String>> map;
    static Map<String, Boolean[]> visited;
    static int cnt;
    static String[] ans;
    static List<String> path;
    static boolean flag;

    public String[] solution(String[][] tickets) {
        map = new HashMap<>();
        visited = new HashMap<>();
        String from, to;
        cnt = 0; //항공권 개수
        for(int i=0; i<tickets.length; i++){ //출발지별 리스트 생성
            from = tickets[i][0];
            to = tickets[i][1];
            cnt++;

            if(map.containsKey(from)){
                map.get(from).add(to);
            }else{
                map.put(from, new ArrayList<>());
                map.get(from).add(to);
            }

            if(!map.containsKey(to)){
                map.put(to, new ArrayList<>());
            }
        }


        List<String> start = new ArrayList<>(map.keySet());
        for(String str : start){
            visited.put(str, new Boolean[map.get(str).size()]); //방문 배열 생성
            Arrays.fill(visited.get(str), false);
            Collections.sort(map.get(str)); //알파벳 순서로 경로 정렬
        }

        flag = false;
        path = new ArrayList<>();
        path.add("ICN");
        dfs(0, "ICN");

        return ans;
    }

    static void dfs(int depth, String from){
        if(depth == cnt){ //모든 항공권을 사용한 경우
            ans = new String[path.size()];
            for(int i=0; i<path.size(); i++){
                ans[i] = path.get(i);
            }
            flag = true;

            return;
        }

        for(int i=0; i<map.get(from).size(); i++){ //현재 도시가 출발지인 항공권 목록
            if(visited.get(from)[i]) continue; //이미 사용한 항공권인 경우
            visited.get(from)[i] = true; //사용 표시
            path.add(map.get(from).get(i));
            dfs(depth+1, map.get(from).get(i));
            if(flag) return; //경로가 한 번 완성되면 그대로 종료
            path.remove(path.size()-1); //백트래킹
            visited.get(from)[i] = false;
        }

    }
}