import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        List<String[]> rList = new ArrayList<>();
        
        Map<String, String> nicknames = new HashMap<>();
        String[] sArr;
        for(String str : record){
            sArr = str.split(" ");
            switch(sArr[0]){
                case "Enter":
                    rList.add(new String[]{sArr[1], "님이 들어왔습니다."});
                    nicknames.put(sArr[1], sArr[2]);
                    break;
                case "Leave":
                    rList.add(new String[]{sArr[1], "님이 나갔습니다."});
                    break;
                case "Change":
                    nicknames.put(sArr[1], sArr[2]);
                    break;
            }
        }
        
        String[] ans = new String[rList.size()];
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<rList.size(); i++){
            sArr = rList.get(i);
            sb.append(nicknames.get(sArr[0])).append(sArr[1]);
            ans[i] = sb.toString();
            sb.setLength(0);
        }
        
        return ans;
    }
}
