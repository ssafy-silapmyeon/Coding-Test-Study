import java.util.*;

class PGS_징검다리 {
    public int solution(int distance, int[] rocks, int n) {
        Integer[] arr = new Integer[rocks.length];
        for(int i=0; i<arr.length; i++){
            arr[i] = rocks[i];
        }

        Arrays.sort(arr);

        int start = 1;
        int end = distance;
        int mid, cnt;
        while(start <= end){
            mid = (start + end) / 2;

            cnt = removeRock(mid, arr, distance);
            if(cnt <= n) start = mid + 1;
            else end = mid - 1;
        }

        return end;
    }

    static int removeRock(int dist, Integer[] arr, int last){
        int cnt = 0;
        int prev = 0;
        for(int i=0; i<arr.length; i++){
            if(prev + dist > arr[i]) cnt++;
            else prev = arr[i];
        }

        if(prev + dist > last) cnt++;

        return cnt;
    }
}