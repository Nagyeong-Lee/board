package studentmanage;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	public static int getInt(String str) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			try {
				System.out.print(str);
				return Integer.parseInt(sc.nextLine());
			}catch(Exception e) {
				
			}
		}
	}
	
//	public static int getSilver() {
//		Scanner sc = new Scanner(System.in);
//		while(true) {
//			try {
//				System.out.print("아이디 : ");
//				return Integer.parseInt(sc.nextLine());
//				System.out.print("이름 : ");
//				return Integer.parseInt(sc.nextLine());
//				System.out.print("아이디 : ");
//				return Integer.parseInt(sc.nextLine());
//			}catch(Exception e) {
//				
//			}
//		}
//	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MemberArr memberArr=new MemberArr();
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("<< 회원 관리 시스템 >>");
			System.out.println("1. 신규 회원 등록");
			System.out.println("2. 회원 정보 출력");
			System.out.println("3. 프로그램 종료");
			int menu=getInt(">> ");
			if(menu==1) {
//				int id=getInt("아이디 : ");
//				System.out.print("이름 : ");
//				String name=sc.nextLine();
//				int point = getInt("포인트 : ");
//				
				memberArr.addMember(new Silver(1001,"a",1000));
				memberArr.addMember(new Gold(1002,"b",2000));
				memberArr.addMember(new Platinum(1003,"c",3000));
				
			}else if(menu==2) {
				System.out.println("아이디\t이름\t포인트\t보너스");
				ArrayList al=memberArr.getMember();
				for(int i=0; i<al.size(); i++) {
					System.out.println(((Member)al.get(i)).getId()+"\t"
									+((Member)al.get(i)).getName()+"\t"
									+((Member)al.get(i)).getPoint()+"\t"
									+((Member)al.get(i)).getBonus());
				}	
				
			}else if(menu==3) {
				System.out.println("프로그램 종료");
				System.exit(0);
				
			}else {
				System.out.println("메뉴 다시 선택");
			}
		}
		
	}

}

