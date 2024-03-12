import java.util.*;

class Solution {
    static long ans;
    static char[] oArr;
    static boolean[] visited;
    public long solution(String expression) {
        Set<Character> set = new HashSet<>();
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<expression.length(); i++){
            if(expression.charAt(i) < '0' || expression.charAt(i) > '9'){
                set.add(expression.charAt(i));
                
                list.add(sb.toString());
                sb.setLength(0);
    
                list.add(expression.charAt(i) + "");
            }else{
                sb.append(expression.charAt(i));
            }
        }
        list.add(sb.toString());
        sb.setLength(0);
        
        oArr = new char[set.size()];
        int size = 0;
        for(char o : set){
            oArr[size++] = o;
        }
        
        visited = new boolean[oArr.length];
        ans = 0;
        perm(0, list);
        
        return ans;
    }
    
    static void perm(int idx, List<String> sList){
        if(idx == oArr.length){
            ans = Math.max(ans, Math.abs(Long.parseLong(sList.get(0))));
            return;
        }
        
        for(int i=0; i<oArr.length; i++){
            if(visited[i]) continue;
            visited[i] = true;
            perm(idx+1, calculate(sList, oArr[i]));
            visited[i] = false;
        }
    }
    
    static List<String> calculate(List<String> sList, char o){
        List<String> nList = new ArrayList<>();
        
        switch(o){
            case '+':
                for(int i=0; i<sList.size(); i++){
                    if(sList.get(i).equals("+")){
                        long prev = Long.parseLong(nList.get(nList.size()-1));
                        long next = Long.parseLong(sList.get(i+1));
                        nList.set(nList.size()-1, String.valueOf(prev+next));
                        i++;
                    }else{
                        nList.add(sList.get(i));
                    }
                }
                break;
            case '-':
                for(int i=0; i<sList.size(); i++){
                    if(sList.get(i).equals("-")){
                        long prev = Long.parseLong(nList.get(nList.size()-1));
                        long next = Long.parseLong(sList.get(i+1));
                        nList.set(nList.size()-1, String.valueOf(prev-next));
                        i++;
                    }else{
                        nList.add(sList.get(i));
                    }
                }
                break;
            case '*':
                for(int i=0; i<sList.size(); i++){
                    if(sList.get(i).equals("*")){
                        long prev = Long.parseLong(nList.get(nList.size()-1));
                        long next = Long.parseLong(sList.get(i+1));
                        nList.set(nList.size()-1, String.valueOf(prev*next));
                        i++;
                    }else{
                        nList.add(sList.get(i));
                    }
                }
                break;
        }
        
        return nList;
    }
}
