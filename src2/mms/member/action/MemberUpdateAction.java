package mms.member.action;

import java.util.Scanner;

import mms.member.svc.MemberUpdateService;
import mms.member.util.ConsoleUtil;
import mms.member.vo.Member;

public class MemberUpdateAction implements Action{

	@Override
	public void execute(Scanner sc) throws Exception {
		ConsoleUtil cu = new ConsoleUtil();
		
		// id값 입력 받음
		int memberId = cu.getMemberId(sc, "수정할 회원의 아이디를 입력하세요");
		
		
		
		Member updatedMember = cu.getUpdateMember(sc, memberId);
		
		// 수정 서비스 호출
		MemberUpdateService memberUpdateService = new MemberUpdateService();
		boolean isUpdateSuccess = memberUpdateService.updateMember(memberId, updatedMember);
			 
		 
		 if (isUpdateSuccess) {
	            System.out.println("아이디 " + memberId + " 회원 정보 수정 성공");
	        } else {
	            System.out.println("회원 정보를 수정할 수 없습니다.");
	        }
	}
	}
	
