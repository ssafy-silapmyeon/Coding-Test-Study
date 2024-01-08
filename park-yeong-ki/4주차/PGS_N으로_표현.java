import java.util.*;

class PGS_N으로_표현 {
    public int solution(int N, int number) {
        Set<Integer>[] dp = new Set[9];
        for(int i=1; i<=8; i++){
            dp[i] = new HashSet<>();
        }

        StringBuilder sb = new StringBuilder();
        int ans = -1;
        List<Integer> temp1, temp2;
        for(int i=1; i<=8; i++){
            dp[i].add(0);
            for(int j=1; j<=i-1; j++){
                temp1 = new ArrayList<>(dp[i-j]);
                temp2 = new ArrayList<>(dp[j]);
                for(int k=0; k<temp1.size(); k++){
                    for(int l=0; l<temp2.size(); l++){
                        dp[i].add(temp1.get(k) + temp2.get(l));
                        dp[i].add(temp1.get(k) - temp2.get(l));
                        dp[i].add(temp1.get(k) * temp2.get(l));
                        dp[i].add(temp1.get(k) / temp2.get(l));
                    }
                }
            }
            dp[i].remove(0);

            sb.append(N);
            dp[i].add(Integer.valueOf(sb.toString()));

            if(dp[i].contains(number)){
                ans = i;
                break;
            }
        }

        return ans;
    }

}