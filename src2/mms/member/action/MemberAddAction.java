package mms.member.action;

import java.util.Scanner;

import mms.member.svc.MemberAddService;
import mms.member.util.ConsoleUtil;
import mms.member.vo.Member;

public class MemberAddAction implements Action{

	@Override
	public void execute(Scanner sc) throws Exception {
		ConsoleUtil cu = new ConsoleUtil();
		
		Member newMember = cu.getNewMember(sc);
		
		MemberAddService memberAddService = new MemberAddService();
		
		boolean isAddSuccess = memberAddService.addMember(newMember);
		
		if(isAddSuccess) {
			System.out.println("ȸ�� ���� ��� ����");
		} else {
			System.out.println("ȸ�� ���� ��� ����");
		}
	}

	
}
