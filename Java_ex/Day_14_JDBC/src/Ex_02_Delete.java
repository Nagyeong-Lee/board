import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Ex_02_Delete {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

	
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = 
		DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "kh", "kh");
		
		Statement stat=con.createStatement();
		String sql=
				"delete from cafe_menu";
		int result=stat.executeUpdate(sql);
		con.commit();
		con.close();
		if(result>0) {
			System.out.println("성공");
		}else {
			System.out.println("실패");
		}
		
		
	}

}
