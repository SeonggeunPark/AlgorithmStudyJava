import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;


/**
 * 백준 2580 : 스도쿠 [GOLD 4]
 */
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int[][] sudoku;
	static boolean[][] check;
	static ArrayList<Blank> blanks;
	static boolean isDone;
	public static void main(String[] args) throws IOException {
		init();
		
		// 빈칸 가장 적은 파트부터 탐색
		for (int r=0; r<9; r++) {
			for (int c=0; c<9; c++) {
				if (sudoku[r][c] != 0) continue;
				Blank b = new Blank(r, c);
				for (int i=1; i<=9; i++) {
					if (check[r][i]) {
						continue;
					}
					if (check[9+c][i]) {
						continue;
					}
					if (check[18+(r/3)*3+c/3][i]) {
						continue;
					}
					
					b.cnt+=1;
					b.pos.add(i);
				}
				// 빈칸리스트에 추가
				blanks.add(b);
			}
		}
		// 가능성 높은 순으로 정렬
		Collections.sort(blanks);
		
		DFS(0);
		
		System.out.println(sb);
	}

	private static void DFS(int idx) {
		if (isDone) return;
		if (idx >= blanks.size()) {
			isDone = true;
			// 출력하고 종료
			for (int r=0; r<9; r++) {
				for (int c=0; c<9; c++) {
					sb.append(sudoku[r][c]).append(' ');
				}
				sb.append('\n');
			}
			return;
		}
		
		Blank b = blanks.get(idx);
		int r = b.r;
		int c = b.c;
		for (int num : b.pos ) {
			if (!check[r][num] && !check[9+c][num] && !check[18+(r/3)*3+c/3][num] && !isDone) {
				// 모두 체크 후 재귀함수 진입
				check[r][num] = true;
				check[9+c][num] = true;
				check[18+(r/3)*3+c/3][num] = true;
				sudoku[r][c] = num;
				
				DFS(idx+1);
				
				// 재귀 후 원상복구
				check[r][num] = false;
				check[9+c][num] = false;
				check[18+(r/3)*3+c/3][num] = false;
				sudoku[r][c] = 0;
			}
		}
		
	}
	private static class Blank implements Comparable<Blank> {
		int r;
		int c;
		int cnt;
		ArrayList<Integer> pos = new ArrayList<>();
		
		public Blank(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		@Override
		public int compareTo(Blank o) {
			return this.cnt-o.cnt;
		}
		
	}
	private static void init() throws IOException {
		// 스도쿠 현재 상태 배열
		sudoku = new int[9][9];
		// 각 행, 열, 사각형 별로 번호를 붙이고, 각 숫자가 존재하는지를 체크하기 위한 배열
		// 행: 0~8 열: 9~17 사각형: 18~26
		check = new boolean[27][10];
		blanks = new ArrayList<>();
		for (int r=0; r<9; r++) {
			StringTokenizer st  = new StringTokenizer(br.readLine());
			for (int c=0; c<9; c++) {
				int n = Integer.parseInt(st.nextToken());
				sudoku[r][c] = n;
				if (n==0) {
					continue;
				}
				check[r][n] = true;
				check[9+c][n] = true;
				check[18+(r/3)*3+c/3][n] = true;
			}
		}
		
	}
}
