import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * 각 노드에서 치킨집까지의 거리 합이 최소가 되도록 하는 문제
 * 모든 치킨집 중 M개를 고르는 조합을 완성한 후
 * 지도 상 모든 집을 BFS탐색하여 치킨집까지의 최소 거리를 구함.
 * 
 * 최종 합을 저장해가며 모든 조합을 계산하고 그중 최소값을 출력한다.
 * 
 * 탐색할 임시 지도 배열을 기존 지도 배열로 초기화하는 과정에서
 * 얓은 복사가 이루어져 오답이 발생하였음.
 * clone() 메서드를 활용하여 깊은 복사로 수정
 * 
 * 시간초과 발생
 */
public class Main {
	static class Chicken {
		int r, c;

		public Chicken() {
		}

		public Chicken(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Chicken [r=" + r + ", c=" + c + "]";
		}
	}
	static class House {
		int r, c;
		public House() {
			// TODO Auto-generated constructor stub
		}
		public House(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		@Override
		public String toString() {
			return "House [r=" + r + ", c=" + c + "]";
		}
	}
	static int N, M, min;
	static int[][] map;
	static int[][] tmpMap;
	static boolean[][] visited;
	static ArrayList<Chicken> chickens;
	static ArrayList<House> houses;
	static Chicken[] pick;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		min = Integer.MAX_VALUE; // 치킨 거리의 최소값을 저장할 변수

		map = new int[N][N];
		tmpMap = new int[N][N];
		visited = new boolean[N][N];
		chickens = new ArrayList<>(); // 치킨집 좌표를 담을 리스트
		houses = new ArrayList<>(); // 집 좌표를 담을 리스트
		pick = new Chicken[M]; // M개를 뽑은 후 저장할 배열

		// 맵 입력 및 치킨집 탐색
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				map[r][c] = sc.nextInt();
				if (map[r][c] == 2) {
					chickens.add(new Chicken(r, c));
					map[r][c] = 0; // 지도상으로는 0으로 초기화
				} else if (map[r][c] == 1) {
					houses.add(new House(r, c));
				}
			}
		}
		pick(0, 0);
		
		System.out.println(min);
	}

	private static void pick(int n, int r) {
		// 모두 골랐으면 탐색 시작
		if (r >= M) {
//			editMap();
			int tmpDist = search();
			if (min > tmpDist) {
				min = tmpDist;
			}
			return;
		}
		// 남은 치킨집 수보다 골라야 할 치킨집 수가 많으면 부적절하므로 종료
		if (n >= chickens.size()) {
			return;
		}

		// 해당 치킨집을 안고른다
		pick(n + 1, r);
		// 해당 치킨집을 고른다
		pick[r] = chickens.get(n);
		pick(n + 1, r + 1);
	}

//	// 선택한 치킨집만 지도상에 2로 표시
//	private static void editMap() {
//		for (int r=0; r<N; r++) {
//			tmpMap[r] = map[r].clone();
//		}
//		for (Chicken chicken : pick) {
//			tmpMap[chicken.r][chicken.c] = 2;
//		}
//	}

	// 모든 집 탐색하며 선택한 각 치킨집과의 최소 거리를 구해 마을의 총 치킨거리 계산
	private static int search() {
		int sum = 0;
		for (House h : houses) {
			int tmpMin = Integer.MAX_VALUE;
			for (Chicken c : pick) {
				tmpMin = Math.min(Math.abs(h.r-c.r)+Math.abs(h.c-c.c), tmpMin);
			}
			sum += tmpMin;
		}
		return sum;
	}
//
//	private static int BFS(int r, int c) {
//		Queue<int[]> q = new LinkedList<>();
//
//		int dist = 0;
//		int size = 1;
//		visited = new boolean[N][N];
//
//		visited[r][c] = true; // 시작지점 방문체크
//		q.add(new int[] { r, c }); // 큐에 삽입
//
//		while (!q.isEmpty()) {
//
//			for (int i = 0; i < size; i++) {
//				int[] curr = q.poll();
//				// 치킨집이면 탐색 종료
//				if (tmpMap[curr[0]][curr[1]] == 2) {
//					return dist;
//				}
//				// 4방탐색
//				for (int dir = 0; dir<4; dir++) {
//					int nr = curr[0] + dr[dir];
//					int nc = curr[1] + dc[dir];
//					
//					if (nr<0 || nr>=N || nc<0 || nc>=N || visited[nr][nc]) continue;
//					
//					q.add(new int[] {nr, nc});
//					visited[nr][nc] = true;
//				}
//			}
//			size = q.size();
//			dist += 1;
//		}
//		
//		return dist;
//	}
}
