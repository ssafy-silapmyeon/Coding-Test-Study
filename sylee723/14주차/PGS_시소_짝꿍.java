class Solution {
    public long solution(int[] weights) {
        int[] count = new int[1001];
        for (int i = 0; i < weights.length; i++) {
            count[weights[i]]++;
        }
        
        long answer = 0;
        for (int i = 100; i <= 1000; i++) {
            if (count[i] == 0) {
                continue;
            }
            
            if (count[i] >= 2) {
                answer += (long)count[i] * (count[i] - 1) / 2;
            }
            
            if (i % 2 == 0 && 3 * i / 2 <= 1000) {
                answer += (long)count[i] * count[3 * i / 2];
            }
            
            if (i % 3 == 0 && 4 * i / 3 <= 1000) {
                answer += (long)count[i] * count[4 * i / 3];
            }
            
            if (2 * i <= 1000) {
                answer += (long)count[i] * count[2 * i];
            }
        }
        
        return answer;
    }
}