import java.util.*;
class Solution {
    static Set<Integer> set = new HashSet<Integer>();
    public int solution(String numbers) {
        int answer = 0;
        int[] num = new int[numbers.length()];
        int[] visited = new int[numbers.length()];
        
        for(int i=0;i<numbers.length();i++){
            num[i] = numbers.charAt(i)-'0';
        }
        
        for(int i=0;i<num.length;i++){
            visited[i]=1;
            perm(num[i],num,visited,1);
            visited[i]=0;
            
        }
        answer = set.size();
        return answer;
    }
    //순열
    public void perm(int n,int[] num, int[] visited,int cnt){
        if(n==0){
            return;
        }
        check(n);
        if(cnt == num.length){
            return;
        }
        
        for(int i=0;i<num.length;i++){
            if(visited[i]==0){
                visited[i]=1;
                perm(n*10 + num[i],num,visited,cnt+1);
                visited[i]=0;
            }
        }
    }
    public void check(int n){
        if(n==1){
            return;
        }
        for(int i=2;i<=Math.sqrt(n);i++){
            if(n%i==0){//소수 아님
                return;
            }
        }

        set.add(n);
    }
}