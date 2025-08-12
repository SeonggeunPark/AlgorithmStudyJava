import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

/*
 * n은 최대 100, 간선도 최대 100개
 * i에서 거리 m 이내의 모든 지역 탐색.
 * 
 */
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int N, M, R, max;
	static int[] items;
	static int[][] dist;
	static ArrayList<Site>[] adjList;
	static class Site {
		int v;
		int l;
		public Site(int v, int l) {
			super();
			this.v = v;
			this.l = l;
		}
	}
	public static void main(String[] args) throws IOException {
		init();
		
		// 플로이드 워셜
		floydWarshall();
		
		// 낙하위치별 최단거리 구하기
		max = 0;
		for (int i=1; i<=N; i++) {
			int sum = items[i];
			for (int j=1; j<=N; j++) {
				if (i==j) continue;
				if (dist[i][j] <= M) {
					sum += items[j];
				}
			}
			max = Math.max(max, sum);
		}
		
		System.out.println(max);
	}
	private static void floydWarshall() {
		// i에서 j로 가는 모든 경로에서 k를 거쳐갈 때 최단거리
		// 양방향 통행 => (i>j) == (j>i) 이므로 중복 계산 줄임
		for (int k=1; k<=N; k++) {
			for (int i=1; i<=N; i++) {
				if (dist[i][k] == Integer.MAX_VALUE) continue;
				for (int j=i+1; j<=N; j++) {
					if (i==j) continue;
					if (dist[k][j] == Integer.MAX_VALUE) continue;
					if (dist[i][j] > dist[i][k]+dist[k][j]) {
						dist[i][j] = dist[i][k]+dist[k][j];
						dist[j][i] = dist[i][j];
					}
				}
			}
		}
		
	}
	private static void init() throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		items = new int[N+1];
		adjList = new ArrayList[N+1];
		for (int i=1; i<=N; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		// 지역별 아이템 수 입력
		st= new StringTokenizer(br.readLine());
		for (int i=1; i<=N; i++) {
			items[i] = Integer.parseInt(st.nextToken());
		}
		
		// 플로이드 워셜용 배열
		dist = new int[N+1][N+1];
		for (int i=1; i<=N; i++) {
			for (int j=1; j<=N; j++) {
				if (i==j) continue;
				dist[i][j] = Integer.MAX_VALUE;
			}
		}
		
		// 인접 정보 리스트 입력
		for (int i=1; i<=R; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			
			dist[a][b] = l;
			dist[b][a] = l;
			
			adjList[a].add(new Site(b, l));
			adjList[b].add(new Site(a, l));
		}
		
	}
}
