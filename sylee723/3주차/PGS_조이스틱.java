class Solution {
    public int solution(String name) {
        int change = 0;
        for (int i = 0; i < name.length(); i++) {
            change += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);
        }
        
        int move = name.length() - 1;
        for (int k = 0; k < name.length(); k++) {
            int right = k;
            while (right > 0 && name.charAt(right) == 'A') {
                right--;
            }
            
            int left = k;
            while (left < name.length() && name.charAt(left) == 'A') {
                left++;
            }
            move = Math.min(move, 2 * right + (name.length() - left));
            move = Math.min(move, right + 2 * (name.length() - left));
        }

        int answer = change + move;
        return answer;
    }
}