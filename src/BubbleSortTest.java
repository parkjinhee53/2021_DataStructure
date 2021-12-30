package hw11_1;

import java.util.Random;
import java.util.Scanner;

public class BubbleSortTest {
	public static void main(String[] args) {
		System.out.println("hw11_1");
		Scanner sc = new Scanner(System.in);
		
		// (1) 정수 개수(n)를 입력받아 크기 n인 int형 배열을 생성
		System.out.print("정수 개수 입력: ");
		int n = sc.nextInt();
		int[] arr = new int[n];
		
		// (2) n개의 랜덤 정수값을 생성하여 배열에 저장 
		Random random = new Random();
		for(int i = 0; i < n; i++) {
			arr[i] = random.nextInt();
		}
		
		// (3) 정렬 전 배열 원소들을 출력
		System.out.print("정렬 전 = ");
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println(); // 줄 바꾸기
		
		// (4) 배열 원소들을 버블 정렬
		bubbleSort(arr);
		
		// (5) 정렬 후 배열 원소들을 출력
		System.out.print("정렬 후 = ");
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		
		sc.close();
	}
	// 배열 arr에 저장된 원소들을 오름차순으로 버블 정렬 
	private static void bubbleSort(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr.length - i -1; j++) {
				if(arr[j] > arr[j+1]) {
					int a = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = a;
				}
			}
		}
	}
}
