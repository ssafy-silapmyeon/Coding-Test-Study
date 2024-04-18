import java.util.*;

class Solution {
    public int[] solution(String msg) {
        Map<String, Integer> map = new HashMap<>();
        char ch = 'A';
        int index = 1;
        while (ch <= 'Z') {
            map.put(String.valueOf(ch), index);
            ch++;
            index++;
        }
        
        ArrayList<Integer> output = new ArrayList<>();
        int start = 0;
        int end = 1;
        
        while (start < msg.length()) {
            String w = msg.substring(start, end);

            String prev = w;
            while (end + 1 <= msg.length()) {
                w = msg.substring(start, end + 1);
                if (!map.containsKey(w)) {
                    w = prev;
                    break;   
                } 
                
                prev = w;
                end++;
            }
            
            output.add(map.get(w));
            if (end < msg.length()) {
                map.put(w + msg.charAt(end), index);
                index++;
            }

            start = end;
            end = end + 1;
        }
        
        int[] answer = output.stream().mapToInt(i->i).toArray();
        return answer;
    }
}