import java.util.*;
import java.io.*;

public class Main {
	static int[][] board=new int[9][9];
	static boolean[][] rows, cols, boxes;
	static ArrayList<int[]> blanks;
	static boolean isFinished;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int r=0; r<9; r++) {
			char[] tmp = br.readLine().toCharArray();
			for (int c=0; c<9; c++) {
				board[r][c] = tmp[c]-'0';
			}
		}
		blanks = new ArrayList<>();
		rows = new boolean[9][10];
		cols = new boolean[9][10];
		boxes = new boolean[9][10];
		isFinished = false;
		// 기록
		for (int r=0; r<9; r++) {
			for (int c=0; c<9; c++) {
				int num = board[r][c];
				if (num == 0) {
					blanks.add(new int[] {r,c});
					continue;
				}
				rows[r][num] = true;
				cols[c][num] = true;
				boxes[3*(r/3) + c/3][num] = true;
			}
		}
		// 탐색
		dfs(0);
		
		System.out.println(sb);
	}
	private static void dfs(int pIdx) {
		if (isFinished) return;
		if (pIdx >= blanks.size()) {
			// 최종본 출력 후 리턴
			for (int r=0; r<9; r++) {
				for (int c=0; c<9; c++) {
					sb.append(board[r][c]);
				}
				sb.append('\n');
			}
			isFinished = true;
			return;
		}
		
		int r = blanks.get(pIdx)[0];
		int c = blanks.get(pIdx)[1];
		for (int i=1; i<=9; i++) {
			if (isFinished) return;
			if (rows[r][i] || cols[c][i] || boxes[3*(r/3) + c/3][i]) continue;
			board[r][c] = i;
			rows[r][i] = true;
			cols[c][i] = true;
			boxes[3*(r/3) + c/3][i] = true;
			dfs(pIdx+1);
			board[r][c] = 0;
			rows[r][i] = false;
			cols[c][i] = false;
			boxes[3*(r/3) + c/3][i] = false;
		}
	}

}