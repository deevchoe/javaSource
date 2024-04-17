package pack4;

public class Ex30StudentDto {
	// 레코드 단위 기억장소
	// type이 다른 여러 개의 기억장소를 하나의 묶음으로 만들어 자료 전송을 하는 것이 목적
	private String hakbun, irum;
	private int jumsu;
	
	public Ex30StudentDto() {	// 생성자를 쓰고 싶으면 내용이 없는 생성자도 만들어줘야해~
		
	}
	
	public Ex30StudentDto(String hakbun, String irum, int jumsu) {
		this.hakbun = hakbun;
		this.irum = irum;
		this.jumsu = jumsu;
		// 생성자를 통해 멤버필드에 값을 줄 경우에는 setter가 필요 없다.
		// 아냐아냐 생성자 싫어!! 하면 getter setter 쓰면 됨
	}

	public String getHakbun() {
		return hakbun;
	}

	public void setHakbun(String hakbun) {
		this.hakbun = hakbun;
	}

	public String getIrum() {
		return irum;
	}

	public void setIrum(String irum) {
		this.irum = irum;
	}

	public int getJumsu() {
		return jumsu;
	}

	public void setJumsu(int jumsu) {
		this.jumsu = jumsu;
	}
	
	
	
}
