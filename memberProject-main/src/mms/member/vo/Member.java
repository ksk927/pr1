package mms.member.vo;
import lombok.Data;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
public class Member {
	
	private int id;
	private String name;
	private String addr;
	private String nation;
	private String email;
	private int age;
	
	public Member(String name, String addr, String nation, String email, int age) {
		this.name = name;
		this.addr = addr;
		this.nation = nation;
		this.email = email;
		this.age = age;
	}
	
	
	
}
