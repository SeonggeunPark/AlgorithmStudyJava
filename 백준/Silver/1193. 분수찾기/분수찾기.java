import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        
        // 부모 값을 찾는 함수
        int p = findParent(N); // 분모 값
        int pNum = p * (p - 1) / 2 + 1; // 부모 값에서 몇 번째 수인지
        
        int numerator;
        int denominator;

        // pNum은 해당 집합의 시작 인덱스이므로 N과의 차이를 계산
        int position = N - pNum;

        // 짝수는 아래 방향, 홀수는 위 방향
        if (p % 2 == 0) {
            // 짝수일 때는 (p - position) / (position + 1)
            numerator = position + 1;
            denominator = p - position;
        } else {
            // 홀수일 때는 (position + 1) / (p - position)
            numerator = p - position;
            denominator = position + 1;
        }

        System.out.println(numerator + "/" + denominator);
    }

    private static int findParent(int n) {
        int i = 1;
        while (true) {
            int max = i * (i + 1) / 2; // 해당 집합에서의 최대값
            if (max >= n) {
                break;
            }
            i += 1;
        }
        return i; // 부모 값
    }
}
