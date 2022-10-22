package controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Temp {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		//더미값
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String id="kh";
		String pw="kh";
		
		String sql="insert into board values(board_seq.nextval,?,?,?,sysdate,0)";
		
		Connection con = DriverManager.getConnection(url,id,pw);
		PreparedStatement pstat=con.prepareStatement(sql);
		
		for(int i =1; i< 145; i++) {
			pstat.setString(1, "Test"+i);
			pstat.setString(2, "Test"+i);
			pstat.setString(3, "Test"+i);
			pstat.executeUpdate();
			Thread.sleep((long)(Math.random()*(700-200+1)+200));
			 System.out.println(i+"번째 데이터 : tESt"+i);

		}
		con.commit();
		con.close();
	}

}
