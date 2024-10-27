import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	static class Word implements Comparable<Word>{
		String word;
		public Word(String word) {
			super();
			this.word = word;
		}
		@Override
		public String toString() {
			return "Word [word=" + word + "]";
		}
		@Override
		public int compareTo(Word o) {
			if (this.word.length() == o.word.length()) {
				for (int i=0; i<this.word.length(); i++) {
					if (this.word.charAt(i)==o.word.charAt(i)) continue;
					return this.word.charAt(i) - o.word.charAt(i);
				}
			}
			return this.word.length() - o.word.length();
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		String[] arr = new String[n];
		PriorityQueue<Word> pq = new PriorityQueue<>();
		for (int i=0; i<n; i++) {
			pq.add(new Word(sc.next()));
		}
		
		while(!pq.isEmpty()) {
			String tmp = pq.poll().word;
			
			if (!pq.isEmpty() && tmp.equals(pq.peek().word)) continue;
			
			System.out.println(tmp);
		}
		
		
	}
}
