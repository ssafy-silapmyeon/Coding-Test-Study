class Solution {
    public int[] solution(int n, int s) {
        if (n > s) {
            return new int[] {-1};
        }
        
        int[] answer = new int[n];
        int value = s / n;
        for (int i = 0; i < n; i++) {
            answer[i] = value;
        }
        
        int remain = s % n;
        for (int i = n - 1; i >= 0; i--) {
            if (remain <= 0) {
                break;
            }
            
            answer[i]++;
            remain--;
        }
        
        return answer;
    }
}