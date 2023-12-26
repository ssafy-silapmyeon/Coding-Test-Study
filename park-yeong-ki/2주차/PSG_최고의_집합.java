import java.util.*;

class PSG_최고의_집합 {
    public int[] solution(int n, int s) {
        int init = s / n;
        int remain = s % n;

        if(init == 0) return new int[]{-1};

        int[] ans = new int[n];
        Arrays.fill(ans, init);

        int size = n-1;
        while(remain-- > 0){
            ans[size--]++;
        }

        return ans;
    }
}