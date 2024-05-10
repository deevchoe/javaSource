package domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// sangdata 테이블과 연결

//JPA를 사용해 테이블과 매핑할 클래스에 붙여주는 어노테이션
@Entity		// sangdata 테이블과 SangumTable class와 매핑하겠다는 뜻
@Table(name="sangdata")
public class SangpumTable {
	
	// pk 칼람이라는 걸 알려주는 거
	@Id		// primarykey 칼람이라는 뜻
	@Column(name="code")	// 원본 테이블에서는 code야~  이름이 같으면 안써줘도 됨
	private int code;
	
	@Column(name="sang", nullable = false)		// sang이라는 칼람   원본 테이블이 null을 허용하지 않는다면 nullable = false를 써줘야 한다.
	private String sang;
	private int su;
	private int dan;
	
	public SangpumTable() {
		// 빈생성자라도 꼭 써줘야 한다.
		// JPA에서는 필수!
	}
	
	public SangpumTable(int code, String sang, int su, int dan) {
		this.code = code;
		this.sang =sang;
		this.su = su;
		this.dan = dan;
	
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getSang() {
		return sang;
	}

	public void setSang(String sang) {
		this.sang = sang;
	}

	public int getSu() {
		return su;
	}

	public void setSu(int su) {
		this.su = su;
	}

	public int getDan() {
		return dan;
	}

	public void setDan(int dan) {
		this.dan = dan;
	}
	
	
}
