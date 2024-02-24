class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int prev = 1;

        for (int i = 0; i < stations.length; i++) {
            int left = stations[i] - w;           
            answer += (left - prev) / (2 * w + 1);
            
            if ((left - prev) % (2 * w + 1) > 0) {
                answer++;
            }
            prev = stations[i] + w + 1;
        }
        
        answer += (n + 1 - prev) / (2 * w + 1);
        if ((n + 1 - prev) % (2 * w + 1) > 0) {
                answer++;
        }

        return answer;
    }
}