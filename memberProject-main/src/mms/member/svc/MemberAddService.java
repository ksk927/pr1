package mms.member.svc;

import mms.member.dao.MemberDAO;
import mms.member.vo.Member;

public class MemberAddService {

	public boolean addMember(Member newMember) throws Exception {
		
		// 서비스의 성공 유무를 나타냄
		boolean isInsertSuccess = false;

		// 저장하는 
		MemberDAO memberDAO = new MemberDAO();
		
		isInsertSuccess = memberDAO.insertNewMember(newMember);
		
		return isInsertSuccess;
		
	}
}
