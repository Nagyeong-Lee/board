import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Ex_03_Update {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		//
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = 
		DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "kh", "kh");
		
		Statement stat=con.createStatement();
		String sql=
				"update cafe_menu set pprice=5000 where pname='Americano'";
		int result=stat.executeUpdate(sql);
		if(result>0) {
			System.out.println("업데이트 성공");
		}else {
			System.out.println("업데이트 실패");
		}
		con.commit();
		con.close();
	}

}
