import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        
        Person[][] persons = new Person[4][N];
        for(int i=0; i<N; i++){
            persons[3][i] = new Person(i, 0);
        }
        
        StringTokenizer st;
        for(int i=0; i<3; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                int score = Integer.parseInt(st.nextToken());
                persons[i][j] = new Person(j, score);
                persons[3][j].score += score;
            }
        }

        for(int i=0; i<4; i++){
            Arrays.sort(persons[i], (p1, p2) -> Integer.compare(p2.score, p1.score));
        }

        int[][] ans = new int[4][N];
        for(int i=0; i<4; i++){
            int rank = 0;
            for(int j=0; j<N; j++){
                int idx = persons[i][j].idx;
                
                if(j == 0 || persons[i][j].score != persons[i][j-1].score){
                    rank = j+1;
                }

                ans[i][idx] = rank;
            }
        }

        for(int i=0; i<4; i++){
            for(int j=0; j<N; j++){
                bw.write(ans[i][j] + " ");
            }
            bw.newLine();
        }

        bw.close();
    }

    static class Person{
        int idx, score;

        Person(int idx, int score){
            this.idx = idx;
            this.score = score;
        }

        @Override
        public String toString(){
            return "idx = " + this.idx + " score = " + this.score;
        }
    }
}
