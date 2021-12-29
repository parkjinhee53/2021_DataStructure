package hw10_1;

import java.util.Scanner;

class MyUndirectedWeightedGraph {
	private int[][] matrix; // 인접 행렬 
	private int numberOfVertices; // 정점 수 
	
	// 정수형 2차원 배열을 매개변수로 받아 그래프를 초기화
	public MyUndirectedWeightedGraph(int[][] matrix) {
		numberOfVertices = matrix.length;
		this.matrix = new int[numberOfVertices][numberOfVertices];
		for(int i = 0; i < numberOfVertices; i++) {
			for(int j = 0; j < numberOfVertices; j++) {
					this.matrix[i][j] = matrix[i][j];
			}
		}
	}
	
	// 정점 v의 차수를 구하여 리턴
	public int getDegree(int v) {
		int degree = 0;
		for(int i = 0; i < numberOfVertices; i++) {
				if (matrix[v][i] != 0) {
					degree += 1;
				}
		}
		return degree;
	}
	
	// 그래프의 간선 총 개수를 구하여 리턴 
	public int getNumberOgEdges() {
		int numberOfEdges = 0;
		for(int i = 0; i < numberOfVertices; i++) {
			for(int j = 0; j < numberOfVertices; j++) {
				if(matrix[i][j] != 0) {
					numberOfEdges += 1;
				}
			}
		}
		return numberOfEdges/2;
	}
	
	// 정점 v에 인접한 정점 구하기 
	public void printAdvertex(int v) {
		int arr [] = new int[numberOfVertices];
		for(int i = 0; i < numberOfVertices; i++) {
			if(matrix[v][i] > 0) {
				arr[i] += i;
				System.out.print(arr[i] + " ");
			}
		}
	}
	
	// 최대 가중치 간선 구하기 
	public void printEdge() {
		int max = 0; // 최댓값 
		
		// 최댓값의 위치를 알기 위해서 변수 만들기 
		int maxi = 0;
		int maxj = 0;
		for(int i = 0; i < numberOfVertices; i++) {
			for(int j = 0; j < numberOfVertices; j++) {
				if(matrix[i][j] > max) {
					maxi = i;
					maxj = j;
				}
			}
		}
		System.out.print("(" + maxi + "," + maxj +")");
	}
}
public class MyUndirectedWeightedGraphTest {
	public static void main(String[] args) {
		System.out.println("hw10_1");
		System.out.println(); // 줄 바꾸기 
		Scanner sc = new Scanner(System.in);
		
		// (1) 10x10 크기의 인접 행렬 원소를 입력받아 그 원소들로 초기화된 MyUndirectedWeightedGraph 객체를 생성
		int[][] matrix = new int[10][10];
		System.out.println("10행 10열의 인접 행령 원소 입력(whitespace로 구분): ");
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				matrix[i][j] = sc.nextInt();
			}
		}
		
		MyUndirectedWeightedGraph graph = new MyUndirectedWeightedGraph(matrix);
		
		// (2) 정점 번호 v를 입력받음
		System.out.println(); // 줄 바꾸기 
		System.out.print("정점 번호(0~9) 입력: ");
		int v = sc.nextInt();
		System.out.println(); // 줄 바꾸기
		
		// (3) v의 차수 출력
		System.out.println("정점 " + v + "의 차수 = " + graph.getDegree(v));
		
		// (4) 그래프의 간선 총 개수 출력
		System.out.println("그래프의 간선 총 개수 = "+ graph.getNumberOgEdges());
		System.out.println();
		
		// (5) v에 인접한 정점 번호 출력 
		System.out.print("정점 " + v + "에 인접한 정점 = ");
		graph.printAdvertex(v);
		System.out.println();
		
		// (6) 그래프의 간선 전체 중에서 가중치가 최대인 간선 출력 
		System.out.print("최대 가중치 간선 = ");
		graph.printEdge();
		System.out.println();
		
		sc.close();
	}
}
