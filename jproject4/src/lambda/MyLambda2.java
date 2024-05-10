package lambda;

@FunctionalInterface
interface MyInter{
	void aaa();		// 아규먼트도 리턴값도 없는 메소드
}

interface MyInterArg{	// 반환값이 없는 메소드
	void bbb(int a, int b);
}

interface MyInterArgReturn{		// 반환값이 있는 메소드
	int ccc(int a, int b);
}


public class MyLambda2 {

	public static void main(String[] args) {
		// 1. 인자가 없은 추상 메소드 처리 : 전통적
		MyInter inter = new MyInter() {
			@Override
			public void aaa() {
				System.out.println("익명 클래스의 aaa 메소드 오버라이딩");
			}
		};
		inter.aaa();
		
		// 람다식으로 표현 1
		MyInter inter2 = () -> 
			System.out.println("익명 클래스의 aaa 메소드 오버라이딩:람다"); 	// 바디 내 수행할 문장이 하나면 중괄호{} 생략 가능
		
		inter2.aaa();
		
		MyInter inter3 = () -> {
			int imsi = 10;
			System.out.println("람다식으로");
			System.out.println(" 복수의 명령문 처리");
			System.out.println("imsi : " + imsi);
		};
		inter3.aaa();
		
		System.out.println("---------");
		// 2. 인자가 있는 추상 메소드 처리 : 전통적
		MyInterArg interArg = new MyInterArg() {
			
			@Override
			public void bbb(int a, int b) {
				System.out.println("두 수의 합은 " + (a + b));
			}
		};
		interArg.bbb(3, 4);
		
		// 람다식으로 표현 2 : arg가 1개일 경우 (a) -> 또는 a -> 로 적용
		MyInterArg interArg2 = (a, b) // 메소드명은 안쓴다. 메소드가 하나밖에 없으니까!!!
				-> System.out.println("람다로 두 수의 합은 " + (a + b));	
		interArg2.bbb(3, 4);
		
		System.out.println("---------");
		// 3. 인자가 있고 반환값도 있는 추상 메소드 처리 : 전통적
		MyInterArgReturn argReturn = new MyInterArgReturn() {
			@Override
			public int ccc(int a, int b) {
				System.out.println("ccc 처리");
				return a + b;
			}
		};
		int result = argReturn.ccc(5, 6);
		System.out.println("두 수를 더한 결과 : " + result);
		
		// 람다식으로 표현 3
		MyInterArgReturn argReturn2 = (m, n) -> (m + n);	// 수행할 문장이 하나인 경우

		MyInterArgReturn argReturn3 = (m, n) -> {
			System.out.println("ccc 수행");		// 수행할 문장이 2개 이상인 경우 return도 써야됨
			return m + n;
		};
		int result2 = argReturn3.ccc(5, 6);
		System.out.println("두 수를 더한 결과2 : " + result2);
	}

}
