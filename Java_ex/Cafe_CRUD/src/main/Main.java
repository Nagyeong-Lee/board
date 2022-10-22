package main;

import java.util.List;
import java.util.Scanner;

import dao.DAO;
import dto.DTO;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		DTO dto = new DTO();
		DAO dao = new DAO();

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(Exception e) {
			e.printStackTrace();
			System.exit(0);
		}

		while(true) {
			System.out.println("<<카페 메뉴 관리 프로그램>>");
			System.out.println("1.메뉴 등록");
			System.out.println("2.메뉴 출력");
			System.out.println("3.메뉴 삭제 (메뉴 번호로 삭제)");
			System.out.println("4.메뉴 수정 (메뉴 번호로 수정)"); //메뉴 번호 제외하고 수정
			System.out.println("5.메뉴 검색 (메뉴 이름으로 검색)");
			System.out.println("0.프로그램 종료");
			System.out.print(">> ");
			int menu=0;
			try {
				menu=Integer.parseInt(sc.nextLine());
			}catch(Exception e) {
				e.printStackTrace();
				continue;
			}
			if(menu==1) {  //insert
				System.out.print("메뉴 이름 : ");
				String pname=sc.nextLine();

				System.out.print("메뉴 가격 : ");
				int pprice=Integer.parseInt(sc.nextLine());

				System.out.print("아이스 가능여부 (Y/N) : ");
				String iced=sc.nextLine();

				System.out.print("토핑 추가 가능여부 (Y/N) : ");
				String topping=sc.nextLine();

				try {
					int result=dao.insert(new DTO(0,pname,pprice,iced,topping));
					if(result>0) {
						System.out.println("메뉴 등록 완료");
					}
				}catch(Exception e) {
					e.printStackTrace();
					System.out.println("관리자에게 문의 바람");
					System.out.println("manager@kh.com");
				}

			}else if(menu==2) { //select
				try {
					List<DTO>arr=dao.select();
					if(arr.size()>0){
						for(DTO d : arr) {
							System.out.println(d.getPid()+"\t"+d.getPname()+"\t"+
									d.getPprice()+"\t"+d.getIced()+"\t"+d.getTopping());
						}
					}
				}catch(Exception e) {
					e.printStackTrace();	
					System.out.println("관리자에게 문의 바람");
					System.out.println("manager@kh.com");
				}

			}else if(menu==3) { //delete
				System.out.print("삭제할 메뉴의 번호 : ");
				int delPID=Integer.parseInt(sc.nextLine());

				try {
					if(dao.pidExist(delPID)) {
						int result=dao.delete(delPID);
						if(result>0) {
							System.out.println("메뉴 삭제 성공");
						}
					}
					else {
						System.out.println("삭제 대상이 없습니다.");
					}
				}catch(Exception e) {
					e.printStackTrace();
					System.out.println("관리자에게 문의 바람");
					System.out.println("manager@kh.com");
				}

			}else if(menu==4) { //update
				System.out.print("수정할 메뉴의 번호 : ");
				int updPID=Integer.parseInt(sc.nextLine());

				try {
					if(dao.pidExist(updPID)) {
						System.out.print("메뉴 이름 : ");
						String pname=sc.nextLine();

						System.out.print("메뉴 가격 : ");
						int pprice=Integer.parseInt(sc.nextLine());

						System.out.print("아이스 가능여부 (Y/N) : ");
						String iced=sc.nextLine();

						System.out.print("토핑 추가 가능여부 (Y/N) : ");
						String topping=sc.nextLine();

						int result=dao.update(new DTO(updPID,pname,pprice,iced,topping));
						if(result>0) {
							System.out.println("메뉴 수정 완료");
						}
					}else {
						System.out.println("수정할 대상이 없습니다.");
					}
				}catch(Exception e) {
					e.printStackTrace();
					System.out.println("관리자에게 문의 바람");
					System.out.println("manager@kh.com");
				}

			}else if(menu==5) {  //search

				System.out.print("검색할 메뉴의 이름 : ");
				String searchByName=sc.nextLine();

				try {

					if(dao.pnameExist(searchByName)) {
						List<DTO>arr=dao.searchByName(searchByName);
						if(arr.size()>0) {
							for(DTO d : arr) {
								System.out.println(d.getPid()+"\t"+d.getPname()+
										d.getPprice()+"\t"+d.getIced()+"\t"+d.getTopping());
							}
							System.out.println("검색 완료");
						}
					}else {
						System.out.println("검색할 대상이 없습니다.");
					}
				}catch(Exception e) {
					e.printStackTrace();
					System.out.println("관리자에게 문의 바람");
					System.out.println("manager@kh.com");
				}

			}else if(menu==0) {
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
			}else {
				System.out.println("메뉴를 다시 선택해주세요.");
			}
		}

	}

}

//카페 메뉴 등록하는 crud프로그램
//jdbc java database connectivity
//아이디값,이름,가격,아이스가능여부,토핑추가여부
//자바에서 dbms접근해서 db 접근 가능하게  /   cafe 테이블생성