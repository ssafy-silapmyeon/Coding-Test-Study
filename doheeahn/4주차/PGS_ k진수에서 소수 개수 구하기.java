import java.util.*;
class Solution {
    static StringBuilder sb = new StringBuilder();
    public int solution(int n, int k) {
        int answer = 0;
        change(n,k);
        int s=0;
        for(int i=0;i<sb.length();i++){
            if(sb.charAt(i)=='0'){
                answer += check(s,i);
                s=i+1;
            }
        }
        answer += check(s,sb.length());
        return answer;
    }
    
    public void change(int n, int k){
        if(n==0){
            return;
        }
        change(n/k,k);
        sb.append(n%k);
    }
    
    public int check(int s,int e){
        long num =0;
        for(int i=s;i<e;i++){
            num= num*10 + sb.charAt(i)-'0';
        }
        if(num ==1 || num ==0){
            return 0;
        }
        for(int i=2;i<=Math.sqrt(num);i++){
            if(num%i==0){
                return 0;
            }
        }
        return 1;
        
    }
}