import java.util.*;

class Solution {
    class Music implements Comparable<Music> {
        int start; int rTime; String title; String sheet;
        public Music (int start, int rTime, String title, String sheet) {
            this.start = start;
            this.rTime = rTime;
            this.title = title;
            this.sheet = sheet;
        }
        @Override
        public int compareTo(Music o) {
            if (this.rTime==o.rTime) {
                return this.start - o.start;
            }
            return o.rTime-this.rTime;
        }
    }
    public String solution(String m, String[] musicinfos) {
        int len = musicinfos.length;
        Music[] musics = new Music[len];
        for (int i=0; i<len; i++) {
            String[] info = musicinfos[i].split(",");
            musics[i] = new Music(strToInt(info[0]), strToInt(info[1])-strToInt(info[0]), info[2], info[3]);
        }
        
        // 정렬
        Arrays.sort(musics);
        
        String answer = "";
        
        // 순차 비교
        for (Music music : musics ) {
            if (match(m, music.sheet, music.rTime)) {
                return music.title;
            }    
        }
        
        return "(None)";
    }
    public int strToInt(String time) {
        int h = Integer.parseInt(time.substring(0,2));
        int m = Integer.parseInt(time.substring(3,5));
        return h*60+m;
    }
    public boolean match(String p, String s, int len) {
        // # 포함된 음을 소문자로 변환
        String P = replaceNotes(p);
        String S = replaceNotes(s);

        // 실제 재생된 악보 생성
        StringBuilder played = new StringBuilder();
        int sLen = S.length();
        for (int i = 0; i < len; i++) {
            played.append(S.charAt(i % sLen));
        }

        // 3. 치환된 멜로디가 실제 악보에 포함되는지 확인
        return played.toString().contains(P);
    }

    private String replaceNotes(String str) {
        return str.replace("C#", "c")
                  .replace("D#", "d")
                  .replace("F#", "f")
                  .replace("G#", "g")
                  .replace("A#", "a")
                  .replace("B#", "b")
                  .replace("E#", "e");
    }
}