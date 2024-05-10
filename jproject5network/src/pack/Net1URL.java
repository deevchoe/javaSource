package pack;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;

// URL 클래스로 특정 웹 서버 컴의 문서 읽기
// 인터넷이 가능한 서버들의 자원에 접근하여 주소 및 기타 정보를 다루는 클래스
public class Net1URL {
	public static void main(String[] args) {
		try {		// 네트워크니까 당연히 써줘야겠지~
			URL url = new URL("https://www.daum.net");
			// https://www.naver.com:443/index.html
			// http 보안용 서버 ==> https. tcp 프로토콜 기반 응용프로그램 계층에서 사용
			// 메인 페이지는 보통 index.html로 되어 있다.
			InputStream is = url.openStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
			//System.out.println(br.read());
			
			// 읽은 문서 파일로 저장
			PrintWriter pw = new PrintWriter(System.out, true);	// 표준 출력장치로 내보내고.      자료를 찍고난 다음엔 메모리 상에 데이터는 지워버려 auto flush 기능
			PrintWriter fw = new PrintWriter(new FileOutputStream("d:/Study/Academy/Acorn/ok.html"));	// 파일로 내보낼게요
			String line = "";
			while((line = br.readLine()) != null) {
				pw.println(line);	// 콘솔로 출력
				fw.println(line);	// file로 저장
				fw.flush();
			}
			br.close();
			is.close();
			pw.close();
			fw.close();
		} catch (Exception e) {
			System.out.println("err : " + e);
		}
	}

}
