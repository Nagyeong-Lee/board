package prac;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class CRUD2 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String id="kh";
		String pw="kh";
		while(true) {
			System.out.println("<<카페 메뉴 관리 프로그램>>");
			System.out.println("1.메뉴 정보 등록");
			System.out.println("2.메뉴 정보 출력");
			System.out.println("3.메뉴 정보 수정 (메뉴 이름으로 수정)");
			System.out.println("4.메뉴 정보 삭제 (메뉴 이름으로 삭제)");
			System.out.println("0.프로그램 종료");
			System.out.print("메뉴를 선택해주세요 >> ");
			int menu=Integer.parseInt(sc.nextLine());

			if(menu==1) {

				System.out.print("등록할 메뉴 이름 : ");
				String pname=sc.nextLine();

				System.out.print("등록할 메뉴 가격 : ");
				int pprice=Integer.parseInt(sc.nextLine());

				System.out.print("아이스 가능 여부 (Y/N) : ");
				String iced=sc.nextLine();

				Connection con = DriverManager.getConnection(url,id,pw);
				String sql=
						"insert into cafe_menu values (cafe_menu_seq.nextval,?,?,?)";
				PreparedStatement pstat=con.prepareStatement(sql);
				pstat.setString(1,pname);
				pstat.setInt(2,pprice);
				pstat.setString(3,iced);
				int result=pstat.executeUpdate();
				if(result>0) {
					System.out.println("메뉴 등록 완료");
				}
				con.commit();
				con.close();

			}else if(menu==2) {
				Connection con=DriverManager.getConnection(url, id, pw);
				String sql=
						"select * from cafe_menu";
				PreparedStatement pstat=con.prepareStatement(sql);
				ResultSet rs = pstat.executeQuery();
				if(rs.next()) {
					int pid=rs.getInt("pid");
					String pname=rs.getString("pname");
					int pprice=rs.getInt("pprice");
					String iced=rs.getString("iced");
					System.out.println(pid+" : "+pname+" : "+pprice+" : "+iced);
				}
				con.close();
			}else if(menu==3) {
				System.out.print("수정할 메뉴의 이름 입력 : ");
				String updName=sc.nextLine();
				
				System.out.print("새로운 메뉴 이름 : ");
				String pname=sc.nextLine();

				System.out.print("새로운 메뉴 가격 : ");
				int pprice=Integer.parseInt(sc.nextLine());

				System.out.print("아이스 가능 여부 (Y/N) : ");
				String iced=sc.nextLine();
				
				Connection con=DriverManager.getConnection(url, id, pw);
				String sql=
						"update cafe_menu set pname=?,pprice=?,iced=? where pname=?";
				PreparedStatement pstat=con.prepareStatement(sql);
				pstat.setString(1, pname);
				pstat.setInt(2, pprice);
				pstat.setString(3, iced);
				pstat.setString(4, updName);
				int result=pstat.executeUpdate();
				if(result>0) {
					System.out.println("메뉴 수정 완료");
				}
				con.commit();
				con.close();
			}else if(menu==4) {
				System.out.print("삭제할 메뉴 이름 입력 : ");
				String delName=sc.nextLine();
				
				Connection con=DriverManager.getConnection(url, id, pw);
				String sql=
						"delete from cafe_menu where pname=?";
				PreparedStatement pstat=con.prepareStatement(sql);
				pstat.setString(1, delName);
				int result=pstat.executeUpdate();
				if(result>0) {
					System.out.println("메뉴 삭제 완료");
				}
				con.commit();
				con.close();
			}else if(menu==0) {
				System.out.println("프로그램을 종료합니다");
				System.exit(0);
			}else {
				System.out.println("메뉴를 다시 선택해주세요");
			}
		}
	}
}

