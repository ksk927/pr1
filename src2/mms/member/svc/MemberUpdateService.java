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
        // ���� ���� ���
        System.out.println("���̵�" + memberId + "ȸ���� ������ �����մϴ�.");
       // System.out.println(memberToUpdate);
        
        // ������ �׸� �Է� �ޱ�
        System.out.print("���� �ּ� : " + memberToUpdate.getAddr() + " ������ �ּ� :  ");
        String addr = sc.nextLine();
        if (addr.isEmpty()) {
            addr = memberToUpdate.getAddr();
        }

        System.out.print("���� �̸��� :  " + memberToUpdate.getEmail() + " ������ �̸��� : ");
        String email = sc.nextLine();
        if (email.isEmpty()) {
            email = memberToUpdate.getEmail();
        }

        System.out.print("���� ���� : " + memberToUpdate.getNation() + " ������ ���� : ");
        String nation = sc.nextLine();
        if (nation.isEmpty()) {
            nation = memberToUpdate.getNation();
        }

        System.out.print("���� ���� : " + memberToUpdate.getAge() + " ������ ���� : ");
        String ageInput = sc.nextLine();
        int age = memberToUpdate.getAge();  // �⺻���� ���� ��
        if (!ageInput.isEmpty()) {
            try {
                age = Integer.parseInt(ageInput);
            } catch (NumberFormatException e) {
                System.out.println("�߸��� ���� �Է��Դϴ�. ���� ���� ����.");
            }
        }
        
        // ������ ������ ���ο� Member ��ü �����Ͽ� ��ȯ
        return new Member(memberId, memberToUpdate.getName(), addr, nation, email, age);
    }
	
}
