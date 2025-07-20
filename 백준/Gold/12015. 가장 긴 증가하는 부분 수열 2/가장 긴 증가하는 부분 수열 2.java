import java.util.List;
import java.util.Map;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

/*
 * N이 최대 100만 개.
 * N번 순회할 때마다 logN 다시 순회하므로 O(NlogN)
 * 최대 10억 회의 연산
 * 
 */
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int N, max;
	static int[] arr, index;

	public static void main(String[] args) throws IOException {
		init();

		for (int i = 1; i < N; i++) {
			int cur = arr[i];
//			if (index[max] < cur) {
//				index[max + 1] = cur;
//				max += 1;
//				continue;
//			}
//			for (int j = max - 1; j >= 1; j--) {
//				if (index[j] < cur) {
//					index[j + 1] = Math.min(cur, index[j + 1]);
//					continue out;
//				} else if (index[j] == cur) {
//					continue out;
//				}
//			}

			int pos = Arrays.binarySearch(index, 1, max+1, cur);
//			System.out.println(Arrays.toString(index));
//			System.out.println(cur+", "+pos);
			if (pos < 0) {
				pos = -(pos + 1);
			}
			index[pos] = arr[i];
			
			if (pos > max) max += 1;
		}

		System.out.println(max);

	}

//	private static void binarySearch(int start, int end, int cur) {
//		if (start > end) {
//
//		}
//		if (start == end) {
//
//		}
//
//		int mid = (start + end) / 2;
//
//		if (index[mid] > cur) {
//			if (start < mid - 1)
//				binarySearch(start, mid - 1, cur);
//			else {
//				
//			}
//				
//		} else if (index[mid] == cur) {
//			return;
//		} else {
//			binarySearch(mid + 1, end, cur);
//		}
//	}

	private static void init() throws IOException {
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		index = new int[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		index[1] = arr[0];
		max = 1;
	}
}
