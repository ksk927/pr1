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
		
		
		
		//  MemberUpdateService ��ü ����
        MemberUpdateService memberUpdateService = new MemberUpdateService();
        
        //  ���� ���� ��û
        boolean isUpdateSuccess = memberUpdateService.updateMember(memberId, sc);
        
        //  ��� ���
        if (isUpdateSuccess) {
            System.out.println("���̵� " + memberId + " �� ȸ�� ���� ���� �Ͽ����ϴ�.");
        } else {
            System.out.println("���̵� " + memberId + " �� ������ ��� ������ �� �����ϴ�.");
        }
	}
	}
	
