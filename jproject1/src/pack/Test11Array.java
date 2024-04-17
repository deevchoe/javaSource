package pack;

public class Test11Array {

	public static void main(String[] args) {
		// main 메소드의 매개변수
		if(args.length == 0) {
			System.out.println("실행 시 값을 주세요");
			System.exit(0);
		}
		
		System.out.println(args.length);
		for(int i = 0; i < args.length; i++) { //0부터 2보다 작은동안
			System.out.println(args[i]);
		}
		System.out.println();
		for(String imsi:args) {
			System.out.println(imsi);
		}

		System.out.println("응용 프로그램 종료");

	}

}
