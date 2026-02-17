import java.util.*;
class Solution {
    class File implements Comparable<File> {
        int idx;
        String head;
        int number;
        
        public File (int idx, String head, int number) {
            this.idx= idx;
            this.head=head;
            this.number=number;
        }
        
        @Override
        public int compareTo(File o) {
            if (this.head.equals(o.head)) {
                if (this.number==o.number) {
                    return this.idx - o.idx;
                }
                return this.number - o.number;
            }
            return this.head.compareTo(o.head);
        }
    }
    public String[] solution(String[] files) {
        File[] fs = new File[files.length];
        // 파일 관리 배열 생성
        for (int i=0; i<files.length; i++) {
            fs[i] = treatFile(files[i], i);
        }
        
        // 기준에 맞게 정렬
        Arrays.sort(fs);
        
        // 출력
        String[] answer = new String[files.length];
        for (int i=0; i<files.length; i++) {
            answer[i] = files[fs[i].idx];
        }
        return answer;
    }
    public File treatFile(String file, int idx) {
        // 숫자가 나오기 직전까지 head
        // 숫자가 끝나는 지점까지 number, 나머지는 tail
        int hId = 0;
        while (file.charAt(hId) < '0' || file.charAt(hId) > '9') {
            hId+=1;
        }
        String head = file.substring(0, hId).toLowerCase();
        int nId = hId+1;
        while (nId<file.length() && file.charAt(nId)>='0' && file.charAt(nId)<='9') {
            nId += 1;
        }
        int number = Integer.parseInt(file.substring(hId, nId));
        
        return new File(idx, head, number);
    }
}