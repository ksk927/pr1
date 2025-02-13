package mms.member.action;

import java.util.Scanner;

import mms.member.svc.MemberUpdateService;
import mms.member.util.ConsoleUtil;
import mms.member.vo.Member;

public class MemberUpdateAction implements Action{

	@Override
	public void execute(Scanner sc) throws Exception {
		ConsoleUtil cu = new ConsoleUtil();
		
		// id�� �Է� ����
		int memberId = cu.getMemberId(sc, "������ ȸ���� ���̵� �Է��ϼ���");
		
		
		
		Member updatedMember = cu.getUpdateMember(sc, memberId);
		
		// ���� ���� ȣ��
		MemberUpdateService memberUpdateService = new MemberUpdateService();
		boolean isUpdateSuccess = memberUpdateService.updateMember(memberId, updatedMember);
			 
		 
		 if (isUpdateSuccess) {
	            System.out.println("���̵� " + memberId + " ȸ�� ���� ���� ����");
	        } else {
	            System.out.println("ȸ�� ������ ������ �� �����ϴ�.");
	        }
	}
	}
	
