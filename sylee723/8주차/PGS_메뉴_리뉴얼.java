import java.util.*;

class Solution {
    static Map<String, Integer> menuCnt;
    static boolean[] selected;

    public String[] solution(String[] orders, int[] course) {
        menuCnt = new HashMap<>();
        List<String> result = new ArrayList<>();
        selected = new boolean[26];

        for (int c : course) {
            menuCnt.clear();
            for (String order : orders) {
                for (int i = 0; i < selected.length; i++) {
                    selected[i] = false;
                }
                makeCourse(0, 0, order, c);
            }
            
            int max = 0;
            for (String key : menuCnt.keySet()) {
                max = Math.max(max, menuCnt.get(key));
            }
            
            if (max >= 2) {
                for (String key : menuCnt.keySet()) {
                    if (menuCnt.get(key) == max) {
                        result.add(key);
                    }
                }
            }
        }
        
        Collections.sort(result);
        String[] answer = new String[result.size()];
        
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        
        return answer;
    }
    
    static void makeCourse(int start, int count, String order, int len) {
        if (count == len) {
            String resultCourse = "";
            for (int i = 0; i < selected.length; i++) {
                if (selected[i]) {
                    resultCourse += (char)('A' + i);
                }
            }
        
            menuCnt.put(resultCourse, menuCnt.getOrDefault(resultCourse, 0) + 1);
            return;
        }
        
        
        for (int i = start; i < order.length(); i++) {
            int idx = order.charAt(i) - 'A';
            if (!selected[idx]) {
                selected[idx] = true;
                makeCourse(i + 1, count + 1, order, len);
                selected[idx] = false;
            }
        }
    }
}