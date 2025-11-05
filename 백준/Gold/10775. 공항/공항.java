import java.io.*;
import java.util.*;

/**
 * 시도 1 - 뒷번호 게이트부터 배정하는 방식 - 최악의 경우 NlogN = 50만 시도 2 - 기본적으로 도킹 가능한 게이트 중 가장 뒤로
 * 배치하긴 해야함. - 이분탐색?
 * 
 * 0 0 0 0 1 0 0 0 1 1 0 0 3 3 1 0 2 2 2 0
 */

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int G = Integer.parseInt(br.readLine());
		int P = Integer.parseInt(br.readLine());
		int[] g = new int[P + 1];
		for (int i = 1; i <= P; i++) {
			g[i] = Integer.parseInt(br.readLine());
		}

		int[] p = new int[G + 1];
		for (int i = 0; i <= G; i++) {
			p[i] = i;
		}

		int cnt = 0;

		for (int i = 1; i<=P; i++) {
			int n = g[i];
			
			// 끝 자리 있는지 확인
			if (find(n, p) == 0) {
				break;
			}

			// 자리 있으면 가장 끝 게이트 배정 => 이전 게이트번호와 union
			int pn = find(n,p);
			union(pn, pn-1, p);
			cnt += 1;
			
		}

		System.out.println(cnt);
	}

	private static void union(int big, int small, int[] p) {
		int pb = find(big, p);
		int ps = find(small, p);
		if (pb == ps)
			return;
		p[pb] = ps;
	}

	private static int find(int x, int[] p) {
		if (p[x] == x)
			return x;
		
		return p[x] = find(p[x], p);
	}
}
