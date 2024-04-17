package pack;

import java.util.Scanner;

public class Test7For {

	public static void main(String[] args) {
		// 반복문 for
		// for(초기치; 조건; 증감치){반복 처리 대상}
		int a;
		//for(int a = 1; a <= 5; a = a + 1) {
		//for(a = 1; a <= 5; a= a + 1) {
		//for(a = 1; a <= 5; a+= 1) {
		
		int sum = 0;	// 누적 기억장소
		
		for(a = 1; a <= 10; a++) {
			System.out.println("a : " + a);
			//a = 4;      a가 값이 증가해도 a의 값이 계속 4가 되기 때문에 무한루프
			sum += a;
		}
		System.out.println("반복문 수행 후 a : " + a);
		System.out.println("합은 " + sum);
		
		for (int i = 65; i <= 90; i++) {
			System.out.print((char)i + " ");
		}
		System.out.println();
		for (int i = 'A'; i <= 'Z'; i++) {
			System.out.print(i + " ");
		}
		System.out.println();
		for(int i = 10; i > 1; i -= 2) {
			System.out.print(i + " ");
		}
		
		System.out.println();
		for(int ytn = 0, tvn = 5; ytn <= 5; ytn++, tvn++) {
			System.out.print(ytn + "," + tvn + ":");
		}
		
		System.out.println();
		int aa = 1;
		for(; aa <= 5; aa++) {
			System.out.print(aa + " ");
		}
		
		System.out.println("\n\n다중 for ------------");
		for(int m = 1; m <= 3; m++) {
			System.out.println("m=" + m);
			for(int n = 1; n <= 4; n++) {
				System.out.print("n:" + n + " ");
			}
			System.out.println();
		}
		
		System.out.println();
		for(char i = 65; i <= 90; i++) {
			System.out.print(i + " : ");
			for(char j = i; j <= 'Z'; j++) {
				System.out.print(j);
			}
			System.out.println();
		}
		
		System.out.println();
		// 구구단 3단 출력
		for(int count = 1; count < 10; count++) {
			System.out.println("3 X " + count + " = " + (3 * count));
		}
		
		//문제 1 : 키보드로 숫자를 받아 구구단 출력
		// 예) 몇 단? 3단
		// 3 * 1 = 3 3 * 2 = 6 ...
		Scanner sc = new Scanner(System.in);
		System.out.print("몇 단?");
		int num = sc.nextInt();
		for(int i = 1; i <= 9; i++) {
			System.out.print(num + " X " + i + " = " + (num * i) + "    ");
		}
		
		System.out.println();
		
		//문제 2 : 1 ~ 100 사이의 정수 중 3의 배수이면서 5의 배수의 갯수와 그 합을 출력
		int num2 = 0;
		int sum2 = 0;
		// int num2, sum2 = 0;
		for(int i = 1; i <= 100; i++) {
			if (i % 3 == 0 && i % 5 == 0) {
				num2++;
				sum2 += i;
			}
		}
		System.out.println("개수 : " + num2 + ", 합 : " + sum2);
		
		//문제 3 : 2 ~ 9단까지 출력 (다중 for)
		// 2 * 1 = 2 2 * 9 = 18 ...
		// ...
		// 9 * 1 = 2 9 * 9 = 81 ...
		for(int i = 2 ; i <= 9; i++) {
			System.out.println();
			for(int j = 1; j <= 9; j++) {
				System.out.print(i + " X " + j + " = " + (i * j) + "    ");
			}
		}
	}

}
