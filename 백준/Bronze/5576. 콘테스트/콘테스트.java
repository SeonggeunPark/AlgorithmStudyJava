import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] w = new int[10];
		int[] k = new int[10];

		for (int i = 0; i < 10; i++) {
			w[i] = Integer.parseInt(br.readLine());
		}
		for (int i = 0; i < 10; i++) {
			k[i] = Integer.parseInt(br.readLine());
		}

//		bubbleSort(w);
//		bubbleSort(k);
//		insertSort(w);
//		insertSort(k);
//		selectSort(w);
//		selectSort(k);
//		mergeSort(w, 0, w.length - 1);
//		mergeSort(k, 0, k.length - 1);
		quickSort(w, 0, w.length - 1);
		quickSort(k, 0, k.length - 1);

		System.out.println((w[9] + w[8] + w[7]) + " " + (k[9] + k[8] + k[7]));
	}

	private static void quickSort(int[] w, int start, int end) {
		if (start >= end) {
			return;
		}
		int pivot = w[start];
		int l = start + 1;
		int r = end;
		while (l <= r) {
			// 왼쪽값중 나보다 큰거 찾기
			while (l <= end && w[l] <= pivot) {
				l += 1;
			}
			// 오른쪽부터 나보다 작은거 찾기
			while (r > start && w[r] >= pivot) {
				r -= 1;
			}
			if (l > r) {
				swap(start, r, w);
			} else
				swap(l, r, w);
		}
		// 교차하는 순간 피봇과 작은위치값 교체
		quickSort(w, start, r - 1);
		quickSort(w, r + 1, end);
	}

	private static void mergeSort(int[] w, int start, int end) {
		if (start >= end)
			return;

		int mid = (start + end) / 2;
		mergeSort(w, start, mid);
		mergeSort(w, mid + 1, end);

		merge(w, start, mid, end);
	}

	private static void merge(int[] w, int start, int mid, int end) {
		int[] tmp = new int[end - start + 1];
		int l = start;
		int r = mid + 1;
		int tIdx = 0;
		while (l <= mid && r <= end) {
			if (w[l] <= w[r]) {
				tmp[tIdx++] = w[l++];
			} else {
				tmp[tIdx++] = w[r++];
			}
		}
		while (l <= mid) {
			tmp[tIdx++] = w[l++];
		}
		while (r <= end) {
			tmp[tIdx++] = w[r++];
		}

		for (int i = 0; i < tmp.length; i++) {
			w[start + i] = tmp[i];
		}
	}

	private static void selectSort(int[] w) {
		// 정렬 시작지점
		for (int i = 0; i < w.length - 1; i++) {
			int minIdx = i;
			// 범위 내 최저값 찾기
			for (int j = i + 1; j < w.length; j++) {
				if (w[minIdx] > w[j]) {
					minIdx = j;
				}
			}
			swap(i, minIdx, w);
		}
	}

	private static void insertSort(int[] w) {
		// 정렬 대상 구간
		for (int i = 1; i < w.length - 1; i++) {
			for (int j = i + 1; j > 0; j--) {
				if (w[j] < w[j - 1]) {
					swap(j, j - 1, w);
				} else
					break;
			}
		}
	}

	private static void bubbleSort(int[] w) {
		for (int i = w.length - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (w[j] > w[j + 1]) {
					swap(j, j + 1, w);
				}
			}
		}
	}

	private static void swap(int i, int j, int[] w) {
		int tmp = w[i];
		w[i] = w[j];
		w[j] = tmp;
	}
}
