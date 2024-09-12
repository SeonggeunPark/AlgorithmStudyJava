import java.util.Scanner;

class Node {
	int num;
	Node link;
}

class SinglyLinkedList {
	Node head;
	int size;

	SinglyLinkedList() {
		head = new Node();
	}
	
	int get(int idx) {
		Node curr = head;
		for (int k = 0; k < idx; k++) {
			curr = curr.link;
		}
		return curr.link.num;
	}
	// 삽입
	void addData(int i, int num) {
		// i 인덱스에 데이터 삽입
		// 0이면 제일 앞에 추가
		// size와 같으면 제일 뒤에 추가
		if (0 > i || i > size) {
			System.out.println("삽입할 위치가 잘못되었습니다.");
			return;
		}
		size++;

		// 새 노드 생성
		Node newNode = new Node();
		newNode.num = num;

		// 삽입할 위치 앞에 있는 노드 찾기
		Node curr = head;
		for (int k = 0; k < i; k++) {
			curr = curr.link;
		}

		// 새 노드부터 연결
		newNode.link = curr.link;
		curr.link = newNode;

	}
}

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();

		SinglyLinkedList first = new SinglyLinkedList();
		SinglyLinkedList second = new SinglyLinkedList();

		for (int i = 0; i < N; i++) {
			first.addData(sc.nextInt()-1, i+1);
		}
		for (int i = 0; i < M; i++) {
			second.addData(sc.nextInt()-1, first.get(M - 1 - i));
		}
		for (int i = 0; i < 3; i++) {
			System.out.println(second.get(i));
		}
	}


}
