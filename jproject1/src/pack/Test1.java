package pack;

public class Test1 {
	public static void main(String[] args) {
		System.out.println("성공!");
		System.out.println("단축키를 사용하자");
		System.out.print("자바");
		System.out.print("변수");
		System.out.println("연습");
		// 한 줄 주석
		/*
		  여러 줄
		  주석. 실행에 참여 안함
		 */
		
		System.out.println("주석 연습"); // 한 줄 주석
		
		System.out.println("---변수 연습---");
		// 기본형 : bcbsilfd - 값을 변수가 직접 기억 boolean/ char / byte? / short / int / long / float / double
		// 참조형 : 객체 - 객체의 주소를 변수가 기억
		// byte : 하나의 단위로 이루어진 이진 문자(bit)의 집합
		// 8bit로 1byte를 구성하는 것이 일반적
		
		// 숫자형 기억장소 : 변수 선언 방법 -> 타입 변수명
		byte var1;	// 1byte 정수 기억장소 -128 ~ 127
		var1 = 3;
		var1 = 5;	// 변수는 이렇게 덮어씌우기 가능
		System.out.println(var1);
		System.out.println(Byte.MAX_VALUE);
		System.out.println(Byte.MIN_VALUE);
		System.out.println("-----------");
		short var2 = 123;	// 2byte 정수 기억장소
		System.out.println(var2);
		
		System.out.println("-----------");
		int var3 = 123;	// 4byte 정수 기억장소
		System.out.println(var3);
		
		System.out.println("-----------");
		long var4 = 123;	// 8byte 정수 기억장소
		var4 = 12345678912345L;
		System.out.println(var4);
		
		System.out.println("형변환에 대해 : 자동형변환(promotion), 강제형변환(casting)");
		// 자바에서 정수는 int로 인정
		short ss = 10;	// promotion 즉,  int를 short으로 자동형변환이 된거
		short ss2 = (short)10;	// casting 위 식과 같은 식
		System.out.println(ss + " " + ss2);		// 여기서 +는 문자열 더하기  ss, ss2 (x) 이 표현은 다른 언어 자바에서는 ss + ss2라고 하면 20이 되어 버림
		short ss3 = (short)50000;
		System.out.println(ss3);
		
		int imsi = 123;
		// short ss4 = 123;
		short ss4 = (short)imsi;
		System.out.println(ss4);
		
		System.out.println("--------------------------------------");
		// 자바에서 실수는 double로 인정 (기본)
		double d1 = 1.2;	// 8byte
		d1 = 12.345;
		d1 = 12345;		// promotion(자동형변환) 정수는 실수 기억장소에 기억될 때 실수로 자동형변환 그래서 결과가 12345.0
		System.out.println(d1);
		
		// 아래 두개가 같은 식
		float f1 = 12.3F;		// casting(강제형변환)		4byte
		float f2 = (float)12.3;
		
		//연산시 큰 타입으로 자동변환
		double result = 4.5 + 10;	// double + int 시 더 큰 타입인 double로 자동변환
		result = 4.5 + (double)10;
		result = (int)4.5 + 10; // 강제로 실수를 정수화할 때 버림 발생
		// 실수를 정수로 바꾼거(강제로) 소수점이하로 버림 4+10인데 실수형 저장소에 값을 저장하기 때문에 결과값은 14.0
		System.out.println(result);
		
		double dd = 5.5;
		//int result2 = 4.5 + 10; // 실수가 정수 자리에 들어갈 수 없기 때문에 type mistmatch error
		int result2 = (int)(4.5 + 10);		// 연산자 우선순위에 의해 4.5 + 10 하고 그 결과를 정수화
		// 4.5 + 10하고 그 결과를 int(정수)로 바꾸고 result2에 치환
		// result2 = (int)4.5 + dd;	// dd = double 4.5는 정수로 바꿔버림 int + double 타입이 안맞아서 mismatch error / result2 = int형이어서 mismatch 에러
		result2 = (int)4.5 + (int)dd;	// 4 + 5   => 강제형변환
		System.out.println(result2);
		
		System.out.println("지금부터는 논리형(boolean) - 참, 거짓 결과 기억");
		boolean bu1 = true;	// 1byte
		bu1 = false;
		System.out.println(bu1);
		
		System.out.println("지금부터는 문자형(char) - Ascii 코드표에 등록된 문자");
		char c1 = 'a';
		// c1 = 'kbs'; // char는 하나의 문자만 써야되기 때문에 에러다.
		c1 = 'k';
		// c1 = "a"; // string을 어떻게 char에 주려고 하니 그렇기 때문에 에러다! "문자열" '문자'의 차이
		c1 = '7'; // 숫자 아니다. 문자다! ''로 감싸줬기 때문에!
		c1 = 'A';
		System.out.println(c1);
		System.out.println(c1 + " " + (int)c1 + " " + 65 + " " + (char)65); // 형변환 // 대문자 A는 아스키 코드로 65
		
		System.out.println("안녕" + 13 + "반가워");
		
		System.out.println("안녕" + (char)13 + "반가워");
		System.out.println("안녕" + "\n" + "반가워"); // 자바 이스케이프 문자 정리
		System.out.println("안녕\n반가워");
		
		System.out.println();
		System.out.println(11 + " " + 0xb + " " + 013); // 다 11임    11(10진수) / 0xb(16진수) / 013(8진수)
		
		System.out.println("\n---문자열 처리-------------");
		// String : 참조형 객체이지만 기본형처럼 사용할 수 있도록 자바가 배려
		String irum = "홍길동";	// 홍길동 객체의 주소를 irum이란 변수가 기억
		System.out.println(irum + "님 만세");
		
		System.out.println();
		// 상수 : final type 변수명 = 값(리터럴, literal)
		// 리터럴은 데이터(값) 그 자체를 뜻한다. 즉, 변수에 넣는 변하지 않는 데이터를 의미하는 것.
		// 한 번 저장된 값은 수정 불가
		final int kbs = 9;
		// kbs = 11; 지역변수 kbs는 새로운 값을 치환받을 수 없어! 수정불가!
		System.out.println("kbs : " + kbs);
		
		final double PI = 3.14; // final 변수 ( = 상수)는 대문자로 쓰기를 권장
		System.out.println("pi : "+ PI);
		
		System.out.println("기본형 변수에 대한 이야기 끝!");
	}
}
