import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static class Node {
		int data;
		Node prev;
		Node next;
	}

	public static class SinglyLinkedList {
		Node head;
		Node tail;
		int size;
		
		public SinglyLinkedList() {
			head = new Node();
			tail = new Node();
			head.next = tail;
			tail.prev = head;
		}
		
		public void push_front(int data) {
			Node newNode = new Node();
			newNode.data = data;
			
			newNode.prev = head;
			newNode.next = head.next;
			head.next.prev = newNode;
			head.next = newNode;
			
			size += 1;
		}
		public void push_back(int data) {
			Node newNode = new Node();
			newNode.data = data;
			
			newNode.next = tail;
			newNode.prev = tail.prev;
			tail.prev.next = newNode;
			tail.prev = newNode;
			
			size += 1;
		}
		public int pop_front() {
			if (size <= 0) {
				return -1;
			}
			int popData = head.next.data;
			
			head.next.next.prev = head;
			head.next = head.next.next;
			
			size -= 1;
			
			return popData;
		}
		public int pop_back() {
			if (size <= 0) {
				return -1;
			}
			int popData = tail.prev.data;
			
			tail.prev.prev.next = tail;
			tail.prev = tail.prev.prev;
			
			size -= 1;
			
			return popData;
		}
	}
	
	static SinglyLinkedList deque;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		deque = new SinglyLinkedList();
		
		for (int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			switch (command) {
			case "push_front": {
				int data = Integer.parseInt(st.nextToken());
				deque.push_front(data);
				break;
			}  
			case "push_back": {
				int data = Integer.parseInt(st.nextToken());
				deque.push_back(data);
				break;
			}
			case "pop_front": {
				System.out.println(deque.pop_front());
				break;
			}
			case "pop_back": {
				System.out.println(deque.pop_back());
				break;
			}
			case "size": {
				System.out.println(deque.size);
				break;
			}
			case "empty": {
				if (deque.size==0) System.out.println(1);
				else System.out.println(0);
				break;
			}
			case "front": {
				if (deque.size==0) System.out.println(-1);
				else System.out.println(deque.head.next.data);
				break;
			}
			case "back": {
				if (deque.size==0) System.out.println(-1);
				else System.out.println(deque.tail.prev.data);
				break;
			}
			default:
				break;
			}
		}
	}

}