import java.util.PriorityQueue;
import java.util.Scanner;

/*
 * 1. N*N 모든 칸 탐색
 * 2. 비어있다면 4방 탐색하여
 * 	2-1) 좋아하는 학생 많은 칸의 위치와 빈 칸 수, 좋아하는 학생 인접 수 저장(우선순위 큐?)
 * 	2-2) 우선순위에 맞는 칸에 배치
 * 3. 최종 만족도 계산
 */
public class Main {
	static int N;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int[][] map;
	static int[][] like;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		map = new int[N + 1][N + 1];
		like = new int[N*N][5];

		// 좋아하는 학생 정보 담은 배열
		for (int i = 0; i < (N * N); i++) {
			like[i][0] = sc.nextInt();
			for (int j = 1; j <= 4; j++) {
				like[i][j] = sc.nextInt();
			}
		}
		// 첫 학생은 무조건 2,2에 배치
		map[2][2] = like[0][0];

		// 다음 학생부터 N*N번 학생까지 반복
		for (int i = 1; i < N * N; i++) {
			PriorityQueue<Seat> pq = new PriorityQueue<>();
			int maxLike = 0;

			// 모든 행열 탐색
			for (int r = 1; r <= N; r++) {
				for (int c = 1; c <= N; c++) {
					// 이미 학생이 있으면 패스
					if (map[r][c] != 0)
						continue;

					int likeCnt = 0;
					int emptyCnt = 0;

					// 4방 탐색
					for (int dir = 0; dir < 4; dir++) {
						int nr = r + dr[dir];
						int nc = c + dc[dir];
						// 범위 벗어나면 패스
						if (nr < 1 || nr > N || nc < 1 || nc > N)
							continue;
						// 빈칸이면 빈칸 수 카운트
						if (map[nr][nc] == 0) {
							emptyCnt += 1;
							continue;
						}
						// 좋아하는 학생 있는지 확인 & 카운트
						for (int idx = 1; idx <= 4; idx++) {
							if (map[nr][nc] == like[i][idx]) {
								likeCnt += 1;
								break;
							}
						}
					}
					// 좋아하는 학생 수가
					// (1)최대이면 큐 초기화 후 삽입!
					// (2)같으면 그냥 삽입
					// (3)적으면 패스
					if (likeCnt > maxLike) {
						maxLike = likeCnt;
						pq.clear();
						pq.add(new Seat(likeCnt, emptyCnt, r, c));
					} else if (likeCnt == maxLike) {
						pq.add(new Seat(likeCnt, emptyCnt, r, c));
					} else {
						continue;
					}
				}
			}
//			System.out.println(like[i][0]+"번 배치완료 "+pq);
			// 모든 행렬에 대해 탐색이 끝나면 가장 우선순위 높은 좌석에 배치
			Seat seat = pq.peek();
			map[seat.r][seat.c] = like[i][0];
		}
//		for (int r=1; r<=N; r++) {
//			for (int c=1; c<=N; c++) {
//				System.out.print(map[r][c]+" ");
//			}
//			System.out.println();
//		}

		int ans = 0;
		// 만족도 계산
		for (int r = 1; r <= N; r++) {
			for (int c = 1; c <= N; c++) {
				int likeCnt = 0;
				int num = -1;
				for (int i = 0; i < N * N; i++) {
					if (map[r][c] == like[i][0]) {
						num = i;
						break;
					}
				}

				// 4방 탐색
				for (int dir = 0; dir < 4; dir++) {
					int nr = r + dr[dir];
					int nc = c + dc[dir];
					// 범위 벗어나면 패스
					if (nr < 1 || nr > N || nc < 1 || nc > N)
						continue;
					// 좋아하는 학생 있는지 확인 & 카운트
					for (int idx = 1; idx <= 4; idx++) {
						if (map[nr][nc] == like[num][idx]) {
							likeCnt += 1;
							break;
						}
					}
				}
				
				ans += likeCnt > 0 ? Math.pow(10, likeCnt-1) : 0;
			}
		}

		System.out.println(ans);
	}
}

class Seat implements Comparable<Seat> {
	int like;
	int empty;
	int r, c;

	public Seat(int like, int empty, int r, int c) {
		this.like = like;
		this.empty = empty;
		this.r = r;
		this.c = c;
	}

	@Override
	public String toString() {
		return "Seat [like=" + like + ", empty=" + empty + ", r=" + r + ", c=" + c + "]";
	}

	@Override
	public int compareTo(Seat o) {
		if (this.empty == o.empty) {
			if (this.r == o.r) {
				return this.c - o.c;
			}
			return this.r - o.r;
		}
		return o.empty - this.empty;
	}
}
