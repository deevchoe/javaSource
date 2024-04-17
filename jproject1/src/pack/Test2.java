package pack;

public class Test2 {
	public static void main(String[] args) {
		// 응용 프로그램의 시작 메소드(method(행위))
		
		// int a;	// 치환 연산자. 오른쪽의 최종 결과값을 왼쪽 기억장소에 저장
		// a = 5;
		int a = 5;
		int b = 3;
		int c = a + b;
		System.out.println("c는 " + c);
		
		System.out.println("산술 연산자 연습 ----------");
		System.out.println(a + b);
		System.out.println(a - b);
		System.out.println(a * b);
		System.out.println(a / b);	// 몫만
		System.out.println(a % b);	//  나머지만
		System.out.println(a / (double)b);	// 결과가 실수
		// 몫과 나머지 모두 (double)을 붙여 실수 연산이 되었기 때문
		
		System.out.println(3 + 4 * 5);	// *,/가 +,- 보다 우선순위 높음
		System.out.println((3 + 4) * 5);	// () 소괄호 내의 연산순위가 가장 높다
		
		//System.out.println(a / 0);	// 0으로 나눌 수 없어용  정수연산인 경우 에러  ArithmeticException: / by zero
		System.out.println(a / 0.0);	// 실수연산인 경우 Infinity(무한대)
		System.out.println(a % 0.0);	// NaN(Not a Number) 숫자가 아니라 표현할 수 없는 상태
		
		System.out.println("문자열 더하기 연산 : +");
		String ss1 = "배가";
		String ss2 = "고파";
		String ss3 = ss1 + ss2;
		System.out.println(ss3);
		System.out.println(ss3 + " " + 123);	// 숫자가 문자열로 자동 변환 후 연산
		System.out.println(ss3 + " " + 123 + 100);
		System.out.println(ss3 + " " + (123 + 100));
		// String ss4 = 5 + 6;		// 정수는 문자열로 그냥 들어갈 수 없기 때문에 type mistmatch
		String ss4 = "5" + 6;	// 자동형변환
		System.out.println(ss4);
		String ss5 = Integer.toString(5) + 6;	// 강제형변환    int를 클래스화     int 기본형 클래스는 Integer (wrapper class)
		System.out.println(ss5);
		String ss6 = Double.toString(5) + 6;
		System.out.println(ss6);
		
		System.out.println();
		int abc = 5 + Integer.parseInt("6");
		System.out.println(abc);
		double abc2 = 5 + Double.parseDouble("6.7");
		System.out.println(abc2);
		
		// 누적
		int no = 1;
		no = no + 1; // 사람이 좋아해
		no += 1;	 // 기계가 좋아해 왜? 속도가 빨라서
		no++; // 후위 증감연산자       1씩만 증감 가능
		++no; // 전위 증감연산자       1씩만 증감 가능
		System.out.println("no : " + no);
		
		int imsi = 5;
		int result = ++imsi + 1; // imsi가 연산 전에 1 증가
		// 6이 되고 1더함
		System.out.println("imsi : " + imsi);
		System.out.println("result : " + result);
		
		int imsi2 = 5;
		int result2 = imsi2++ + 1;	// imsi2가 연산 후에 1 증가
		// 더하고 늘어남 5+1해서 그 결과가 result2에 들어가고 나서야 1이 더해짐
		System.out.println("imsi : " + imsi2);
		System.out.println("result : " + result2);
		// 주의 증감연산자는 다른 연산자와 함께 쓰지 않도록 권장
		
		// 부호 관련
		int imsi3 = 3;
		System.out.println(imsi3);
		
		// 양수를 음수로 바꾸는 2가지 방법
		System.out.println(-imsi3);
		System.out.println(imsi3 * -1);
	}
}
