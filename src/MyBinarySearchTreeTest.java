package hw9_2;
import java.util.Scanner;

class MyBinarySearchTree {
	private Node root = null; // 루트 노드를 가리키는 인스턴스 변수 
	
	// 노드 구조를 표현하는 클래스 
	private class Node {
		String key; // 단어(키값)
		int count; // 빈도 
		Node leftChild; // 왼쪽 자식 
		Node rightChild; // 오른쪽 자식
	}
	
	// 트리에 key를 삽입 
	public void insert(String key) {
		root = insertKey(root, key);
	}
	
	// 트리에서 key를 검색하여 빈도를 리턴
	public int search(String key) {
		Node p = searchNode(key);
		if(p != null) {
			return p.count;
		}
		else {
			return 0;
		}
	}
	
	// 트리의 모든 키값:빈도 쌍을 키값 오름차순으로 출력 -> print 메소드 대신 toString 오버라이드해도 됨
	public void print() {
		inorder(root);
		System.out.println();
	}
	
	// p를 루트로 하는 트리를 중위 순회 
	private void inorder(Node p) {
		if(p != null) {
			inorder(p.leftChild);
			System.out.print(p.key + ":"+ p.count + " ");
			inorder(p.rightChild);
		}
	}
	
	// p를 루트로 하는 트리에 key를 삽입하고, 삽입 후 루트 리턴 
	private Node insertKey(Node p, String key) {
		if(p == null) {
			Node newNode = new Node();
			newNode.key = key;
			newNode.leftChild = null;
			newNode.rightChild = null;
			newNode.count = 1;
			return newNode;
		}
		else if(key.compareTo(p.key) < 0) {  
			p.leftChild = insertKey(p.leftChild, key);
			return p;
		}
		else if(key.compareTo(p.key) > 0) {  
			p.rightChild = insertKey(p.rightChild, key);
			return p;
		}
		else { // 같으면 
			p.count++;
			return p;
		}
	}
	
	// key를 탐색하여 노드를 리턴(검색 실패하면 0 리턴) 
	private Node searchNode(String key) {
		Node p = root;
		while(p != null) {
			if(key.compareTo(p.key) < 0) { 
				p = p.leftChild;
			}
			else if(key.compareTo(p.key) > 0) {  
				p = p.rightChild;
			}
			else {
				return p;
			}
		}
		return null;
	}
}
public class MyBinarySearchTreeTest {
	public static void main(String[] args) {
		System.out.println("hw9_2");
		System.out.println(); // 줄 바꾸기 
		Scanner sc = new Scanner(System.in);
		
		// MyBinarySearchTree형 객체를 생성
		MyBinarySearchTree tree = new MyBinarySearchTree();
		
		// 한 줄의 단어 목록을 입력받아 각 단어를 하나씩 tree 삽입
		System.out.println("단어 목록 입력(하나 이상의 공백으로 구분): ");
		String[] word = sc.nextLine().trim().split("\\s+");
		System.out.println(); // 줄 바꾸기 
		
		for(int i = 0; i < word.length; i++) {
			System.out.print(word[i]);
			tree.insert(word[i]);
		}
				
		// tree에 저장된 정보(단어와 빈도)를 단어 오름차순으로 출력 
		System.out.print("트리 = ");
		tree.print();
		System.out.println(); // 줄 바꾸기 
		
		// 한 줄의 검색할 단어 목록을 입력받아 각 단어를 tree에서 검색하여 빈도 출력(각 단어는 하나 이상의 공백으로 구분)
		System.out.println("검색할 단어 목록 입력(하나 이상의 공백으로 구분): ");
		String[] s = sc.nextLine().trim().split("\\s+");
		
		for(int i = 0; i < s.length; i++) {
			System.out.println(s[i] + "의 빈도 = " + tree.search(s[i]));
		}
		sc.close();
	}
}
