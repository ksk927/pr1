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
	
	public Member getMemberById(int memberId) {
	    for (Member member : memberList) {
	        if (member.getId() == memberId) {
	            return member;
	        }
	    }
	    return null;  // ȸ���� ������ null�� ��ȯ
	}
	
	public boolean updateMember(int memberId, Member updatedMember) {
		for (Member member : memberList) {
			if (member.getId() == memberId) {
				//System.out.println("���� ��: " + member);

				// ���� ������ �����ϸ鼭 ���ο� ���� ����
				if (updatedMember.getAddr() != null && !updatedMember.getAddr().isEmpty()) {
					member.setAddr(updatedMember.getAddr());
				}
				if (updatedMember.getEmail() != null && !updatedMember.getEmail().isEmpty()) {
					member.setEmail(updatedMember.getEmail());
				}
				if (updatedMember.getNation() != null && !updatedMember.getNation().isEmpty()) {
					member.setNation(updatedMember.getNation());
				}
				if (updatedMember.getAge() > 0) {
					member.setAge(updatedMember.getAge());
				}

				//System.out.println("���� ��: " + member);
				return true;
			}
		}
		
		return false;
	}

    
	
	
}
