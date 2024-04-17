package pack4;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Getter
//@Setter
//@NoArgsConstructor //아규먼트가 없는 생성자가 만들어짐
//@AllArgsConstructor// 아규먼트가 있는 생성자가 만들어짐
@Data // 생성자 빼고 다 만들어줌
public class Ex31StudDto { 
	private String name;
	private int kor, eng;
	
}
