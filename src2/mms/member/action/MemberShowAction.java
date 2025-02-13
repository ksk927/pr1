package mms.member.action;

import java.util.Scanner;

import mms.member.svc.MemberShowService;
import mms.member.util.ConsoleUtil;
import mms.member.vo.Member;

public class MemberShowAction implements Action{
	
	@Override
	public void execute(Scanner sc) throws Exception {
		ConsoleUtil cu = new ConsoleUtil();
		
		int MemberId = cu.getMemberId(sc, null);
		// id ���� �޾ƿ԰� 0�̸� ��ü ����� ��ȸ
		// �ƴϸ� Ư�� ��ϸ� �ҷ��ð�
		boolean isShowSuccess = false;
		
		MemberShowService memberShowService = new MemberShowService();
		if(MemberId == 0) {
			// ��ü ��� ��ȸ
			isShowSuccess = memberShowService.showAllMember(MemberId);
		} else {
			isShowSuccess = memberShowService.showMember(MemberId);
		}
		
		if(isShowSuccess) {
			System.out.println("ȸ�� ���� ���� ����");
		} else {
			System.out.println("ȸ�� ������ �ҷ��� �� �����ϴ�.");
			System.out.println("���� ���̵�ų� ������ �Է��Ͽ����ϴ�.");
		}
	}
	
}
