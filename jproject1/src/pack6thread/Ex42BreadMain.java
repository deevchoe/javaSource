package pack6thread;

public class Ex42BreadMain {

	public static void main(String[] args) {
		// 스레드 간 자원 공유 및 스레드 활성화/비활성화 연습
		Ex42BreadPlate breadPlate = new Ex42BreadPlate();
		
		Ex42BreadMaker maker = new Ex42BreadMaker(breadPlate);
		Ex42BreadEater eater = new Ex42BreadEater(breadPlate);
		// 메인스레드에 의한 싱글테스킹
		//maker.run();
		//eater.run();
		
		// 사용자 정의 스레드에 의한 멀티 테스킹
		maker.start(); 		
		eater.start();
	}

}
