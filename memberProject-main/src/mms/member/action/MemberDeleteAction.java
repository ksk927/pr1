package mms.member.action;

import java.util.Scanner;

import mms.member.svc.MemberDeleteService;
import mms.member.util.ConsoleUtil;

public class MemberDeleteAction implements Action {

	@Override
	public void execute(Scanner sc) throws Exception {
		ConsoleUtil cu = new ConsoleUtil();
		
		int memberId = cu.getMemberId(sc,"�����Ͻ� ȸ�� ���̵� �Է����ּ���:");

	    boolean isDeleteSuccess = false;
	        
	    MemberDeleteService memberDeleteService = new MemberDeleteService();
	    
	    if (memberId == 0) {
	        // Handle case for deleting a specific member by ID (you can add logic for this)
	        System.out.println("�߸��� �Է��Դϴ�. 0�� ����� �� �����ϴ�.");
	    } else {
	    	
	    	try {
	    		isDeleteSuccess = memberDeleteService.deleteMember(memberId);
	    	} catch (Exception e) {
	    		e.printStackTrace();
	    	}
	    	
	    }

	    if (isDeleteSuccess) {
	        System.out.println(memberId+"�� ȸ���� ���� ���� ����");
	    } else {
	        System.out.println("���̵� ��ġ���� �ʰų� ���� ���̵� �Դϴ�.");
	    }
	}
}