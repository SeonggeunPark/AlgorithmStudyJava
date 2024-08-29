import java.util.Scanner;

public class Main {
	static int N;
	static int[] arr;
	static int[] tmp;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		quickSort(0, arr.length - 1);
		
		for (int i : arr) {
			System.out.println(i);
		}
	}

	static void quickSort(int left, int right) {
		if (left >= right) return;
		int pivot = left;
		int L = left + 1;
		int R = right;
//		System.out.println(Arrays.toString(arr));
//		System.out.printf("전 %d %d\n",L, R);

		while (L <= R) {
			// 왼쪽 : pivot보다 큰 값 찾기
			while (L<=R && arr[L] <= arr[pivot])
				L++;
			// 오른쪽 : pivot보다 작은 값 찾기
			while (arr[R] > arr[pivot])
				R--;
			
			if (L < R) {
				swap(L, R);
			}
		}
		swap(left, R);
		pivot = R;
		quickSort(left, pivot-1);
		quickSort(pivot+1,right);
	}

	static void swap(int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
}