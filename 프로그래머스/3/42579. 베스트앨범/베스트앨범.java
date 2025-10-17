import java.util.*;

class Solution {
    private class Song implements Comparable<Song> {
        int num;
        int play;
        
        Song(int num, int play){
				this.num = num;
				this.play = play;
        }
        
        @Override
        public int compareTo(Song o) {
            if (this.play == o.play) {
                return this.num-o.num;
            }
            return o.play-this.play;
        }
    }
    public int[] solution(String[] genres, int[] plays) {
        /*
        Song객체 만들어 재생수 내림차순 정렬? 10000log10000 = 100만
        Map으로 장르 : 노래번호
        */
        Map<String, Integer> genreSum = new HashMap<>();
        Map<String, List<Song>> genreSongs = new HashMap<>();
        
        for (int i=0; i<genres.length; i++) {
            Song s = new Song(i, plays[i]);
            genreSum.put(genres[i], genreSum.getOrDefault(genres[i], 0)+plays[i]);
            if (genreSongs.get(genres[i])==null) {
                genreSongs.put(genres[i], new ArrayList<>());
                genreSongs.get(genres[i]).add(s);
            } else {
                genreSongs.get(genres[i]).add(s);
            }
        }
        
        List<String> order = new ArrayList<>(genreSum.keySet());
        Collections.sort(order, (a, b) ->
            genreSum.get(b) - genreSum.get(a)
        );
        
        List<Integer> ans = new ArrayList<>();
        for (String genre : order) {
            Collections.sort(genreSongs.get(genre));
            for (int i=0; i<2; i++) {
                if (genreSongs.get(genre).size() > i) {
                    ans.add(genreSongs.get(genre).get(i).num);
                }
            }
        }
        
        int[] answer = new int[ans.size()];
        for (int i=0; i<answer.length; i++) {
            answer[i] = ans.get(i);
        }
        
        return answer;
    }
}