package mms.member.util;

import java.util.Scanner;

import mms.member.vo.Member;
import java.util.InputMismatchException;

public class ConsoleUtil {
	static int id = 1;
	// Member�� ������ִ� ����
	public Member getNewMember(Scanner sc) throws Exception {
		// ȸ�� �Է� ��� �ۼ�
		System.out.println("����� ȸ�� ������ �Է��ϼ���");
		
		System.out.print("�̸� : ");
		String name = sc.next();
		
		System.out.print("�ּ� : ");
		String addr = sc.next();
		
		System.out.print("���� : ");
		String nation = sc.next();
		
		System.out.print("�̸��� : ");
		String email = sc.next();

		System.out.print("���� : ");
		int age = 0;
		
		do {
			try {
				age = sc.nextInt();
				if (age <= 0) {
					throw new Exception("IsCanNotBeAge");
				}
				break;
			} catch(InputMismatchException e) {
				sc.nextLine(); // ���۸� �������� 
				System.out.println("���ڸ� �ٽ� �Է����ּ���");
				System.out.print("���� : ");
				continue;
			} catch(Exception e) {
				sc.nextLine(); // ���۸� �������� 
				System.out.println("�߸��� ���� �Է��Ͽ����ϴ�.");
				System.out.println("�ٽ� �Է����ּ���.");
				System.out.print("���� : ");
			}
		} while(true);
		
		
		
		
		
		Member newMember = new Member(id++,name, addr, nation, email, age);
		
		return newMember;
	}
	public int getMemberId(Scanner sc,String message) {
		// ȸ�� �Է� ��� �ۼ�
		System.out.println(message);
		System.out.print(">>");
		return sc.nextInt();
		
	}
	
	public int getServiceNumber(Scanner sc) {
		 return sc.nextInt();
	}
	
	
	
}
