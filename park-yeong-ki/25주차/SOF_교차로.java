import java.io.*;
import java.util.*;

public class Main {
    static Deque<Car>[] roads;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        roads = new Deque[4];
        for(int i=0; i<4; i++){
            roads[i] = new ArrayDeque<>();
        }
        
        StringTokenizer st;
        int t;
        char w;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            t = Integer.parseInt(st.nextToken());
            w = st.nextToken().charAt(0);
            roads[w-'A'].addLast(new Car(t, i));
        }

        int[] ans = new int[N];
        Arrays.fill(ans, -1);
        
        Car[] cars = new Car[4];
        while(true){
            int minTime = Integer.MAX_VALUE;
            for(Deque<Car> deque : roads){
                if(!deque.isEmpty()){
                    minTime = Math.min(minTime, deque.peek().time);
                }
            }

            if(minTime == Integer.MAX_VALUE) break;

            for(int i=0; i<roads.length; i++){
                if(!roads[i].isEmpty() && roads[i].peek().time == minTime){
                    cars[i] = roads[i].poll();
                }else{
                    cars[i] = null;
                }
            }

            int cnt = 0;
            for(int i=0; i<4; i++){
                if(cars[i] != null && cars[i-1 == -1 ? 3 : i-1] == null){
                    if(!roads[i].isEmpty()){
                        roads[i].peek().time = Math.max(cars[i].time + 1, roads[i].peek().time);
                    }
                    ans[cars[i].idx] = cars[i].time;
                } else if(cars[i] != null && cars[i-1 == -1 ? 3 : i-1] != null){
                    cars[i].time++;
                    roads[i].addFirst(cars[i]);    
                    cnt++;
                } 
            }

            if(cnt == 4) break;
        }

        for(int i=0; i<N; i++){
            bw.write(ans[i] + "\n");
        }

        bw.close();
    }

    static class Car{
        int time, idx;

        Car(int time, int idx){
            this.time = time;
            this.idx = idx;
        }

        @Override
        public String toString(){
            return "time = " + time + " idx = " + idx;
        }
    }
}
