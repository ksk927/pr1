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
		
		//  MemberUpdateService 객체 생성
        MemberUpdateService memberUpdateService = new MemberUpdateService();
        
        //  정보 수정 요청
        boolean isUpdateSuccess = memberUpdateService.updateMember(memberId, sc);
        
        //  결과 출력
        if (isUpdateSuccess) {
            System.out.println("아이디 " + memberId + " 의 회원 정보 수정 하였습니다.");
        } else {
            System.out.println("아이디 " + memberId + " 의 정보가 없어서 수정할 수 없습니다.");
        }
	}

}
