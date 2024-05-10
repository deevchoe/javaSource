package pack;

public class Student {
	private String name;
	private int kor, eng;
	
	public Student() {
		
	}
	
	public Student(String name, int kor, int eng) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public static void main(String[] args) {
		Student myStudent = new Student("최지연", 80, 60);
		System.out.println("이름 : " + myStudent.getName());
		System.out.println("국어 점수 : " + myStudent.getKor());
		System.out.println("영어 점수 : " + myStudent.getEng());

	}

}
