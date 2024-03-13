import java.util.*;

class Solution {
    static int answer;
    public int solution(int storey) {
        answer = storey;
        
        // 1의 자리부터 0으로 만들기
        bfs(storey);
        return answer;
    }
    
    static void bfs(int start) {
        Map<Integer, Integer> visited = new HashMap<>();
        Queue<Elevator> queue = new ArrayDeque<>();
        
        visited.put(start, 0);
        queue.add(new Elevator(start, 0, 1));
        
        while (!queue.isEmpty()) {
            Elevator now = queue.poll();
            if (now.floor == 0) {
                answer = Math.min(answer, now.count);
                continue;
            }
                        
            int remain = now.floor % (now.digit * 10);
            if (remain == 0) {
                queue.add(new Elevator(now.floor, now.count, now.digit * 10));
                continue;
            }
            
            int down = now.floor - remain;
            int dCnt = now.count + remain / now.digit;
            if ((!visited.containsKey(down) || visited.get(down) > dCnt) && dCnt <= answer) {
                visited.put(down, dCnt);
                queue.add(new Elevator(down, dCnt, now.digit * 10));
            }
            
            int up = now.floor + (now.digit * 10 - remain);
            int uCnt = now.count + (up - now.floor) / now.digit;
            if ((!visited.containsKey(up) || visited.get(up) > uCnt) && uCnt <= answer) {
                visited.put(up, uCnt);
                queue.add(new Elevator(up, uCnt, now.digit * 10));
            }
        }
    }
    
    static class Elevator {
        int floor, count, digit;
        
        public Elevator(int floor, int count, int digit) {
            this.floor = floor;
            this.count = count;
            this.digit = digit;
        }
    }
}