import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        ArrayList<String> cache = new ArrayList<>();
        
        for (int c = 0; c < cacheSize; c++) {
            cache.add("");
        }

        int answer = 0; 
        for (int i = 0; i < cities.length; i++) {
            String city = cities[i].toLowerCase();
            int removeIdx = 0;
            boolean hit = false;
            for (int c = 0; c < cacheSize; c++) {
                if (city.equals(cache.get(c))) {
                    removeIdx = c;
                    hit = true;
                    break;
                }
            }
            
            if (hit) {
                answer += 1;
            } else {
                answer += 5;
            }
            
            if (cache.size() > removeIdx) {
                cache.remove(removeIdx);
            }
            if (cache.size() == cacheSize - 1) {
                cache.add(city); 
            }
        }
        
        return answer;
    }
}