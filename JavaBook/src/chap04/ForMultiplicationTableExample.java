package chap04;

public class ForMultiplicationTableExample {
	public static void main(String[] args) {
		
		for(int m = 2; m <= 9; m++) {	// 바깥쪽 for문
			System.out.println("===" + m + "단 ===");	// 먼저 한번 실행	=> 바깥쪽 for문이 실행이 완료되면 또 한번 실행
			for(int n = 1; n <= 9; n++) {	// 중첩 for문		=> 바깥쪽 for문이 한번 실행되면 얘는 9번 실행
				System.out.println(m + " x " + n + " = " + (m*n));
			}
		}

	}
}
