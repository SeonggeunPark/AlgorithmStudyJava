import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // 테스트 케이스 수

        StringBuilder sb = new StringBuilder();
        for (int testCase = 0; testCase < t; testCase++) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);

            // a의 마지막 자릿수로 계산 (1~10만 고려)
            int lastDigit = a % 10;

            // 주기 패턴 구하기
            int[] pattern = getPattern(lastDigit);
            int patternLength = pattern.length;

            // b가 0이면 결과는 항상 1
            if (b == 0) {
                sb.append(1).append("\n");
                continue;
            }

            // 패턴에서 b % 패턴길이의 위치를 구함 (0-based index 조정)
            int index = (b - 1) % patternLength;
            sb.append(pattern[index]).append("\n");
        }

        System.out.println(sb);
    }

    // 마지막 자릿수의 주기 패턴을 구하는 메서드
    private static int[] getPattern(int lastDigit) {
        switch (lastDigit) {
            case 0: return new int[]{10};
            case 1: return new int[]{1};
            case 2: return new int[]{2, 4, 8, 6};
            case 3: return new int[]{3, 9, 7, 1};
            case 4: return new int[]{4, 6};
            case 5: return new int[]{5};
            case 6: return new int[]{6};
            case 7: return new int[]{7, 9, 3, 1};
            case 8: return new int[]{8, 4, 2, 6};
            case 9: return new int[]{9, 1};
            default: return new int[]{};
        }
    }
}
