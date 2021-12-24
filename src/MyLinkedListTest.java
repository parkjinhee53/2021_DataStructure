package hw6_1;

class MyLinkedList {
	private Node head = null; // private 인스턴스 변수-단순 연결 리스트의 첫번째 노드
	public int counts = 0; // 단어의 개수를 저장할 변수 
	
	private class Node { // 노드 구조를 정의하는 private 클래스  필드 2개 
		String item; // 각각의 노드가 저장할 데이터 
		Node link; // 다음 노드의 정보
	}
	
	public void add(String item) { // 매개변수로 받은 원소를 리스트 맨 앞에 삽입하는 메소드
		Node newNode = new Node(); // 새로운 노드 생성
		newNode.item = item;
		newNode.link = head; // 새로운 노드의 link 
		head = newNode; // 첫번째 노드는 새로운 노드 
		
		if(head.link == null) { // 리스트 원소가 하나면 새로 만든 노드가 head 
			newNode = head;
		}
	}
	
	public int count(String item) { // 매개변수로 받은 원소가 리스트에 몇 개 있는지 세는 메소드 
		Node temp = head;
		while(temp != null) { // temp 값이 null이 아니면 무한 반복 
			if(item.equals(temp.item)) { // 매개변수로 받은 원소랑 같다면 
				counts++; // 1 증가 
				temp = temp.link; // 다음 노드랑 비교해야 하기 때문에 temp를 다음 노드로 바꿔줌 
			}
			else { 
				temp = temp.link; // 같지 않으면 temp는 다음 노드로 바뀜  
			}
		}
		return counts;
	}
	
	@Override
	public String toString() { // 리스트의 내용을 하나의 문자열로 구성하여 리턴하는 메소드 
		String Mlist = ""; // 리스트에 있는 데이터를 저장할 변수
		if(head == null) { // 첫번째 노드가 비어있으면 빈 리스트
			return "[]";
		}
		else {
			Node node = head;
			Mlist = "[";
			while(node.link != null) { // node의 link가 null이 아니면 무한 반복
				Mlist += node.item + ",";
				node = node.link; // 다음 node로 바꾸기
			}
			Mlist += node.item + "]"; // 마지막 node는 반복문에서 false이기 때문에 따로 추가해줌
			return Mlist.toString();
		}
	}
	
	public void remove(String item) { // 매개변수로 받은 원소를 리스트에서 모두 삭제하는 메소드 
		Node temp = head;
		
		if (temp.item.equals(item)) { // 맨 처음 값이 같을 때
			head = temp.link; // 같으면 삭제해야 하기 때문에 head를 temp의 link에 해당하는 노드에 연결 
		}
		while(temp.link != null) { // // 아닐 때 temp의 link가 null이 아니면 무한 반복 
			if (temp.link.item.equals(item)) { // temp의 link가 매개변수로 받은 원소랑 같다면 
				temp.link = temp.link.link; // temp의 link는 temp link의 link로 바뀜 
			}
			else {
				temp = temp.link; // 다음 temp로 바꾸기 
			}
		}
		return;
	}
}
	
public class MyLinkedListTest {
	public static void main(String[]args) {
		MyLinkedList list = new MyLinkedList(); // MyLinkedList 객체 생성 
		
		System.out.println("hw6_1");
		System.out.println(); // 줄 바꾸기 
		System.out.println("초기 리스트 = " + list.toString()); // 초기 리스트 출력 
		System.out.println(); // 줄 바꾸기 
		
		// 10개의 단어 리스트에 삽입 
		list.add("DOG");
		list.add("cat");
		list.add("DVD");
		list.add("cup");
		list.add("can");
		list.add("DOG");
		list.add("cat");
		list.add("case");
		list.add("character");
		list.add("DOG");
		
		System.out.println("단어 10개 삽입 후 = " + list.toString());
		System.out.println("EGG 개수 = " + list.count("EGG")); // EGG 개수 출력 
		System.out.println("DOG 개수 = " + list.count("DOG")); // DOG 개수 출력 
		System.out.println(); // 줄 바꾸기 
		
		list.remove("EGG"); // EGG 삭제 
		System.out.println("EGG 삭제 후 = " + list);
		list.remove("DOG"); // DOG 삭제 
		System.out.println("DOG 삭제 후 = " + list);
		list.add("FAN"); // FAN 삽입 
		System.out.println("FAN 삽입 후 = " + list);
		list.remove("DVD"); // DVD 삭제 
		System.out.println("DVD 삭제 후 = " + list);
	}
}
