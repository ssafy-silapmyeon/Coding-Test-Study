import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> gPlayCnt = new HashMap<>();
        Map<String, ArrayList<Song>> songByG = new HashMap<>();
        
        for (int i = 0; i < genres.length; i++) {
            if (gPlayCnt.containsKey(genres[i])) {
                gPlayCnt.put(genres[i], gPlayCnt.get(genres[i]) + plays[i]);
                ArrayList<Song> songList = songByG.get(genres[i]);
                songList.add(new Song(i, plays[i]));
                songByG.put(genres[i], songList);
            } else {
                gPlayCnt.put(genres[i], plays[i]);
                ArrayList<Song> songList = new ArrayList<>();
                songList.add(new Song(i, plays[i]));
                songByG.put(genres[i], songList);
            }
        }
        
        String maxG;
        int maxCnt;
        ArrayList<Integer> album = new ArrayList<>();
        while (!gPlayCnt.isEmpty()) {
            maxG = "";
            maxCnt = 0;
            
            for (String genre : gPlayCnt.keySet()) {
                if (maxCnt < gPlayCnt.get(genre)) {
                    maxG = genre;
                    maxCnt = gPlayCnt.get(genre);
                }
            }
            gPlayCnt.remove(maxG);
            ArrayList<Song> songList = songByG.get(maxG);
            Collections.sort(songList);
            
            for (int i = 0; i < Math.min(2, songList.size()); i++) {
                album.add(songList.get(i).num);
            }
        }
        
        int[] answer = new int[album.size()];
        for (int i = 0; i < album.size(); i++) {
            answer[i] = album.get(i);
        }
        
        return answer;
    }
    
    static class Song implements Comparable<Song>{
        int num, play;
        
        public Song(int num, int play) {
            this.num = num;
            this.play = play;
        }
        
        @Override
        public int compareTo(Song o) {
            if (this.play != o.play) {
                return -(this.play - o.play);
            } else {
                return this.num - o.num;
            }
        }
    }
}