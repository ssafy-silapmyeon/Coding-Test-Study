import java.util.*;

class PGS_이중우선순위큐 {
    public int[] solution(String[] operations) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();

        for(int i=0; i<operations.length; i++){
            char o = operations[i].charAt(0);
            int num = Integer.valueOf(operations[i].substring(2, operations[i].length()));
            if(o == 'I'){ //삽입
                treeMap.put(num, treeMap.getOrDefault(num, 0) + 1);
            }else{ //삭제
                if(treeMap.isEmpty()) continue;
                int key = 0;
                if(num == -1){ //최소
                    key = treeMap.firstKey();
                }else{ //최대
                    key = treeMap.lastKey();
                }
                int cnt = treeMap.get(key) - 1;
                if(cnt <= 0) treeMap.remove(key);
                else treeMap.put(key, cnt);
            }
        }

        if(treeMap.isEmpty()){
            return new int[]{0,0};
        }else{
            return new int[]{treeMap.lastKey(), treeMap.firstKey()};
        }
    }
}