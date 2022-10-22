package mid;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*Design Pattern MVC1 (Model, View+Control) view는 ui, control은 if, 배열/데이터작업민 model로
		 * 회원관리시스템
		 * 1.신규등록(id,name,point) 등급 silver,gold
		 * 2.회원목록(id,name,point,bonus)
		 */

		//클래스간의 관계
		//Has-A 포함관계 A Has a B
		//IS-A 상속관계  A Is a B

		//회원관리 문제점
		//코드 중복 너무 많음 -> 상속으로 해결
		//코드 결합도가 높다 (의존적) -> 다형성으로 해결  중 
		//데이터 저장소 문제 -> Collection으로 해결    요
		Scanner sc = new Scanner(System.in);
		Manager manager=new Manager(); //배열 관리하는 Manager 인스턴스 생성

		while(true) {
			System.out.println("<< 회원 관리 시스템>>");
			System.out.println("1.신규 회원 등록");
			System.out.println("2.회원 정보 출력");
			System.out.print(">> ");
			int menu=Integer.parseInt(sc.nextLine());

			if(menu==1) {
				manager.addMember(new Silver(1001,"Alice",1000));
				manager.addMember(new Silver(1002,"Tom",2000));
				manager.addMember(new Silver(1003,"Jay",3000));
				manager.addMember(new Gold(1004,"MIKE",4000));
				manager.addMember(new Gold(1005,"Elsa",5000));
				//				Silver s1 = new Silver("1001","Alice",1000);	
				//				manager.addMember(s1);

				//				Silver s2 = new Silver("1002","Tom",2000);	
				//				manager.addMember(s2);

			}else if(menu==2) {

				ArrayList<Member>member=manager.getMember();

				System.out.println("아이디\t이름\t포인트\t보너스");
				//				for(int i=0; i<member.size(); i++) {
				//					System.out.println(member.get(i)+"\t"+
				//							((ArrayList)(member[i])).getName()+"\t"+
				//							(member[i].getPoint())+"\t"+
				//							member[i].getBonus());  //오버라이딩된 getBonus()실행

				//				System.out.println(((Member) member.get(i)).getId()+"\t"
				//						            +((Member) member.get(i)).getName()+"\t"                 //ArrayList타입을 형변환
				//						            +((Member) member.get(i)).getPoint()+"\t"+
				//						            ((Member) member.get(i)).getBonus());

				//					System.out.println(member.get(i).getId()+"\t"+      //제너릭 사용시 다운캐스팅 필요x
				//					                   member.get(i).getName()+"\t"+
				//					                   member.get(i).getPoint()+"\t"+
				//					                   member.get(i).getBonus()+"\t");

				for( Member i : member) {
					System.out.println(i.getId()+"\t"+
							i.getName()+"\t"+
							i.getPoint()+"\t"+
							i.getBonus()+"\t");
				}
			}
		}
	}
}
