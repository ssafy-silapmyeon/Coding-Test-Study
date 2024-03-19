import java.util.*;

class Solution {
    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, -1, 1};
    
    public int[] solution(String[] maps) {
        ArrayList<Integer> daysList = new ArrayList<>();
        boolean[][] visited = new boolean[maps.length][maps[0].length()];
        
        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[i].length(); j++) {
                if (maps[i].charAt(j) != 'X' && !visited[i][j]) {
                    int days = bfs(i, j, maps, visited);
                    daysList.add(days);
                }
            }
        }

        Collections.sort(daysList);
        
        if (daysList.size() == 0) {
            return new int[] {-1};
        } else {
            int[] answer = new int[daysList.size()];
            for (int i = 0; i < daysList.size(); i++) {
                answer[i] = daysList.get(i);
            }
            
            return answer;
        }
    }
    
    static int bfs(int si, int sj, String[] maps, boolean[][] visited) {
        Queue<int[]> queue = new ArrayDeque<>();
        visited[si][sj] = true;
        queue.add(new int[] {si, sj});
        
        int days = 0;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            days += maps[now[0]].charAt(now[1]) - '0';
            
            for (int d = 0; d < 4; d++) {
                int nexti = now[0] + di[d];
                int nextj = now[1] + dj[d];
                
                if (nexti >= 0 && nexti < maps.length && nextj >= 0 && nextj < maps[0].length() && !visited[nexti][nextj] && maps[nexti].charAt(nextj) != 'X') {
                    visited[nexti][nextj] = true;
                    queue.add(new int[] {nexti, nextj});
                }
            }
        }
        
        return days;
    }
}