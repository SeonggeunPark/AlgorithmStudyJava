import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int[] arr = new int[N];
		int[] tmp = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.fill(tmp, 1);
		int max = 1;

		for (int i = 1; i < N; i++) {
			// 같으면 이전 값과 같은 값
			if (arr[i] == arr[i - 1]) {
				tmp[i] = tmp[i - 1];
			}
			// 아니라면 이전 값 탐색
			else {
				for (int j = 0; j < i; j++) {
					// 현재 값보다 크면 패스
					if (arr[j] >= arr[i])
						continue;
					// 현재 값보다 같으면 같은값
//					else if (arr[j] == arr[i]) {
//						tmp[i] = tmp[j];
//						break;
//					}
					// 현재값보다 작은 값중 최대값 갱신
					else {
						if (tmp[i] <= tmp[j]) {
							tmp[i] = tmp[j] + 1;
						}
					}
				}
			}
			max = Math.max(max, tmp[i]);
		}
		
//		System.out.println(Arrays.toString(tmp));
		System.out.println(max);

	}
}
