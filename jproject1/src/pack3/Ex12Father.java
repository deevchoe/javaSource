package pack3;

public class Ex12Father extends Ex12GrandFa{	// 단일 상속만 가능
	//Ex12GrandFa fa = new Ex12GrandFa();		// 포함관계
	
	public String gabo = "꽃병";		// 은닉화
	private int nai = 55;
	private int house = 1;
	
	public Ex12Father() {
		//super();	// 매개변수가 없는 부모 생성자 호출
		System.out.println("아버지 생성자");
		
	}
	
	public Ex12Father(int n) {
		System.out.println("아버지 생성자라고 해");
	}
	
	@Override	// 오버라이딩 체크 기능 : 메소드가 부모 메소드와 이름이 같은지 알려줌
	public int getNai() {	// Method overriging(오버라이딩)
		return nai;
	}
	
	public String say() {
		return "아버지 말씀 : 에러 잡는 연습을 하거라";
	}
	
	final public String getHouse() {	// 메소드에 final하면 자식 클래스에서 오버라이딩 불가
		return "집 : " + house + "채";
	}
	
	public void showData() {
		System.out.println("아버지 나이 " + nai);
		System.out.println("아버지 나이 " + this.nai);
		System.out.println("아버지 나이 " + getNai());		// 현재 클래스에서 getNai를 찾아. 없으면 부모에게 가서 찾아!
		System.out.println("아버지 나이 " + this.getNai());	// this는 현재 클래스에서 getNai를 찾아. 없으면 부모에게 가서 찾아!
		
		//System.out.println("할아버지 나이 " + super.nai);	// 에러
		System.out.println("할아버지 나이 " + super.getNai());	// super는 처음부터 부모에게 가서 찾아!
		
		System.out.println();
		String gabo = "물병";
		System.out.println("가보 " + gabo);	// 현재 블록 내에서 뒤지기 때문에   출력값 : 물병
		System.out.println("가보 " + this.gabo);	// 현재 클래스를 뒤져서 있으면 그거 출력 없으면 부모에게 가서 찾아서 출력    근데 있으니까 출력값은 꽃병
		System.out.println("가보 " + super.gabo);	// 부모에게 바로 가서 찾아서 있으면 값 출력 출력값은 상감청자
		
	}
}
