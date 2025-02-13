package mms.member.svc;



import java.util.Scanner;
import mms.member.dao.MemberDAO;
import mms.member.vo.Member;

public class MemberUpdateService {
	
	public boolean updateMember(int memberId, Scanner sc) throws Exception {
		
		boolean isUpdateSuccess = false;
		
		MemberDAO memberDAO = new MemberDAO();
		
		// ���� ȸ�� ���� ��������
        Member existingMember = memberDAO.getMemberById(memberId);
        if (existingMember == null) {
            //System.out.println("�ش� ID�� ȸ���� �������� �ʽ��ϴ�.");
            return false;
        }

        // ���� ���� ���
        System.out.println("���̵�  " + memberId + " �� ȸ�� ������ �����մϴ�.");
        //System.out.println("���� ȸ�� ����: " + existingMember);
        
        sc.nextLine();
        
     // �� ���� �Է¹ޱ�
        String nation = getValidInput(sc, "������ ���� (����: " + existingMember.getNation() + "): ", existingMember.getNation());
        String addr = getValidInput(sc, "������ �ּ� (����: " + existingMember.getAddr() + "): ", existingMember.getAddr());
        String email = getValidInput(sc, "������ �̸��� (����: " + existingMember.getEmail() + "): ", existingMember.getEmail());
        
        
        int age = existingMember.getAge();
        boolean validAge = false;
        while (!validAge) {
            System.out.print("������ ���� (����: " + existingMember.getAge() + "): ");
            String ageInput = sc.nextLine();
            if (ageInput.isEmpty()) {
                age = existingMember.getAge();  // ���� �Է��� ������ ���� �� ����
                validAge = true;
            } else {
                try {
                    age = Integer.parseInt(ageInput);
                    validAge = true;
                } catch (NumberFormatException e) {
                    System.out.println("�߸��� ���� �Է�. ���ڸ� �Է����ּ���.");
                }
            }
        }

        // ���ο� Member ��ü ����
        Member updatedMember = new Member(memberId, existingMember.getName(), addr, nation, email, age);

        // DAO�� ������Ʈ ��û
        isUpdateSuccess = memberDAO.updateMember(memberId, updatedMember);

        return isUpdateSuccess;
    }
	
	// �Է°��� �޾Ƽ� �� ���� �ƴϸ� �� ����, �� ���̸� �⺻���� ��ȯ�ϴ� �Լ�
    private String getValidInput(Scanner sc, String prompt, String defaultValue) {
        System.out.print(prompt);
        String input = sc.nextLine().trim();
        if (input.isEmpty()) {
            input = defaultValue;  // �� ���� ������ �⺻������ ����
        }
        return input;
    }
	
	
	
}
