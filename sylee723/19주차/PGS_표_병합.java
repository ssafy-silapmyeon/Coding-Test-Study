import java.util.*;

class Solution {
    static int[][] parent = new int[50][50];
    static Map<Integer, String> map = new HashMap<>();
    
    public String[] solution(String[] commands) {
        initTable();
        ArrayList<String> result = new ArrayList<>();
        
        for (String command : commands) {
            String[] cmd = command.split(" ");
            switch (cmd[0]) {
                case "UPDATE":
                    if (cmd.length == 4) {
                        int r = Integer.parseInt(cmd[1]) - 1;
                        int c = Integer.parseInt(cmd[2]) - 1;
                        String value = cmd[3];
                        
                        int key = findParent(r, c);
                        map.put(key, value);
                    } else {
                        String value1 = cmd[1];
                        String value2 = cmd[2];
                        
                        for (int key : map.keySet()) {
                            if (map.get(key).equals(value1)) {
                                map.put(key, value2);
                            }
                        }
                    }
                    break;
                case "MERGE":
                    int r1 = Integer.parseInt(cmd[1]) - 1;
                    int c1 = Integer.parseInt(cmd[2]) - 1;
                    int r2 = Integer.parseInt(cmd[3]) - 1;
                    int c2 = Integer.parseInt(cmd[4]) - 1;
                    
                    merge(r1, c1, r2, c2);
                    break;
                case "UNMERGE":
                    int r = Integer.parseInt(cmd[1]) - 1;
                    int c = Integer.parseInt(cmd[2]) - 1;
                        
                    unmerge(r, c);
                    break;
                case "PRINT":
                    int i = Integer.parseInt(cmd[1]) - 1;
                    int j = Integer.parseInt(cmd[2]) - 1;
                    int key = findParent(i, j);
                    result.add(map.getOrDefault(key, "EMPTY"));
                    break;
            }
        }
        
        String[] answer = result.toArray(String[]::new);
        return answer;
    }
    
    static void initTable() {
        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 50; j++) {
                parent[i][j] = 50 * i + j;
            }
        }
    }
    
    static int findParent(int i, int j) {
        if (parent[i][j] == 50 * i + j) {
            return parent[i][j];
        } 
        
        return parent[i][j] = findParent(parent[i][j] / 50, parent[i][j] % 50);
    }
    
    static void merge(int r1, int c1, int r2, int c2) {
        int p1 = findParent(r1, c1);
        int p2 = findParent(r2, c2);
        
        if (p1 == p2) {
            return;
        }
        
        if (map.containsKey(p1)) { // 두 셀 모두 또는 셀1 만 값을 갖고 있는 경우
            map.remove(p2);
            parent[p2 / 50][p2 % 50] = p1;
        } else { // 셀2만 값을 갖고 있거나 둘다 갖고 있지 않은 경우
            parent[p1 / 50][p1 % 50] = p2;
        }
    }
    
    static void unmerge(int r, int c) {
        int key = findParent(r, c);
        
        if (map.containsKey(key)) {
            String value = map.get(key);
            map.remove(key);
            map.put(50 * r + c, value);
        }
        
        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 50; j++) {
                findParent(i, j);
            }
        }
        
        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 50; j++) {
                if (parent[i][j] == key) {
                    parent[i][j] = 50 * i + j;
                }
            }
        }
    }
}