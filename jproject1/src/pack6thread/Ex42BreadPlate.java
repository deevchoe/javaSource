package pack6thread;

public class Ex42BreadPlate {
	private int breadCount = 0;		// 스레드 간 자원 공유 대상
	
	public Ex42BreadPlate() {
		
	}
	
	// 현재 메소드를 스레드로 호출하면 해당 스레드의 처리가 진행되는 동안 락이 걸림
	public synchronized void makeBread() {
		if(breadCount >= 10) {
			try {
				System.out.println("빵 생산 목표 초과(10개 기준)");
				wait();		// thread를 not runnable 상태로 만듦
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		}
		
		breadCount++;	// 빵을 만듦
		System.out.println("빵 생산 총 개수 : " + breadCount + "개");
		notify();	// thread를 runnable 상태로 되돌림
	}
	
	public synchronized void eatBread() {
		if(breadCount < 1) {
			try {
				System.out.println("빵이 없어 기다림");
				wait();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		breadCount--;	// 빵을 소비
		System.out.println("빵 소비 후 총 개수 : " + breadCount + "개");
		notify();
	}
	
}
