package main;

import java.util.List;
import java.util.Scanner;

import dao.DAO;
import dto.DTO;
public class Main {
	
	
	//DBCP : DataBase Connection Pool
	//다수의 동시 접속자가 발생할시,db과부하에 의해 서비스가 막히는 것을
	//방지하기 위해 Connection 객체를 일정 개수 생성후 대여&반환하는 시스템
	//이전 코드는 Connection 객체 새로 계속 만듦
	//근데 사용자 수천명씩 들어오면 db뻗음
	//해결책 --> 울타리안에 connection 한 30개 만들어놓고
	//         사용자 들어오면 꺼내서 하나주고 나중에 들어온 사용자는
	//         대기중 (로딩중이라 뜸)
	
	
	//Singleton Pattern : 특정 목적의 클래스들은 new를 자유롭게 사용해서는 안되고
	//               	   단 하나의 인스턴스로만 사용하게끔 제한해야하는데 , 이때 사용하는 디자인패턴
	//왜 제한함? 자원낭비줄이려고,우리는 dbcp때문에 connection 오버플로우되지말라고
	//new를 1번만 해야됨
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub


		Scanner sc = new Scanner(System.in);

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");   

		}catch(Exception e) {       

			e.printStackTrace(); 

			System.exit(0);

		}

		DTO dto = new DTO();
		DAO dao = DAO.getInstance();

		while(true) {

			System.out.println("1.글 작성");

			System.out.println("2.글 목록 출력");

			System.out.println("3.글 삭제 (글 번호로 삭제)");

			System.out.println("4.글 수정 (글 번호로 수정)");

			System.out.println("5.글 검색 (작성자 이름으로 검색)");

			System.out.println("0.프로그램 종료");

			System.out.print(">> ");

			int menu=0;

			try {

				menu=Integer.parseInt(sc.nextLine());

			}catch(Exception e) {

				e.printStackTrace();

				continue;

			}

			if(menu==1) {       //insert

				System.out.print("작성자 입력 : ");

				String writer=sc.nextLine();



				System.out.print("글 입력 : ");

				String text=sc.nextLine();

				try {

					int result=dao.insert(new DTO(0,writer,text,null));

					if(result>0) {

						System.out.println("글 작성 완료");

					}

				}catch(Exception e) {

					e.printStackTrace();

					System.out.println("관리자에게 문의 바람");

				}

			}else if(menu==2) {  //select

				String url="jdbc:oracle:thin:@localhost:1521:xe";

				String id="gb";

				String pw="1234";

				try {

					List<DTO>result=dao.selectAll();

					if(result.size()>0) {

						for(DTO d : result) {

							System.out.println(d.getWrite_num()+" : "+d.getWriter()+" : "+d.getText()+" : "

											+d.getFormedDate());

						}

					}else {

						System.out.println("출력할 대상이 없습니다.");

					}

				}catch(Exception e) {

					e.printStackTrace();

					System.out.println("관리자에게 문의 바람");

				}

			}else if(menu==3) {     //delete

				System.out.print("삭제할 글 번호 입력 : ");

				int delWrite_num=Integer.parseInt(sc.nextLine());

				try {

					int result=dao.delete(delWrite_num);

					if(result==0) {

						System.out.println("대상을 찾을 수 없습니다.");

					}else if(result>0){

						System.out.println("글 삭제 완료");

					}

				}catch(Exception e) {

					e.printStackTrace();

					System.out.println("관리자에게 문의 바람");

				}

			}else if(menu==4) {   //update

				System.out.print("수정할 글 번호 입력 : ");

				int updWrite_num=Integer.parseInt(sc.nextLine());



				System.out.print("작성자 입력 : ");

				String updWriter=sc.nextLine();

				System.out.print("글 입력 : ");
				String updText=sc.nextLine();

				try {

					int result=dao.update(new DTO(updWrite_num,updWriter,updText,null));
					if(result==0) {
						System.out.println("대상을 찾을 수 없습니다.");
					}else if(result>0) {
						System.out.println("글 수정 완료");
					}

				}catch(Exception e) {
					e.printStackTrace();
					System.out.println("관리자에게 문의 바람");
				}

			}else if(menu==5) {   //search
				System.out.print("작성자 검색 : ");
				String searchName=sc.nextLine();
				try {

					List<DTO>arr = dao.search(searchName);
					if(arr.size()==0) {
						System.out.println("대상을 찾을 수 없습니다.");
					}else{

						for(DTO d2 : arr) {
							System.out.println(
									d2.getWrite_num()+" : "+d2.getWriter()+" : "+
										d2.getText()+" : "+d2.getFormedDate());
						}
						System.out.println("검색 완료");
					}

				}catch(Exception e) {
					e.printStackTrace();
					System.out.println("관리자에게 문의 바람");
				}

			}else if(menu==0) {
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
			}else {
				System.out.println("메뉴를 다시 선택해주세요");
			}

		}

	}

}


