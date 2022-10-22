import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {



	//	public ShopMember searchUser(String memberId) {
	//
	//		String query = "SELECT * FROM SHOP_MEMBER WHERE MEMBER_ID =" + memberId;
	//		ShopMember shopMember = new ShopMember();
	//
	//
	//		try(
	//				Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "test_01", "T3sxl!&00");
	//				Statement stmt = conn.createStatement();
	//				ResultSet rset = stmt.executeQuery(query);
	//				) {
	//
	//			if(rset.next()) {
	//
	//				shopMember.setMemberId(rset.getString("MEMBER_ID"));
	//
	//				shopMember.setMemberPw(rset.getString("MEMBER_PW"));
	//
	//				shopMember.setPhone(rset.getString("PHONE"));
	//				
	//				shopMember.setGender(rset.getString("GENDER").charAt(0));
	//
	//			}
	//
	//		} catch (SQLException e) {
	//			e.printStackTrace();
	//		}
	//		return shopMember;
	//	}




	public ShopMember searchUser(String memberId) {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		String query = "SELECT * FROM SHOP_MEMBER WHERE MEMBER_ID =" + memberId;

		ShopMember shopMember = new ShopMember();


		try(Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "test_01", "T3sxl!&00");

				Statement stmt = conn.createStatement();

				ResultSet rset = stmt.executeQuery(query);){

			if(rset.next()) {

				shopMember.setMemberId(rset.getString("MEMBER_ID"));

				shopMember.setMemberPw(rset.getString("MEMBER_PW"));

				shopMember.setPhone(rset.getString("PHONE"));

				shopMember.setGender(rset.getString("GENDER").charAt(0));

			}

		} catch (SQLException e) {

			e.printStackTrace();

		} 
		return shopMember;

	}
}