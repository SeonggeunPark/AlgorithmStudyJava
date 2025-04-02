import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

public class Main {
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	public static int R, C, T, currDust, time;
	public static int[][] map, tmp;
	public static int[] purifierPos = new int[2];	// 공기청정기 행 위치(열은 항상 0)
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		currDust = 0;
		time = 0;
		
		// 방 미세먼지 정보 입력
		map = new int[R][C];
		boolean foundPurifier = false;
		for (int r=0; r<R; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c=0; c<C; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if (!foundPurifier && map[r][c] == -1) {
					purifierPos[0] = r;
					purifierPos[1] = r+1;
					foundPurifier = true;
				}
			}
		}
		// 시간 흐름 
		while (time < T) {
			// 먼지 확산
			diffuseFineDust();
			// 공기청정기 작동
			operatePurifier();
			// 현재 방의 미세먼지 계산
			currDust = countDust();
			// 1초 지남
			time += 1;
		}
		
		System.out.println(currDust);
	}
	private static int countDust() {
		int sum = 0;
		for (int r=0; r<R; r++) {
			for (int c=0; c<C; c++) {
				if (map[r][c] == -1) continue;
				sum += map[r][c];
			}
		}
		return sum;
	}
	private static void operatePurifier() {
		moveDust(0, 0, 1, moveDust(0, C-1, 2, moveDust(purifierPos[0], C-1, 0, moveDust(purifierPos[0], 0, 3, 0))));
		moveDust(R-1, 0, 0, moveDust(R-1, C-1, 2, moveDust(purifierPos[1], C-1, 1, moveDust(purifierPos[1], 0, 3, 0))));
	}
	private static int moveDust(int r, int c, int dir, int prev) {
		int prevDust = prev;
		int currDust = 0;
		if (prevDust < 0) prevDust=0;
		r += dr[dir];
		c += dc[dir];
		// 끝까지 이동
		while(0 <= r && r < R && 0 <= c && c < C && map[r][c] != -1) {
			currDust = map[r][c];
			map[r][c] = prevDust;
			prevDust = currDust;
			
			r += dr[dir];
			c += dc[dir];
		}
		return prevDust;
	}
	private static void diffuseFineDust() {
		// 증감량 임시저장 배열 초기화
		tmp = new int[R][C];
		
		// 배열 순회하며 미세먼지 있으면 연산
		for (int r=0; r<R; r++) {
			for (int c=0; c<C; c++) {
				if (map[r][c] <= 0) continue;
				diffuse(r, c, map[r][c]);
			}
		}
		// 임시저장한 증감량 계산
		for (int r=0; r<R; r++) {
			for (int c=0; c<C; c++) {
				if (tmp[r][c] == 0) continue;
				map[r][c] += tmp[r][c];
			}
		}
	}
	private static void diffuse(int r, int c, int dust) {
		// 확산량 저장
		int expectedDiffusion = dust/5;
		for (int dir=0; dir<4; dir ++) {
			int nr = r + dr[dir];
			int nc = c + dc[dir];
			// 공기청정기나 칸이 없으면 확산 X
			if (nr < 0 || nr >= R || nc < 0 || nc >= C || map[nr][nc] == -1) continue;
			// 증감량 임시저장
			tmp[r][c] -= expectedDiffusion;
			tmp[nr][nc] += expectedDiffusion;
		}
	}
}
