import java.util.*;
class Solution {
    static class Tangerines{
        int size,num;
        
        public Tangerines(int size, int num){
            this.size = size;
            this.num = num;
        }
        
    }
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        int[] arr = new int[10000001];
        PriorityQueue<Tangerines> pq = new PriorityQueue<>(new Comparator<Tangerines>(){
            
            @Override
            public int compare(Tangerines o1,Tangerines o2){
                return o2.num - o1.num;
            }
            
        });
        
        for(int i=0;i<tangerine.length;i++){
            arr[tangerine[i]]++;
        }
        for(int i=1;i<=10000000;i++){
            if(arr[i]!=0){
                pq.offer(new Tangerines(i,arr[i]));
            }
        }

        while(k>0){
            answer++;
            k -= pq.poll().num;
            
        }
        
        return answer;
    }
}