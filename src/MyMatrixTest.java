/*
 * 2021.9.23 
 * 행렬 표현 
 */
package hw5_1;
import java.util.Scanner;
import java.util.Random;

class MyMatrix {
	private int[][] array; // 행렬을 구현하는 정수형 2차원 배열 
	private int row; // 행의 개수 
	private int column; // 열의 개수 
	
	// 행과 열의 개수를 매개변수로 받아 모든 원소가 0인 행렬을 생성하는 생성자 
	public MyMatrix(int row, int column) {
		this.row = row;
		this.column = column;
		this.array = new int[row][column];
	}
	
	// 현재 행렬의 전치 행렬을 표현하는데 필요한 생성자 (행과 열의 개수, 2차원 배열을 매개변수로 받음)
	public MyMatrix(int row, int column, int[][]array) {
		this.row = row;
		this.column = column;
		this.array = array;
	}
	
	// 인덱스 i, j와 정수값(value)를 매개변수로 받아 i행 j열 원소를 value로 지정(단, i와 j는 0부터 시작하는 배열 인덱스)
	public void set(int i, int j, int value) {
		array[i][j] = value;
	}
	
	// 현재 행렬의 전치 행렬을 표현하는 새로운 MyMatrix 객체를 생성하여 리턴
	public MyMatrix transpose() {
		int[][] m = new int[column][row]; // 행, 열 바꾼 2차월 배열 생성 
		for(int i = 0; i < row; i++) { // 새로 만든 2차원 배열에 값 저장하기 위해 반복문 사용 
			for(int j = 0; j < column; j++) {
				m[j][i] = array[i][j];
			}
		}
		return new MyMatrix(column, row, m);
	}
	
	// 행렬의 모든 원소들을 하나의 문자열로 만들어 리턴 (한 행이 한 줄에 표시되도록 함)
	@Override
	public String toString() {
		String matrix = ""; // 한 행이 한 줄에 표시될 수 있도록 한 행의 값들을 저장할 문자열 객체 선언  
		for(int i = 0; i < row; i++) { // 반복문으로 matrix에 값을 저장 
			for(int j = 0; j < column; j++) {
				matrix += array[i][j] + " ";
				if(j == column - 1) { // 열에서 1을 뺀 값이 각 행의 마지막 열이기 때문에 줄을 바꿔야 함 
					matrix += ("\n"); // 줄 바꾸기 
				}
			}
		}
		return matrix; // 한 행이 한 줄에 표시되도록 값을 저장한 matrix를 리턴 
	}
}
public class MyMatrixTest {
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		Random rd = new Random(); // 랜덤 객체 생성 
		
		System.out.println("hw5_1");
		System.out.println(); // 줄 바꾸기 
		
		System.out.print("행의 개수 입력: "); 
		int row = sc.nextInt(); // 행의 개수 입력받기 
		System.out.print("열의 개수 입력: ");
		int column = sc.nextInt(); // 열의 개수 입력받기 
		System.out.println(); // 줄 바꾸기 
		
		MyMatrix matrix = new MyMatrix(row, column); //row행 column열 크기의 행렬인 MyMatrix 객체 생성(matrix)
		
		// matrix의 원소들을 1~9 범위의 랜덤 정수값으로 각각 지정 (반복문 사용)
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < column; j++) {
				matrix.set(i, j, rd.nextInt(9 - 1 + 1) + 1);
			}
		}
		// matrix 출력 
		System.out.println("matrix = ");
		System.out.println(matrix.toString());
		
		// matrix의 전치 행렬인 새로운 행렬 객체 transposedMatrix를 구함 
		MyMatrix transposedMatrix = matrix.transpose();
		
		// transposedMatrix 출력 
		System.out.println("transposedMatrix = ");
		System.out.print(transposedMatrix);
		
		System.out.println(); // 줄 바꾸기 
		
		// matrix 출력 
		System.out.println("matrix = ");
		System.out.println(matrix.toString());
		
		sc.close();
	}
}