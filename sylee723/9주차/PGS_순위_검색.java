import java.util.*;

class Solution {
    static Map<String, Integer> LANG, JOB, CAREER, FOOD;
    static Map<String, ArrayList<Integer>> category;

    public int[] solution(String[] info, String[] query) {
        setIdx();
        makeCategory();
        readInfo(info);
        
        for (String key : category.keySet()) {
            ArrayList<Integer> list = category.get(key);
            Collections.sort(list);
        }
        
        int[] answer = new int[query.length];
        for (int i = 0; i < query.length; i++) {
            String[] splitQ = query[i].split(" ");
            String keyStr = "";
            keyStr += LANG.get(splitQ[0]);
            keyStr += JOB.get(splitQ[2]);
            keyStr += CAREER.get(splitQ[4]);
            keyStr += FOOD.get(splitQ[6]);
            
            int minScore = Integer.parseInt(splitQ[7]);
            answer[i] = binarySearch(category.get(keyStr), minScore);
        }
        
        return answer;
    }
    
    static void setIdx() {
        LANG = new HashMap<>();
        LANG.put("-", 0);
        LANG.put("cpp", 1);
        LANG.put("java", 2);
        LANG.put("python", 3);
        
        JOB = new HashMap<>();
        JOB.put("-", 0);
        JOB.put("backend", 1);
        JOB.put("frontend", 2);
        
        CAREER = new HashMap<>();
        CAREER.put("-", 0);
        CAREER.put("junior", 1);
        CAREER.put("senior", 2);
        
        FOOD = new HashMap<>();
        FOOD.put("-", 0);
        FOOD.put("chicken", 1);
        FOOD.put("pizza", 2);
    }
    
    static void makeCategory() {
        category = new HashMap<>();
        int[] key = new int[4];
        for (int l = 0; l < LANG.size(); l++) {
            key[0] = l;
            for (int j = 0; j < JOB.size(); j++) {
                key[1] = j;
                for (int c = 0; c < CAREER.size(); c++) {
                    key[2] = c;
                    for (int f = 0; f < FOOD.size(); f++) {
                        key[3] = f;
                        
                        String keyStr = "" + key[0] + key[1] + key[2] + key[3];
                        category.put(keyStr, new ArrayList<Integer>());
                    }
                }
            }
        }
    }
    
    static void readInfo(String[] info) {        
        for (int i = 0; i < info.length; i++) {
            String[] data = info[i].split(" ");
            int[] key = new int[4];
            key[0] = LANG.get(data[0]);
            key[1] = JOB.get(data[1]);
            key[2] = CAREER.get(data[2]);
            key[3] = FOOD.get(data[3]);
            
            ArrayList<String> keyList = new ArrayList<>();
            keyList.add("0000");
            keyList.add("" + key[0] + "000");
            keyList.add("0" + key[1] + "00");
            keyList.add("00" + key[2] + "0");
            keyList.add("000" + key[3]);
            
            keyList.add("" + key[0] + key[1] + "00");
            keyList.add("" + key[0] + "0" + key[2] + "0");
            keyList.add("" + key[0] + "00" + key[3]);
            keyList.add("0" + key[1] + key[2] + "0");
            keyList.add("0" + key[1] + "0" + key[3]);
            keyList.add("00" + key[2] + key[3]);
            
            keyList.add("0" + key[1] + key[2] + key[3]);
            keyList.add("" + key[0] + "0" + key[2] + key[3]);
            keyList.add("" + key[0] + key[1] + "0" + key[3]);
            keyList.add("" + key[0] + key[1] + key[2] + "0");
            keyList.add("" + key[0] + key[1] + key[2] + key[3]);
            
            for (String keyStr : keyList) {
                ArrayList<Integer> tmp = category.get(keyStr);
                tmp.add(Integer.parseInt(data[4]));
                category.put(keyStr, tmp);
            }
        }
    }
    
    static int binarySearch(ArrayList<Integer> arr, int find) {
        int start = 0; 
        int end = arr.size() - 1;
        
        while (start <= end) {
            int mid = (start + end) / 2;
            
            if (arr.get(mid) < find) {
                start = mid + 1;
            } else if (arr.get(mid) > find) {
                end = mid - 1;
            } else {
                start = mid;
                break;
            }
        }
        
        if (start >= arr.size()) {
            return 0;
        }
        
        while (start >= 0 && arr.get(start) >= find) {
            start--;
        }
        
        return arr.size() - (start + 1);
    }
}