package mms.member.action;

import java.util.Scanner;

import mms.member.svc.MemberShowService;
import mms.member.util.ConsoleUtil;
import mms.member.vo.Member;

public class MemberShowAction implements Action{
	
	@Override
	public void execute(Scanner sc) throws Exception {
		ConsoleUtil cu = new ConsoleUtil();
		
		int MemberId = 0;
		do {
			
			try {
				MemberId = cu.getMemberId(sc,"��ȸ�Ͻ� ȸ�� ��ȣ�� �Է����ּ���(��ü�� 0)");
				break;
			} catch(Exception e) {
				System.out.println("���� ���ڸ� �Է����ּ���");
				sc.nextLine(); // ���۸� �������� 
				continue;
			}
			
		} while(true);

		// id ���� �޾ƿ԰� 0�̸� ��ü ����� ��ȸ
		// �ƴϸ� Ư�� ��ϸ� �ҷ��ð�
		boolean isShowSuccess = false;
		
		MemberShowService memberShowService = new MemberShowService();
		if(MemberId == 0) {
			// ��ü ��� ��ȸ
			isShowSuccess = memberShowService.showAllMember();
		} else {
			isShowSuccess = memberShowService.showMember(MemberId);
		}
		
		if(isShowSuccess) {
			System.out.println("ȸ�� ���� ���� ����");
		} else {
			System.out.println("ȸ�� ������ �ҷ��� �� �����ϴ�.");
			System.out.println("�������� �ʴ� ���̵� �Է��Ͽ����ϴ�.");
		}
	}
	
}
