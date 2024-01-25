class Solution {
    public long solution(int n, int[] times) {
        long start = 0;
        long end = (long)times[0] * n;
        
        long answer = binarySearch(start, end, n, times);
        return answer;
    }
    
    static long binarySearch(long start, long end, int key, int[] times) {
        long mid, count;
        long answer = -1;
        
        while (start <= end) {
            mid = (start + end) / 2;
            count = 0;
            
            for (int time : times) {
                count += mid / time;
            }
             
            if (count >= key) {
                answer = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        
        return answer;
    }
}