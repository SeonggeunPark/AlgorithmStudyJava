import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static class Student implements Comparable<Student> {
		String name;
		int korean;
		int english;
		int math;

		public Student(String name, int korean, int english, int math) {
			super();
			this.name = name;
			this.korean = korean;
			this.english = english;
			this.math = math;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		@Override
		public int compareTo(Student o) {
			if (this.korean == o.korean) {
				if (o.english == this.english) {
					if (o.math == this.math) {
						return this.name.compareTo(o.name);
					}
					return o.math - this.math;
				}
				return this.english - o.english;
			}
			return o.korean-this.korean;
		}
	}

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Student> pq = new PriorityQueue<>();
		
		for (int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			pq.add(new Student(st.nextToken(), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		

		for (int i=0; i<N; i++) {
			System.out.println(pq.poll().getName());
		}
	}
}
