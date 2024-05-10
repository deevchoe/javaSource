package debugtest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import debug.Calculator;

public class CalculatorTest {
	//Calculator calculator = new Calculator();
	Calculator calculator;
	
	@Before
	public void setup() {
		calculator = new Calculator();
	}
	
	@Test
	public void testPlus() {
		assertTrue(calculator.plus(8, 4) == 12);

		int a = 8, b = 7;
		assertEquals(a, 8); 	// 변수의 값이 같은지 확인
		
		int[] arr = {0, 0};
		int arr2[] = new int[2];
		assertArrayEquals(arr, arr2); 	 	// 배열 요소 값 비교
	}

	@Ignore
	@Test
	public void testMulti() {		// testMulti()는 Ignore 했기 때문에 대상이 아님
		fail("Not yet implemented");
	}

	@Test(timeout = 1000)	// 1초 단위로 수행시간 검사
	public void testDivide() {
		assertTrue(calculator.divide(8, 4) == 2);
		//assertTrue(calculator.divide(10, 4) == 2.5);
		
		for(int i = 0; i < 1000000; i++) {
			System.out.print(i + " ");   // 수행시간 확인
			// db를 연결하는데 몇 초 안에 연결되는지 확인하고싶어. 
			// 빅데이터 처리할때 어느 정도 시간이 걸렸음 좋겠어. 
			// 외부 장치하고 연결 시간 테스트 할 때 실행
		}
	}

}
