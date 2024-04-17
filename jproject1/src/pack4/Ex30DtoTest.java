package pack4;

import java.util.ArrayList;

public class Ex30DtoTest {
	// DTO(DataTransferObject) : ...... 레코드 단위의 기억장소 
	ArrayList<Ex30StudentDto> list = new ArrayList<Ex30StudentDto>();	// 다른 타입은 넣을 수 없다. Ex30StudentDto 타입만 사용 가능
	Ex30StudentDto dto;		// DTO
	
	// DTO 유추하기
	public void aa() {
		String[] persons = new String[3];
		persons[0] = "홍길동";
		persons[1] = "고길동";
		persons[2] = "신길동";
		
		for(String s:persons) {
			System.out.println(s);
		}
	}
	
	public void insertList() {		// 레코드 단위(DTO)로 학생 정보 입력해 list에 저장
		dto = new Ex30StudentDto();
		dto.setHakbun("ks1");
		dto.setIrum("손오공");
		dto.setJumsu(90);
		list.add(dto);		// 첫번째 학생 자료 list에 등록
		
		dto = new Ex30StudentDto();
		dto.setHakbun("ks2");
		dto.setIrum("저팔계");
		dto.setJumsu(50);
		list.add(dto);		// 두번째 학생 자료 list에 등록
		
		dto = new Ex30StudentDto();
		dto.setHakbun("ks3");
		dto.setIrum("사오정");
		dto.setJumsu(40);
		list.add(dto);		// 세번째 학생 자료 list에 등록
	}

	public void showList() {	// list 컬렉션에 저장된 학생 자료를 출력
		System.out.println("학생 수는 " + list.size());
		System.out.println(list.get(0));
		System.out.println(list.get(0).getIrum());
		
		System.out.println("------------");
		for(int i = 0; i < list.size(); i++) {	// 전통적인 for문
			//Ex30StudentDto sdto = net Ex30StudentDto();
			//sdto = list.get(i);
			Ex30StudentDto sdto = list.get(i);
			System.out.println(sdto.getHakbun() + " " + sdto.getIrum() + " " + sdto.getJumsu());
		}
		
		System.out.println("------------");
		for(Ex30StudentDto d:list) {	// 향상된 for문  ->  배열이나 컬렉션을 쓸 경우 훨씬 깔끔한 방법
			System.out.println(d.getHakbun() + " " + d.getIrum() + " " + d.getJumsu());
		}
	}
	
	public static void main(String[] args) {
		Ex30DtoTest dtoTest = new Ex30DtoTest();
		dtoTest.aa();
		System.out.println();
		dtoTest.insertList();
		dtoTest.showList();
	}

}
