import java.util.*;
class Solution {
    static int ans=0;
    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];
        for(int i=0;i<numbers.length;i++){
            ans =1;
            String num = Long.toBinaryString(numbers[i]);
            num = perfectBinary(num,num.length());//완전 이진 트리
            check(num,num.length()/2); //루트 노드
            answer[i] = ans;
        }
        return answer;
    }
    public void check(String num,int idx){
        
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(idx);
        while(true){
            int size = queue.size();
            int n = queue.peek()-(queue.peek()/2);
            for(int i=0;i<size;i++){
                int cur = queue.poll();
                if(cur ==0){
                    return;
                }
                int next1 = cur -n;
                int next2 = cur+n;
                if(num.charAt(cur)=='0' && (num.charAt(next1)=='1' || num.charAt(next2)=='1')){
                    ans =0;
                    return;
                }
                queue.offer(next1);
                queue.offer(next2);
            }
        }

    }
    
    public String perfectBinary(String num,int l){
        int cnt =0;
        int p = (int)Math.pow(2,cnt);
        while(l > p){
            l -= p;
            cnt ++;
            p=(int) Math.pow(2,cnt);
        }
        for(int i=0;i<p-l;i++){
            num = "0"+num;
        }
        
       return num; 
    }
}