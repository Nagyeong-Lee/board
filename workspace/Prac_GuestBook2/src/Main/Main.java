package main;

import java.util.List;
import java.util.Scanner;

import dao.DAO;
import dto.DTO;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DAO dao = DAO.getInstance();
		DTO dto = new DTO();
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("<<방명록 프로그램>>");
			System.out.println("1.글 작성하기");
			System.out.println("2.전체 글 보기");
			System.out.println("3.글 삭제하기");
			System.out.println("4.글 수정하기");
			System.out.println("5.글 검색하기");
			System.out.println("0.프로그램 종료하기");
			System.out.print(">> ");

			int menu=0;
			try {
				menu=Integer.parseInt(sc.nextLine());
			}catch(Exception e) {
				e.printStackTrace();
				continue;
			}

			if(menu==1) { //insert

				System.out.print("작성자 이름 : ");
				String writer=sc.nextLine();

				System.out.print("글 내용 : ");
				String text=sc.nextLine();

				try {
					int result=dao.insert(new DTO(0,writer,text,null));
					if(result>0) {
						System.out.println("글 작성 완료");
					}
				}catch(Exception e) {
					e.printStackTrace();
					System.out.println("실행 실패 >> 관리자에게 문의 바람");
				}
			}else if(menu==2) { //select
				try {
					List<DTO>list=dao.selectAll();
					if(list.size()>0) {
						for(DTO d : list) {
							System.out.println(d.getText_num()+"\t"+d.getWriter()+"\t"
									+d.getText()+"\t"+d.getFormedDate());
						}
					}else {
						System.out.println("출력할 글이 없음");
					}
				}catch(Exception e) {
					e.printStackTrace();
					System.out.println("실행 실패 >> 관리자에게 문의 바람");
				}

			}else if(menu==3) {  //delete
				System.out.print("삭제할 글 번호 입력 : ");
				int delText_num=Integer.parseInt(sc.nextLine());

				try {
					if(dao.isText_numExist(delText_num)) {
						int result=dao.deleteByText_num(delText_num);
						if(result>0) {
							System.out.println("글 삭제 완료");
						}
					}else{
						System.out.println("삭제할 글이 없음");
					}
				}catch (Exception e) {
					e.printStackTrace();
					System.out.println("실행 실패 >> 관리자에게 문의 바람");
				}
			}else if(menu==4) {  //update 
				try {
					System.out.print("수정할 글 번호 입력 : ");
					int updText_num=Integer.parseInt(sc.nextLine());

					if(dao.isText_numExist(updText_num)) {
						System.out.print("작성자 이름 : ");
						String updWriter=sc.nextLine();

						System.out.print("글 내용 : ");
						String updText=sc.nextLine();

						int result=dao.update(new DTO(updText_num,updWriter,updText,null));
						if(result>0) {
							System.out.println("글 수정 완료");
						}
					}else{
						System.out.println("수정할 글이 없음");
					}
				}catch (Exception e) {
					e.printStackTrace();
					System.out.println("실행 실패 >> 관리자에게 문의 바람");
				}
			}else if(menu==5) {

				System.out.print("검색할 글 번호 입력 : ");
				int searchByText_num=Integer.parseInt(sc.nextLine());

				System.out.print("작성자 이름 : ");
				String SearchByWriter=sc.nextLine();
				try {
					if(dao.isText_numExist(searchByText_num)) { //우선
						List<DTO>list=dao.searchByText_num(searchByText_num);
						if(list.size()>0) {
							for(DTO d : list) {
								System.out.println(d.getText_num()+"\t"+d.getWriter()+"\t"
										+d.getText()+"\t"+d.getFormedDate());
							}
						}
					}else if(dao.isWriterExist(SearchByWriter)) {
						List<DTO>list=dao.searchByWriter(SearchByWriter);
						if(list.size()>0) {
							for(DTO d : list) {
								System.out.println(d.getText_num()+"\t"+d.getWriter()+"\t"
										+d.getText()+"\t"+d.getFormedDate());
							}
						}
					}
				}catch (Exception e) {
					e.printStackTrace();
					System.out.println("실행 실패 >> 관리자에게 문의 바람");
				}
			}else if(menu==0) {
				System.out.println("프로그램을 종료합니다");
				System.exit(0);
			}else {
				System.out.println("메뉴를 다시 선택해주세요");
			}
		}
	}
}


