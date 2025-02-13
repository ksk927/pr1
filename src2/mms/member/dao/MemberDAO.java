package mms.member.dao;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import mms.member.vo.Member;

public class MemberDAO {
	
	static List<Member> memberList = new CopyOnWriteArrayList<Member>();

	
	public boolean insertNewMember(Member newMember) {
		// ����� ���⼭ �����ϰ� 
		// ���񽺿��� ȣ�� 
		return memberList.add(newMember);
	}
	
	public boolean showMember(List<Member> memberList, int memberId ) {
		for(Member member : memberList) {
			if (member.getId() == memberId) {
				System.out.println(member);
				return true;
			}
		}
		return false;
	}
	
	public boolean showAllMember(List<Member> memberList) {
		for(Member member : memberList) {
				System.out.println(member);
			}
		
		return true;	
	}
	
	public static List<Member> getMemberList() {
		return memberList;
	}
	
	public boolean updateMember(int memberId, Member updatedInfo) {
	    for (Member member : memberList) {
	        if (member.getId() == memberId) {
	            // ���� �� ���� ���
	            //System.out.println("���� �� ����: " + member);

	            // ���� ȸ�� ���� ������Ʈ
	            member.setAddr(updatedInfo.getAddr());
	            member.setEmail(updatedInfo.getEmail());
	            member.setNation(updatedInfo.getNation());
	            member.setAge(updatedInfo.getAge());

	            // ���� �� ���� ���
	            //System.out.println("���� �� ����: " + member);
	            
	            return true; // ������Ʈ ����
	        }
	    }
	    //System.out.println("ȸ�� ���� ���� ����: �ش� ID�� ȸ���� �����ϴ�.");
	    return false; // ID�� �������� ����
	}
	
	public Member getMemberById(int memberId) {
        // memberList�� ��ȸ�ϸ鼭 �ش� ID�� ȸ���� ã��
        for (Member member : memberList) {
            if (member.getId() == memberId) {
                return member;  // �ش� ID�� ȸ���� ã���� ��ȯ
            }
        }
        return null;  // �ش� ID�� ȸ���� ������ null ��ȯ
    }
	
	
}
