import java.util.*;
class Solution {
    static class Car implements Comparable<Car>{
        String n;
        int t;
        public Car(String n,int t){
            this.n = n;
            this.t =t;
        }
        
        @Override
        public int compareTo(Car o){
            return this.n.compareTo(o.n);
        }
    }
    public int[] solution(int[] fees, String[] records) {

        Map<String,String> map = new HashMap<>();
        List<Car> list = new LinkedList<>();
        
        for(int i=0;i<records.length;i++){
            StringTokenizer st = new StringTokenizer(records[i]);
            String time = st.nextToken();
            String car = st.nextToken();
            String info = st.nextToken();
            if(info.equals("OUT")){
                boolean check = false;
                String inTime = map.get(car);
                map.remove(car);
                st = new StringTokenizer(inTime,":");
                int in = Integer.parseInt(st.nextToken())*60+Integer.parseInt(st.nextToken());
                st = new StringTokenizer(time,":");
                int out = Integer.parseInt(st.nextToken())*60+Integer.parseInt(st.nextToken());
                int result = out - in;
                
                for(Car c:list){
                    if(c.n.equals(car)){
                        c.t += result;
                        check = true;
                    }
                }
                if(!check)
                    list.add(new Car(car,result));
            
                continue;
            }
            map.put(car,time); 
        }
        
        for(Map.Entry<String, String> m:map.entrySet()){    
            boolean check = false;
            String inTime = m.getValue();
            StringTokenizer st = new StringTokenizer(inTime,":");
            int in = Integer.parseInt(st.nextToken())*60+Integer.parseInt(st.nextToken());
            int out = 23*60+59;
            int result = out - in;
               
            for(Car c:list){
                if(c.n.equals(m.getKey())){
                    c.t += result;
                    check = true;
                }
            }
            if(!check)
                list.add(new Car(m.getKey(),result)); 
    }

        Collections.sort(list);
        int[] answer = new int[list.size()];
        int i=0;
        for(Car c:list){
            if(c.t <= fees[0]){
                c.t = fees[1];
            }
            else{
                c.t = (c.t-fees[0]) % fees[2]==0 ? (c.t-fees[0])/fees[2]*fees[3]+fees[1] : ((c.t-fees[0])/fees[2]+1)*fees[3]+fees[1];
            }
            answer[i++]=c.t;
        }
        return answer;
    }
}