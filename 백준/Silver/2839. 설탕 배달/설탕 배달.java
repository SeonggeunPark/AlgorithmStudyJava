import java.util.Scanner;

/*
 * 5키로그램 짜리가 최대가 되어야 하므로,
 * 5로 나누어 떨어질 경우 몫을 출력,
 * N / 5 부터 for문을 사용해 1개씩 줄여나가며 
 * 3과 나누었을 때 정확하게 떨어지는 양을 계산.
 * 최종적으로 나누어 떨어지지 않을 경우 -1 츨력
 */
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 5키로, 3키로짜리 설탕봉지 개수
		int five = 0;
		int three = 0;

		int N = sc.nextInt();
		// 5로 나누어떨어지면 몫을 출력하고 종료
		if (N % 5 == 0) {
			System.out.println(N / 5);
			return;
		}
		// 5로 나누어지지 않을 경우
		for (five = N / 5; five >= 0; five--) {
			// 5로 나눈 나머지가 3으로 나누어 떨어지면 두 값을 더해 출력 후 종료
			if ((N - 5*five) % 3 == 0) {
				three = (N - 5*five) / 3;
				System.out.println(five + three);
				return;
			}
		}
		// 3만으로 나누어 떨어질 경우 추가
		if (N%3 == 0) {
			System.out.println(N/3);
			return;
		}

		// 모두 해당되지 않을 경우 N킬로그램 만들 수 없으므로 -1 출력
		System.out.println(-1);

	}
}
