package pack;

import java.net.URLEncoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

// 제3자가 제공하는 라이브러리(jsoup.jar)를 사용해 웹 스크래핑
// HTML 문서 데이터 구문 분석, 자료 추출 및 조작용 오픈 소스
public class Net2 {
	public static void main(String[] args) {
		// 위키백과 사이트에서 검색 결과 읽기
		
		//https://ko.wikipedia.org/wiki/자바   ==> X!!! 이렇게 쓰면 안돼!!
		
		//https://ko.wikipedia.org/wiki/%EC%9E%90%EB%B0%94
		// 위처럼 자바를 인코딩해줘야해 2진형태로 바꿔줘야만돼~~
		
		try {
			System.out.println(URLEncoder.encode("자바","UTF-8"));
			
			String url = "https://ko.wikipedia.org/wiki/" + URLEncoder.encode("자바","UTF-8");
			// Document : 웹페이지 문서
			Document doc = Jsoup.connect(url).get(); 
			String text = doc.text();	// 웹 문서에 텍스트를 모두 읽음
			//System.out.println(text);
			
			printKoreanText(text);		// 읽어온 자료에 대해서 한글만 추출
		} catch (Exception e) {
			System.out.println("err : " + e.getMessage());
		}
	}
	
	private static void printKoreanText(String text) {
		// 정규 표현식을 사용해서
		// 한글과 공백만 얻기
		Pattern pattern = Pattern.compile("[가-힣\\s]+");   // s : 공백      / + : 하나 이상의 글자?
		Matcher matcher = pattern.matcher(text);
		
		while(matcher.find()) {
			String line = matcher.group().trim();	// trim() : 앞뒤의 공백을 자를거야   ltream : 왼쪽 공백 잘러 rtream : 오른쪽 공백 잘러
			if(!line.isEmpty()) {	// 빈 줄은 제외
				System.out.println(line);
			}
		}
	}

}


