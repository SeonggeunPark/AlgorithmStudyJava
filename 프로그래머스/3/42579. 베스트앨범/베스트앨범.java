import java.util.*;

class Solution {
    public class Genre {
        List<Song> songs;
        int played;
        public Genre(int played) {
            songs = new ArrayList<>();
            this.played = played;
        }
    }
    public class Song {
        int num;
        int played;
        public Song(int num, int played) {
            this.num = num;
            this.played = played;
        }
    }
    public int[] solution(String[] genres, int[] plays) {
        int len = genres.length;
        Map<String, Genre> genreMap = new HashMap<>();
        for (int i=0; i<len; i++) {
            String gen = genres[i];
            int play = plays[i];
            if (genreMap.get(gen) == null) {
                Genre genre = new Genre(play);
                genre.songs.add(new Song(i, play));
                genreMap.put(gen, genre);
            } else {
                Genre genre = genreMap.get(gen);
                genre.played += play;
                genre.songs.add(new Song(i, play));
            }
        }
        
        Genre[] gens = new Genre[genreMap.keySet().size()];
        int idx = 0;
        for (String key : genreMap.keySet()) {
            gens[idx++] = genreMap.get(key);
        }
        Arrays.sort(gens, new Comparator<Genre>(){
           @Override
            public int compare(Genre o1, Genre o2) {
                return o2.played - o1.played;
            }
        });
        List<Integer> result = new ArrayList<>();
        for (Genre gen : gens) {
            if (gen.songs.size()<2) {
                result.add(gen.songs.get(0).num);
            } else {
                int max1 = 0;
                int max2 = 0;
                int num1 = 0;
                int num2 = 0;
                for (Song song : gen.songs) {
                    if (song.played > max1) {
                        max2 = max1;
                        num2 = num1;
                        max1 = song.played;
                        num1 = song.num;
                    } else if (song.played > max2) {
                        max2 = song.played;
                        num2 = song.num;
                    }
                }
                result.add(num1);
                result.add(num2);
            }
        }
        int[] answer = new int[result.size()];
        for (int i=0; i<result.size(); i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }
}