import java.util.*;

class Solution {
    static Map<Character, Integer> map = new HashMap<>();
    static char[] person = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    static boolean[] visited = new boolean[person.length];
    static int answer;
    static String[] sData;
    
    public int solution(int n, String[] data) {
        sData = data;
        answer = 0;
        perm(0);
        return answer;
    }
    
    static void perm(int idx){
        if(idx == person.length){
            int d1, d2;
            char opr;
            for(String cond : sData){
                d1 = Math.abs(map.get(cond.charAt(0)) - map.get(cond.charAt(2))) - 1;
                d2 = cond.charAt(4) - '0';
                opr = cond.charAt(3);
                if(opr == '=' && d1 != d2) return;
                else if(opr == '>' && d1 <= d2) return;
                else if(opr == '<' && d1 >= d2) return;
            }
            
            answer++;
            return;
        }
        
        for(int i=0; i<person.length; i++){
            if(visited[i]) continue;
            map.put(person[i], idx);
            visited[i] = true;
            perm(idx+1);
            visited[i] = false;
        }
    }
}
