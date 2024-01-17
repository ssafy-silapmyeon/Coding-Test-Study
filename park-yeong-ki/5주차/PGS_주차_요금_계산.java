import java.util.*;

class PGS_주차_요금_계산 {
    public int[] solution(int[] fees, String[] records) {
        Map<String, Integer> map = new HashMap<>();
        String[] info, time;
        int m;
        for(int i=0; i<records.length; i++){
            info = records[i].split(" ");
            time = info[0].split(":");
            m = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);

            if(info[2].equals("IN")){
                map.put(info[1], map.getOrDefault(info[1], 0) + m);
            }else{
                map.put(info[1], map.get(info[1]) - m);
            }
        }
        List<String> nums = new ArrayList<>(map.keySet());
        Collections.sort(nums);

        for(String s : nums){
            if(map.get(s) >= 0) map.put(s, 1439 - map.get(s));
            else map.put(s, -1 * map.get(s));
        }

        int[] ans = new int[nums.size()];
        int plus;
        for(int i=0; i<nums.size(); i++){
            plus = map.get(nums.get(i)) - fees[0];
            if(plus < 0) plus = 0;

            ans[i] = fees[1] + (plus / fees[2]) * fees[3];
            if(plus % fees[2] != 0) ans[i] += fees[3];
        }

        return ans;
    }
}