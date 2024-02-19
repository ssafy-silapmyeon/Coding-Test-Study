class Solution {
    public int solution(int n) {
        int answer = 0;

        int num = 0;
        for (int i = 1 ; ; i++) {
            num += i;
            if (n - num < 0)
                break;
            
            if ((n - num) % i == 0) {
                answer++;
            }
        }
        return answer;
    }
}