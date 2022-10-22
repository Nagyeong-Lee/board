package guestbook;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dao.DAO;
import dto.GuestBook_DTO;

public class GuestBook {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");   // M에 작성
		}catch(Exception e) {           //라이브러리 파일 없으면 어차피 밑에도 실행안되서 종료
			e.printStackTrace(); 
			System.exit(0);
		}

		GuestBook_DAO dao = new GuestBook_DAO();
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
					int result=dao.insert(new GuestBook_DTO(0,writer,text,null)); //null값은 참조자료형으로 0의미 빈값 채워넣기
					if(result>0) {
						System.out.println("글 작성 완료");
					}
				}catch(Exception e) {
					e.printStackTrace();
					System.out.println("관리자에게 문의 바람");
					System.out.println("manager@manager.com");
				}
			}else if(menu==2) {  //select
//				String url="jdbc:oracle:thin:@localhost:1521:xe";
//				String id="gb";
//				String pw="1234";
				try {
					//					Connection con = DriverManager.getConnection(url,id,pw);
					//					String sql="select * from guestbook order by 1";
					//					PreparedStatement pstat=con.prepareStatement(sql);
					//					ResultSet rs = pstat.executeQuery();
					//					while(rs.next()) {
					//						int write_num=rs.getInt("write_num");
					//						String writer=rs.getString("writer");
					//						String text=rs.getString("text");
					//						Timestamp write_date=rs.getTimestamp("write_date");
					//						SimpleDateFormat sdf = new SimpleDateFormat("MM월dd일hh시mm분");
					//						System.out.println(write_num+" : "+writer+" : "+text+" : "
					//								+sdf.format(write_date.getTime()));
					List<GuestBook_DTO>result=dao.selectAll();
					if(result.size()>0) {
						for(GuestBook_DTO d : result) {
							//SimpleDateFormat sdf = new SimpleDateFormat("MM월dd일hh시mm분");
//							System.out.println(d.getWrite_num()+" : "+d.getWriter()+" : "+d.getText()+" : "
//											+sdf.format(d.getWrite_date().getTime()));
							System.out.println(d.getWrite_num()+" : "+d.getWriter()+" : "+d.getText()+" : "
									+d.getFormedDate());
						}
					}else {
						System.out.println("출력할 대상이 없습니다.");
					}
				}
				//DATE 타입은 시분초 안나와서 TIMESTAMP로 
			catch(Exception e) {
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
				int result=dao.update(new GuestBook_DTO(updWrite_num,updWriter,updText,null));
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
				List<GuestBook_DTO>arr = dao.search(searchName);
				if(arr.size()==0) {
					System.out.println("대상을 찾을 수 없습니다.");
				}else{
					for(GuestBook_DTO dto : arr) {
						System.out.println(
								dto.getWrite_num()+" : "+dto.getWriter()+" : "+
								dto.getText()+" : "+dto.getFormedDate());
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


