package mms.member.action;

import java.util.Scanner;

import mms.member.svc.MemberDeleteService;
import mms.member.util.ConsoleUtil;

public class MemberDeleteAction implements Action {

	@Override
	public void execute(Scanner sc) throws Exception {
		ConsoleUtil cu = new ConsoleUtil();
		
		int memberId = cu.getMemberId(sc,"삭제하실 회원 아이디를 입력해주세요:");

	    boolean isDeleteSuccess = false;
	        
	    MemberDeleteService memberDeleteService = new MemberDeleteService();
	    
	    if (memberId == 0) {
	        // Handle case for deleting a specific member by ID (you can add logic for this)
	        System.out.println("잘못된 입력입니다. 0은 사용할 수 없습니다.");
	    } else {
	    	
	    	try {
	    		isDeleteSuccess = memberDeleteService.deleteMember(memberId);
	    	} catch (Exception e) {
	    		e.printStackTrace();
	    	}
	    	
	    }

	    if (isDeleteSuccess) {
	        System.out.println(memberId+"번 회원의 정보 삭제 성공");
	    } else {
	        System.out.println("아이디가 일치하지 않거나 없는 아이디 입니다.");
	    }
	}
}