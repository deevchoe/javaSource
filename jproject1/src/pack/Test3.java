package pack;

public class Test3 {

	public static void main(String[] args) {
		// 관계, 논리 연산자
		int a = 5;
		
		System.out.println(a > 3);	// 관계 연산자
		boolean bo = a > 3;
		System.out.println(bo);
		System.out.println(a >= 3);
		System.out.println(a <= 3);
		System.out.println(a == 3);
		System.out.println(a != 3);
		
		System.out.println();
		int b = 10;
		System.out.println(a > 3);
		System.out.println(b > 3);
		System.out.println(a > 3 && b > 3); 	// 논리 연산자 and (논리곱)
		System.out.println(a > 3 && b <= 3);
		
		System.out.println(a > 3 || b > 3); 	// 논리 연산자 or (논리합)
		System.out.println(a > 3 || b <= 3);
		System.out.println(a < 3 || b <= 3);
		
		System.out.println(a < 3 || b <= 1 + 1 * 1);
		boolean bb = a < 3 || b <= 1 + 1 * 1;
		System.out.println(bb);
		// 연산자 우선순위 : ()소괄호 > 산술(*, / > +, -) > 관계 > 논리 > 치환
		
		System.out.println("\n\nshift 연산 -------------");
		// int ii = 8, ij;		// ii,와 ij를 선언한거 ii = 8을 갖고있고 ij는 아무것도 없음
		int ii = 8, ij = 0;
		System.out.println("ii : " + Integer.toBinaryString(ii)); // 10진수 8을 2진수 8로 변환
		
		ij = ii << 1;	// << : shift 연산자      << 좌측으로 1bit 이동. 남는 우측은 0으로 채움
		System.out.println("ii : " + ii + ", ij : " + ij);	// 지역변수 ij 초기화 필요
		
		ij = ii >> 1;	// << 우측으로 1bit 이동. 남는 좌측은 부호(0:양수, 1:음수)와 같은 값으로 채움
		System.out.println("ii : " + ii + ", ij : " + ij);
		
		ij = ii >>> 2;	// << 우측으로 2bit 이동. 남는 좌측은 0으로 채움
		System.out.println("ii : " + ii + ", ij : " + ij);
		
		System.out.println("삼항 연산자  (조건)?참일때값:거짓일때값");
		int sbs = 3;
		int mbc = (sbs > 5)?100:10 + 20 * 2;
		System.out.println(mbc);
		
		System.out.println();
		int x, y, z;
		x = y = z = 5;
		System.out.println(x + " " + y + " " + z);
		
		System.out.println("논리 연산자에서 주의할 점 -------");
		/*
		aa();
		System.out.println(aa());
		
		boolean imsi = aa();
		System.out.println(imsi);
		*/
		
		// boolean a1 = false, b1 = true, c1;
		boolean a1 = true, b1 = false, c1;
		c1 = a1 || b1;	// or
		System.out.println("c1 : " + c1);
		c1 = a1 && b1;	// and
		System.out.println("c1 : " + c1);
		
		System.out.println();
		boolean b2, b3;
		b1 = aa();
		System.out.println(b1);
		System.out.println(bb());
		
		System.out.println("~~~~~~~~~~~");
		//b2 = aa() || bb(); // aa() 수행 결과가 참이므로 bb() 수행 안함     ||가 둘 중 하나가 참이면 참이니까
		//b2 = bb() || aa(); // bb()가 false라 aa() 값도 출력
		b2 = aa() | bb();	// or연산 : 모든 메소드 호출
		System.out.println(b2);
		
		System.out.println();
		// b3 = aa() && bb();	// 둘 다 참일때만 참이기 때문에 aa() bb()의 결과 모두 봄
		// b3 = bb() && aa();		// bb()가 false라 aa() 수행안함
		b3 = bb() & aa();
		System.out.println(b3);
		
		System.out.println("프로그램 종료");
		
		System.out.println("연산자 얘기 끝!");
	}
	
	public static boolean aa() {
		System.out.println("aa 출력");
		return true;
	}
	
	public static boolean bb() {
		System.out.println("bb 출력");
		return false;
	}

}
