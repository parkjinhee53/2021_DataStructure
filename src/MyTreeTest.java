package hw9_1;

class MyLinkedTree {
	// 루트 노드를 가리키는 private 인스턴스 변수 root
	private Node root = null;
	
	// 노드 구조를 정의하는 private 클래스
	private class Node {
		char data;
		Node leftChild;
		Node rightChild;
	}
	
	// 생성자
	public MyLinkedTree(char data, MyLinkedTree leftSubtree, MyLinkedTree rightSubtree) {
		root = new Node();
		root.data = data;
		if(leftSubtree == null) {
			root.leftChild = null;
		}
		else {
			root.leftChild = leftSubtree.root;
		}
		if(rightSubtree == null) {
			root.rightChild = null;
		}
		else {
			root.rightChild = rightSubtree.root;
		}
	}
	
	// 전위 순회를 위한 서비스 메소드
	public void preorder() {
		preorder(root);
	}
	
	// 전위 순회하며 트리 노드 데이터를 출력하는 메소드
	private void preorder(Node p) {
		if(p != null) {
			System.out.print(p.data + " ");
			preorder(p.leftChild);
			preorder(p.rightChild);
		}
	}
	
	// 중위 순회를 위한 서비스 메소드
	public void inorder() {
		inorder(root);
	}
	
	// 중위 순회하며 트리 노드 데이터를 출력하는 메소드
	private void inorder(Node p) {
		if(p != null) {
			inorder(p.leftChild);
			System.out.print(p.data + " ");
			inorder(p.rightChild);
		}
	}
	
	// 후위 순회를 위한 서비스 메소드
	public void postorder() {
		postorder(root);
	}
	
	// 후위 순회하며 트리 노드 데이터를 출력하는 메소드
	private void postorder(Node p) {
		if(p != null) {
            postorder(p.leftChild);
            postorder(p.rightChild);
            System.out.print(p.data + " ");
        }
	}
}

// 문자형 자료를 저장하는 이진 트리를 배열로 구현한 클래스
class MyArrayTree {
	private char[] arr = new char[12]; // 문자형 배열 변수 
	private char root = 0; // 루트 
	
	// 생성자
	public MyArrayTree(char[] arr) {
		this.arr =arr;
	}
	
	// 전위 순회를 위한 서비스 메소드
	public void preorder() {
		preorder(root);
	}
	
	// 전위 순회 출력하는 메소드
	private void preorder(int c) {
		if(c < arr.length) {
			System.out.print(arr[c] + " ");
			preorder(2*c+1); // 왼쪽
			preorder(2*c+2); // 오른쪽 
		}
	}
	
	// 중위 순회를 위한 서비스 메소드
	public void inorder() {
		inorder(root);
	}
	
	// 중위 순회 출력하는 메소드 
	private void inorder(int c) {
		if(c < arr.length) {
			inorder(2*c+1); // 왼쪽
			System.out.print(arr[c] + " ");
			inorder(2*c+2); // 오른쪽 
		}
	}
	
	// 후위 순회를 위한 서비스 메소드
	public void postorder() {
		postorder(root);
	}
	
	// 후위 순회 출력하는 메소드
	private void postorder(int c) {
		if(c < arr.length) { 
			postorder(2*c+1); // 왼쪽 
			postorder(2*c+2); // 오른쪽 
			System.out.print(arr[c] + " ");
		}
	}
}

public class MyTreeTest {
	public static void main(String[] args) {
		System.out.println("hw9_1");
		
		// 노드 7개로 이루어진 MyLinkedTree형 예제 트리 linked Tree를 생성
		MyLinkedTree tree7 = new MyLinkedTree('D', null, null);
		MyLinkedTree tree6 = new MyLinkedTree('C', null, null);
		MyLinkedTree tree5 = new MyLinkedTree('B', null, null);
		MyLinkedTree tree4 = new MyLinkedTree('A', null, null);
		MyLinkedTree tree3 = new MyLinkedTree('/', tree6, tree7);
		MyLinkedTree tree2 = new MyLinkedTree('*', tree4, tree5);
		MyLinkedTree linkedTree = new MyLinkedTree('-', tree2, tree3);
		
		System.out.println(); // 줄 바꾸기 
		System.out.println("연결 자료구조로 구현한 이진 트리 순회");
		
		//linkedTree를 전위,중위,후위 순회
		System.out.print("전위 순회: ");
		linkedTree.preorder();
		System.out.println(); // 줄 바꾸기 
		
		System.out.print("중위 순회: ");
		linkedTree.inorder();
		System.out.println(); // 줄 바꾸기 
		
		System.out.print("후위 순회: ");
		linkedTree.postorder();
		System.out.println(); // 줄 바꾸기 
		
		// 노드 11개로 이루어진 MyArrayTree형 예제 트리(arrayTree)를 생성 
		char[] charArray = {'+', '-', '*', '*', '/', 'A', 'B', 'C', 'D', 'E', 'F'};
		MyArrayTree arrayTree = new MyArrayTree(charArray);
		
		System.out.println(); // 줄 바꾸기 
		System.out.println("배열로 구현한 이진 트리 순회");
		
		System.out.print("전위 순회: ");
		arrayTree.preorder();
		System.out.println(); // 줄 바꾸기 
		
		System.out.print("중위 순회: ");
		arrayTree.inorder();
		System.out.println(); // 줄 바꾸기 
		
		System.out.print("후위 순회: ");
		arrayTree.postorder();
		System.out.println(); // 줄 바꾸기 
	}
}
