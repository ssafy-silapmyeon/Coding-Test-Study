import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        boolean[] visited = new boolean[words.length];
        Queue<String> queue = new ArrayDeque<>();
        queue.add(begin);
        
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            for (int s = 0; s < size; s++) {
                String now = queue.poll();
                if (now.equals(target)) {
                    return step;
                }
                
                for (int i = 0; i < words.length; i++) {
                    if (visited[i])
                        continue;
                    
                    int count = 0;
                    for (int j = 0; j < now.length(); j++) {
                        if (now.charAt(j) != words[i].charAt(j)) {
                            count++;
                        }
                    }
                    
                    if (count == 1) {
                        visited[i] = true;
                        queue.add(words[i]);
                    }
                }
            }
            step++;
        }
        
        return 0;
    }
}