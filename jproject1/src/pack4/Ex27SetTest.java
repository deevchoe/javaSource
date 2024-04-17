package pack4;

import java.util.HashSet;
import java.util.Iterator;

// Collection : 다수의 객체를 담을 수 있는 집합형 자료구조
public class Ex27SetTest {

	public static void main(String[] args) { 
		// Set 류의 HashSet으로 연습 : 중복 불가, 순서 없음
		
		//Ex27SetTest test = new Ex27SetTest();
		//HashSet<Ex27SetTest> list = new HashSet<Ex27SetTest>();
		//list.add(1);
		//list.add(test);
		
		HashSet<String> list = new HashSet<String>();
		list.add("lee");
		list.add("lee");
		list.add("lee");
		list.add("park");
		list.add("hong");
		//list.remove("park"); park만 삭제
		//list.clear(); 모두 삭제
		System.out.println("크기 : " + list.size()); // 배열의 크기는 length / 컬렉션의 크기는 size
		
		for(Object obj:list) {	// String의 슈퍼 클래스는 object이기 때문에 이렇게 써도 됨
			System.out.println(obj);
		}
		
		System.out.println();
		// Iterator (반복자) : 개발자가 컨테이너, 특히 리스트를 순회할 수 있게 해주는 객체다.
		Iterator iter = list.iterator();
		while(iter.hasNext()) {
			String ss = (String)iter.next();
			System.out.println(ss);
		}
		
		
	}

}
