import java.util.*;

class Solution {
    static String[] sArr;
    static Map<String, Integer> menuMap;
    static int[] maxCustomer;
    public String[] solution(String[] orders, int[] course) {
        sArr = new String[orders.length];
        menuMap = new HashMap<>();
        maxCustomer = new int[11];
        
        char[] cArr;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<orders.length; i++){
            cArr = orders[i].toCharArray();
            Arrays.sort(cArr);
            
            for(int j=0; j<cArr.length; j++){
                sb.append(cArr[j]);
            }
            
            sArr[i] = sb.toString();
            sb.setLength(0);
        }
        
        for(int i=0; i<sArr.length; i++){
            comb(0, i, "");
        }
        
        List<String> ans = new ArrayList<>();
        for(int i=0; i<course.length; i++){
            int cnt = course[i];
            for(String menu : menuMap.keySet()){
                if(cnt == menu.length() && maxCustomer[cnt] >= 2 && maxCustomer[cnt] == menuMap.get(menu)){
                    ans.add(menu);
                }
            }
        }
        
        Collections.sort(ans);
        
        return ans.toArray(new String[0]);
    }
    
    static void comb(int start, int idx, String menu){
        if(menu.length() >= 2) {
            menuMap.put(menu, menuMap.getOrDefault(menu, 0) + 1);
            maxCustomer[menu.length()] = Math.max(maxCustomer[menu.length()], menuMap.get(menu));
        }
        
        for(int i=start; i<sArr[idx].length(); i++){
            comb(i+1, idx, menu + sArr[idx].charAt(i));
        }
    }
}
