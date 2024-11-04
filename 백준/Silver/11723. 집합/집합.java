import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입출력 속도 향상을 위해 BufferedReader와 BufferedWriter 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 명령어 개수 M 입력
        int M = Integer.parseInt(br.readLine());

        // 비트마스크를 위한 정수 변수 선언 (20개의 숫자 상태를 표현하기 위한 비트마스크)
        int bitSet = 0;

        // M개의 명령어 처리
        for (int i = 0; i < M; i++) {
            // 명령어를 공백 기준으로 분리하여 배열에 저장
            String[] command = br.readLine().split(" ");
            String comm = command[0]; // 명령어 종류

            // 명령어 종류에 따라 분기 처리
            switch (comm) {
                case "add": {
                    // "add x": x를 집합에 추가
                    int x = Integer.parseInt(command[1]) - 1; // x 값을 0 기반으로 변환
                    bitSet |= (1 << x); // x번째 비트를 1로 설정하여 추가
                    break;
                }
                case "remove": {
                    // "remove x": x를 집합에서 제거
                    int x = Integer.parseInt(command[1]) - 1; // x 값을 0 기반으로 변환
                    bitSet &= ~(1 << x); // x번째 비트를 0으로 설정하여 제거
                    break;
                }
                case "check": {
                    // "check x": x가 집합에 있는지 확인
                    int x = Integer.parseInt(command[1]) - 1; // x 값을 0 기반으로 변환
                    if ((bitSet & (1 << x)) != 0) {
                        // x번째 비트가 1이면 집합에 존재
                        bw.write("1\n");
                    } else {
                        // x번째 비트가 0이면 집합에 존재하지 않음
                        bw.write("0\n");
                    }
                    break;
                }
                case "toggle": {
                    // "toggle x": x가 있으면 제거, 없으면 추가
                    int x = Integer.parseInt(command[1]) - 1; // x 값을 0 기반으로 변환
                    bitSet ^= (1 << x); // x번째 비트를 반전하여 토글
                    break;
                }
                case "all": {
                    // "all": 1부터 20까지 모든 원소 추가
                    bitSet = (1 << 20) - 1; // 20개의 비트를 모두 1로 설정
                    break;
                }
                case "empty": {
                    // "empty": 모든 원소 제거
                    bitSet = 0; // 모든 비트를 0으로 설정
                    break;
                }
            }
        }

        // 최종 결과 출력
        bw.flush(); // BufferedWriter에 저장된 내용을 출력
        bw.close(); // BufferedWriter 자원 해제
    }
}
