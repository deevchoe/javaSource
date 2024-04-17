package pack4;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Ex29MapTest {

	public static void main(String[] args) { 
		// Map류의 HashMap으로 연습 : 자료를 키와 값으로 저장. 검색이 편리
		HashMap<String, String> list = new HashMap<String, String>(); // 키는 중복되면 안됨 밸류는 중복될 수 있어
		list.put("1", "lee");
		list.put("2", "kim");
		list.put("3", "kim");
		list.put("4", "han");
		list.put("5", "choi");
		
		System.out.println("크기 : " + list.size());
		System.out.println(list.containsKey("2")); // 2있어? 있으면 true 없으면 false
		System.out.println(list.containsKey("7"));
		System.out.println(list.containsValue("han"));
		
		System.out.println();
		
		Set set = list.keySet();	// Set류를 사용했다.
		Iterator iter = set.iterator();	// iterator 객체를 만들었다.
		while(iter.hasNext()) {
			String ss = (String)iter.next();
			System.out.println(ss);		// 키 출력
			System.out.println(list.get(ss));	// 값 출력
		}

	}

}
