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
			System.out.println("=====회원관리 프로그램=====");
			System.out.println("1. 회원등록"); // MemberAddAction
			System.out.println("2. 회원목록보기"); // MemberShowAction
			System.out.println("3. 회원정보수정"); // MemberUpdateAction
			System.out.println("4. 회원정보삭제"); // MemberDeleteAction
			System.out.println("5. 프로그램종료");
			System.out.println("메뉴 번호 : ");
			
			try {
				// 어떤 값을 받는지 가끔 헷갈려서 Util 메서드에 추가 후  
				// 어떤 역할을 하는지 알 수 있도록 util의 메서드로 처리하였음
				// sc.nextint(); 
				menu = cu.getServiceNumber(sc);
			} catch(InputMismatchException e){
				sc.nextLine(); // 버퍼를 비워줘야함 
				System.out.println("숫자 1부터 5에 해당하는 값을 입력해주세요");
				continue;
			}
			Action action = null;
			if(menu<= 0 || menu > 5) {
				System.out.println("숫자 1부터 5에 해당하는 값을 입력해주세요");
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
				System.out.println("프로그램을 종료합니다.");
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
