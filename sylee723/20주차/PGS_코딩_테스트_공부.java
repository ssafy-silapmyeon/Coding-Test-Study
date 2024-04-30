class Solution {
    public int solution(int alp, int cop, int[][] problems) {
        int ALP_REQ = alp;
        int COP_REQ = cop;

        for (int i = 0; i < problems.length; i++) {
            ALP_REQ = Math.max(ALP_REQ, problems[i][0]);
            COP_REQ = Math.max(COP_REQ, problems[i][1]);
        }
        
        int[][] d = new int[ALP_REQ + 1][COP_REQ + 1]; 
        for (int i = alp; i <= ALP_REQ; i++) {
            for (int j = cop; j <= COP_REQ; j++) {
                d[i][j] = Integer.MAX_VALUE;
            }
        }
        
        d[alp][cop] = 0;
        for (int i = alp; i <= ALP_REQ; i++) {
            for (int j = cop; j <= COP_REQ; j++) {
                if (i + 1 <= ALP_REQ) {
                    d[i + 1][j] = Math.min(d[i + 1][j], d[i][j] + 1);
                }
                if (j + 1 <= COP_REQ) {
                    d[i][j + 1] = Math.min(d[i][j + 1], d[i][j] + 1);
                }
                
                for (int p = 0; p < problems.length; p++) {
                    if (i < problems[p][0] || j < problems[p][1]) {
                        continue;
                    }
                    
                    int after_alp = Math.min(i + problems[p][2], ALP_REQ);
                    int after_cop = Math.min(j + problems[p][3], COP_REQ);
                    d[after_alp][after_cop] = Math.min(d[after_alp][after_cop], d[i][j] + problems[p][4]);
                }
            }
        }

        int answer = d[ALP_REQ][COP_REQ];
        return answer;
    }
}