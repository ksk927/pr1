package mms.member.svc;

import mms.member.dao.MemberDAO;
import mms.member.vo.Member;

public class MemberShowService {

	public boolean showMember(int memberId) throws Exception {
		
		// ������ ���� ������ ��Ÿ��
		boolean isShowSuccess = false;

		//
		MemberDAO memberDAO = new MemberDAO();
		
		isShowSuccess = memberDAO.showMember(memberId);
		
		return isShowSuccess;
		
	}
	public boolean showAllMember() throws Exception {
		
		// ������ ���� ������ ��Ÿ��
		boolean isShowSuccess = false;

		// 
		MemberDAO memberDAO = new MemberDAO();
		
		isShowSuccess = memberDAO.showAllMember();
		
		return isShowSuccess;
		
	}
	
}
