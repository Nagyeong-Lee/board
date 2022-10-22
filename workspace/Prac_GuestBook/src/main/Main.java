package main;

import java.sql.Timestamp;
import java.util.List;
import java.util.Scanner;

import dao.DAO;
import dto.DTO;

public class Main {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		DTO dto = new DTO();
		DAO dao = DAO.getInstance();

		while(true) {

			System.out.println("<<방명록 프로그램>>");
			System.out.println("1.글 작성하기");
			System.out.println("2.글 정보 출력하기");
			System.out.println("3.글 삭제하기 (글 번호로 삭제)");
			System.out.println("4.글 수정하기 (글 번호로 수정)");
			System.out.println("5.글 검색하기 (작성자 이름으로 검색)");
			System.out.println("0.프로그램 종료하기");
			System.out.print(">> ");
			int menu=0;
			try {
				menu=Integer.parseInt(sc.nextLine());
			}catch(Exception e) {
				e.printStackTrace();
				continue;
			}

			//insert
			if(menu==1) { 
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

				//select   ----> 몇분전으로 출력하기
			}else if(menu==2) { 
				try {
					List<DTO>list=dao.select();
					if(list.size()>0) {
						for(DTO d: list) {
							System.out.println(d.getText_num()+"\t"+d.getWriter()+"\t"
									+d.getText()+"\t"+d.getFormedWrite_timeByString());
						}
					}else {
						System.out.println("출력할 대상이 없습니다");
					}
				}catch(Exception e) {
					e.printStackTrace();
					System.out.println("관리자에게 문의 바람");
				}

				//delete 글번호로
			}else if(menu==3) { 
				System.out.print("삭제할 글 번호 입력 : ");
				int text_num=Integer.parseInt(sc.nextLine());
				try {
					if(dao.isText_NumExist(text_num)) {
						if(dao.delete(text_num)>0) {
							System.out.println("글 삭제 완료");
						}
					}else {
						System.out.println("삭제할 대상이 없습니다");
					}
				}catch(Exception e) {
					e.printStackTrace();
					System.out.println("관리자에게 문의 바람");
				}

				//update
			}else if(menu==4) { 
				System.out.print("수정할 글 번호 입력 : ");
				int text_num=Integer.parseInt(sc.nextLine());
				try {
					if(dao.isText_NumExist(text_num)) {
						System.out.print("작성자 입력 : ");
						String writer=sc.nextLine();

						System.out.print("글 입력 : ");
						String text=sc.nextLine();
						long curTime=System.currentTimeMillis(); //수정된 시간으로 출력
						Timestamp updTime=new Timestamp(curTime);
						int result=dao.update(new DTO(text_num,writer,text,updTime));
						if(result>0) {
							System.out.println("글 수정 완료");
						}
					}else {
						System.out.println("수정할 대상이 없습니다");
					}
				}catch(Exception e) {
					e.printStackTrace();
					System.out.println("관리자에게 문의 바람");
				}

				//search
			}else if(menu==5) {
				System.out.print("검색할 작성자 이름 입력 :");
				String searchWriter=sc.nextLine();
				try {
					List<DTO>list=dao.searchByWriter(searchWriter);
					if(dao.isWriterExist(searchWriter)) {
						if(list.size()>0) {
							for(DTO d : list) {
								System.out.println(d.getText_num()+"\t"+d.getWriter()+"\t"+d.getText()+
										"\t"+d.getFormedWrite_time());
							}
						}
					}else {
						System.out.println("작성자가 존재하지 않습니다.");
					}
				}catch(Exception e) {
					e.printStackTrace();
					System.out.println("관리자에게 문의 바람");
				}

			}else if(menu==0) {
				System.out.println("프로그램을 종료합니다");
				System.exit(0);
			}else {
				System.out.println("메뉴를 다시 선택하세요");
			}

		}
	}

}

