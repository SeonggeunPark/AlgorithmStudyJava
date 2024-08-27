import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        
        for (int t=1; t<=T; t++) {
            
            int N = Integer.parseInt(br.readLine());
            int[] sentence = new int[N];
            
            while (N > 0) {
                char[] arr = br.readLine().toCharArray();
                out : for (int i=0; i<arr.length; i++) {

                    char c = arr[i];
                    // 구두점일 때
                    if (c == '!' || c == '.' || c == '?') {
                        N--;
                    }
                    // 대문자이면서 첫글자이거나 앞에 공백이나 구두점이 있으면 탐색 시작.
                    if ((65 <= c && c <= 90) && (i <= 0 || arr[i-1] == ' ' || arr[i-1] == '!' || arr[i-1] == '.' || arr[i-1] == '?')) {
                        // 공백 or 배열 끝날때까지 대문자 있는지 확인
                        for (int j = i+1; j <= arr.length; j++) {
                            // 단어가 끝났거나 문장의 끝에 도달한 경우
                            if (j == arr.length || arr[j] == ' ' || arr[j] == '!' || arr[j] == '.' || arr[j] == '?') {
                                sentence[N-1]++;
                                i = j - 1;  // i를 j의 바로 앞 위치로 설정
                                break;
                            }
                            char tmp = arr[j];
                            // 중간에 대문자 혹은 숫자를 만나면 탐색 종료
                            if ((65 <= tmp && tmp <= 90) || (0 <= tmp-'0' && tmp-'0' <= 9)) {
                                i = j;
                                continue out;
                            }
                        }
                    }
                }
            }
            System.out.print("#" + t + " ");
            for (int i = sentence.length - 1; i >= 0; i--) {
                System.out.print(sentence[i] + " ");
            }
            System.out.println();
        }
    }
}