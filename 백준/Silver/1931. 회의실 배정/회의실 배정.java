import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	static class Meeting implements Comparable<Meeting> {
		int start;
		int end;

		public Meeting() {
		}

		public Meeting(int start, int end) {
			this.start = start;
			this.end = end;
		}

		// 끝나는 시간 순서대로 정렬
		@Override
		public int compareTo(Meeting o) {
			if (this.end == o.end) {
				return this.start - o.start;
			}
			return this.end - o.end;
		}
		@Override
		public String toString() {
			return "Meeting [start=" + start + ", end=" + end + "]";
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 회의 수
		// 회의 정보 우선순위큐 삽입
		PriorityQueue<Meeting> pq = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			pq.add(new Meeting(sc.nextInt(), sc.nextInt()));
		}
		int tmpEnd = pq.poll().end;
		int cnt = 1;
		// 큐가 빌 때까지 반복
		while (!pq.isEmpty()) {
			Meeting m = pq.poll();
			// 끝나는
			if(tmpEnd <= m.start) {
				cnt += 1;
				tmpEnd = m.end;
			}
		}
		
		System.out.println(cnt);
	}
}
