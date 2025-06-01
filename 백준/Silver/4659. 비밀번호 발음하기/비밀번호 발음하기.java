import java.io.*;

public class Main {

    public static boolean isAcceptable(String pw) {
        String vowels = "aeiou";
        boolean hasVowel = false;
        int vowelCount = 0;
        int consonantCount = 0;

        char prev = 0;

        for (int i = 0; i < pw.length(); i++) {
            char ch = pw.charAt(i);

            // 모음 여부 판별
            boolean isVowel = vowels.indexOf(ch) != -1;

            // 조건 1: 모음 포함 여부 체크
            if (isVowel) {
                hasVowel = true;
                vowelCount++;
                consonantCount = 0;
            } else {
                consonantCount++;
                vowelCount = 0;
            }

            // 조건 2: 모음 3개 또는 자음 3개 연속 체크
            if (vowelCount == 3 || consonantCount == 3) {
                return false;
            }

            // 조건 3: 같은 글자 연속 2번 (단 ee, oo는 허용)
            if (i > 0 && ch == prev) {
                if (!(ch == 'e' || ch == 'o')) {
                    return false;
                }
            }

            prev = ch;
        }

        return hasVowel;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String pw;
        while (!(pw = br.readLine()).equals("end")) {
            if (isAcceptable(pw)) {
                System.out.printf("<%s> is acceptable.\n", pw);
            } else {
                System.out.printf("<%s> is not acceptable.\n", pw);
            }
        }
    }
}
