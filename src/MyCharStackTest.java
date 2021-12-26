package hw7_1;
import java.util.EmptyStackException;
import java.util.Scanner;

class MyCharStack {
	private Node top = null; // 스택의 꼭데기(top) 원소 노드를 가리키는 private 인스턴스 변수
	
	private class Node { // 노드 구조를 나타내는 private 클래스
		char data; // 각각의 노드가 저장할 데이터 
		Node link; // 다음 노드의 정보
	}
	
	public boolean isEmpty() { // isEmpty - 스택이 비었는지를 검사하는 public 메소드
		return top == null;
	}
	
	public void push(char item) { // push - 스택에 원소를 삽입하는 public 메소드 
		Node newNode = new Node(); // 새로운 노드 생성
		newNode.data = item; // 새로운 노드의 데이터는 매개변수로 받은 item 
		newNode.link = top; // 새로운 노드의 link
		top = newNode; // top은 새로운 노드 
	}
	
	public char pop() { // pop - 스택에서 원소를 삭제하여 리턴하는 public 메소드 
		if(isEmpty()) { // 스택이 비어있는 경우 EmptyStackException 예외 발생 
			throw new EmptyStackException();
		}
		else {
			char item = top.data;
			top = top.link; // top 바꾸기 
			return item;
		}
	}
	
	public char peek() { // peek - 스택의 top 원소를 리턴하는 public 메소드
		if(isEmpty()) { // 스택이 비어있는 경우 EmptyStackException 예외 발생 
			throw new EmptyStackException();
		}
		return top.data;
	}
}
public class MyCharStackTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("hw7_1");
		
		MyCharStack stack = new MyCharStack(); // MyCharStack 객체 생성 
		MyCharStack checkstack = new MyCharStack(); // 괄호 수식이 올바른지 아닌지 확인하기 위해 MyCharStack 객체 하나 더 생성
		
		// 괄호 수식 문자열 입력받기 
		System.out.print("괄호 수식 입력: ");
		String exp = sc.next();
		int error = 0; // 올바른 괄호 수식인지를 확인해줄 변수 
		
		for(int i = 0; i < exp.length(); i++) { // 문자열 길이만큼 반복해서 수식의 문자를 하나씩 차례대로 스택에 삽입
			char e = exp.charAt(i); // e에는 문자열 exp를 char 타입으로 한 글자씩 저장 
			stack.push(e); // 스택에 삽입 

			if(error == 1) { // error가 1이면 잘못된 괄호 수식이기 때문에 다른 조건을 확인할 필요가 없어서 다음 반복을 실행 
				continue;
			}

			if(e == '(' || e == '[') { // (, [ 라면 checkstack에 삽입 
				checkstack.push(e);
			}
			 //)면 스택이 비어있지 않고 스택의 top 원소가 ( 이어야 올바른 괄호 수식이기 때문에 스택의 top를 삭제할 수 있음 
			else if(e == ')' ) {
				if (!checkstack.isEmpty() && checkstack.peek() == '(') {
					checkstack.pop(); // ( 삭제 
				}
				else {
					error = 1; // 위 조건에 해당하지 않으면 잘못된 괄호 수식이기 때문에 error가 1로 바뀜
				}
			}
			// ]면 스택이 비어있지 않고 스택의 top 원소가 [ 이어야 올바른 괄호 수식이기 때문에 스택의 top를 삭제할 수 있음 
			else if(e == ']' ) { 
				if(!checkstack.isEmpty() && checkstack.peek() == '[') {
					checkstack.pop(); // [ 삭제 
				} 
				else {
					error = 1; // 위 조건에 해당하지 않으면 잘못된 괄호 수식이기 때문에 error가 1로 바뀜
				}
			}
		}

		System.out.print("스택에서 삭제하여 출력 = ");
		while(!stack.isEmpty()) { // 스택이 빌 때까지 스택에서 하나씩 삭제하여 출력 
			System.out.print(stack.pop());
		}
		
		System.out.println(); // 줄 바꾸기 
		
		// 수식이 올바른 괄호 수식인가를 검사하여 결과를 출력 
		if(checkstack.isEmpty()) {
			if(error == 0) {
				System.out.println("올바른 괄호 수식입니다.");
			}
			else { // error이 1이면 잘못된 괄호 수식 
				System.out.println("잘못된 괄호 수식입니다.");
			}
		}
		else { // checkstack가 비어있지 않으면 잘못된 괄호 수식 
			System.out.println("잘못된 괄호 수식입니다.");
		}
		sc.close();
	}
}
