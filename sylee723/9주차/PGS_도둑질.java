class Solution {
    public int solution(int[] money) {
        int[] d1 = new int[money.length];
        int[] d2 = new int[money.length];
        
        int last = money.length - 1;
        d1[0] = money[0];
        d1[1] = Math.max(d1[0], money[1]);
        for (int i = 2; i <= last - 1; i++) {
            d1[i] = Math.max(d1[i - 1], d1[i - 2] + money[i]);
        }
        
        d2[0] = 0;
        d2[1] = money[1];
        for (int i = 2; i <= last; i++) {
            d2[i] = Math.max(d2[i - 1], d2[i - 2] + money[i]);
        }
        
        int answer = Math.max(d1[last - 1], d2[last]);
        return answer;
    }
}