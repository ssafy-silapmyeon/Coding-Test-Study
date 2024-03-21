class Solution {
    static boolean[] selected;
    static long remain;
    
    public int[] solution(int n, long k) {
        selected = new boolean[n + 1];
        int[] answer = new int[n];
        remain = k;
        
        for (int i = 0; i < n; i++) {
            answer[i] = findNum(i, n - i);
        }
        
        return answer;
    }
    
    static int findNum(int idx, int n) {
        long fact = 1;
        for (int i = 1; i < n; i++) {
            fact *= i;
        }
        
        int order = 1;
        while (remain > fact) {
            remain -= fact;
            order++;
        }

        for (int i = 1; i < selected.length; i++) {
            if (!selected[i]) {
                order--;
            }
            
            if (order == 0) {
                selected[i] = true;
                return i;
            }
        }

        return -1;
    }
}