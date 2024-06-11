import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String message = br.readLine();
        String key = br.readLine();
        String ans="";
        char[][] arr= new char[5][5];
        int r=0;
        int c=0;
        HashMap<Character,String> map = new HashMap<>();
        for(int i=0;i<key.length();i++){
            if(map.containsKey(key.charAt(i))){
                continue;
            }
            arr[r][c] = key.charAt(i);
            map.put(key.charAt(i),Integer.toString(r)+" "+Integer.toString(c));
            c++;
            if(c==5){
                r++;
                c=0;
            }
        }

        for(int i=0;i<26;i++){
            if((char)('A'+i)=='J'||map.containsKey((char)('A'+i))){
                continue;
            }
            arr[r][c] = (char)('A'+i);
            map.put(arr[r][c],Integer.toString(r)+" "+Integer.toString(c));
            c++;
            if(c==5){
                r++;
                c=0;
            }
        }


        for(int i=0;i<message.length();i+=2){
            char c1 = message.charAt(i);
            char c2 ='X';
            if(i < message.length()-1){
                c2 = message.charAt(i+1);
            }
            
            if(c1 == c2 && i < message.length()-1){
                if(c1=='X'){
                    c2 = 'Q';
                }
                else{
                    c2 = 'X';
                }
                i--;
            }

            StringTokenizer st = new StringTokenizer(map.get(c1));
            int row1= Integer.parseInt(st.nextToken());
            int col1 = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(map.get(c2));
            int row2 = Integer.parseInt(st.nextToken());
            int col2 = Integer.parseInt(st.nextToken());

            if(row1 == row2){//같은 행에 존재 한다면
                ans += arr[row1][(col1+1)%5];
                ans += arr[row2][(col2+1)%5];
            }
            else if(col1 == col2){//같은 열에 존재 한다면
                ans += arr[(row1+1)%5][col1];
                ans += arr[(row2+1)%5][col2];
            }
            else{
                ans += arr[row1][col2];
                ans += arr[row2][col1];
            }
            
        }
        System.out.println(ans);
    }
}
