package pack1;

public class Ex1Main {	// 응용 프로그램의 시작, 즉 main을 위한 클래스일 뿐.
	public static void main(String[] args) {
		System.out.println("이런 저런 작업을 하다가...");
		int a = 1;	// int는 전문가가 만든 타입
		System.out.println("기본형 변수 a가 기억한 값 : " + a);   // 기본형 변수 = 값 자체를 기억함
		
		System.out.println();
		// 자동차 객체를 만들고 싶어...
		Ex1Car car1 = new Ex1Car();		// 클래스 --> 인스턴스화 --> 인스턴스(객체)
		// Ex1Car는 우리가 직접 생성한 타입
		// Ex1Car : 보조기억장치에 있는 Ex1Car.class를 주기억장치로 로딩   //클래스
		// car1 : 객체 변수 - 객체의 주소를 기억  // 참조형 변수
		// new : 인스턴스화를 키워드
		// Ex1Car() : 생성자를 호출     // 생성자
		System.out.println("Ex1Car 타입의 생성된 객체 주소 : " + car1);    // car1 = 참조형 변수   = 주소를 기억함
		System.out.println("바퀴 수 : " + car1.wheel);  // 멤버 변수 호출
		car1.abc(); // 멤버 메소드 호출 괄호가 있으니까... 메소드..
		//car1.def();	private이므로 호출 불가
		System.out.println("객체 하나 더 생성 ---");
		Ex1Car car2 = new Ex1Car();
		System.out.println("Ex1Car 타입의 생성된 객체 주소 : " + car2);
		System.out.println("바퀴 수 : " + car2.wheel);
		car2.abc();
		
		System.out.println();
		System.out.println(car1.getClass());	// 객체변수 타입 확인
		System.out.println(car2.getClass());
		System.out.println(car1.getClass() == car2.getClass());	// 타입비교
		System.out.println(car1 == car2);	// 주소비교

	}

}
