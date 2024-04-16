import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        Queue<String> queue = new LinkedList<>();
        HashMap<String,Integer> map = new HashMap();
        
        for(int i=0;i<cities.length;i++){
            boolean check = false;
            for(Map.Entry<String,Integer> entrymap : map.entrySet()){
                if(entrymap.getKey().equalsIgnoreCase(cities[i])){//캐시에 존재
                    queue.offer(cities[i]);
                    int n = map.get(entrymap.getKey());
                    map.put(entrymap.getKey(),n+1);
                    answer +=1;
                    check = true;
                    break;
                }
            }
            if(!check){//캐시에 존재 하지 않음
                if(cacheSize !=0 && map.size() == cacheSize){
                    String s = "";
                    int n = 100000;
                    while(n>1){
                        s = queue.poll();
                        for(Map.Entry<String,Integer> entrymap : map.entrySet()){
                            if(entrymap.getKey().equalsIgnoreCase(s)){
                                n = map.get(entrymap.getKey());
                                if(n==1){
                                    map.remove(entrymap.getKey());
                                }
                                else{
                                    map.put(entrymap.getKey(),n-1);
                                }
                                break;
                            }
                        }
                    }
                }
                
                if(cacheSize !=0){
                    map.put(cities[i],1);
                    queue.offer(cities[i]);
                }
                answer +=5;
                
            }
        }
        return answer;
    }
}