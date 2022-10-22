import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Ex_04_Select {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub


		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = 
				DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "kh", "kh");

		Statement stat=con.createStatement();
		String sql="select * from cafe_menu";
		ResultSet rs =stat.executeQuery(sql);
		//ResultSet rs는 select한 테이블의 헤더를 가리킴,한행씩만 select가능
		//		rs.next();// rs가 가리키는 화살표를 하나 아래로 내림 ,다음행 있냐?
		//				// rs.next() : 화살표 하나 내려서 다음행 있으면 true,없으면false반환
		//		
		//	
		//		int pid=rs.getInt("pid");
		//		int pprice=rs.getInt("pprice");
		//		String pname=rs.getString("pname");
		//		
		//		System.out.println(pid+" : "+pname+" : "+pprice);
		//		//con.commit(); 안해도됨. 우리가 select한거라?
		while(rs.next()) {
			int pid=rs.getInt("pid");
			int pprice=rs.getInt("pprice");
			String pname=rs.getString("pname");
			System.out.println(pid+" : "+pname+" : "+pprice);

		}
		con.close();
	}

}
