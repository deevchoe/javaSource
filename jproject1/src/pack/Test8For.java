package pack;

public class Test8For {

	public static void main(String[] args) {
		// 반복문 : continue, break
		System.out.println("뭔가를 하다가...");
		
		for(int i = 1; i <= 10; i++) {
			System.out.println(i);
			if(i == 3) continue;	// continue = 아래 문장을 무시   위 for문으로 복기
			if(i == 5) break;	// break = 멈춰!   자기가 있는 블록에서 자기 자리에서 끝내는거
			//if(i == 5) System.exit(0); 아예 프로그램을 끝내는거
			System.out.println("금요일");
		}
		
		System.out.println();
		int kk = 0;
		for(;;) {
			kk++;
			System.out.println("무한 반복 출력");
			if(kk == 10) break;
		}
		
		System.out.println();
		kbs:for(int i = 1; i <= 3; i++) {
			mbc:for(int j = 1; j <= 5; j++) {
				System.out.print(i + " " + j + "  ");
				// if(j == 3) continue; // mbc로 복기
				if(j == 3) continue kbs; // 해당 label로 분기      kbs로 복기 
				if(j == 5) break kbs; // kbs 블럭을 빠져나감
			}
			System.out.println("~~~~~~");
		}
	}
}
