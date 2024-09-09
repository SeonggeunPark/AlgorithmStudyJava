import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static int[] p;
	static int n,m,cnt;
	static int[] truer;
	static ArrayList<Integer>[] party;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		cnt =0;
		// 진실 알고 있는 자 저장
		String[] line = br.readLine().split(" ");
		int zero = Integer.parseInt(line[0]);
		truer = new int[zero];

		for (int i = 0; i < zero; i++) {
			truer[i] = Integer.parseInt(line[i+1]);
		}
		// 파티 저장
		party = new ArrayList[m];
		
		for (int i = 0; i < party.length; i++) {
			party[i] = new ArrayList<>();
			String[] line2 = br.readLine().split(" ");
			int party_Size = Integer.parseInt(line2[0]);

			for (int j = 1; j <= party_Size; j++) {
				int child = Integer.parseInt(line2[j]);
				party[i].add(child);
			}
		}

		// 각자 자기 자신 초기화
		p = new int[n + 1];
		for (int i = 1; i < n + 1; i++) {
			p[i] = i;
		}
		
		// 각 파티 그룹 사람들 하나의 파티로 만들기
		for (int i = 0; i < party.length; i++) {
			int firstpeople = party[i].get(0);
			for (int j = 1; j < party[i].size(); j++) {
				int first = findSet(firstpeople);
				int partyone = findSet(party[i].get(j));
				
				union(first, partyone);
			}
		}
		
		for (int i = 0; i < party.length; i++) {
			boolean ok = true;
			int cur = party[i].get(0);
			for (int j = 0; j < truer.length; j++) {
				if (findSet(cur) == findSet(truer[j])) {
					ok = false;
					break;
				}
			}
			if (ok) cnt++;
		}
		System.out.println(cnt);

	}

	static int findSet(int x) {
		if (x != p[x]) {
			p[x] = findSet(p[x]);
		}
		return p[x];
	}

	static void union(int x, int y) {
		p[y] = x;
	}
}
