package mms.member.svc;

import mms.member.dao.MemberDAO;
import mms.member.vo.Member;

public class MemberShowService {

	public boolean showMember(int memberId) throws Exception {
		
		// ������ ���� ������ ��Ÿ��
		boolean isShowSuccess = false;

		//
		MemberDAO memberDAO = new MemberDAO();
		
		isShowSuccess = memberDAO.showMember(memberDAO.getMemberList(),memberId);
		
		return isShowSuccess;
		
	}
	public boolean showAllMember(int memberId) throws Exception {
		
		// ������ ���� ������ ��Ÿ��
		boolean isShowSuccess = false;

		// 
		MemberDAO memberDAO = new MemberDAO();
		
		isShowSuccess = memberDAO.showAllMember(memberDAO.getMemberList());
		
		return isShowSuccess;
		
	}
	
}
