import java.util.*;

class PGS_불량_사용자 {
    static String[] ui, bi;
    static List<String> listC, listP;
    static boolean[] visited;

    public int solution(String[] user_id, String[] banned_id) {
        ui = user_id;
        bi = banned_id;
        listC = new ArrayList<>();
        comb(0,0,"");

        listP = new ArrayList<>();
        visited = new boolean[bi.length];
        perm(0,"");

        int ans = 0;
        for(String c : listC){
            for(String p : listP){
                if(isPossible(c, p)){
                    ans++;
                    break;
                }
            }
        }

        return ans;
    }

    static boolean isPossible(String c, String p){
        String s1, s2;
        for(int i=0; i<bi.length; i++){
            s1 = ui[c.charAt(i) - '0'];
            s2 = bi[p.charAt(i) - '0'];

            if(s1.length() != s2.length()) return false;

            for(int j=0; j<s1.length(); j++){
                if(s1.charAt(j) != s2.charAt(j) && s2.charAt(j) != '*'){
                    return false;
                }
            }
        }

        return true;
    }

    static void perm(int idx, String str){
        if(idx == bi.length){
            listP.add(str);
            return;
        }

        for(int i=0; i<bi.length; i++){
            if(visited[i]) continue;
            visited[i] = true;
            perm(idx+1, str+i);
            visited[i] = false;
        }
    }

    static void comb(int start, int cnt, String str){
        if(cnt == bi.length){
            listC.add(str);
            return;
        }

        for(int i=start; i<ui.length; i++){
            comb(i+1, cnt+1, str+i);
        }
    }
}