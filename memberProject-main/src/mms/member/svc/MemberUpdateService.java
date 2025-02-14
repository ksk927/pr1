package mms.member.svc;

import java.util.Scanner;

import mms.member.dao.MemberDAO;
import mms.member.vo.Member;

public class MemberUpdateService {
	
		public boolean updateMember(int memberId, Scanner sc) throws Exception {
		
			boolean isUpdateSuccess = false;
		
			MemberDAO memberDAO = new MemberDAO();
		
			// 기존 회원 정보 가져오기
	        Member existingMember = memberDAO.getMemberById(memberId);
	        if (existingMember == null) {
	            //System.out.println("해당 ID의 회원이 존재하지 않습니다.");
	            return false;
	        }

	        // 기존 정보 출력
	        System.out.println("아이디  " + memberId + " 의 회원 정보를 수정합니다.");
	        //System.out.println("현재 회원 정보: " + existingMember);
	        
	        sc.nextLine();
	        
	        // 새 정보 입력받기
	        String nation = getValidInput(sc, "수정할 국가 (현재: " + existingMember.getNation() + "): ", existingMember.getNation());
	        String addr = getValidInput(sc, "수정할 주소 (현재: " + existingMember.getAddr() + "): ", existingMember.getAddr());
	        String email = getValidInput(sc, "수정할 이메일 (현재: " + existingMember.getEmail() + "): ", existingMember.getEmail());
	        
	        
	        int age = existingMember.getAge();
	        boolean validAge = false;
	        
	        while (!validAge) {
	            System.out.print("수정할 나이 (현재: " + existingMember.getAge() + "): ");
	            String ageInput = sc.nextLine();
	            if (ageInput.isEmpty()) {
	                age = existingMember.getAge();  // 나이 입력이 없으면 기존 값 유지
	                validAge = true;
	            } else {
	                try {
	                    age = Integer.parseInt(ageInput);
	                    validAge = true;
	                } catch (NumberFormatException e) {
	                    System.out.println("잘못된 나이 입력. 숫자만 입력해주세요.");
	                }
	            }
	        }
	
	        // 새로운 Member 객체 생성
	        Member updatedMember = new Member(memberId, existingMember.getName(), addr, nation, email, age);
	
	        // DAO에 업데이트 요청
	        isUpdateSuccess = memberDAO.updateMember(memberId, updatedMember);
	
	        return isUpdateSuccess;
	        
		}
	
		// 입력값을 받아서 빈 값이 아니면 그 값을, 빈 값이면 기본값을 반환하는 함수
		private String getValidInput(Scanner sc, String prompt, String defaultValue) {
			System.out.print(prompt);
			String input = sc.nextLine().trim();
			if (input.isEmpty()) {
				input = defaultValue;  // 빈 값이 들어오면 기본값으로 설정
			}
			return input;
    }
	
	
    
}
