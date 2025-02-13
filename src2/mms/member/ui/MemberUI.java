package mms.member.ui;

import java.util.Scanner;

import mms.member.action.Action;
import mms.member.action.MemberAddAction;
import mms.member.action.MemberDeleteAction;
import mms.member.action.MemberShowAction;
import mms.member.action.MemberUpdateAction;

public class MemberUI {

	public static void main(String[] args) {

		boolean isStop = false;
		
		Scanner sc = new Scanner(System.in);
		
		do {
			System.out.println("=====ȸ������ ���α׷�=====");
			System.out.println("1. ȸ�����"); //registerMember
			System.out.println("2. ȸ����Ϻ���"); // showMemberList
			System.out.println("3. ȸ����������"); // updateMember
			System.out.println("4. ȸ����������"); // deleteMember
			System.out.println("5. ���α׷�����");
			System.out.println("�޴� ��ȣ : ");
			
			int menu = sc.nextInt();
			Action action = null;
			switch(menu) {
			case 1:
				action = new MemberAddAction();
				System.out.println("ADD ���α׷� ���� ");
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
				System.out.println("���α׷� ����");
				isStop = true;
				break;
			default:
				break;
			}
			
			try {
				action.execute(sc);		
			} catch(Exception e){
				e.printStackTrace();
			}
			
		} while(!isStop);
		
	}

}
