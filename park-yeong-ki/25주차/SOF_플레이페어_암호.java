import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder msg = new StringBuilder(sc.next());
        String key = sc.next();

        Map<Character, Integer> map = new HashMap<>();
        char[] arr = new char[25];
        int idx = 0;
        for(int i=0; i<key.length(); i++){
            if(map.containsKey(key.charAt(i))) continue; 
            map.put(key.charAt(i), idx);
            arr[idx++] = key.charAt(i);
        }

        char ch;
        for(int i=65; i<=90; i++){
            ch = (char)i;
            if('J' == ch || map.containsKey(ch)) continue; 
            map.put(ch, idx);
            arr[idx++] = ch;
        }
        
        for(int i=0; i<msg.length(); i+=2){
            if(i+1 < msg.length() && msg.charAt(i) == msg.charAt(i+1)){
                if(msg.charAt(i) == 'X'){
                    msg.insert(i+1, 'Q');
                }else{
                    msg.insert(i+1, 'X');
                }
            }
        }
        
        if(msg.length() % 2 == 1){
            msg.append('X');
        }

        StringBuilder ans = new StringBuilder();
        int r1, c1, r2, c2, temp;
        for(int i=0; i<msg.length(); i+=2){
            r1 = map.get(msg.charAt(i)) / 5;
            c1 = map.get(msg.charAt(i)) % 5;
            r2 = map.get(msg.charAt(i+1)) / 5;
            c2 = map.get(msg.charAt(i+1)) % 5;

            if(r1 == r2){
                c1 = c1 + 1 == 5 ? 0 : c1 + 1;
                c2 = c2 + 1 == 5 ? 0 : c2 + 1;
            } else if(c1 == c2){
                r1 = r1 + 1 == 5 ? 0 : r1 + 1;
                r2 = r2 + 1 == 5 ? 0 : r2 + 1;
            } else{
                temp = c1;
                c1 = c2;
                c2 = temp;
            }
            ans.append(arr[r1 * 5 + c1]).append(arr[r2 * 5 + c2]);
        }

        System.out.println(ans);
    }
}
