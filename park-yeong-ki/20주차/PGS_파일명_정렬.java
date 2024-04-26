import java.util.*;

class Solution {
    static int idx;
    public String[] solution(String[] files) {
        String[][] sArr = new String[files.length][3];
        for(int i=0; i<files.length; i++){
            idx = 0;
            sArr[i][0] = getHead(files[i]);
            sArr[i][1] = getNumber(files[i]);
            sArr[i][2] = files[i].substring(idx, files[i].length());
        }
        
        Arrays.sort(sArr, new Comparator<String[]>(){
            @Override
            public int compare(String[] o1, String[] o2){
                if(o1[0].toUpperCase().compareTo(o2[0].toUpperCase()) == 0){
                    return Integer.parseInt(o1[1]) - Integer.parseInt(o2[1]);
                }
                return o1[0].toUpperCase().compareTo(o2[0].toUpperCase());
            }
        });
        
        String[] answer = new String[sArr.length];
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<sArr.length; i++){
            sb.append(sArr[i][0]).append(sArr[i][1]).append(sArr[i][2]);
            answer[i] = sb.toString();
            sb.setLength(0);
        }

        return answer;
    }
    
    static String getNumber(String file){
        int s=idx;
        while(idx < file.length() && 
              idx - s <= 5 && 
              '0' <= file.charAt(idx) && file.charAt(idx) <= '9'){
            idx++;
        }
        return file.substring(s, idx);
    }
    
    static String getHead(String file){
        int s=idx;
        while(idx < file.length() &&
              '0' > file.charAt(idx) || file.charAt(idx) > '9'){
            idx++;
        }
        return file.substring(s, idx);
    }
}
