import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int sumW, sumB;
	static int[][] paper;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
	
		N = Integer.parseInt(br.readLine());
		
		sumW = 0; // 같은 색인 종이의 개수
		sumB = 0;
		
		paper = new int[N][N];

		for (int r=0; r<N; r++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int c=0; c<N; c++) {
				paper[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		int cutCnt = 0;
		DFS(0, 0, cutCnt); // 시작지점 0, 0부터 시작, 총 N*N 색깔 체크
		
		System.out.println(sumW);
		System.out.println(sumB);
	}
	private static void DFS(int r, int c, int cutCnt) {
		// 최대한으로 잘랐다면 sum에 1 더하고 작업 끝
		if (N == Math.pow(2, cutCnt)) {
			if (paper[r][c] == 1) {
				sumB += 1;
				return;
			}
			sumW += 1;
			return;
		}
		// 모두 같은 색이면 더이상 자르지 않고 sum에 1 더한 후 작업 끝
		if (check(r,c,N/Math.pow(2, cutCnt))) {
			if (paper[r][c] == 1) {
				sumB += 1;
				return;
			}
			sumW += 1;
			return;
		}
		// 다른 색이면 잘라서 재귀함수 호출
		else {
			for (int i=r; i<r+N/Math.pow(2, cutCnt); i+=N/Math.pow(2, cutCnt+1)) {
				for (int j=c; j<c+N/Math.pow(2, cutCnt); j+=N/Math.pow(2, cutCnt+1)) {
					DFS(i, j, cutCnt+1);
				}
			}
		}
	}
	// 범위(startR, startC부터 d칸) 내 칸이 모두 같은 색인지 확인
	private static boolean check(int startR, int startC, double d) {
		int prevColor = paper[startR][startC];
		
		for (int r=startR; r<startR+d; r++) {
			for (int c=startC; c<startC+d; c++) {
				if(paper[r][c] != prevColor) {
					return false;
				}
				prevColor = paper[r][c];
			}
		}
		
		return true;
	}
}
