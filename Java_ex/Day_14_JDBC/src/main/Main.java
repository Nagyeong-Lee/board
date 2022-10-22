package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import dao.DAO;


public class Main {
	public static void main(String[] args) {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(Exception e) {
			System.out.println("필요한 파일이 없습니다.");
			System.exit(0);
		}

		Scanner sc = new Scanner(System.in);
		DAO dao = new DAO();


		while(true) {
			System.out.println("<< 방명록 프로그램 >>");
			System.out.println("1. 글 남기기");
			System.out.println("2. 글 목록보기");
			System.out.println("3. 글 삭제하기 ( 글 번호로 삭제 )");
			System.out.println("4. 글 수정하기 ( 글 번호로 수정 )");
			System.out.println("5. 글 검색하기 ( 작성자로 검색 ) ");
			System.out.println("0. 프로그램 종료");
			System.out.print(">> ");
			int menu = Integer.parseInt(sc.nextLine());

			if(menu == 1) {
				System.out.print("작성자 : ");
				String writer = sc.nextLine();

				System.out.print("메세지 : ");
				String contents = sc.nextLine();

				try {
					int result = dao.insert(writer,  contents);
					if(result > 0) {
						System.out.println("입력 완료");
					}
				}catch(Exception e) {
					e.printStackTrace();
					System.out.println("문제가 발생했습니다. 관리자에게 문의하세요.");
					System.out.println("manager@admin.com");
				}
			}else if(menu == 2) {
				String url = "jdbc:oracle:thin:@localhost:1521:xe";
				String id = "kh";
				String pw = "kh";

				String sql = "select * from guestbook";
				try {
					Connection con = DriverManager.getConnection(url,id,pw);
					PreparedStatement pstat = con.prepareStatement(sql);

					ResultSet rs = pstat.executeQuery();
					while(rs.next()) {
						int seq = rs.getInt("seq");
						String writer = rs.getString("writer");
						String contents = rs.getString("contents");
						Timestamp write_date = rs.getTimestamp("write_date");

						SimpleDateFormat sdf = new SimpleDateFormat("MM월dd일 hh시mm분");
						String formed_writeDate = sdf.format(write_date);

						System.out.println(seq+"\t"+writer+"\t"+contents+"\t"+formed_writeDate);
					}
					con.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}else if(menu == 3) {

				System.out.print("삭제할 글의 번호 : ");
				int seq = Integer.parseInt(sc.nextLine());

				try {
					if(dao.isSeqExist(seq)) {
						int result = dao.delete(seq);
						if(result > 0) {
							System.out.println("삭제 완료");
						}
					}else {
						System.out.println("삭제 대상이 존재하지 않습니다.");
					}
				}catch(Exception e) {
					e.printStackTrace();
					System.out.println("문제가 발생했습니다. 관리자에게 문의하세요.");
					System.out.println("manager@admin.com");
				}
			}else if(menu == 4) {
				System.out.print("수정할 글의 번호 : ");
				int seq = Integer.parseInt(sc.nextLine());

				try {
					if(dao.isSeqExist(seq)) {

						System.out.print("수정할 작성자 : ");
						String writer = sc.nextLine();

						System.out.print("수정할 메세지 : ");
						String contents = sc.nextLine();

						int result = dao.update(seq,writer,contents);

						if(result > 0) {
							System.out.println("변경 완료");
						}
					}else {
						System.out.println("수정할 대상 글이 존재하지 않습니다.");
					}
				}catch(Exception e) {
					e.printStackTrace();
					System.out.println("문제가 발생했습니다. 관리자에게 문의하세요.");
					System.out.println("manager@admin.com");
				}
			}else if(menu == 5) {
				System.out.print("검색 할 작성자 입력 : ");
				String pwriter = sc.nextLine();

				try {
					if(dao.isWriterExist(pwriter)) {

						String url = "jdbc:oracle:thin:@localhost:1521:xe";
						String id = "kh";
						String pw = "kh";

						String sql = "select * from guestbook where writer = ?";

						Connection con = DriverManager.getConnection(url,id,pw);
						PreparedStatement pstat = con.prepareStatement(sql);
						pstat.setString(1, pwriter);

						ResultSet rs = pstat.executeQuery();
						while(rs.next()) {
							int seq = rs.getInt("seq");
							String writer = rs.getString("writer");
							String contents = rs.getString("contents");
							Timestamp write_date = rs.getTimestamp("write_date");

							SimpleDateFormat sdf = new SimpleDateFormat("MM월dd일 hh시mm분");
							String formed_writeDate = sdf.format(write_date);

							System.out.println(seq+"\t"+writer+"\t"+contents+"\t"+formed_writeDate);
						}
						con.close();


					}else {
						System.out.println("검색 대상자가 존재하지 않습니다.");
					}
				}catch(Exception e) {
					e.printStackTrace();
					System.out.println("문제가 발생했습니다. 관리자에게 문의하세요.");
					System.out.println("manager@admin.com");
				}



			}else if(menu == 0) {
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
			}else {
				System.out.println("메뉴를 다시 확인해주세요.");
			}
		}

	}
}

