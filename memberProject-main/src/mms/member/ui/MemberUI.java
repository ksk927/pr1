package mms.member.ui;

import java.util.Scanner;

import mms.member.action.Action;
import mms.member.action.MemberAddAction;
import mms.member.action.MemberDeleteAction;
import mms.member.action.MemberShowAction;
import mms.member.action.MemberUpdateAction;
import mms.member.util.ConsoleUtil;

import java.util.InputMismatchException;

public class MemberUI {

	public static void main(String[] args) {
		ConsoleUtil cu = new ConsoleUtil();
		Scanner sc = new Scanner(System.in);
		int menu = 0;
		do {
			System.out.println("=====ȸ������ ���α׷�=====");
			System.out.println("1. ȸ�����"); // MemberAddAction
			System.out.println("2. ȸ����Ϻ���"); // MemberShowAction
			System.out.println("3. ȸ����������"); // MemberUpdateAction
			System.out.println("4. ȸ����������"); // MemberDeleteAction
			System.out.println("5. ���α׷�����");
			System.out.println("�޴� ��ȣ : ");
			
			try {
				// � ���� �޴��� ���� �򰥷��� Util �޼��忡 �߰� ��  
				// � ������ �ϴ��� �� �� �ֵ��� util�� �޼���� ó���Ͽ���
				// sc.nextint(); 
				menu = cu.getServiceNumber(sc);
			} catch(InputMismatchException e){
				sc.nextLine(); // ���۸� �������� 
				System.out.println("���� 1���� 5�� �ش��ϴ� ���� �Է����ּ���");
				continue;
			}
			Action action = null;
			if(menu<= 0 || menu > 5) {
				System.out.println("���� 1���� 5�� �ش��ϴ� ���� �Է����ּ���");
				continue;
			}
			switch(menu) {
			case 1:
				action = new MemberAddAction();
				break;
			case 2:
				action = new MemberShowAction();
				break;
			case 3:
				action = new MemberUpdateAction();
				break;
			case 4:
				action = new MemberDeleteAction();
				break;
			case 5:
				System.out.println("���α׷��� �����մϴ�.");
				System.exit(0);
				break;
			default:
				break;
			}
			
			try {
				action.execute(sc);		
			} catch (Exception e) {
				continue;
				
			}
			
		} while(true);
		
	}

}
