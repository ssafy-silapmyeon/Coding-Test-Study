import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> minPQ = new PriorityQueue<>();
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Collections.reverseOrder());
        ArrayList<Integer> numList = new ArrayList<>();
       
        String[] cmd;
        for (String op : operations) {
            cmd = op.split(" ");
            
            if (cmd[0].equals("I")) {
                minPQ.add(Integer.parseInt(cmd[1]));
                maxPQ.add(Integer.parseInt(cmd[1]));
                numList.add(Integer.parseInt(cmd[1]));
            } else {
                if (numList.size() == 0) {
                    continue;
                } else {
                    if (cmd[1].equals("1")) {
                        while (true) {
                            int rm = maxPQ.poll();
                            if (numList.contains(rm)) {
                                numList.remove(Integer.valueOf(rm));
                                break;
                            }
                        }
                    } else {
                        while (true) {
                            int rm = minPQ.poll();
                            if (numList.contains(rm)) {
                                numList.remove(Integer.valueOf(rm));
                                break;
                            } 
                        }
                    }
                }
            }
        }

        int[] answer = new int[2];
        if (numList.size() > 0) {
            while (true) {
                int max = maxPQ.poll();
                if (numList.contains(max)) {
                    answer[0] = max;
                    break;
                }
            }
            while (true) {
                int min = minPQ.poll();
                if (numList.contains(min)) {
                    answer[1] = min;
                    break;
                }
            }
        }
        
        return answer;
    }
}