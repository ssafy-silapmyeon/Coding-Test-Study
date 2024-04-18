class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        int[] pre = new int[27];
        for(int i=1;i<skill.length();i++){
            char cur = skill.charAt(i);
            pre[cur-'A'+1] = skill.charAt(i-1)-'A'+1;
        }
        
        for(int i=0;i<skill_trees.length;i++){
            boolean[] learn = new boolean[27];
            boolean result = true;
            for(int j=0;j<skill_trees[i].length();j++){
                char cur = skill_trees[i].charAt(j);
                learn[cur-'A'+1]=true; //배웠음
                
                int check = cur-'A'+1;
                if(pre[check]!=0){
                    int p = pre[check];
                    if(!learn[p]){
                        result = false;
                        break;
                    }
                }
            }
            if(result){
                answer++;
            }
        }
        return answer;
    }
}