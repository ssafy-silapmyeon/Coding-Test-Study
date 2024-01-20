import java.util.*;
class Solution {
    public int[] solution(int[] sequence, int k) {
        int dis = Integer.MAX_VALUE;
        int[] answer = new int[2];
        int len = sequence.length;
        long[] arr = new long[len];
        Map<Long,Integer> map = new HashMap<>();
        //연속된 구간의 합과 k의 차이 구하기
        for(int i=0;i<len;i++){
            if(i==0){
                arr[i]=sequence[i]-k;
            }
            else{
                arr[i] = arr[i-1]+sequence[i];
            }
            
            map.put(arr[i],i);
            if(arr[i]==0){
                dis = i+1;
                answer[0] = 0;
                answer[1] =i;
            }
        }
        
        for(int i=0;i<len;i++){
            if(map.get(arr[i]-k)!=null && dis>i-map.get(arr[i]-k)){
                int dis1 = map.get(arr[i]-k);
                if(dis == i-dis1 && answer[0]<dis1+1){
                    continue;
                }
                answer[0]=dis1+1;
                answer[1]=i;
                dis = i-dis1;
            }
            if(map.get(arr[i]+k)!=null && dis>map.get(arr[i]+k)-i){
                int dis2 = map.get(arr[i]+k);
                if(dis == dis2-i && answer[0]>i+1){
                    continue;
                }
                answer[0] = i+1;
                answer[1] = dis2;
                dis = dis2-i;
            }
        }
        
        return answer;
    }
}