import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<String, Car> map = new HashMap<>();
        for (int i = 0; i < records.length; i++) {
            String[] data = records[i].split(" ");
           
            if (data[2].equals("IN")) {
                if (map.containsKey(data[1])) {
                    Car car = map.get(data[1]);
                    car.setIn(data[0]);
                    map.put(data[1], car);
                } else {
                    map.put(data[1], new Car(data[0]));
                }
            } else {
                Car car = map.get(data[1]);
                car.setOut(data[0]);
                map.put(data[1], car);
            }
        }
        
        List<String> keySet = new ArrayList<>(map.keySet());
        Collections.sort(keySet);
        
        int[] answer = new int[map.size()];
        for (int i = 0; i < keySet.size(); i++) {
            Car car = map.get(keySet.get(i));
            int time = car.getTime();
            answer[i] = fees[1];
            
            if (time > fees[0]) {
                int overtime = (time - fees[0]) / fees[2];
                if ((time - fees[0]) % fees[2] != 0) {
                    overtime += 1;
                }
                answer[i] += overtime * fees[3]; 
            }
        }
        
        return answer;
    }
    
    static class Car {
        int in, out, time;
        
        public Car(String in) {
            String h = in.split(":")[0];
            String m = in.split(":")[1];
            this.in = Integer.parseInt(h) * 60 + Integer.parseInt(m);
            this.out = 23 * 60 + 59;
            this.time = 0;
        }
        
        public void setIn(String in) {
            this.time += this.out - this.in;
            
            String h = in.split(":")[0];
            String m = in.split(":")[1];
            this.in = Integer.parseInt(h) * 60 + Integer.parseInt(m);
            this.out = 23 * 60 + 59;
        }
        
        public void setOut(String out) {
            String h = out.split(":")[0];
            String m = out.split(":")[1];
            this.out = Integer.parseInt(h) * 60 + Integer.parseInt(m);
        }
        
        public int getTime() {
            return (this.out - this.in) + this.time;
        }
    }
}