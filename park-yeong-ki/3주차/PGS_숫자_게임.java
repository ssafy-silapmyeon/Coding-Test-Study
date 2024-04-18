import java.util.*;

class PGS_숫자_게임 {
    public int solution(int[] A, int[] B) {
        Integer[] aArr = new Integer[A.length];
        for(int i=0; i<A.length; i++){
            aArr[i] = A[i];
        }

        Integer[] bArr = new Integer[B.length];
        for(int i=0; i<B.length; i++){
            bArr[i] = B[i];
        }

        Arrays.sort(aArr);
        Arrays.sort(bArr);

        int aIdx = 0;
        int bIdx = 0;
        while(aIdx != aArr.length && bIdx != bArr.length){
            if(aArr[aIdx] < bArr[bIdx]) aIdx++;
            bIdx++;
        }

        return aIdx;
    }
}