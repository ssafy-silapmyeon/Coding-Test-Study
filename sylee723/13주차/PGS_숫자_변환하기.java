import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        Queue<Integer> queue = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();
        
        queue.add(y);
        visited.add(y);
        
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int s = 0; s < size; s++) {
                int now = queue.poll();
                if (now == x) {
                    return count;
                }
                
                if (now - n >= x && !visited.contains(now - n)) {
                    visited.add(now - n);
                    queue.add(now - n);
                }
                
                if (now % 2 == 0 && now / 2 >= x && !visited.contains(now / 2)) {
                    visited.add(now / 2);
                    queue.add(now / 2);
                }
                
                if (now % 3 == 0 && now / 3 >= x && !visited.contains(now / 3)) {
                    visited.add(now / 3);
                    queue.add(now / 3);
                }
            }
            count++;
        }
        
        return -1;
    }
}