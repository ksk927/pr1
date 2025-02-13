package mms.member.svc;

import java.util.Scanner;

import mms.member.dao.MemberDAO;
import mms.member.vo.Member;

public class MemberUpdateService {
	
	public boolean updateMember(int memberId, Member newMember) throws Exception {
		
		boolean isUpdateSuccess = false;
		
		MemberDAO memberDAO = new MemberDAO();
		
		isUpdateSuccess = memberDAO.updateMember(memberId, newMember);
		
		return isUpdateSuccess;
	}
	
	public Member getUpdatedMember(int memberId, Member memberToUpdate, Scanner sc) {
        // 기존 정보 출력
        System.out.println("아이디" + memberId + "회원의 정보를 수정합니다.");
       // System.out.println(memberToUpdate);
        
        // 수정할 항목 입력 받기
        System.out.print("이전 주소 : " + memberToUpdate.getAddr() + " 수정할 주소 :  ");
        String addr = sc.nextLine();
        if (addr.isEmpty()) {
            addr = memberToUpdate.getAddr();
        }

        System.out.print("이전 이메일 :  " + memberToUpdate.getEmail() + " 수정할 이메일 : ");
        String email = sc.nextLine();
        if (email.isEmpty()) {
            email = memberToUpdate.getEmail();
        }

        System.out.print("이전 국가 : " + memberToUpdate.getNation() + " 수정할 국가 : ");
        String nation = sc.nextLine();
        if (nation.isEmpty()) {
            nation = memberToUpdate.getNation();
        }

        System.out.print("이전 나이 : " + memberToUpdate.getAge() + " 수정할 나이 : ");
        String ageInput = sc.nextLine();
        int age = memberToUpdate.getAge();  // 기본값은 기존 값
        if (!ageInput.isEmpty()) {
            try {
                age = Integer.parseInt(ageInput);
            } catch (NumberFormatException e) {
                System.out.println("잘못된 나이 입력입니다. 기존 나이 유지.");
            }
        }
        
        // 수정된 정보로 새로운 Member 객체 생성하여 반환
        return new Member(memberId, memberToUpdate.getName(), addr, nation, email, age);
    }
	
}
