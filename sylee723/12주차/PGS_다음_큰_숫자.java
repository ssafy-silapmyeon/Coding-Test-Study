class Solution {
    public int solution(int n) {
        int cnt = count1(n);
        
        int answer = n + 1;
        while (true) {
            if (cnt == count1(answer)) {
                break;
            }
            
            answer++;
        }

        return answer;
    }
    
    static int count1(int n) {
        int cnt = 0;
        while (n > 0) {
            if (n % 2 == 1) {
                cnt++;
            }
            n /= 2;
        }
        
        return cnt;
    }
}