import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        ArrayList<Num> numList = new ArrayList<>();
        for (int number : numbers) {
            int digit = 1;
            if (number >= 1000) {
                digit = 1000;
            } else if (number >= 100) {
                digit = 100;
            } else if (number >= 10) {
                digit = 10;
            }
            
            numList.add(new Num(number, digit));
        }
        
        Collections.sort(numList);
        StringBuilder answer = new StringBuilder();

        if (numList.get(0).value == 0) {
            return "0";
        }
        
        for (Num num : numList) {
            answer.append(num.value);
        }
        
        return answer.toString();
    }
    
    static class Num implements Comparable<Num> {
        int value, digit;
        
        public Num(int value, int digit) {
            this.value = value;
            this.digit = digit;
        }
        
        @Override
        public int compareTo(Num o) {
            int a = o.value * this.digit * 10 + this.value;
            int b = this.value * o.digit * 10 + o.value;
            
            return a - b;
        }
    }
}