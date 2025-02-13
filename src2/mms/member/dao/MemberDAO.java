package mms.member.dao;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import mms.member.vo.Member;

public class MemberDAO {
	
	static List<Member> memberList = new CopyOnWriteArrayList<Member>();

	
	public boolean insertNewMember(Member newMember) {
		// 기능을 여기서 정의하고 
		// 서비스에서 호출 
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
	            // 수정 전 정보 출력
	            //System.out.println("수정 전 정보: " + member);

	            // 기존 회원 정보 업데이트
	            member.setAddr(updatedInfo.getAddr());
	            member.setEmail(updatedInfo.getEmail());
	            member.setNation(updatedInfo.getNation());
	            member.setAge(updatedInfo.getAge());

	            // 수정 후 정보 출력
	            //System.out.println("수정 후 정보: " + member);
	            
	            return true; // 업데이트 성공
	        }
	    }
	    //System.out.println("회원 정보 수정 실패: 해당 ID의 회원이 없습니다.");
	    return false; // ID가 존재하지 않음
	}
	
	public Member getMemberById(int memberId) {
        // memberList를 순회하면서 해당 ID의 회원을 찾음
        for (Member member : memberList) {
            if (member.getId() == memberId) {
                return member;  // 해당 ID의 회원을 찾으면 반환
            }
        }
        return null;  // 해당 ID의 회원이 없으면 null 반환
    }
	
	
}
