import java.util.*;
class Solution {
    String[] cell = new String[2501];
    int[] parent = new int[2501];
    public String[] solution(String[] commands) {
        String[] answer;
        LinkedList<String> result = new LinkedList<>();
        for(int i=1;i<=2500;i++){
            cell[i] = "";
            parent[i] = i;
        }
        
        for(int i=0;i<commands.length;i++){
            String s = commands[i];
            StringTokenizer st = new StringTokenizer(s);
            String com = st.nextToken();
            
            if(com.equals("UPDATE")){
                if(st.countTokens()==3){
                    int r = Integer.parseInt(st.nextToken());
                    int c = Integer.parseInt(st.nextToken());
                    String v = st.nextToken();
                    int idx = find(r-1,c);
                    cell[idx] = v;
                }
                else{
                    String v1 = st.nextToken();
                    String v2 = st.nextToken();
                    for(int j=1;j<=2500;j++){
                        if(cell[j].equals(v1)){
                            cell[j] = v2;
                        }
                        
                    }
                }

            }
            else if(com.equals("MERGE")){
                int r1 = Integer.parseInt(st.nextToken());
                int c1 = Integer.parseInt(st.nextToken());
                int r2 = Integer.parseInt(st.nextToken());
                int c2 = Integer.parseInt(st.nextToken());
                union(r1-1,c1,r2-1,c2);
            }
            else if(com.equals("UNMERGE")){
                int r = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                unmerge(r-1,c);
            }
            else{//print
                int r = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                String p = print(r-1,c);
                if(p.equals("")){
                    p = "EMPTY";
                }
                result.add(p);
            }
        }
        answer = new String[result.size()];
        int i=0;
        for(String s: result){
            answer[i] = s;
            i++;
        }
        
        return answer;
    }
    public String print(int r, int c){
        int p = find(r,c);
        return cell[p];
    }
    public void unmerge(int r, int c){
        int p = find(r,c);
        String s = cell[p];
        LinkedList<Integer> list = new LinkedList<>();
        for(int i=0;i<50;i++){
            for(int j=1;j<=50;j++){
                if(p == find(i,j)){
                    int idx = i*50 +j;
                    list.add(idx);
                } 
            }
        }
        for(int idx:list){
            parent[idx] = idx;
            cell[idx] = "";
        }
        int idx = r*50 +c;
        cell[idx]= s;
    }
    public void union(int r1, int c1, int r2, int c2){
        int p1 = find(r1,c1);
        int p2 = find(r2,c2);
        String s1 = cell[p1];
        String s2 = cell[p2];
        if(s1.length()==0 && s2.length()!=0){
            parent[p1] = p2;
        }
        else{
            parent[p2] = p1;
        }
    }
    public int find(int r, int c){
        int idx = (r*50)+c;
        if(parent[idx] != idx){
            int f = find(parent[idx]/50, parent[idx]%50);
            parent[idx] = f;
            return f;
        }
        else{
            return idx;
        }
    }
}