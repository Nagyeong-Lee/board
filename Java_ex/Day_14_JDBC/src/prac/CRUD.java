package prac;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class CRUD {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String id="kh";
		String pw="kh";
		
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("<<카페 메뉴 관리 프로그램>>");
			System.out.println("1.신규 메뉴 등록");
			System.out.println("2.메뉴 정보 출력");
			System.out.println("3.메뉴 정보 삭제 (상품코드로 삭제)");
			System.out.println("4.메뉴 정보 수정 (상품코드로 수정)");
			System.out.println("0.프로그램 종료");
			System.out.print(">> ");
			int menu=Integer.parseInt(sc.nextLine());

			if(menu==1) {
				
				System.out.print("메뉴 이름 : ");
				String pname=sc.nextLine();
				
				System.out.print("메뉴 가격 : ");
				int pprice=Integer.parseInt(sc.nextLine());
				
				System.out.print("아이스 가능 여부 (Y/N) : ");
				String iced=sc.nextLine();
				
				Connection con=DriverManager.getConnection(url,id,pw);
				String sql=
				"insert into cafe_menu values(cafe_menu_seq.nextval,?,?,?)";
				PreparedStatement pstat=con.prepareStatement(sql);
				pstat.setString(1, pname);
				pstat.setInt(2, pprice);
				pstat.setString(3, iced);
				int result = pstat.executeUpdate();
				if(result>0) {
					System.out.println("메뉴 등록 성공");
				}else {
					System.out.println("메뉴 등록 실패");
				}
				con.commit();
				con.close();

			}else if(menu==2) {
				
				Connection con=DriverManager.getConnection(url,id,pw);
				String sql=
				"select * from cafe_menu order by 1";
				PreparedStatement pstat=con.prepareStatement(sql);
				ResultSet rs = pstat.executeQuery();
				while(rs.next()) {
					int pid=rs.getInt("pid");
					String pname=rs.getString("pname");
					int pprice=rs.getInt("pprice");
					String iced=rs.getString("iced");
					System.out.println(pid+" : "+pname+" : "+pprice+" : "+iced);
				}
				con.close();

			}else if(menu==3) {
				
				System.out.print("삭제할 상품의 번호 입력 : ");
				int delID=Integer.parseInt(sc.nextLine());
				
				Connection con=DriverManager.getConnection(url, id, pw);
				String sql=
				"delete from cafe_menu where pid=?";
				PreparedStatement pstat=con.prepareStatement(sql);
				pstat.setInt(1,delID);
				int result=pstat.executeUpdate();
				if(result>0) {
					System.out.println("메뉴 삭제 성공");
				}else {
					System.out.println("메뉴 삭제 실패");
				}
				con.commit();
				con.close();

			}else if(menu==4) {
				
				System.out.println("수정할 상품의 번호 입력 : ");
				int updID=Integer.parseInt(sc.nextLine());
				
				System.out.print("메뉴 이름 : ");
				String pname=sc.nextLine();
				
				System.out.print("메뉴 가격 : ");
				int pprice=Integer.parseInt(sc.nextLine());
				
				System.out.print("아이스 가능 여부 (Y/N) : ");
				String iced=sc.nextLine();
				
				Connection con=DriverManager.getConnection(url,id,pw);
				String sql=
				"update cafe_menu set pname=?,pprice=?,iced=? where pid=?" ;
				PreparedStatement pstat=con.prepareStatement(sql);
				pstat.setString(1,pname);
				pstat.setInt(2,pprice);
				pstat.setString(3,iced);
				pstat.setInt(4,updID);
				int result=pstat.executeUpdate();
				if(result>0) {
					System.out.println("메뉴 수정 성공");
				}else {
					System.out.println("메뉴 수정 실패");
				}
				con.commit();
				con.close();

			}else if(menu==0) {
				System.out.println("프로그램 종료");
				System.exit(0);
			}else {
				System.out.println("메뉴 다시 선택");
			}
		}
	}

}
