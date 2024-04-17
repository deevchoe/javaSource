package pack1;

public class Ex2Car {
	private int speed; // private int speed=0 과 같다
	public String irum;
	private double weight;	// private double weight=0.0 과 같다.

	public Ex2Car() {               // 객체가 생성될 때  
		irum = "홍길동";
		speed = 10;
	}

	public void showData() {
		System.out.println("이름은 " + irum + ", 속도는 " + speed);
	}

//	public void abcd(int s, int password) {	// private 멤버값을 외부에서 접근하기 위한 메소드
	public void setSpeed(int s) { // speed에만 집중        // 주고 싶을 때
		speed = s;
		//return;
	}
	
	public int getSpeed() {		// getter 메소드    
		return speed;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
		// 멤버필드 weight에 지역변수 weight 값을 치환
		// 지역변수의 이름과 멤버필드(전역변수)가 같을 때 구분하기 위해 this라는 키워드를 붙여준다.
		// 현재 클래스 내에 있는 멤버필드에 this 키워드를 붙여줌
	}
}
