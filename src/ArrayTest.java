/*
 * 2021.9.15
 * 배열 연습 
 */
package hw3_1;
import java.util.Scanner;

public class ArrayTest {
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("hw3_1");
		
		System.out.print("정수 개수 입력: ");
		int n = sc.nextInt(); // 정수 개수 입력받기 (배열 원소 수)
		int [] arr = new int[n]; // 크기가 n인 int형 배열을 생성 
		int count = 0; // 최대값 개수를 확인할 변수 
		
		System.out.print(n + "개의 정수 입력: ");
		for(int i = 0; i < n; i++) { // n개의 정수 입력받기 
			arr[i] = sc.nextInt(); // 입력받은 정수 배열에 저장
		}
		
		int max = arr[0]; // 최대값
		
		for(int i = 0; i < arr.length; i++) { // 최대값 구하기 
			if (arr[i] > max) {
				max = arr[i];
			}
		}
		
		for(int i = 0; i < arr.length; i++) { // 최대값 개수 구하기 
			if(arr[i] == max) { 
				count++;
			}
		}
		
		System.out.print("최대값 제외 = ");
		for(int i = 0; i < arr.length; i++) { // 최대값 제외한 정수 출력 
			if(arr[i] != max) {
				System.out.print(arr[i] + " ");
			}
		}
		
		System.out.println(); // 한줄 띄어쓰기
		System.out.println("최대값 개수 = " + count); // 최대값 개수 출력 
	}
}
