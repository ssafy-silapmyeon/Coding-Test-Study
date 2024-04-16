import java.util.*;

class Solution {
    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];
        
        for (int i = 0; i < numbers.length; i++) {
            String b = toBinary(numbers[i]);
            
            char[] tree = new char[b.length() + 1];
            makeTree(tree, 1, b);
            
            if (isAvailable(tree)) {
                answer[i] = 1;
            } else {
                answer[i] = 0;
            }
        }
        
        return answer;
    }
    
    static String toBinary(long num) {
        String b = "";
        while (num > 0) {
            b = (num % 2) + b;
            num /= 2;
        }
        
        int len = 0;
        int pow = 1;
        while (len < b.length()) {
            len += pow;
            pow *= 2;
        }
        
        String zero = "";
        for (int l = 0; l < len - b.length(); l++) {
            zero += '0';
        }
        
        return zero + b;
    }
    
    static void makeTree(char[] tree, int idx, String b) {
        if (idx >= tree.length) {
            return;
        }
        
        int mid = b.length() / 2;
        tree[idx] = b.charAt(mid);

        makeTree(tree, idx * 2, b.substring(0, mid)); // left
        makeTree(tree, idx * 2 + 1, b.substring(mid + 1)); // right
    }
    
    static boolean isAvailable(char[] tree) {
        boolean[] visited = new boolean[tree.length];
        Queue<Integer> queue = new ArrayDeque<>();
        
        if (tree[1] == '1') { // root
            visited[1] = true;
            queue.add(1);
        }
        
        while (!queue.isEmpty()) {
            int now = queue.poll();
            
            if (now * 2 < tree.length && tree[now * 2] == '1') {
                visited[now * 2] = true;
                queue.add(now * 2);
            }
            if (now * 2 + 1 < tree.length && tree[now * 2 + 1] == '1') {
                visited[now * 2 + 1] = true;
                queue.add(now * 2 + 1);
            }
        }
        
        for (int i = 0; i < tree.length; i++) {
            if (tree[i] == '1' && !visited[i]) {
                return false;
            }
        }
        
        return true;
    }
}