package mall;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		while(true) {

			Scanner sc =  new Scanner(System.in);
			Manager manager = new Manager();
			
			System.out.println("<< 회원 관리 시스템>>");
			System.out.println("1.신규 회원 등록");
			System.out.println("2.회원 정보 출력");
			System.out.println("3.프로그램 종료");
			System.out.print(">> ");
			int menu=Integer.parseInt(sc.nextLine());

			if(menu==1) {

				manager.addMember(new Silver(1001,"Alice",1000));
				manager.addMember(new Silver(1002,"Ali",1500));
				manager.addMember(new Gold(10013,"j",1000));
				manager.addMember(new Gold(1004,"jacky",2000));
				manager.addMember(new Platinum(1005,"poby",4000));

			}else if(menu==2) {
				
				System.out.println("번호\t이름\t포인트\t보너스");
				ArrayList<Member>arr=manager.getMember();
				for(Member m : arr) {
					System.out.println(
							m.getId()+"\t"+
					        m.getName()+"\t"+
							m.getPoint()+"\t"+
					        m.getBonus());
				
				}

			}else if(menu==3) {
				System.out.println("종료");
				System.exit(0);
			}else {
				System.out.println("다시 선택");
			}
		}
	}

}
