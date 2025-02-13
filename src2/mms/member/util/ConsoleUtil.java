package mms.member.util;

import java.util.Scanner;

import mms.member.dao.MemberDAO;
import mms.member.svc.MemberUpdateService;
import mms.member.vo.Member;

public class ConsoleUtil {
	static int id = 1;
	// Member를 만들어주는 역할
	public Member getNewMember(Scanner sc) {
		// 회원 입력 기능 작성
		System.out.println("등록할 회원 정보를 입력하세요");
		
		System.out.print("이름 : ");
		String name = sc.next();
		
		System.out.print("주소 : ");
		String addr = sc.next();
		
		System.out.print("국가 : ");
		String nation = sc.next();
		
		System.out.print("이메일 : ");
		String email = sc.next();

		System.out.print("나이 : ");
		int age = sc.nextInt();
		
		
		
		Member newMember = new Member(id++,name, addr, nation, email, age);
		
		return newMember;
	}
	public int getMemberId(Scanner sc,String message) {
		// 회원 입력 기능 작성
		System.out.println(message);
		System.out.print(">>");
		
		return sc.nextInt();
		
	}
	
	
	public Member getUpdateMember(Scanner sc, int memberId) {
	    // 먼저, memberId로 해당 회원을 찾음
		MemberDAO memberDAO = new MemberDAO();
	    Member memberToUpdate = memberDAO.getMemberById(memberId);

	    if (memberToUpdate == null) {
	        //System.out.println("해당 ID의 회원이 존재하지 않습니다.");
	        return null;
	    }
	    // MemberUpdateService 호출
	    MemberUpdateService updateService = new MemberUpdateService();
	    
	    // 엔터키를 처리하기 위해 하나의 sc.nextLine()을 호출
	    
	    sc.nextLine();
	    
	    //수정된 회원 정보를 가져오기
        Member updatedMember = updateService.getUpdatedMember(memberId, memberToUpdate, sc);
	    
        
        //수정된 회원 정보를 반환
        return updatedMember;
	}
	
}
