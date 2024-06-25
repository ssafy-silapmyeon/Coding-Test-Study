import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int N = 1 << (H+1);
        
        Queue<Long>[][] employees = new Queue[N][2]; //왼쪽, 오른쪽 업무를 입력할 직원수만큼의 큐 생성
        for(int i=1; i<N; i++){
            employees[i][0] = new ArrayDeque<>();
            employees[i][1] = new ArrayDeque<>();
        }

        for(int i = 1<<H; i < 1<<(H+1); i++){ //말단 직원 업무 입력
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<K; j++){
                employees[i][0].add(Long.parseLong(st.nextToken()));
            }
        }
        
        long ans = 0;
        for(int i=1; i<=R; i++){
            int start = 0;
            int num = i % 2;
            while(start <= H){
                
                if(start == H){
                    num = 0;
                }
                
                for(int j = 1<<start; j < 1<<(start+1); j++){
                    if(start == 0 && !employees[j][num].isEmpty()){
                        ans += employees[j][num].poll();    
                    }else if(!employees[j][num].isEmpty()) {
                        long work = employees[j][num].poll();
                        int parent = j/2;
                        int pos = j%2 == 0 ? 1 : 0; //왼쪽 자식 노드인 경우 1, 오른쪽 자식 노드인 경우 0로 반대 표시
                        employees[parent][pos].add(work);
                    }
                }
                
                start++;
            }
        }

        System.out.println(ans);
    }
}
