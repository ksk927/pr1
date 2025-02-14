package mms.member.dao;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.CopyOnWriteArrayList;

import mms.member.vo.Member;

public class MemberDAO {
	
	static List<Member> memberList = new CopyOnWriteArrayList<Member>();

	
	public boolean insertNewMember(Member newMember) {
		// 기능을 여기서 정의하고 
		// 서비스에서 호출 
		return memberList.add(newMember);
	}
	
	public boolean showMember(int memberId ) {
		for(Member member : memberList) {
			if (member.getId() == memberId) {
				System.out.println(member);
				return true;
			}
		}
		return false;
	}
	
	public boolean showAllMember() {
		if (memberList.size() != 0) {
			for(Member member : memberList) {
				System.out.println(member);
			}
			
			return true;
		} else {
			System.out.println("현재 가입한 회원이 없습니다.");
			
			return true;
		}
	}
	
	public static List<Member> getMemberList() {
		return memberList;
	}
	
	public boolean deleteMember(int memberID) {
		for(Member member : memberList) {
			if (member.getId() == memberID) {
				memberList.remove(member);
		//		System.out.println("아이디"+memberID + "정보가 삭제되었습니다");
				return true;
			}
		}
		//		System.out.println("회원 ID 가 일치하지 않습니다.");
		return false;
		
	}
	public Member getMemberById(int memberId) {
	    for (Member member : memberList) {
	        if (member.getId() == memberId) {
	            return member;
	        }
	    }
	    return null;  // 회원이 없으면 null을 반환
	}
	
	public boolean updateMember(int memberId, Member updatedMember) {
		for (Member member : memberList) {
			if (member.getId() == memberId) {
				System.out.println("수정 전: " + member);

				// 기존 정보를 유지하면서 새로운 정보 적용
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

				System.out.println("수정 후: " + member);
				return true;
			}
		}
		
		return false;
	}	
	
	
}
