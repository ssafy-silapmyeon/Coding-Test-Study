import java.io.*;
import java.util.*;

public class Main {
    static class CAR{
        int idx,time;
        char dir;
        CAR(int idx,int time,char dir){
            this.idx = idx;
            this.time = time;
            this.dir = dir;
        }
    }
    static int[] dir = new int[4];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        CAR[] arr = new CAR[n];
        int[] result = new int[n];
        
        for(int i=0;i<n;i++){
            result[i]=-1;
        }
        
        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            char dir = st.nextToken().charAt(0);
            arr[i] = new CAR(i,time,dir);
        }
        Arrays.sort(arr,(o1,o2)-> o1.time-o2.time);
        LinkedList<CAR> list = new LinkedList<>(); //시간별로 차 나열

        int idx =0;
        int t=0;
        while(idx <n || ((list.size() !=0)&& (dir[0]==0 || dir[1]==0 || dir[2]==0 || dir[3]==0))){
            if(list.size()==0){
                t = arr[idx].time;
            }
            else{
                t++;
            }
            while(idx <n && arr[idx].time == t){
                list.add(arr[idx]);
                check(arr[idx]);
                idx++;
            }
            go(list,t,result);
            
            if(dir[0]!=0 && dir[1]!=0 && dir[2]!=0 && dir[3]!=0){//교착상태
                break;
            }
        } 

        for(int i=0;i<n;i++){
            System.out.println(result[i]);
        }
    }

    static public void go(LinkedList<CAR> list,int t,int[] result){
        int[] d = new int[4];
        boolean[] visited = new boolean[4];
        LinkedList<CAR> rem = new LinkedList<>();
        for(CAR car:list){
            if(dir[(car.dir-'A'+3)%4]==0 && !visited[car.dir-'A']){//오른쪽 확인
                result[car.idx] = t;
                d[car.dir-'A']++;
                visited[car.dir-'A'] = true;
                rem.add(car);
            }
        }
        list.removeAll(rem);
        for(int i=0;i<4;i++){
            dir[i] -= d[i];
        }
    }
    static public void check(CAR car){
        if(car.dir =='A'){
            dir[0]++;
        }
        else if(car.dir =='B'){
            dir[1]++;
        }    
        else if(car.dir =='C'){
            dir[2]++;
        }
        else{
            dir[3]++;
        }
    }
}
