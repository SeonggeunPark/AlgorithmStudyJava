import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < 3; i++) {
			pq.add(sc.nextInt());
		}
		
		pq.poll();
		System.out.println(pq.poll());
	}
}