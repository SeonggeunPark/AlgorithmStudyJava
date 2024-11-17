import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		Map<Integer, Integer> map = new HashMap<>(); // 최빈값 계산

		int n = sc.nextInt();
		int[] arr = new int[n];

		int sum = 0;
		// 입력받으면서 총합 구함
		for (int i = 0; i < n; i++) {
			int tmp = sc.nextInt();
			arr[i] = tmp;
			sum += tmp;
			// 해당 값의 빈도를 카운트
			if (map.containsKey(tmp)) {
				map.put(tmp, map.get(tmp) + 1);
			} else {
				map.put(tmp, 1);
			}
		}

		// 산술평균 출력
		sb.append(Math.round((double) sum / n)).append('\n');
		// 중앙값 계산
		Arrays.sort(arr); // 오름차순 정렬
		sb.append(arr[n / 2]).append('\n');

		// 최빈값 계산
		int max = 0;
		List<Integer> list = new ArrayList<>();
		for (int key : map.keySet()) {
			if (map.get(key) > max) {
				max = map.get(key);
				list.clear();
				list.add(key);
			} else if (map.get(key) == max) {
				list.add(key);
			}
		}
		Collections.sort(list);
		if (list.size() <= 1) {
			sb.append(list.get(0)).append('\n');
		} else {
			sb.append(list.get(1)).append('\n');
		}
		
		// 최대값, 최소값 차이
		sb.append(arr[n - 1] - arr[0]);

		System.out.println(sb);
	}
}
