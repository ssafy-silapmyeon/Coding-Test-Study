import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        String[][] s_record = new String[record.length][];
        Map<String, String> idNicknameMap = new HashMap<>();
        
        for (int r = 0; r < record.length; r++) {
            s_record[r] = record[r].split(" ");
            if (s_record[r][0].equals("Enter") || s_record[r][0].equals("Change")) {
                idNicknameMap.put(s_record[r][1], s_record[r][2]);
            }
        }
        
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < s_record.length; i++) {
            if (s_record[i][0].equals("Enter")) {
                list.add(idNicknameMap.get(s_record[i][1]) + "님이 들어왔습니다.");
            } else if (s_record[i][0].equals("Leave")) {
                list.add(idNicknameMap.get(s_record[i][1]) + "님이 나갔습니다.");
            }
        }
        
        String[] answer = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
                       
        return answer;
    }
}