import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader  br       = new BufferedReader(new InputStreamReader(System.in));
        char[]          text     = br.readLine().toCharArray();
        char[]          bomb     = br.readLine().toCharArray();
        int             bombLen  = bomb.length;

        Deque<Character> result      = new ArrayDeque<>();
        Deque<Integer>   matchLens   = new ArrayDeque<>();
        int              matchLen    = 0;

        for (char c : text) {
            result.addLast(c);

            // 1) 현재 문자로부터 이어붙인 뒤의 일치 길이 계산
            if (c == bomb[matchLen]) {
                matchLen++;
            } else {
                // 불일치라면, 이 문자가 bomb[0]인지만 보고 1 또는 0으로 재설정
                matchLen = (c == bomb[0]) ? 1 : 0;
            }
            matchLens.addLast(matchLen);

            // 2) 폭발이 일어날 만큼 매칭됐으면
            if (matchLen == bombLen) {
                // bombLen 개 만큼 뒤에서 제거
                for (int i = 0; i < bombLen; i++) {
                    result.removeLast();
                    matchLens.removeLast();
                }
                // 남은 마지막 matchLen 으로 복원
                matchLen = matchLens.isEmpty() ? 0 : matchLens.peekLast();
            }
        }

        // 3) 결과 출력
        if (result.isEmpty()) {
            System.out.println("FRULA");
        } else {
            StringBuilder sb = new StringBuilder(result.size());
            for (char c : result) {
                sb.append(c);
            }
            System.out.println(sb);
        }
    }
}
