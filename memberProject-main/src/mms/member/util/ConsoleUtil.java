package mms.member.util;

import java.util.Scanner;

import mms.member.vo.Member;
import java.util.InputMismatchException;

public class ConsoleUtil {
	static int id = 1;
	// Member를 만들어주는 역할
	public Member getNewMember(Scanner sc) throws Exception {
		// 회원 입력 기능 작성
		System.out.println("등록할 회원 정보를 입력하세요");
		
		System.out.print("이름 : ");
		String name = sc.next();
		
		System.out.print("주소 : ");
		String addr = sc.next();
		
		System.out.print("국가 : ");
		String nation = sc.next();
		
		System.out.print("이메일 : ");
		String email = sc.next();

		System.out.print("나이 : ");
		int age = 0;
		
		do {
			try {
				age = sc.nextInt();
				if (age <= 0) {
					throw new Exception("IsCanNotBeAge");
				}
				break;
			} catch(InputMismatchException e) {
				sc.nextLine(); // 버퍼를 비워줘야함 
				System.out.println("숫자를 다시 입력해주세요");
				System.out.print("나이 : ");
				continue;
			} catch(Exception e) {
				sc.nextLine(); // 버퍼를 비워줘야함 
				System.out.println("잘못된 값을 입력하였습니다.");
				System.out.println("다시 입력해주세요.");
				System.out.print("나이 : ");
			}
		} while(true);
		
		
		
		
		
		Member newMember = new Member(id++,name, addr, nation, email, age);
		
		return newMember;
	}
	public int getMemberId(Scanner sc,String message) {
		// 회원 입력 기능 작성
		System.out.println(message);
		System.out.print(">>");
		return sc.nextInt();
		
	}
	
	public int getServiceNumber(Scanner sc) {
		 return sc.nextInt();
	}
	
	
	
}
