import java.util.*;
class Solution {
    class Music{
        int id;
        int play;
        
        public Music(int id, int play){
            this.id =id;
            this.play = play;
        }
        
    }
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        HashMap <String, Integer> mapSum = new HashMap<>();
        HashMap <String, ArrayList<Music>> mapMusic = new HashMap<>();

        
        for(int i=0;i<genres.length;i++){ //장르별 재생횟수 합
            ArrayList<Music> music = new ArrayList<>();
            if(mapSum.get(genres[i])==null){
                mapSum.put(genres[i],plays[i]);
            }
            else{
                int sum = mapSum.get(genres[i]);
                mapSum.put(genres[i],sum+plays[i]);
                music = new ArrayList<>(mapMusic.get(genres[i]));
            }

            music.add(new Music(i,plays[i]));
            mapMusic.put(genres[i],music);
        }
        
        List<String> sumList = new ArrayList<>(mapSum.keySet());//장르 list로 저장
        Collections.sort(sumList, new Comparator<String>(){
            @Override
            public int compare(String s1, String s2){
                return mapSum.get(s2)-mapSum.get(s1);
            }
        });
        
        List<Integer> result = new ArrayList<>();
         for(String g: sumList){
             Collections.sort(mapMusic.get(g), new Comparator<Music>(){
                
                 @Override
                    public int compare(Music m1,Music m2){
                    if(m1.play==m2.play){
                    return m1.id-m2.id;
                    }
                    return m2.play-m1.play;
                }
                 
             });
             int cnt=0;
            for(Music m : mapMusic.get(g)){//music 객체 리스트
                result.add(m.id);
                cnt++;
                if(cnt==2)
                    break;
            }
         }
        
        answer = new int[result.size()];
        int n=0;
        for(int i : result){
            answer[n]=i;
            n++;
            
        }
        return answer;
    }
}
